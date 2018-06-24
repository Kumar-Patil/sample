package com.taxi.to;

import java.sql.Timestamp;

/**
 *
 * @author
 */
public class PricingTo {

    private long pricingId;
    private String status;
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

    public PricingTo(long pricingId, String status, float pricePerUnitDistance, float pricePerMinute, long vendorId, String pricingGroupName, String vendorName) {
        this.pricingId = pricingId;
        this.status = status;
        this.pricePerUnitDistance = pricePerUnitDistance;
        this.pricePerMinute = pricePerMinute;
        this.vendorId = vendorId;
        this.pricingGroupName = pricingGroupName;
        this.vendorName = vendorName;
    }

    public long getPricingId() {
        return pricingId;
    }

    public void setPricingId(long pricingId) {
        this.pricingId = pricingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
