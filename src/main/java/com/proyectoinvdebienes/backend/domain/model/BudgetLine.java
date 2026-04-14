package com.proyectoinvdebienes.backend.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.math.BigDecimal;

@Entity
@Table(name = "Partidas_Presupuestarias")
public class BudgetLine extends BaseEntity {

    @Column(name = "codigo_partida", nullable = false, unique = true)
    private String code;

    @Column(name = "nombre_partida", nullable = false)
    private String description;

    @Transient
    private BigDecimal allocatedAmount;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(BigDecimal allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }
}
