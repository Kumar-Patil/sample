package com.taxi.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author
 */
@Entity
@Table(name = "cabs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cabs implements Serializable {

    private Long cabId;
    private String cabType;
    private String cabModel;
    private String cabColor;
    private String cabNo;
    private String cabRegistrationNo;
    private int status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private PricingGroups pricingGroups;
    private Vendors vendors;

    /* New fields are added */
    private String yearOfRegistration;
    private String plateNumber;
    private String insurer;
    private String insurancePolicyNumber;
    private Timestamp inuranceExpiryDate;
    private String mot;
    private Timestamp motExpiry;
    private Timestamp roadTaxExpiry;
    private Timestamp vehicleStart;
    private Timestamp hireExpiry;
    private String ownerDriver;

    private CabAttributes cabAttributes;
    private CabDocuments cabDocuments;

    public Cabs() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getCabId() {
        return cabId;
    }

    public void setCabId(Long cabId) {
        this.cabId = cabId;
    }

    @Column(name = "cab_type", nullable = false)
    public String getCabType() {
        return cabType;
    }

    public void setCabType(String cabType) {
        this.cabType = cabType;
    }

    @Column(name = "cab_model", nullable = false)
    public String getCabModel() {
        return cabModel;
    }

    public void setCabModel(String cabModel) {
        this.cabModel = cabModel;
    }

    @Column(name = "cab_color", nullable = false)
    public String getCabColor() {
        return cabColor;
    }

    public void setCabColor(String cabColor) {
        this.cabColor = cabColor;
    }

    @Column(name = "cab_no", nullable = false)
    public String getCabNo() {
        return cabNo;
    }

    public void setCabNo(String cabNo) {
        this.cabNo = cabNo;
    }

    @Column(name = "cab_registration_no", nullable = false)
    public String getCabRegistrationNo() {
        return cabRegistrationNo;
    }

    public void setCabRegistrationNo(String cabRegistrationNo) {
        this.cabRegistrationNo = cabRegistrationNo;
    }

    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "created_at", nullable = false)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "updated_at", nullable = false)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Column(name = "deleted_at", nullable = true)
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pricing_group_id", nullable = false)
    public PricingGroups getPricingGroups() {
        return pricingGroups;
    }

    public void setPricingGroups(PricingGroups pricingGroups) {
        this.pricingGroups = pricingGroups;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = false)
    public Vendors getVendors() {
        return vendors;
    }

    public void setVendors(Vendors vendors) {
        this.vendors = vendors;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id", nullable = false)
    public CabAttributes getCabAttributes() {
        return cabAttributes;
    }

    public void setCabAttributes(CabAttributes cabAttributes) {
        this.cabAttributes = cabAttributes;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", nullable = false)
    public CabDocuments getCabDocuments() {
        return cabDocuments;
    }

    public void setCabDocuments(CabDocuments cabDocuments) {
        this.cabDocuments = cabDocuments;
    }

    @Column(name = "year_of_registration", nullable = false)
    public String getYearOfRegistration() {
        return yearOfRegistration;
    }

    public void setYearOfRegistration(String yearOfRegistration) {
        this.yearOfRegistration = yearOfRegistration;
    }

    @Column(name = "plate_number", nullable = false)
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Column(name = "insurer", nullable = false)
    public String getInsurer() {
        return insurer;
    }

    public void setInsurer(String insurer) {
        this.insurer = insurer;
    }

    @Column(name = "insurance_policy_number", nullable = false)
    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Column(name = "inurance_expiry_date", nullable = false)
    public Timestamp getInuranceExpiryDate() {
        return inuranceExpiryDate;
    }

    public void setInuranceExpiryDate(Timestamp inuranceExpiryDate) {
        this.inuranceExpiryDate = inuranceExpiryDate;
    }

    @Column(name = "mot", nullable = false)
    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    @Column(name = "mot_expiry", nullable = false)
    public Timestamp getMotExpiry() {
        return motExpiry;
    }

    public void setMotExpiry(Timestamp motExpiry) {
        this.motExpiry = motExpiry;
    }

    @Column(name = "road_tax_expiry", nullable = false)
    public Timestamp getRoadTaxExpiry() {
        return roadTaxExpiry;
    }

    public void setRoadTaxExpiry(Timestamp roadTaxExpiry) {
        this.roadTaxExpiry = roadTaxExpiry;
    }

    @Column(name = "vehicle_start", nullable = false)
    public Timestamp getVehicleStart() {
        return vehicleStart;
    }

    public void setVehicleStart(Timestamp vehicleStart) {
        this.vehicleStart = vehicleStart;
    }

    @Column(name = "hire_expiry", nullable = false)
    public Timestamp getHireExpiry() {
        return hireExpiry;
    }

    public void setHireExpiry(Timestamp hireExpiry) {
        this.hireExpiry = hireExpiry;
    }

    @Column(name = "owner_driver", nullable = false)
    public String getOwnerDriver() {
        return ownerDriver;
    }

    public void setOwnerDriver(String ownerDriver) {
        this.ownerDriver = ownerDriver;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cabs other = (Cabs) obj;
        return true;
    }

    public Cabs(Long cabId, String cabType, String cabModel, String cabColor, String cabNo, String cabRegistrationNo, int status, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt, PricingGroups pricingGroups, Vendors vendors, String yearOfRegistration, String plateNumber, String insurer, String insurancePolicyNumber, Timestamp inuranceExpiryDate, String mot, Timestamp motExpiry, Timestamp roadTaxExpiry, Timestamp vehicleStart, Timestamp hireExpiry, String ownerDriver, CabAttributes cabAttributes, CabDocuments cabDocuments) {
        this.cabId = cabId;
        this.cabType = cabType;
        this.cabModel = cabModel;
        this.cabColor = cabColor;
        this.cabNo = cabNo;
        this.cabRegistrationNo = cabRegistrationNo;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.pricingGroups = pricingGroups;
        this.vendors = vendors;
        this.yearOfRegistration = yearOfRegistration;
        this.plateNumber = plateNumber;
        this.insurer = insurer;
        this.insurancePolicyNumber = insurancePolicyNumber;
        this.inuranceExpiryDate = inuranceExpiryDate;
        this.mot = mot;
        this.motExpiry = motExpiry;
        this.roadTaxExpiry = roadTaxExpiry;
        this.vehicleStart = vehicleStart;
        this.hireExpiry = hireExpiry;
        this.ownerDriver = ownerDriver;
        this.cabAttributes = cabAttributes;
        this.cabDocuments = cabDocuments;
    }

    @Override
    public String toString() {
        return "Cabs{" + "cabId=" + cabId + ", cabType=" + cabType + ", cabModel=" + cabModel + ", cabColor=" + cabColor + ", cabNo=" + cabNo + ", cabRegistrationNo=" + cabRegistrationNo + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + ", pricingGroups=" + pricingGroups + ", vendors=" + vendors + ", yearOfRegistration=" + yearOfRegistration + ", plateNumber=" + plateNumber + ", insurer=" + insurer + ", insurancePolicyNumber=" + insurancePolicyNumber + ", inuranceExpiryDate=" + inuranceExpiryDate + ", mot=" + mot + ", motExpiry=" + motExpiry + ", roadTaxExpiry=" + roadTaxExpiry + ", vehicleStart=" + vehicleStart + ", hireExpiry=" + hireExpiry + ", ownerDriver=" + ownerDriver + ", cabAttributes=" + cabAttributes + ", cabDocuments=" + cabDocuments + '}';
    }

}
