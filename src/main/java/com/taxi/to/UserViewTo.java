package com.taxi.to;

import java.sql.Timestamp;

/**
 *
 * @author Santosh
 */
public class UserViewTo {

    /* Documents */
    private String userPic;
    private String proofOfAddress;
    private String aggrement1;
    private String aggrement2;
    private String aggrement3;
    private String aggrement4;

    /* Added new column */
    private Timestamp hireDate;
    private Timestamp hireEndDate;
    private String otherphone;
    private String sex;
    private String name;
    private String ifsc;
    private String accountNo;
    private Timestamp createdAt;
    private Timestamp updateAt;
    private Timestamp deletedAt;

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }
    /* Location Details */
    private String street;
    private String zip;
    private String cityName;
    private String stateName;
    private String countryName;
    private String address;

    private String status;
    private String role;
    private String phone;
    private String email;
    private String firstName;
    private String lastName;

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

    public String getOtherphone() {
        return otherphone;
    }

    public void setOtherphone(String otherphone) {
        this.otherphone = otherphone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public UserViewTo() {
    }

    public UserViewTo(String userPic, String proofOfAddress, String aggrement1, String aggrement2, String aggrement3, String aggrement4, Timestamp hireDate, Timestamp hireEndDate, String otherphone, String sex, String name, String ifsc, String accountNo, Timestamp createdAt, Timestamp updateAt, Timestamp deletedAt, String street, String zip, String cityName, String stateName, String countryName, String address, String status, String role, String phone, String email, String firstName, String lastName) {
        this.userPic = userPic;
        this.proofOfAddress = proofOfAddress;
        this.aggrement1 = aggrement1;
        this.aggrement2 = aggrement2;
        this.aggrement3 = aggrement3;
        this.aggrement4 = aggrement4;
        this.hireDate = hireDate;
        this.hireEndDate = hireEndDate;
        this.otherphone = otherphone;
        this.sex = sex;
        this.name = name;
        this.ifsc = ifsc;
        this.accountNo = accountNo;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.deletedAt = deletedAt;
        this.street = street;
        this.zip = zip;
        this.cityName = cityName;
        this.stateName = stateName;
        this.countryName = countryName;
        this.address = address;
        this.status = status;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
