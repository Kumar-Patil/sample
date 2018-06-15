package com.taxi.to;

/**
 *
 *
 */
public class VendorsTo {

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
    private long id;
    private String status;
    private String vendorRegistrationNo;

    public String getVendorRegistrationNo() {
        return vendorRegistrationNo;
    }

    public void setVendorRegistrationNo(String vendorRegistrationNo) {
        this.vendorRegistrationNo = vendorRegistrationNo;
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public VendorsTo(String firstName, String lastName, String email, String mobileNo, long id, String status, String vendorRegistrationNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNo = mobileNo;
        this.id = id;
        this.status = status;
        this.vendorRegistrationNo = vendorRegistrationNo;
    }

}
