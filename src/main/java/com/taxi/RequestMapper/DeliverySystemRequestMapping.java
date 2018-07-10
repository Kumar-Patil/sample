package com.taxi.RequestMapper;

import com.taxi.domain.User;
import java.sql.Timestamp;

/**
 *
 * @author Santosh
 */
public class DeliverySystemRequestMapping {

    private Long deliveryId;

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrderCategory() {
        return orderCategory;
    }

    public void setOrderCategory(String orderCategory) {
        this.orderCategory = orderCategory;
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

    public Timestamp getBookingAt() {
        return bookingAt;
    }

    public void setBookingAt(Timestamp bookingAt) {
        this.bookingAt = bookingAt;
    }

    public Timestamp getDeliveryAt() {
        return deliveryAt;
    }

    public void setDeliveryAt(Timestamp deliveryAt) {
        this.deliveryAt = deliveryAt;
    }

    public Timestamp getPickUpAt() {
        return pickUpAt;
    }

    public void setPickUpAt(Timestamp pickUpAt) {
        this.pickUpAt = pickUpAt;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }

    public String getContactPersonMobileno() {
        return contactPersonMobileno;
    }

    public void setContactPersonMobileno(String contactPersonMobileno) {
        this.contactPersonMobileno = contactPersonMobileno;
    }

    public String getPickUpAddress() {
        return pickUpAddress;
    }

    public void setPickUpAddress(String pickUpAddress) {
        this.pickUpAddress = pickUpAddress;
    }

    public String getPickUpPinCode() {
        return pickUpPinCode;
    }

    public void setPickUpPinCode(String pickUpPinCode) {
        this.pickUpPinCode = pickUpPinCode;
    }

    public String getReciptentName() {
        return reciptentName;
    }

    public void setReciptentName(String reciptentName) {
        this.reciptentName = reciptentName;
    }

    public String getReciptentMobileNo() {
        return reciptentMobileNo;
    }

    public void setReciptentMobileNo(String reciptentMobileNo) {
        this.reciptentMobileNo = reciptentMobileNo;
    }

    public String getReciptentAddress() {
        return reciptentAddress;
    }

    public void setReciptentAddress(String reciptentAddress) {
        this.reciptentAddress = reciptentAddress;
    }

    public String getReciptentPinCode() {
        return reciptentPinCode;
    }

    public void setReciptentPinCode(String reciptentPinCode) {
        this.reciptentPinCode = reciptentPinCode;
    }

    public String getReciptentEmail() {
        return reciptentEmail;
    }

    public void setReciptentEmail(String reciptentEmail) {
        this.reciptentEmail = reciptentEmail;
    }

    private int status;
    private String orderCategory;
    private String deliveryCurrentStatus;
    private String orderType;
    private String type;
    private Long weight;
    private int noOfUnits;
    private Timestamp bookingAt;
    private Timestamp deliveryAt;
    private Timestamp pickUpAt;
    private String contactPersonName;
    private String contactPersonEmail;
    private String contactPersonMobileno;
    private String pickUpAddress;
    private String pickUpPinCode;
    private String reciptentName;
    private String reciptentMobileNo;
    private String reciptentAddress;
    private String reciptentPinCode;
    private String reciptentEmail;
}
