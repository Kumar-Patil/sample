package com.taxi.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author
 */
@Entity
@Table(name = "drivers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Drivers implements Serializable {

    private Long driverId;
    private String firstName;
    private String lastName;
    private String photo;
    private int status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private User user;
    private Locations locations;
    private String mobileNo;
    private String email;
    private Vendors vendors;
    private Cabs cabs;

    private String sex;
    private String password;
    private String otherPhone;
    private String address;
    private Timestamp startDate;
    private String driverLicenceNumber;
    private Timestamp driverLicenceExpiry;
    private String insuranceNumber;
    private DriverAttributes driverAttributes;
    private DriverDocuments driverDocuments;

    private String aliasName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Column(name = "first_name", nullable = true)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = true)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "photo", nullable = true)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "created_at", nullable = false)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "updated_at", nullable = false)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Column(name = "deleted_at", nullable = true)
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = true)
    public Locations getLocations() {
        return locations;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }

    @Column(name = "phone", nullable = true)
    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Column(name = "email", nullable = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = false)
    public Vendors getVendors() {
        return vendors;
    }

    public void setVendors(Vendors vendors) {
        this.vendors = vendors;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cab_id", nullable = false)
    public Cabs getCabs() {
        return cabs;
    }

    public void setCabs(Cabs cabs) {
        this.cabs = cabs;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_attributes_id", nullable = false)
    public DriverAttributes getDriverAttributes() {
        return driverAttributes;
    }

    public void setDriverAttributes(DriverAttributes driverAttributes) {
        this.driverAttributes = driverAttributes;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_documents_id", nullable = false)
    public DriverDocuments getDriverDocuments() {
        return driverDocuments;
    }

    public void setDriverDocuments(DriverDocuments driverDocuments) {
        this.driverDocuments = driverDocuments;
    }

    @Override
    public String toString() {
        return "Drivers{" + "driverId=" + driverId + ", firstName=" + firstName + ", lastName=" + lastName + ", photo=" + photo + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + ", user=" + user + ", locations=" + locations + ", mobileNo=" + mobileNo + ", email=" + email + ", vendors=" + vendors + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.driverId);
        hash = 89 * hash + Objects.hashCode(this.firstName);
        hash = 89 * hash + Objects.hashCode(this.lastName);
        hash = 89 * hash + Objects.hashCode(this.photo);
        hash = 89 * hash + this.status;
        hash = 89 * hash + Objects.hashCode(this.createdAt);
        hash = 89 * hash + Objects.hashCode(this.updatedAt);
        hash = 89 * hash + Objects.hashCode(this.deletedAt);
        hash = 89 * hash + Objects.hashCode(this.user);
        hash = 89 * hash + Objects.hashCode(this.locations);
        hash = 89 * hash + Objects.hashCode(this.mobileNo);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.vendors);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Drivers other = (Drivers) obj;
        return true;
    }

    @Column(name = "sex", nullable = false)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "other_phone", nullable = false)
    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    @Column(name = "address", nullable = true)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "start_date", nullable = true)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Column(name = "driver_licence_number", nullable = true)
    public String getDriverLicenceNumber() {
        return driverLicenceNumber;
    }

    public void setDriverLicenceNumber(String driverLicenceNumber) {
        this.driverLicenceNumber = driverLicenceNumber;
    }

    @Column(name = "driver_licence_expiry", nullable = true)
    public Timestamp getDriverLicenceExpiry() {
        return driverLicenceExpiry;
    }

    public void setDriverLicenceExpiry(Timestamp driverLicenceExpiry) {
        this.driverLicenceExpiry = driverLicenceExpiry;
    }

    @Column(name = "insurance_number", nullable = true)
    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    @Column(name = "alias_name", nullable = true)
    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

}
