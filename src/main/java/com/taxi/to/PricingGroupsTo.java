package com.taxi.to;

import java.sql.Timestamp;

/**
 *
 * @author
 */
public class PricingGroupsTo {

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private long pricingId;
    private int status;
    private float pricePerUnitDistance;
    private float pricePerMinute;
    private long vendorId;
    private String pricingGroupName;
    private String vendorName;

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public PricingGroupsTo(Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt, long pricingId, int status, float pricePerUnitDistance, float pricePerMinute, long vendorId, String pricingGroupName, String vendorName) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.pricingId = pricingId;
        this.status = status;
        this.pricePerUnitDistance = pricePerUnitDistance;
        this.pricePerMinute = pricePerMinute;
        this.vendorId = vendorId;
        this.pricingGroupName = pricingGroupName;
        this.vendorName = vendorName;
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

    public long getPricingId() {
        return pricingId;
    }

    public void setPricingId(long pricingId) {
        this.pricingId = pricingId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getPricePerUnitDistance() {
        return pricePerUnitDistance;
    }

    public void setPricePerUnitDistance(float pricePerUnitDistance) {
        this.pricePerUnitDistance = pricePerUnitDistance;
    }

    public float getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(float pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public String getPricingGroupName() {
        return pricingGroupName;
    }

    public void setPricingGroupName(String pricingGroupName) {
        this.pricingGroupName = pricingGroupName;
    }

}
