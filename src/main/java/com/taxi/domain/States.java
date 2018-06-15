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
@Table(name = "states")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class States implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int stateId;
    private String state;
    private String stateCode;
    private Countries countries;

    @Id
    @Column(name = "state_id")
    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    @Column(name = "name")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "code")
    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = true)
    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final States other = (States) obj;
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.stateCode, other.stateCode)) {
            return false;
        }
        if (!Objects.equals(this.stateId, other.stateId)) {
            return false;
        }
        if (!Objects.equals(this.countries, other.countries)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "State{" + "stateId=" + stateId + ", state=" + state + ", stateCode=" + stateCode + ", countries=" + countries + '}';
    }
}
