package com.proyectoinvdebienes.backend.domain.model;

import com.proyectoinvdebienes.backend.domain.enums.RoleName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Usuarios")
public class UserAccount extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String password;

    @Transient
    private RoleName role;

    @Column(name = "id_rol")
    private Long roleId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleName getRole() {
        if (role != null) {
            return role;
        }
        if (roleId == null) {
            return RoleName.EMPLEADO;
        }
        return switch (roleId.intValue()) {
            case 1 -> RoleName.ADMINISTRADOR;
            case 2 -> RoleName.COMPRAS;
            case 3 -> RoleName.INVENTARIO;
            case 4 -> RoleName.EMPLEADO;
            case 5 -> RoleName.FINANZAS;
            default -> RoleName.EMPLEADO;
        };
    }

    public void setRole(RoleName role) {
        this.role = role;
        this.roleId = switch (role) {
            case ADMINISTRADOR -> 1L;
            case COMPRAS -> 2L;
            case INVENTARIO -> 3L;
            case EMPLEADO -> 4L;
            case FINANZAS -> 5L;
        };
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
