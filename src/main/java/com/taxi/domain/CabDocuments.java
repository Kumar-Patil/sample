package com.taxi.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
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
@Table(name = "cabs_documents")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CabDocuments implements Serializable {

    private Long documentId;

    public CabDocuments() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }
    private String policeDisclouser;
    private String proofOfAddress;
    private String licencePhoto;
    private String licencePapers;
    private String pcolicence;
    private String inuranceCopy;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    @Column(name = "police_disclouser", nullable = true)
    public String getPoliceDisclouser() {
        return policeDisclouser;
    }

    public void setPoliceDisclouser(String policeDisclouser) {
        this.policeDisclouser = policeDisclouser;
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

    @Column(name = "licence_papers", nullable = true)
    public String getLicencePapers() {
        return licencePapers;
    }

    public void setLicencePapers(String licencePapers) {
        this.licencePapers = licencePapers;
    }

    @Column(name = "pco_licence", nullable = true)
    public String getPcolicence() {
        return pcolicence;
    }

    public void setPcolicence(String pcolicence) {
        this.pcolicence = pcolicence;
    }

    @Column(name = "inurance_copy", nullable = true)
    public String getInuranceCopy() {
        return inuranceCopy;
    }

    public void setInuranceCopy(String inuranceCopy) {
        this.inuranceCopy = inuranceCopy;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.documentId);
        hash = 71 * hash + Objects.hashCode(this.policeDisclouser);
        hash = 71 * hash + Objects.hashCode(this.proofOfAddress);
        hash = 71 * hash + Objects.hashCode(this.licencePhoto);
        hash = 71 * hash + Objects.hashCode(this.licencePapers);
        hash = 71 * hash + Objects.hashCode(this.pcolicence);
        hash = 71 * hash + Objects.hashCode(this.inuranceCopy);
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
        final CabDocuments other = (CabDocuments) obj;
        return true;
    }

    public CabDocuments(Long documentId, String policeDisclouser, String proofOfAddress, String licencePhoto, String licencePapers, String pcolicence, String inuranceCopy) {
        this.documentId = documentId;
        this.policeDisclouser = policeDisclouser;
        this.proofOfAddress = proofOfAddress;
        this.licencePhoto = licencePhoto;
        this.licencePapers = licencePapers;
        this.pcolicence = pcolicence;
        this.inuranceCopy = inuranceCopy;
    }
}
