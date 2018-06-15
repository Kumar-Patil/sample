package com.taxi.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author
 */
@Entity
@Table(name = "driver_documents")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DriverDocuments implements Serializable {

    private String policeDisclose;
    private String proofOfAddress;
    private String licencePhoto;
    private String pcoLicence;
    private String agreement;
    private String licencePaper;

    public DriverDocuments() {
    }
    private String insurance;
    private long driverDocumentId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public long getDriverDocumentId() {
        return driverDocumentId;
    }

    public void setDriverDocumentId(long driverDocumentId) {
        this.driverDocumentId = driverDocumentId;
    }

    @Column(name = "police_disclouser", nullable = true)
    public String getPoliceDisclose() {
        return policeDisclose;
    }

    public void setPoliceDisclose(String policeDisclose) {
        this.policeDisclose = policeDisclose;
    }

    @Column(name = "proof_of_address", nullable = true)
    public String getProofOfAddress() {
        return proofOfAddress;
    }

    public void setProofOfAddress(String proofOfAddress) {
        this.proofOfAddress = proofOfAddress;
    }

    @Column(name = "licence_photo", nullable = true)
    public String getLicencePhoto() {
        return licencePhoto;
    }

    public void setLicencePhoto(String licencePhoto) {
        this.licencePhoto = licencePhoto;
    }

    @Column(name = "pco_licence", nullable = true)
    public String getPcoLicence() {
        return pcoLicence;
    }

    public void setPcoLicence(String pcoLicence) {
        this.pcoLicence = pcoLicence;
    }

    @Column(name = "agreement", nullable = true)
    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    @Column(name = "licence_papers", nullable = true)
    public String getLicencePaper() {
        return licencePaper;
    }

    public void setLicencePaper(String licencePaper) {
        this.licencePaper = licencePaper;
    }

    @Column(name = "inurance", nullable = true)
    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    @Column(name = "created_at", nullable = true)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "updated_at", nullable = true)
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

    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    private int status;
}
