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
@Table(name = "cabs_attributes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CabAttributes implements Serializable {

    public CabAttributes() {
    }

    public CabAttributes(Long attributeId, String fourSeater, String fiveSeater, String sixSeater, String sevenSeater, String eightSeater, String exexutive, String goodCOndition, String avgCondition, String wheelChair) {
        this.attributeId = attributeId;
        this.fourSeater = fourSeater;
        this.fiveSeater = fiveSeater;
        this.sixSeater = sixSeater;
        this.sevenSeater = sevenSeater;
        this.eightSeater = eightSeater;
        this.exexutive = exexutive;
        this.goodCOndition = goodCOndition;
        this.avgCondition = avgCondition;
        this.wheelChair = wheelChair;
    }

    /*Attributes */
    private Long attributeId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    @Column(name = "four_seater", nullable = true)
    public String getFourSeater() {
        return fourSeater;
    }

    public void setFourSeater(String fourSeater) {
        this.fourSeater = fourSeater;
    }

    @Column(name = "five_seater", nullable = true)
    public String getFiveSeater() {
        return fiveSeater;
    }

    public void setFiveSeater(String fiveSeater) {
        this.fiveSeater = fiveSeater;
    }

    @Column(name = "six_seater", nullable = true)
    public String getSixSeater() {
        return sixSeater;
    }

    public void setSixSeater(String sixSeater) {
        this.sixSeater = sixSeater;
    }

    @Column(name = "seven_seater", nullable = true)
    public String getSevenSeater() {
        return sevenSeater;
    }

    public void setSevenSeater(String sevenSeater) {
        this.sevenSeater = sevenSeater;
    }

    @Column(name = "eight_seater", nullable = true)
    public String getEightSeater() {
        return eightSeater;
    }

    public void setEightSeater(String eightSeater) {
        this.eightSeater = eightSeater;
    }

    @Column(name = "exexutive", nullable = true)
    public String getExexutive() {
        return exexutive;
    }

    public void setExexutive(String exexutive) {
        this.exexutive = exexutive;
    }

    @Column(name = "good_condition", nullable = true)
    public String getGoodCOndition() {
        return goodCOndition;
    }

    public void setGoodCOndition(String goodCOndition) {
        this.goodCOndition = goodCOndition;
    }

    @Column(name = "avg_condition", nullable = true)
    public String getAvgCondition() {
        return avgCondition;
    }

    public void setAvgCondition(String avgCondition) {
        this.avgCondition = avgCondition;
    }

    @Column(name = "wheel_chair", nullable = true)
    public String getWheelChair() {
        return wheelChair;
    }

    public void setWheelChair(String wheelChair) {
        this.wheelChair = wheelChair;
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

    private String fourSeater;
    private String fiveSeater;
    private String sixSeater;
    private String sevenSeater;
    private String eightSeater;
    private String exexutive;
    private String goodCOndition;
    private String avgCondition;
    private String wheelChair;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.attributeId);
        hash = 29 * hash + Objects.hashCode(this.fourSeater);
        hash = 29 * hash + Objects.hashCode(this.fiveSeater);
        hash = 29 * hash + Objects.hashCode(this.sixSeater);
        hash = 29 * hash + Objects.hashCode(this.sevenSeater);
        hash = 29 * hash + Objects.hashCode(this.eightSeater);
        hash = 29 * hash + Objects.hashCode(this.exexutive);
        hash = 29 * hash + Objects.hashCode(this.goodCOndition);
        hash = 29 * hash + Objects.hashCode(this.avgCondition);
        hash = 29 * hash + Objects.hashCode(this.wheelChair);
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
        final CabAttributes other = (CabAttributes) obj;
        return true;
    }

    @Override
    public String toString() {
        return "CabAttributes{" + "attributeId=" + attributeId + ", fourSeater=" + fourSeater + ", fiveSeater=" + fiveSeater + ", sixSeater=" + sixSeater + ", sevenSeater=" + sevenSeater + ", eightSeater=" + eightSeater + ", exexutive=" + exexutive + ", goodCOndition=" + goodCOndition + ", avgCondition=" + avgCondition + ", wheelChair=" + wheelChair + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + '}';
    }
}
