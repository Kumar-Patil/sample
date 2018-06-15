package com.taxi.RequestMapper;

/**
 *
 * @author
 */
public class VendorRequestMapper {

    private long id;
    private int status;
    private String firstName;
    private String lastName;
    private String photo;
    private String address;
    private String vendorRegistrationNo;

    public String getVendorRegistrationNo() {
        return vendorRegistrationNo;
    }

    public void setVendorRegistrationNo(String vendorRegistrationNo) {
        this.vendorRegistrationNo = vendorRegistrationNo;
    }

    public VendorRequestMapper() {

    }
    private String street;
    private String zip;
    private int cityId;
    private int stateId;
    private int countryId;
    private long locationId;
    private String email;
    private String mobileNo;

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

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public VendorRequestMapper(long id, int status, String firstName, String lastName, String photo, String address, String vendorRegistrationNo, String street, String zip, int cityId, int stateId, int countryId, long locationId, String email, String mobileNo) {
        this.id = id;
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
        this.address = address;
        this.vendorRegistrationNo = vendorRegistrationNo;
        this.street = street;
        this.zip = zip;
        this.cityId = cityId;
        this.stateId = stateId;
        this.countryId = countryId;
        this.locationId = locationId;
        this.email = email;
        this.mobileNo = mobileNo;
    }

}
