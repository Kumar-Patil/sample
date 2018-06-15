package com.taxi.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author
 */
@Entity
@Table(name = "surge_pricing")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SurgePricing implements Serializable {

    private long surgeId;
    private String name;
    private int status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private Timestamp surgeExpiryStartDate;
    private Timestamp surgeExpiryEndDate;
    private float latitudeStart;
    private float latitudeEnd;
    private float longitudeStart;
    private float longitudeEnd;
    private float factor;

    public SurgePricing() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public long getSurgeId() {
        return surgeId;
    }

    public void setSurgeId(long surgeId) {
        this.surgeId = surgeId;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Column(name = "start_at", nullable = true)
    public Timestamp getSurgeExpiryStartDate() {
        return surgeExpiryStartDate;
    }

    public void setSurgeExpiryStartDate(Timestamp surgeExpiryStartDate) {
        this.surgeExpiryStartDate = surgeExpiryStartDate;
    }

    @Column(name = "end_at", nullable = true)
    public Timestamp getSurgeExpiryEndDate() {
        return surgeExpiryEndDate;
    }

    public void setSurgeExpiryEndDate(Timestamp surgeExpiryEndDate) {
        this.surgeExpiryEndDate = surgeExpiryEndDate;
    }

    @Column(name = "latitude_start", nullable = true)
    public float getLatitudeStart() {
        return latitudeStart;
    }

    public void setLatitudeStart(float latitudeStart) {
        this.latitudeStart = latitudeStart;
    }

    @Column(name = "latitude_end", nullable = true)
    public float getLatitudeEnd() {
        return latitudeEnd;
    }

    public void setLatitudeEnd(float latitudeEnd) {
        this.latitudeEnd = latitudeEnd;
    }

    @Column(name = "longitude_start", nullable = true)
    public float getLongitudeStart() {
        return longitudeStart;
    }

    public void setLongitudeStart(float longitudeStart) {
        this.longitudeStart = longitudeStart;
    }

    @Column(name = "longitude_end", nullable = true)
    public float getLongitudeEnd() {
        return longitudeEnd;
    }

    public void setLongitudeEnd(float longitudeEnd) {
        this.longitudeEnd = longitudeEnd;
    }

    @Column(name = "factor", nullable = false)
    public float getFactor() {
        return factor;
    }

    public void setFactor(float factor) {
        this.factor = factor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.surgeId ^ (this.surgeId >>> 32));
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + this.status;
        hash = 53 * hash + Objects.hashCode(this.createdAt);
        hash = 53 * hash + Objects.hashCode(this.updatedAt);
        hash = 53 * hash + Objects.hashCode(this.deletedAt);
        hash = 53 * hash + Objects.hashCode(this.surgeExpiryStartDate);
        hash = 53 * hash + Objects.hashCode(this.surgeExpiryEndDate);
        hash = 53 * hash + Float.floatToIntBits(this.latitudeStart);
        hash = 53 * hash + Float.floatToIntBits(this.latitudeEnd);
        hash = 53 * hash + Float.floatToIntBits(this.longitudeStart);
        hash = 53 * hash + Float.floatToIntBits(this.longitudeEnd);
        hash = 53 * hash + Float.floatToIntBits(this.factor);
        return hash;
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
        final SurgePricing other = (SurgePricing) obj;
        return true;
    }

    @Override
    public String toString() {
        return "SurgePricing{" + "surgeId=" + surgeId + ", name=" + name + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + surgeExpiryStartDate + ", surgeExpiryEndDate=" + surgeExpiryEndDate + ", latitudeStart=" + latitudeStart + ", latitudeEnd=" + latitudeEnd + ", longitudeStart=" + longitudeStart + ", longitudeEnd=" + longitudeEnd + ", factor=" + factor + '}';
    }

}
