package com.taxi.util;

/**
 *
 * @author santopat
 */
public class PolylineData {

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    private float lat;
    private float lng;
    private String lable;
    private String iconUrl;
    private boolean draggable;

    public PolylineData(float lat, float lng, String lable, String iconUrl, boolean draggable) {
        this.lat = lat;
        this.lng = lng;
        this.lable = lable;
        this.iconUrl = iconUrl;
        this.draggable = draggable;
    }

    public boolean isDraggable() {
        return draggable;
    }

    public void setDraggable(boolean draggable) {
        this.draggable = draggable;
    }
}
