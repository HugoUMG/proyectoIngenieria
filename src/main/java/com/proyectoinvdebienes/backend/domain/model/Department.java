package com.proyectoinvdebienes.backend.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Departamentos")
public class Department extends BaseEntity {

    @Column(name = "nombre_depto", nullable = false, unique = true)
    private String name;

    @Column(name = "centro_costo", unique = true)
    private String costCenterCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }
}
