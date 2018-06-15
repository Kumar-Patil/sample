package com.taxi.domain;

import java.io.Serializable;
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
@Table(name = "driver_attributes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DriverAttributes implements Serializable {

    private String crb;
    private String delivery;
    private String female;
    private String luggage;
    private String NHS;

    private String pets;
    private String uniformed;
    private String topman;
    private long driverAttribteId;

    public DriverAttributes() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public long getDriverAttribteId() {
        return driverAttribteId;
    }

    public void setDriverAttribteId(long driverAttribteId) {
        this.driverAttribteId = driverAttribteId;
    }

    @Column(name = "crb", nullable = true)
    public String getCrb() {
        return crb;
    }

    public void setCrb(String crb) {
        this.crb = crb;
    }

    @Column(name = "delivery", nullable = true)
    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    @Column(name = "female", nullable = true)
    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    @Column(name = "luggage", nullable = true)
    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    @Column(name = "pets", nullable = true)
    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    @Column(name = "uniformed", nullable = true)
    public String getUniformed() {
        return uniformed;
    }

    public void setUniformed(String uniformed) {
        this.uniformed = uniformed;
    }

    @Column(name = "topman", nullable = true)
    public String getTopman() {
        return topman;
    }

    public void setTopman(String topman) {
        this.topman = topman;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.crb);
        hash = 37 * hash + Objects.hashCode(this.delivery);
        hash = 37 * hash + Objects.hashCode(this.female);
        hash = 37 * hash + Objects.hashCode(this.luggage);
        hash = 37 * hash + Objects.hashCode(this.NHS);
        hash = 37 * hash + Objects.hashCode(this.pets);
        hash = 37 * hash + Objects.hashCode(this.uniformed);
        hash = 37 * hash + Objects.hashCode(this.topman);
        hash = 37 * hash + (int) (this.driverAttribteId ^ (this.driverAttribteId >>> 32));
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
        final DriverAttributes other = (DriverAttributes) obj;
        return true;
    }

    @Override
    public String toString() {
        return "DriverAttributes{" + "crb=" + crb + ", delivery=" + delivery + ", female=" + female + ", luggage=" + luggage + ", NHS=" + NHS + ", pets=" + pets + ", uniformed=" + uniformed + ", topman=" + topman + ", driverAttribteId=" + driverAttribteId + '}';
    }

    public DriverAttributes(String crb, String delivery, String female, String luggage, String NHS, String pets, String uniformed, String topman, long driverAttribteId) {
        this.crb = crb;
        this.delivery = delivery;
        this.female = female;
        this.luggage = luggage;
        this.NHS = NHS;
        this.pets = pets;
        this.uniformed = uniformed;
        this.topman = topman;
        this.driverAttribteId = driverAttribteId;
    }

    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    private int status;

    /**
     *
     * @param nhs
     * @return
     */
    @Column(name = "NHS", nullable = true)
    public String getNHS() {
        return NHS;
    }

    public void setNHS(String nhs) {
        this.NHS = nhs;
    }

}
