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
@Table(name = "bank_account_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BankAccountDetails implements Serializable {

    private Long accountId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private String name;
    private String ifsc;
    private String accountNo;
    private String adddress;
    private String adddress1;
    private String adddress2;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ifsc", nullable = false)
    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    @Column(name = "account_no", nullable = false)
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Column(name = "adddress", nullable = false)
    public String getAdddress() {
        return adddress;
    }

    public void setAdddress(String adddress) {
        this.adddress = adddress;
    }

    @Column(name = "adddress1", nullable = false)
    public String getAdddress1() {
        return adddress1;
    }

    public void setAdddress1(String adddress1) {
        this.adddress1 = adddress1;
    }

    @Column(name = "adddress2", nullable = false)
    public String getAdddress2() {
        return adddress2;
    }

    public void setAdddress2(String adddress2) {
        this.adddress2 = adddress2;
    }

    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    private int status;

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
        final BankAccountDetails other = (BankAccountDetails) obj;
        return true;
    }

    @Override
    public String toString() {
        return "BankAccountDetails{" + "accountId=" + accountId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + ", name=" + name + ", ifsc=" + ifsc + ", accountNo=" + accountNo + ", adddress=" + adddress + ", adddress1=" + adddress1 + ", adddress2=" + adddress2 + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.accountId);
        hash = 59 * hash + Objects.hashCode(this.createdAt);
        hash = 59 * hash + Objects.hashCode(this.updatedAt);
        hash = 59 * hash + Objects.hashCode(this.deletedAt);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.ifsc);
        hash = 59 * hash + Objects.hashCode(this.accountNo);
        hash = 59 * hash + Objects.hashCode(this.adddress);
        hash = 59 * hash + Objects.hashCode(this.adddress1);
        hash = 59 * hash + Objects.hashCode(this.adddress2);
        return hash;
    }

    public BankAccountDetails(Long accountId, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt, String name, String ifsc, String accountNo, String adddress, String adddress1, String adddress2) {
        this.accountId = accountId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.name = name;
        this.ifsc = ifsc;
        this.accountNo = accountNo;
        this.adddress = adddress;
        this.adddress1 = adddress1;
        this.adddress2 = adddress2;
    }

}
