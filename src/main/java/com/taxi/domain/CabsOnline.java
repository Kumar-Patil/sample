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
@Table(name = "cabs_online")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CabsOnline implements Serializable {

    private Long userOnlineId;
    private String source;
    private String destination;
    private float sourceLat;
    private float sourceLng;
    private float destinationLat;
    private float destinationLng;
    private int isOnline;

    @Column(name = "is_online", nullable = false)
    public int getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(int isOnline) {
        this.isOnline = isOnline;
    }
    private int isOnTrip;

    @Column(name = "is_on_trip", nullable = false)
    public int getIsOnTrip() {
        return isOnTrip;
    }

    public void setIsOnTrip(int isOnTrip) {
        this.isOnTrip = isOnTrip;
    }

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp last_updated_at;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getUserOnlineId() {
        return userOnlineId;
    }

    public void setUserOnlineId(Long userOnlineId) {
        this.userOnlineId = userOnlineId;
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

    public CabsOnline() {
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
        final CabsOnline other = (CabsOnline) obj;
        return true;
    }

    public CabsOnline(Long userOnlineId, String source, String destination, float sourceLat, float sourceLng, float destinationLat, float destinationLng, int isOnline, int isOnTrip, Timestamp createdAt, Timestamp updatedAt, Timestamp last_updated_at, User user) {
        this.userOnlineId = userOnlineId;
        this.source = source;
        this.destination = destination;
        this.sourceLat = sourceLat;
        this.sourceLng = sourceLng;
        this.destinationLat = destinationLat;
        this.destinationLng = destinationLng;
        this.isOnline = isOnline;
        this.isOnTrip = isOnTrip;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.last_updated_at = last_updated_at;
        this.user = user;
    }

   

}
