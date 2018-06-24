package com.taxi.RequestMapper;

import java.sql.Timestamp;

/**
 *
 * @author Santosh
 */
public class UserRequestMapper {
    private long id;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getHireDate() {
        return hireDate;
    }

    public void setHireDate(Timestamp hireDate) {
        this.hireDate = hireDate;
    }

    public Timestamp getHireEndDate() {
        return hireEndDate;
    }

    public void setHireEndDate(Timestamp hireEndDate) {
        this.hireEndDate = hireEndDate;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getProofOfAddress() {
        return proofOfAddress;
    }

    public void setProofOfAddress(String proofOfAddress) {
        this.proofOfAddress = proofOfAddress;
    }

    public String getAggrement1() {
        return aggrement1;
    }

    public void setAggrement1(String aggrement1) {
        this.aggrement1 = aggrement1;
    }

    public String getAggrement2() {
        return aggrement2;
    }

    public void setAggrement2(String aggrement2) {
        this.aggrement2 = aggrement2;
    }

    public String getAggrement3() {
        return aggrement3;
    }

    public void setAggrement3(String aggrement3) {
        this.aggrement3 = aggrement3;
    }

    public String getAggrement4() {
        return aggrement4;
    }

    public void setAggrement4(String aggrement4) {
        this.aggrement4 = aggrement4;
    }
    /* Location Details */
    private String street;
    private String zip;
    private int cityId;
    private int stateId;
    private int countryId;
    private String address;
    
    /* Added new column */
    private Timestamp hireDate;
    private Timestamp hireEndDate;
    
    /* Documents */
    private String userPic;
    private String proofOfAddress;
    private String aggrement1;
    private String aggrement2;
    private String aggrement3;
    private String aggrement4;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    private String firstName;
    private String lastName;

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
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String role;
    private String phone;
    private String email;
    private String password;
}
