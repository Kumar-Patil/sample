package com.taxi.to;

/**
 *
 * @author santopat
 */
public class TripsInProgress {

    private Long tripId;
    private Long userId;
    private String driver;
    private String source;
    private String destination;

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTimeElap() {
        return timeElap;
    }

    public void setTimeElap(int timeElap) {
        this.timeElap = timeElap;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TripsInProgress(Long tripId, Long userId, String driver, String source, String destination, int timeElap, int eta, String status) {
        this.tripId = tripId;
        this.userId = userId;
        this.driver = driver;
        this.source = source;
        this.destination = destination;
        this.timeElap = timeElap;
        this.eta = eta;
        this.status = status;
    }
    private int timeElap;
    private int eta;
    private String status;
}
