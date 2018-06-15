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
@Table(name = "countries")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Countries implements Serializable {

    private static final long serialVersionUID = 1L;
    private int countriId;
    private String name;
    private String code;
    private String dialingCode;

    public Countries() {
            }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "countri_id", unique = true, nullable = false)
    public int getCountriId() {
        return countriId;
    }

    public void setCountriId(int countriId) {
        this.countriId = countriId;
    }

    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "code", nullable = false, length = 255)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "dialing_code", nullable = false, length = 255)
    public String getDialingCode() {
        return dialingCode;
    }

    public void setDialingCode(String dialingCode) {
        this.dialingCode = dialingCode;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.countriId);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.code);
        hash = 41 * hash + Objects.hashCode(this.dialingCode);
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
        final Countries other = (Countries) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Countries{" + "countriId=" + countriId + ", name=" + name + ", code=" + code + ", dialingCode=" + dialingCode + '}';
    }

    public Countries(int countriId, String name, String code, String dialingCode) {
        this.countriId = countriId;
        this.name = name;
        this.code = code;
        this.dialingCode = dialingCode;
    }
    
}
