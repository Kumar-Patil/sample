package com.taxi.RequestMapper;

import java.sql.Timestamp;

/**
 *
 * @author
 */
public class SurgePricingMapping {

    private long vendorId;
    private long surgeId;
    private String name;
    private int status;
    private Timestamp surgeExpiryStartDate;
    private Timestamp surgeExpiryEndDate;
    private float latitudeStart;
    private float latitudeEnd;
    private float longitudeStart;
    private float longitudeEnd;
    private float factor;

    public SurgePricingMapping() {
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public long getSurgeId() {
        return surgeId;
    }

    public void setSurgeId(long surgeId) {
        this.surgeId = surgeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getSurgeExpiryStartDate() {
        return surgeExpiryStartDate;
    }

    public void setSurgeExpiryStartDate(Timestamp surgeExpiryStartDate) {
        this.surgeExpiryStartDate = surgeExpiryStartDate;
    }

    public Timestamp getSurgeExpiryEndDate() {
        return surgeExpiryEndDate;
    }

    public void setSurgeExpiryEndDate(Timestamp surgeExpiryEndDate) {
        this.surgeExpiryEndDate = surgeExpiryEndDate;
    }

    public float getLatitudeStart() {
        return latitudeStart;
    }

    public void setLatitudeStart(float latitudeStart) {
        this.latitudeStart = latitudeStart;
    }

    public float getLatitudeEnd() {
        return latitudeEnd;
    }

    public void setLatitudeEnd(float latitudeEnd) {
        this.latitudeEnd = latitudeEnd;
    }

    public float getLongitudeStart() {
        return longitudeStart;
    }

    public void setLongitudeStart(float longitudeStart) {
        this.longitudeStart = longitudeStart;
    }

    public float getLongitudeEnd() {
        return longitudeEnd;
    }

    public void setLongitudeEnd(float longitudeEnd) {
        this.longitudeEnd = longitudeEnd;
    }

    public float getFactor() {
        return factor;
    }

    public void setFactor(float factor) {
        this.factor = factor;
    }

    public SurgePricingMapping(long vendorId, long surgeId, String name, int status, Timestamp surgeExpiryStartDate, Timestamp surgeExpiryEndDate, float latitudeStart, float latitudeEnd, float longitudeStart, float longitudeEnd, float factor) {
        this.vendorId = vendorId;
        this.surgeId = surgeId;
        this.name = name;
        this.status = status;
        this.surgeExpiryStartDate = surgeExpiryStartDate;
        this.surgeExpiryEndDate = surgeExpiryEndDate;
        this.latitudeStart = latitudeStart;
        this.latitudeEnd = latitudeEnd;
        this.longitudeStart = longitudeStart;
        this.longitudeEnd = longitudeEnd;
        this.factor = factor;
    }
}
