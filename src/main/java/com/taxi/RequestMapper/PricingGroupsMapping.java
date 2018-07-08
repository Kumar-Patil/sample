package com.taxi.RequestMapper;

/**
 *
 * @author
 */
public class PricingGroupsMapping {

    private long pricingId;
    private int status;
    private float pricePerUnitDistance;
    private float pricePerMinute;
    private long vendorId;
    private String pricingGroupName;

    public PricingGroupsMapping() {

    }

    public String getPricingGroupName() {
        return pricingGroupName;
    }

    public void setPricingGroupName(String pricingGroupName) {
        this.pricingGroupName = pricingGroupName;
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

}
