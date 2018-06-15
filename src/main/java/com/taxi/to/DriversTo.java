package com.taxi.to;

/**
 *
 * @author
 */
public class DriversTo {

    private String firstName;
    private String lastName;
    private int status;
    private String mobileNo;
    private String email;
    private long driverId;
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public DriversTo() {
    }

    public DriversTo(String firstName, String lastName, String sex, int status, String mobileNo, String email, long driverId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.status = status;
        this.mobileNo = mobileNo;
        this.email = email;
        this.driverId = driverId;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
