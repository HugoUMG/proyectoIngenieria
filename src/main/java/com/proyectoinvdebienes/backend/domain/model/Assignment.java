package com.proyectoinvdebienes.backend.domain.model;

import com.proyectoinvdebienes.backend.domain.enums.AssignmentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.LocalDate;

@Entity
@Table(name = "Asignacion_Activos")
public class Assignment extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_activo")
    private Asset asset;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado")
    private Employee employee;

    @Column(name = "fecha_entrega", nullable = false)
    private LocalDate assignedAt;

    @Transient
    private LocalDate expectedReturnAt;

    @Column(name = "fecha_devolucion")
    private LocalDate returnedAt;

    @Enumerated(EnumType.STRING)
    @Transient
    private AssignmentStatus status;

    @Transient
    private String digitalSignature;

    @Transient
    private String receiptConfirmation;

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDate assignedAt) {
        this.assignedAt = assignedAt;
    }

    public LocalDate getExpectedReturnAt() {
        return expectedReturnAt;
    }

    public void setExpectedReturnAt(LocalDate expectedReturnAt) {
        this.expectedReturnAt = expectedReturnAt;
    }

    public LocalDate getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(LocalDate returnedAt) {
        this.returnedAt = returnedAt;
    }

    public AssignmentStatus getStatus() {
        return status;
    }

    public void setStatus(AssignmentStatus status) {
        this.status = status;
    }

    public String getDigitalSignature() {
        return digitalSignature;
    }

    public void setDigitalSignature(String digitalSignature) {
        this.digitalSignature = digitalSignature;
    }

    public String getReceiptConfirmation() {
        return receiptConfirmation;
    }

    public void setReceiptConfirmation(String receiptConfirmation) {
        this.receiptConfirmation = receiptConfirmation;
    }
}
