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
 * @author Santosh Patil
 */
@Entity
@Table(name = "delivery_tracking_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DeliverySystemTrackingDetails implements Serializable {

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private Long deliveryTHId;
    private User user;
    private Cabs cabs;
    private DeliverySystem deliverySystem;
    private Drivers drivers;
    private String deliveryMessage;
    private String deliveryStatus;
    private String image;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getDeliveryTHId() {
        return deliveryTHId;
    }

    public void setDeliveryTHId(Long deliveryTHId) {
        this.deliveryTHId = deliveryTHId;
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
    @JoinColumn(name = "user_id", nullable = true)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cab_id", nullable = true)
    public Cabs getCabs() {
        return cabs;
    }

    public void setCabs(Cabs cabs) {
        this.cabs = cabs;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_system_id", nullable = true)
    public DeliverySystem getDeliverySystem() {
        return deliverySystem;
    }

    public void setDeliverySystem(DeliverySystem deliverySystem) {
        this.deliverySystem = deliverySystem;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = true)
    public Drivers getDrivers() {
        return drivers;
    }

    public void setDrivers(Drivers drivers) {
        this.drivers = drivers;
    }

    @Column(name = "delivery_message", nullable = true)
    public String getDeliveryMessage() {
        return deliveryMessage;
    }

    public void setDeliveryMessage(String deliveryMessage) {
        this.deliveryMessage = deliveryMessage;
    }

    @Column(name = "delivery_status", nullable = true)
    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    @Column(name = "image", nullable = true)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public DeliverySystemTrackingDetails() {
    }
}
