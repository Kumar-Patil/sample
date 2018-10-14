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
 * @author Santosh
 */
@Entity
@Table(name = "delivery_progress")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DeliveryProgress implements Serializable {

    private Long deliveryProgressId;
    private Long deliveryId;

    private String source;
    private String destination;
    private float sourceLat;
    private float sourceLng;
    private float destinationLat;
    private float destinationLng;
    private int isProgress;

    @Column(name = "is_progress", nullable = false)
    public int getIsProgress() {
        return isProgress;
    }

    public void setIsProgress(int isProgress) {
        this.isProgress = isProgress;
    }
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp last_updated_at;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getDeliveryProgressId() {
        return deliveryProgressId;
    }

    public void setDeliveryProgressId(Long deliveryProgressId) {
        this.deliveryProgressId = deliveryProgressId;
    }

    @Column(name = "source", nullable = false, length = 255)
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Column(name = "destination", nullable = false, length = 255)
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Column(name = "last_updated_at")
    public Timestamp getLast_updated_at() {
        return last_updated_at;
    }

    public void setLast_updated_at(Timestamp last_updated_at) {
        this.last_updated_at = last_updated_at;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    public User getUser() {
        return user;
    }

    public DeliveryProgress() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "source_lat", nullable = false)
    public float getSourceLat() {
        return sourceLat;
    }

    public void setSourceLat(float sourceLat) {
        this.sourceLat = sourceLat;
    }

    @Column(name = "source_lng", nullable = false)
    public float getSourceLng() {
        return sourceLng;
    }

    public void setSourceLng(float sourceLng) {
        this.sourceLng = sourceLng;
    }

    @Column(name = "destination_lat", nullable = false)
    public float getDestinationLat() {
        return destinationLat;
    }

    public void setDestinationLat(float destinationLat) {
        this.destinationLat = destinationLat;
    }

    @Column(name = "destination_lng", nullable = false)
    public float getDestinationLng() {
        return destinationLng;
    }

    public void setDestinationLng(float destinationLng) {
        this.destinationLng = destinationLng;
    }

    @Column(name = "delivery_id", nullable = false)
    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
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
        final DeliveryProgress other = (DeliveryProgress) obj;
        return true;
    }

}
