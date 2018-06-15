package com.taxi.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cities implements Serializable{

    private int cityId;
    private String citieName;
    private States states;

    public Cities() {
    }

    @Id
    @Column(name = "city_id")
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Column(name = "name")
    public String getCitieName() {
        return citieName;
    }

    public void setCitieName(String citieName) {
        this.citieName = citieName;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", nullable = true)
    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }

    public Cities(int cityId, String citieName, States states) {
        this.cityId = cityId;
        this.citieName = citieName;
        this.states = states;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.cityId;
        hash = 11 * hash + Objects.hashCode(this.citieName);
        hash = 11 * hash + Objects.hashCode(this.states);
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
        final Cities other = (Cities) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Cities{" + "cityId=" + cityId + ", citieName=" + citieName + ", states=" + states + '}';
    }
    
}
