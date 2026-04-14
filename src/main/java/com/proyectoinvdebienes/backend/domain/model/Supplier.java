package com.proyectoinvdebienes.backend.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Proveedores")
public class Supplier extends BaseEntity {

    @Column(name = "nombre_proveedor", nullable = false)
    private String name;

    @Column(name = "rfc", nullable = false, unique = true)
    private String taxId;

    @Column(name = "correo")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
