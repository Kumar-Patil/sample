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
 * @author Santosh
 */
@Entity
@Table(name = "driver_online")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DriverCabOnline implements Serializable {

    private Long driverOnlineId;
    private String source;
    private String destination;
    private float lat;
    private float lng;
    private int is_online;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp last_updated_at;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getDriverOnlineId() {
        return driverOnlineId;
    }

    public void setDriverOnlineId(Long driverOnlineId) {
        this.driverOnlineId = driverOnlineId;
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

    @Column(name = "lat", nullable = false)
    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    @Column(name = "lng", nullable = false)
    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    @Column(name = "is_online", nullable = false)
    public int getIs_online() {
        return is_online;
    }

    public void setIs_online(int is_online) {
        this.is_online = is_online;
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

    public DriverCabOnline(Long driverOnlineId, String source, String destination, float lat, float lng, int is_online, Timestamp createdAt, Timestamp updatedAt, Timestamp last_updated_at, User user) {
        this.driverOnlineId = driverOnlineId;
        this.source = source;
        this.destination = destination;
        this.lat = lat;
        this.lng = lng;
        this.is_online = is_online;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.last_updated_at = last_updated_at;
        this.user = user;
    }

    public DriverCabOnline() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.driverOnlineId);
        hash = 53 * hash + Objects.hashCode(this.source);
        hash = 53 * hash + Objects.hashCode(this.destination);
        hash = 53 * hash + Float.floatToIntBits(this.lat);
        hash = 53 * hash + Float.floatToIntBits(this.lng);
        hash = 53 * hash + this.is_online;
        hash = 53 * hash + Objects.hashCode(this.createdAt);
        hash = 53 * hash + Objects.hashCode(this.updatedAt);
        hash = 53 * hash + Objects.hashCode(this.last_updated_at);
        hash = 53 * hash + Objects.hashCode(this.user);
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
        final DriverCabOnline other = (DriverCabOnline) obj;
        return true;
    }

    @Override
    public String toString() {
        return "UserOnline{" + "driverOnlineId=" + driverOnlineId + ", source=" + source + ", destination=" + destination + ", lat=" + lat + ", lng=" + lng + ", is_online=" + is_online + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", last_updated_at=" + last_updated_at + ", user=" + user + '}';
    }

}
