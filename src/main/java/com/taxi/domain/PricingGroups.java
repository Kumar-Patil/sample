package com.taxi.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
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
@Table(name = "pricing_groups")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PricingGroups implements Serializable {

    private Long pricingId;
    private String name;
    private float pricePerUnitDistance;
    private float pricePerMinute;
    private int status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private Vendors vendors;

    public PricingGroups() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getPricingId() {
        return pricingId;
    }

    public void setPricingId(Long pricingId) {
        this.pricingId = pricingId;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price_per_unit_distance", nullable = false)
    public float getPricePerUnitDistance() {
        return pricePerUnitDistance;
    }

    public void setPricePerUnitDistance(float pricePerUnitDistance) {
        this.pricePerUnitDistance = pricePerUnitDistance;
    }

    @Column(name = "price_per_minute", nullable = false)
    public float getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(float pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
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
    @JoinColumn(name = "vendor_id", nullable = false)
    public Vendors getVendors() {
        return vendors;
    }

    public void setVendors(Vendors vendors) {
        this.vendors = vendors;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.pricingId);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Float.floatToIntBits(this.pricePerUnitDistance);
        hash = 97 * hash + Float.floatToIntBits(this.pricePerMinute);
        hash = 97 * hash + this.status;
        hash = 97 * hash + Objects.hashCode(this.createdAt);
        hash = 97 * hash + Objects.hashCode(this.updatedAt);
        hash = 97 * hash + Objects.hashCode(this.deletedAt);
        hash = 97 * hash + Objects.hashCode(this.vendors);
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
        final PricingGroups other = (PricingGroups) obj;
        return true;
    }

    @Override
    public String toString() {
        return "PricingGroups{" + "pricingId=" + pricingId + ", name=" + name + ", pricePerUnitDistance=" + pricePerUnitDistance + ", pricePerMinute=" + pricePerMinute + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + ", vendors=" + vendors + '}';
    }

}
