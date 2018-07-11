package com.taxi.to;

import java.sql.Timestamp;

/**
 *
 * @author Santosh Patil
 */
public class DeliverySystemTransfer {

    private Timestamp bookingAt;
    private String deliveryCurrentStatus;
    private String orderType;
    private String type;
    private Long weight;
    private int noOfUnits;
    private String contactPersonName;
    private String reciptentName;
    private Long deliveryId;

    public DeliverySystemTransfer() {
    }

    public Timestamp getBookingAt() {
        return bookingAt;
    }

    public void setBookingAt(Timestamp bookingAt) {
        this.bookingAt = bookingAt;
    }

    public String getDeliveryCurrentStatus() {
        return deliveryCurrentStatus;
    }

    public void setDeliveryCurrentStatus(String deliveryCurrentStatus) {
        this.deliveryCurrentStatus = deliveryCurrentStatus;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public int getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(int noOfUnits) {
        this.noOfUnits = noOfUnits;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getReciptentName() {
        return reciptentName;
    }

    public void setReciptentName(String reciptentName) {
        this.reciptentName = reciptentName;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }
}
