package com.taxi.to;

/**
 *
 * @author santopat
 */
public class VendorMap {

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
    private String vendorRegNo;
    private long userId;
    private int status;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getVendorRegNo() {
        return vendorRegNo;
    }

    public void setVendorRegNo(String vendorRegNo) {
        this.vendorRegNo = vendorRegNo;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
