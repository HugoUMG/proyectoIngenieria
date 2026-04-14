package com.proyectoinvdebienes.backend.domain.model;

import com.proyectoinvdebienes.backend.domain.enums.AssetStatus;
import com.proyectoinvdebienes.backend.domain.enums.TagType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Activos")
public class Asset extends BaseEntity {

    @Transient
    private String assetCode;

    @Transient
    private String name;

    @Column(name = "descripcion_especifica")
    private String description;

    @Transient
    private String serialNumber;

    @Transient
    private LocalDate acquisitionDate;

    @Column(name = "valor_actual")
    private BigDecimal acquisitionCost;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_bien", nullable = false)
    private AssetStatus status;

    @Enumerated(EnumType.STRING)
    @Transient
    private TagType tagType;

    @Column(name = "tag_qr_rfid", unique = true)
    private String tagValue;

    @Transient
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_detalle")
    private PurchaseInvoice purchaseInvoice;

    @Transient
    private Employee currentCustodian;

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(LocalDate acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public BigDecimal getAcquisitionCost() {
        return acquisitionCost;
    }

    public void setAcquisitionCost(BigDecimal acquisitionCost) {
        this.acquisitionCost = acquisitionCost;
    }

    public AssetStatus getStatus() {
        return status;
    }

    public void setStatus(AssetStatus status) {
        this.status = status;
    }

    public TagType getTagType() {
        return tagType;
    }

    public void setTagType(TagType tagType) {
        this.tagType = tagType;
    }

    public String getTagValue() {
        return tagValue;
    }

    public void setTagValue(String tagValue) {
        this.tagValue = tagValue;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public PurchaseInvoice getPurchaseInvoice() {
        return purchaseInvoice;
    }

    public void setPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
    }

    public Employee getCurrentCustodian() {
        return currentCustodian;
    }

    public void setCurrentCustodian(Employee currentCustodian) {
        this.currentCustodian = currentCustodian;
    }
}
