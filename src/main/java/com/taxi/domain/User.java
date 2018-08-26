package com.taxi.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String role;
    private String phone;
    private String email;
    private String password;
    private int status;
    private int phoneVerified;
    private int emailVerified;
    private String APIToken;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private String OTPValue;
    private String firstName;
    private String lastName;

    //Additional Cloumns
    private Timestamp hireDate;
    private Timestamp hireEndDate;
    private String otherphone;
    private String sex;
    private BankAccountDetails accountDetails;
    private UserDocuments userDocuments;
    private Locations Locations;
    private String regNo;

    //Addition fields added
    private Timestamp dob;
    private String current_possition;
    private String father_name;
    private Timestamp licence_expiry_date;
    private Timestamp insurance_expiry_Date;
    private String insurance_number;
    private String licence_number;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_USER_DETAILS")
    @SequenceGenerator(name = "SEQ_USER_DETAILS", sequenceName = "user_id_seq")
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Column(name = "role", length = 50, nullable = false)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "phone", length = 255, nullable = false)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "email", length = 255, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", length = 255, nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "phone_verified", length = 4, nullable = true)
    public int getPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(int phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    @Column(name = "email_verified", length = 4, nullable = true)
    public int getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(int emailVerified) {
        this.emailVerified = emailVerified;
    }

    @Column(name = "remember_token", length = 255, nullable = true)
    public String getAPIToken() {
        return APIToken;
    }

    public void setAPIToken(String APIToken) {
        this.APIToken = APIToken;
    }

    @Column(name = "created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "updated_at")
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

    @Column(name = "OTP_VALUE", nullable = true)
    public String getOTPValue() {
        return OTPValue;
    }

    public void setOTPValue(String oTPValue) {
        OTPValue = oTPValue;
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

    @Column(name = "hire_date", nullable = true)
    public Timestamp getHireDate() {
        return hireDate;
    }

    public void setHireDate(Timestamp hireDate) {
        this.hireDate = hireDate;
    }

    @Column(name = "hire_end_date", nullable = true)
    public Timestamp getHireEndDate() {
        return hireEndDate;
    }

    public void setHireEndDate(Timestamp hireEndDate) {
        this.hireEndDate = hireEndDate;
    }

    @Column(name = "otherphone", nullable = true)
    public String getOtherphone() {
        return otherphone;
    }

    public void setOtherphone(String otherphone) {
        this.otherphone = otherphone;
    }

    @Column(name = "sex", nullable = true)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_bank_account_id", nullable = true)
    public BankAccountDetails getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(BankAccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_document_id", nullable = true)
    public UserDocuments getUserDocuments() {
        return userDocuments;
    }

    public void setUserDocuments(UserDocuments userDocuments) {
        this.userDocuments = userDocuments;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = true)
    public Locations getLocations() {
        return Locations;
    }

    public void setLocations(Locations Locations) {
        this.Locations = Locations;
    }

    @Column(name = "vendor_registration_no", nullable = true)
    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    @Column(name = "dob", nullable = true)
    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
    }

    @Column(name = "current_possition", nullable = true)
    public String getCurrent_possition() {
        return current_possition;
    }

    public void setCurrent_possition(String current_possition) {
        this.current_possition = current_possition;
    }

    @Column(name = "father_name", nullable = true)
    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    @Column(name = "licence_expiry_date", nullable = true)
    public Timestamp getLicence_expiry_date() {
        return licence_expiry_date;
    }

    public void setLicence_expiry_date(Timestamp licence_expiry_date) {
        this.licence_expiry_date = licence_expiry_date;
    }

    @Column(name = "insurance_expiry_Date", nullable = true)
    public Timestamp getInsurance_expiry_Date() {
        return insurance_expiry_Date;
    }

    public void setInsurance_expiry_Date(Timestamp insurance_expiry_Date) {
        this.insurance_expiry_Date = insurance_expiry_Date;
    }

    @Column(name = "insurance_number", nullable = true)
    public String getInsurance_number() {
        return insurance_number;
    }

    public void setInsurance_number(String insurance_number) {
        this.insurance_number = insurance_number;
    }

    @Column(name = "licence_number", nullable = true)
    public String getLicence_number() {
        return licence_number;
    }

    public void setLicence_number(String licence_number) {
        this.licence_number = licence_number;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 23 * hash + Objects.hashCode(this.role);
        hash = 23 * hash + Objects.hashCode(this.phone);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.password);
        hash = 23 * hash + this.status;
        hash = 23 * hash + Objects.hashCode(this.phoneVerified);
        hash = 23 * hash + Objects.hashCode(this.emailVerified);
        hash = 23 * hash + Objects.hashCode(this.APIToken);
        hash = 23 * hash + Objects.hashCode(this.createdAt);
        hash = 23 * hash + Objects.hashCode(this.updatedAt);
        hash = 23 * hash + Objects.hashCode(this.deletedAt);
        hash = 23 * hash + Objects.hashCode(this.OTPValue);
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
        final User other = (User) obj;
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", role=" + role + ", phone=" + phone + ", email=" + email + ", password=" + password + ", status=" + status + ", phoneVerified=" + phoneVerified + ", emailVerified=" + emailVerified + ", APIToken=" + APIToken + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + ", OTPValue=" + OTPValue + '}';
    }

}
