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
@Table(name = "trips")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Trips implements Serializable {

    private Long tripId;
    private String source;
    private String destination;
    private String trip_status;
    private Timestamp estimated_start_time;
    private Timestamp actual_start_time;
    private Timestamp estimated_end_time;
    private Timestamp actual_end_time;
    private float estimated_distance;
    private float actual_distance;
    private float estimated_fare;
    private float actual_fare;
    private float lat;
    private float lng;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp last_updated_at;
    private User userRider;
    private User userVendor;
    private User userDriver;
    private Cabs cab;
    private String event_message;
    private float destination_lat;

    private float destination_lng;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    @Column(name = "source", nullable = false)
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Column(name = "destination", nullable = false)
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Column(name = "trip_status", nullable = false)
    public String getTrip_status() {
        return trip_status;
    }

    public void setTrip_status(String trip_status) {
        this.trip_status = trip_status;
    }

    @Column(name = "estimated_start_time", nullable = false)
    public Timestamp getEstimated_start_time() {
        return estimated_start_time;
    }

    public void setEstimated_start_time(Timestamp estimated_start_time) {
        this.estimated_start_time = estimated_start_time;
    }

    @Column(name = "actual_start_time", nullable = false)
    public Timestamp getActual_start_time() {
        return actual_start_time;
    }

    public void setActual_start_time(Timestamp actual_start_time) {
        this.actual_start_time = actual_start_time;
    }

    @Column(name = "estimated_end_time", nullable = false)
    public Timestamp getEstimated_end_time() {
        return estimated_end_time;
    }

    public void setEstimated_end_time(Timestamp estimated_end_time) {
        this.estimated_end_time = estimated_end_time;
    }

    @Column(name = "actual_end_time", nullable = false)
    public Timestamp getActual_end_time() {
        return actual_end_time;
    }

    public void setActual_end_time(Timestamp actual_end_time) {
        this.actual_end_time = actual_end_time;
    }

    @Column(name = "estimated_distance", nullable = false)
    public float getEstimated_distance() {
        return estimated_distance;
    }

    public void setEstimated_distance(float estimated_distance) {
        this.estimated_distance = estimated_distance;
    }

    @Column(name = "actual_distance", nullable = false)
    public float getActual_distance() {
        return actual_distance;
    }

    public void setActual_distance(float actual_distance) {
        this.actual_distance = actual_distance;
    }

    @Column(name = "estimated_fare", nullable = false)
    public float getEstimated_fare() {
        return estimated_fare;
    }

    public void setEstimated_fare(float estimated_fare) {
        this.estimated_fare = estimated_fare;
    }

    @Column(name = "actual_fare", nullable = false)
    public float getActual_fare() {
        return actual_fare;
    }

    public void setActual_fare(float actual_fare) {
        this.actual_fare = actual_fare;
    }

    @Column(name = "source_lat", nullable = false)
    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    @Column(name = "source_lng", nullable = false)
    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
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

    @Column(name = "last_updated_at", nullable = false)
    public Timestamp getLast_updated_at() {
        return last_updated_at;
    }

    public void setLast_updated_at(Timestamp last_updated_at) {
        this.last_updated_at = last_updated_at;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rider_id", nullable = true)
    public User getUserRider() {
        return userRider;
    }

    public void setUserRider(User userRider) {
        this.userRider = userRider;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = true)
    public User getUserVendor() {
        return userVendor;
    }

    public void setUserVendor(User userVendor) {
        this.userVendor = userVendor;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = true)
    public User getUserDriver() {
        return userDriver;
    }

    public void setUserDriver(User userDriver) {
        this.userDriver = userDriver;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cab_id", nullable = true)
    public Cabs getCab() {
        return cab;
    }

    public void setCab(Cabs cab) {
        this.cab = cab;
    }

    @Column(name = "event_message", nullable = false)
    public String getEvent_message() {
        return event_message;
    }

    public void setEvent_message(String event_message) {
        this.event_message = event_message;
    }

    @Column(name = "destincation_lat", nullable = false)
    public float getDestination_lat() {
        return destination_lat;
    }

    public void setDestination_lat(float destination_lat) {
        this.destination_lat = destination_lat;
    }

    @Column(name = "destination_lng", nullable = false)
    public float getDestination_lng() {
        return destination_lng;
    }

    public void setDestination_lng(float destination_lng) {
        this.destination_lng = destination_lng;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.tripId);
        hash = 41 * hash + Objects.hashCode(this.source);
        hash = 41 * hash + Objects.hashCode(this.destination);
        hash = 41 * hash + Objects.hashCode(this.trip_status);
        hash = 41 * hash + Objects.hashCode(this.estimated_start_time);
        hash = 41 * hash + Objects.hashCode(this.actual_start_time);
        hash = 41 * hash + Objects.hashCode(this.estimated_end_time);
        hash = 41 * hash + Objects.hashCode(this.actual_end_time);
        hash = 41 * hash + Float.floatToIntBits(this.estimated_distance);
        hash = 41 * hash + Float.floatToIntBits(this.actual_distance);
        hash = 41 * hash + Float.floatToIntBits(this.estimated_fare);
        hash = 41 * hash + Float.floatToIntBits(this.actual_fare);
        hash = 41 * hash + Float.floatToIntBits(this.lat);
        hash = 41 * hash + Float.floatToIntBits(this.lng);
        hash = 41 * hash + Objects.hashCode(this.createdAt);
        hash = 41 * hash + Objects.hashCode(this.updatedAt);
        hash = 41 * hash + Objects.hashCode(this.last_updated_at);
        hash = 41 * hash + Objects.hashCode(this.userRider);
        hash = 41 * hash + Objects.hashCode(this.userVendor);
        hash = 41 * hash + Objects.hashCode(this.userDriver);
        hash = 41 * hash + Objects.hashCode(this.cab);
        hash = 41 * hash + Objects.hashCode(this.event_message);
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
        final Trips other = (Trips) obj;
        return true;
    }

    public Trips() {
    }

    public Trips(Long tripId, String source, String destination, String trip_status, Timestamp estimated_start_time, Timestamp actual_start_time, Timestamp estimated_end_time, Timestamp actual_end_time, float estimated_distance, float actual_distance, float estimated_fare, float actual_fare, float lat, float lng, Timestamp createdAt, Timestamp updatedAt, Timestamp last_updated_at, User userRider, User userVendor, User userDriver, Cabs cab) {
        this.tripId = tripId;
        this.source = source;
        this.destination = destination;
        this.trip_status = trip_status;
        this.estimated_start_time = estimated_start_time;
        this.actual_start_time = actual_start_time;
        this.estimated_end_time = estimated_end_time;
        this.actual_end_time = actual_end_time;
        this.estimated_distance = estimated_distance;
        this.actual_distance = actual_distance;
        this.estimated_fare = estimated_fare;
        this.actual_fare = actual_fare;
        this.lat = lat;
        this.lng = lng;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.last_updated_at = last_updated_at;
        this.userRider = userRider;
        this.userVendor = userVendor;
        this.userDriver = userDriver;
        this.cab = cab;
    }

}
