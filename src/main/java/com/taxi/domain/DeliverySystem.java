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
@Table(name = "delivery_system")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DeliverySystem implements Serializable {

    private Long deliveryId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private User user;
    private int status;
    private String orderCategory;
    private String deliveryCurrentStatus;
    private String orderType;
    private String type;
    private Long weight;
    private int noOfUnits;
    private Timestamp bookingAt;
    private Timestamp deliveryAt;
    private Timestamp pickUpAt;
    private String contactPersonName;
    private String contactPersonEmail;
    private String contactPersonMobileno;
    private String pickUpAddress;
    private String pickUpPinCode;
    private String reciptentName;
    private String reciptentMobileNo;
    private String reciptentAddress;
    private String reciptentPinCode;
    private String reciptentEmail;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
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

    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "order_category", nullable = true)
    public String getOrderCategory() {
        return orderCategory;
    }

    public void setOrderCategory(String orderCategory) {
        this.orderCategory = orderCategory;
    }

    @Column(name = "delivery_current_status", nullable = true)
    public String getDeliveryCurrentStatus() {
        return deliveryCurrentStatus;
    }

    public void setDeliveryCurrentStatus(String deliveryCurrentStatus) {
        this.deliveryCurrentStatus = deliveryCurrentStatus;
    }

    @Column(name = "order_type", nullable = true)
    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Column(name = "type", nullable = true)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "weight", nullable = true)
    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Column(name = "no_of_units", nullable = true)
    public int getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(int noOfUnits) {
        this.noOfUnits = noOfUnits;
    }

    @Column(name = "booking_at", nullable = true)
    public Timestamp getBookingAt() {
        return bookingAt;
    }

    public void setBookingAt(Timestamp bookingAt) {
        this.bookingAt = bookingAt;
    }

    @Column(name = "delivery_at", nullable = true)
    public Timestamp getDeliveryAt() {
        return deliveryAt;
    }

    public void setDeliveryAt(Timestamp deliveryAt) {
        this.deliveryAt = deliveryAt;
    }

    @Column(name = "pick_up_at", nullable = true)
    public Timestamp getPickUpAt() {
        return pickUpAt;
    }

    public void setPickUpAt(Timestamp pickUpAt) {
        this.pickUpAt = pickUpAt;
    }

    @Column(name = "contact_person_name", nullable = true)
    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    @Column(name = "contact_person_email", nullable = true)
    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }

    @Column(name = "contact_person_mobile_no", nullable = true)
    public String getContactPersonMobileno() {
        return contactPersonMobileno;
    }

    public void setContactPersonMobileno(String contactPersonMobileno) {
        this.contactPersonMobileno = contactPersonMobileno;
    }

    @Column(name = "pick_up_address", nullable = true)
    public String getPickUpAddress() {
        return pickUpAddress;
    }

    public void setPickUpAddress(String pickUpAddress) {
        this.pickUpAddress = pickUpAddress;
    }

    @Column(name = "pick_up_pin_code", nullable = true)
    public String getPickUpPinCode() {
        return pickUpPinCode;
    }

    public void setPickUpPinCode(String pickUpPinCode) {
        this.pickUpPinCode = pickUpPinCode;
    }

    @Column(name = "reciptent_name", nullable = true)
    public String getReciptentName() {
        return reciptentName;
    }

    public void setReciptentName(String reciptentName) {
        this.reciptentName = reciptentName;
    }

    @Column(name = "reciptent_mobile_no", nullable = true)
    public String getReciptentMobileNo() {
        return reciptentMobileNo;
    }

    public void setReciptentMobileNo(String reciptentMobileNo) {
        this.reciptentMobileNo = reciptentMobileNo;
    }

    @Column(name = "reciptent_address", nullable = true)
    public String getReciptentAddress() {
        return reciptentAddress;
    }

    public void setReciptentAddress(String reciptentAddress) {
        this.reciptentAddress = reciptentAddress;
    }

    @Column(name = "reciptent_pin_code", nullable = true)
    public String getReciptentPinCode() {
        return reciptentPinCode;
    }

    public void setReciptentPinCode(String reciptentPinCode) {
        this.reciptentPinCode = reciptentPinCode;
    }

    @Column(name = "reciptent_email", nullable = true)
    public String getReciptentEmail() {
        return reciptentEmail;
    }

    public void setReciptentEmail(String reciptentEmail) {
        this.reciptentEmail = reciptentEmail;
    }

    public DeliverySystem(Long deliveryId, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt, User user, int status, String orderCategory, String deliveryCurrentStatus, String orderType, String type, Long weight, int noOfUnits, Timestamp bookingAt, Timestamp deliveryAt, Timestamp pickUpAt, String contactPersonName, String contactPersonEmail, String contactPersonMobileno, String pickUpAddress, String pickUpPinCode, String reciptentName, String reciptentMobileNo, String reciptentAddress, String reciptentPinCode, String reciptentEmail) {
        this.deliveryId = deliveryId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.user = user;
        this.status = status;
        this.orderCategory = orderCategory;
        this.deliveryCurrentStatus = deliveryCurrentStatus;
        this.orderType = orderType;
        this.type = type;
        this.weight = weight;
        this.noOfUnits = noOfUnits;
        this.bookingAt = bookingAt;
        this.deliveryAt = deliveryAt;
        this.pickUpAt = pickUpAt;
        this.contactPersonName = contactPersonName;
        this.contactPersonEmail = contactPersonEmail;
        this.contactPersonMobileno = contactPersonMobileno;
        this.pickUpAddress = pickUpAddress;
        this.pickUpPinCode = pickUpPinCode;
        this.reciptentName = reciptentName;
        this.reciptentMobileNo = reciptentMobileNo;
        this.reciptentAddress = reciptentAddress;
        this.reciptentPinCode = reciptentPinCode;
        this.reciptentEmail = reciptentEmail;
    }

    public DeliverySystem() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.deliveryId);
        hash = 37 * hash + Objects.hashCode(this.createdAt);
        hash = 37 * hash + Objects.hashCode(this.updatedAt);
        hash = 37 * hash + Objects.hashCode(this.deletedAt);
        hash = 37 * hash + Objects.hashCode(this.user);
        hash = 37 * hash + this.status;
        hash = 37 * hash + Objects.hashCode(this.orderCategory);
        hash = 37 * hash + Objects.hashCode(this.deliveryCurrentStatus);
        hash = 37 * hash + Objects.hashCode(this.orderType);
        hash = 37 * hash + Objects.hashCode(this.type);
        hash = 37 * hash + Objects.hashCode(this.weight);
        hash = 37 * hash + this.noOfUnits;
        hash = 37 * hash + Objects.hashCode(this.bookingAt);
        hash = 37 * hash + Objects.hashCode(this.deliveryAt);
        hash = 37 * hash + Objects.hashCode(this.pickUpAt);
        hash = 37 * hash + Objects.hashCode(this.contactPersonName);
        hash = 37 * hash + Objects.hashCode(this.contactPersonEmail);
        hash = 37 * hash + Objects.hashCode(this.contactPersonMobileno);
        hash = 37 * hash + Objects.hashCode(this.pickUpAddress);
        hash = 37 * hash + Objects.hashCode(this.pickUpPinCode);
        hash = 37 * hash + Objects.hashCode(this.reciptentName);
        hash = 37 * hash + Objects.hashCode(this.reciptentMobileNo);
        hash = 37 * hash + Objects.hashCode(this.reciptentAddress);
        hash = 37 * hash + Objects.hashCode(this.reciptentPinCode);
        hash = 37 * hash + Objects.hashCode(this.reciptentEmail);
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
        final DeliverySystem other = (DeliverySystem) obj;
        if (this.status != other.status) {
            return false;
        }
        if (this.noOfUnits != other.noOfUnits) {
            return false;
        }
        if (!Objects.equals(this.orderCategory, other.orderCategory)) {
            return false;
        }
        if (!Objects.equals(this.deliveryCurrentStatus, other.deliveryCurrentStatus)) {
            return false;
        }
        if (!Objects.equals(this.orderType, other.orderType)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.contactPersonName, other.contactPersonName)) {
            return false;
        }
        if (!Objects.equals(this.contactPersonEmail, other.contactPersonEmail)) {
            return false;
        }
        if (!Objects.equals(this.contactPersonMobileno, other.contactPersonMobileno)) {
            return false;
        }
        if (!Objects.equals(this.pickUpAddress, other.pickUpAddress)) {
            return false;
        }
        if (!Objects.equals(this.pickUpPinCode, other.pickUpPinCode)) {
            return false;
        }
        if (!Objects.equals(this.reciptentName, other.reciptentName)) {
            return false;
        }
        if (!Objects.equals(this.reciptentMobileNo, other.reciptentMobileNo)) {
            return false;
        }
        if (!Objects.equals(this.reciptentAddress, other.reciptentAddress)) {
            return false;
        }
        if (!Objects.equals(this.reciptentPinCode, other.reciptentPinCode)) {
            return false;
        }
        if (!Objects.equals(this.reciptentEmail, other.reciptentEmail)) {
            return false;
        }
        if (!Objects.equals(this.deliveryId, other.deliveryId)) {
            return false;
        }
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        if (!Objects.equals(this.updatedAt, other.updatedAt)) {
            return false;
        }
        if (!Objects.equals(this.deletedAt, other.deletedAt)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.weight, other.weight)) {
            return false;
        }
        if (!Objects.equals(this.bookingAt, other.bookingAt)) {
            return false;
        }
        if (!Objects.equals(this.deliveryAt, other.deliveryAt)) {
            return false;
        }
        if (!Objects.equals(this.pickUpAt, other.pickUpAt)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DeliverySystem{" + "deliveryId=" + deliveryId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + ", user=" + user + ", status=" + status + ", orderCategory=" + orderCategory + ", deliveryCurrentStatus=" + deliveryCurrentStatus + ", orderType=" + orderType + ", type=" + type + ", weight=" + weight + ", noOfUnits=" + noOfUnits + ", bookingAt=" + bookingAt + ", deliveryAt=" + deliveryAt + ", pickUpAt=" + pickUpAt + ", contactPersonName=" + contactPersonName + ", contactPersonEmail=" + contactPersonEmail + ", contactPersonMobileno=" + contactPersonMobileno + ", pickUpAddress=" + pickUpAddress + ", pickUpPinCode=" + pickUpPinCode + ", reciptentName=" + reciptentName + ", reciptentMobileNo=" + reciptentMobileNo + ", reciptentAddress=" + reciptentAddress + ", reciptentPinCode=" + reciptentPinCode + ", reciptentEmail=" + reciptentEmail + '}';
    }

}
