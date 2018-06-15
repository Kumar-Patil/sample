package com.taxi.to;

import java.sql.Timestamp;

/**
 *
 * @author
 */
public class CabsTo {

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private Long cabId;
    private String cabType;
    private String cabModel;
    private String cabColor;
    private String cabNo;
    private String cabRegistrationNo;
    private int status;
    private long vendorId;
    private long pricingId;

    public CabsTo(Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt, Long cabId, String cabType, String cabModel, String cabColor, String cabNo, String cabRegistrationNo, int status, long vendorId, long pricingId) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.cabId = cabId;
        this.cabType = cabType;
        this.cabModel = cabModel;
        this.cabColor = cabColor;
        this.cabNo = cabNo;
        this.cabRegistrationNo = cabRegistrationNo;
        this.status = status;
        this.vendorId = vendorId;
        this.pricingId = pricingId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Long getCabId() {
        return cabId;
    }

    public void setCabId(Long cabId) {
        this.cabId = cabId;
    }

    public String getCabType() {
        return cabType;
    }

    public void setCabType(String cabType) {
        this.cabType = cabType;
    }

    public String getCabModel() {
        return cabModel;
    }

    public void setCabModel(String cabModel) {
        this.cabModel = cabModel;
    }

    public String getCabColor() {
        return cabColor;
    }

    public void setCabColor(String cabColor) {
        this.cabColor = cabColor;
    }

    public String getCabNo() {
        return cabNo;
    }

    public void setCabNo(String cabNo) {
        this.cabNo = cabNo;
    }

    public String getCabRegistrationNo() {
        return cabRegistrationNo;
    }

    public void setCabRegistrationNo(String cabRegistrationNo) {
        this.cabRegistrationNo = cabRegistrationNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public long getPricingId() {
        return pricingId;
    }

    public void setPricingId(long pricingId) {
        this.pricingId = pricingId;
    }

}
