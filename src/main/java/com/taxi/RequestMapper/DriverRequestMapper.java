package com.taxi.RequestMapper;

import java.sql.Timestamp;

/**
 *
 * @author
 */
public class DriverRequestMapper {

    private long driverId;
    private int status;
    private String firstName;
    private String lastName;
    private String photo;
    private String address;
    private long cabId;
    private String email;
    private String mobileNo;
    private String street;
    private String zip;
    private int cityId;
    private int stateId;
    private int countryId;

    private String sex;
    private String password;
    private String otherPhone;
    private Timestamp startDate;
    private String driverLicenceNumber;
    private Timestamp driverLicenceExpiry;

    private String crb;
    private String delivery;
    private String female;
    private String luggage;
    private String NHS;
    private String pets;
    private String uniformed;
    private String topman;
    private long driverAttribteId;

    private String policeDisclose;
    private String proofOfAddress;
    private String licencePhoto;
    private String pcoLicence;
    private String agreement;
    private String licencePaper;
    private String insurance;
    private Long driverDocumentId;
    private String aliasName;

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getPoliceDisclose() {
        return policeDisclose;
    }

    public void setPoliceDisclose(String policeDisclose) {
        this.policeDisclose = policeDisclose;
    }

    public String getProofOfAddress() {
        return proofOfAddress;
    }

    public void setProofOfAddress(String proofOfAddress) {
        this.proofOfAddress = proofOfAddress;
    }

    public String getLicencePhoto() {
        return licencePhoto;
    }

    public void setLicencePhoto(String licencePhoto) {
        this.licencePhoto = licencePhoto;
    }

    public String getPcoLicence() {
        return pcoLicence;
    }

    public void setPcoLicence(String pcoLicence) {
        this.pcoLicence = pcoLicence;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getLicencePaper() {
        return licencePaper;
    }

    public void setLicencePaper(String licencePaper) {
        this.licencePaper = licencePaper;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public Long getDriverDocumentId() {
        return driverDocumentId;
    }

    public void setDriverDocumentId(Long driverDocumentId) {
        this.driverDocumentId = driverDocumentId;
    }

    public String getCrb() {
        return crb;
    }

    public void setCrb(String crb) {
        this.crb = crb;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    public String getNHS() {
        return NHS;
    }

    public void setNHS(String NHS) {
        this.NHS = NHS;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    public String getUniformed() {
        return uniformed;
    }

    public void setUniformed(String uniformed) {
        this.uniformed = uniformed;
    }

    public String getTopman() {
        return topman;
    }

    public void setTopman(String topman) {
        this.topman = topman;
    }

    public long getDriverAttribteId() {
        return driverAttribteId;
    }

    public void setDriverAttribteId(long driverAttribteId) {
        this.driverAttribteId = driverAttribteId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public String getDriverLicenceNumber() {
        return driverLicenceNumber;
    }

    public void setDriverLicenceNumber(String driverLicenceNumber) {
        this.driverLicenceNumber = driverLicenceNumber;
    }

    public Timestamp getDriverLicenceExpiry() {
        return driverLicenceExpiry;
    }

    public void setDriverLicenceExpiry(Timestamp driverLicenceExpiry) {
        this.driverLicenceExpiry = driverLicenceExpiry;
    }

    public long getCabId() {
        return cabId;
    }

    public void setCabId(long cabId) {
        this.cabId = cabId;
    }

    public DriverRequestMapper() {

    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

}
