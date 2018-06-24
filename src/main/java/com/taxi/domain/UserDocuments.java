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
@Table(name = "user_documents")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserDocuments implements Serializable {

    private Long userId;

    public UserDocuments() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getUserId() {
        return userId;
    }

    public void setDocumentId(Long userId) {
        this.userId = userId;
    }
    private String userPic;
    private String proofOfAddress;
    private String aggrement1;
    private String aggrement2;
    private String aggrement3;
    private String aggrement4;

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    @Column(name = "proof_of_address", nullable = true)
    public String getProofOfAddress() {
        return proofOfAddress;
    }

    public void setProofOfAddress(String proofOfAddress) {
        this.proofOfAddress = proofOfAddress;
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
        final UserDocuments other = (UserDocuments) obj;
        return true;
    }

    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    private int status;

    @Column(name = "user_pic", nullable = true)
    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    @Column(name = "aggrement1", nullable = true)
    public String getAggrement1() {
        return aggrement1;
    }

    public void setAggrement1(String aggrement1) {
        this.aggrement1 = aggrement1;
    }

    @Column(name = "aggrement2", nullable = true)
    public String getAggrement2() {
        return aggrement2;
    }

    public void setAggrement2(String aggrement2) {
        this.aggrement2 = aggrement2;
    }

    @Column(name = "aggrement3", nullable = true)
    public String getAggrement3() {
        return aggrement3;
    }

    public void setAggrement3(String aggrement3) {
        this.aggrement3 = aggrement3;
    }

    @Column(name = "aggrement4", nullable = true)
    public String getAggrement4() {
        return aggrement4;
    }

    public void setAggrement4(String aggrement4) {
        this.aggrement4 = aggrement4;
    }
}
