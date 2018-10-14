package com.taxi.RequestMapper;

/**
 *
 * @author santopat
 */
public class OnlineUserPushData {

    private String source;
    private String destination;
    private float sourceLat;
    private float sourceLng;
    private float destinationLng;
    private float destinationLat;
    private int isOnline;

    public int getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(int isOnline) {
        this.isOnline = isOnline;
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

    public float getSourceLat() {
        return sourceLat;
    }

    public void setSourceLat(float sourceLat) {
        this.sourceLat = sourceLat;
    }

    public float getSourceLng() {
        return sourceLng;
    }

    public void setSourceLng(float sourceLng) {
        this.sourceLng = sourceLng;
    }

    public float getDestinationLng() {
        return destinationLng;
    }

    public void setDestinationLng(float destinationLng) {
        this.destinationLng = destinationLng;
    }

    public float getDestinationLat() {
        return destinationLat;
    }

    public void setDestinationLat(float destinationLat) {
        this.destinationLat = destinationLat;
    }

}
