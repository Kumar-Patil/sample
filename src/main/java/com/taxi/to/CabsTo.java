package com.taxi.to;

import java.sql.Timestamp;

/**
 *
 * @author
 */
public class CabsTo {

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private Long cabId;
    private String cabType;
    private String cabModel;
    private String cabColor;
    private String cabNo;
    private String cabRegistrationNo;
    private String status;
    private String plateNumber;

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Long getCabId() {
        return cabId;
    }

    public void setCabId(Long cabId) {
        this.cabId = cabId;
    }

    public String getCabType() {
        return cabType;
    }

    public void setCabType(String cabType) {
        this.cabType = cabType;
    }

    public String getCabModel() {
        return cabModel;
    }

    public void setCabModel(String cabModel) {
        this.cabModel = cabModel;
    }

    public String getCabColor() {
        return cabColor;
    }

    public void setCabColor(String cabColor) {
        this.cabColor = cabColor;
    }

    public String getCabNo() {
        return cabNo;
    }

    public void setCabNo(String cabNo) {
        this.cabNo = cabNo;
    }

    public String getCabRegistrationNo() {
        return cabRegistrationNo;
    }

    public void setCabRegistrationNo(String cabRegistrationNo) {
        this.cabRegistrationNo = cabRegistrationNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CabsTo(Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt, Long cabId, String cabType, String cabModel, String cabColor, String cabNo, String cabRegistrationNo, String status, String plateNumber) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.cabId = cabId;
        this.cabType = cabType;
        this.cabModel = cabModel;
        this.cabColor = cabColor;
        this.cabNo = cabNo;
        this.cabRegistrationNo = cabRegistrationNo;
        this.status = status;
        this.plateNumber = plateNumber;
    }

}
