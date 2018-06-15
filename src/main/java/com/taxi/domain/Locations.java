package com.taxi.domain;

import java.io.Serializable;
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
@Table(name = "locations")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Locations implements Serializable {

    private Long locationId;
    private Countries countries;
    private States states;
    private Cities cities;
    private String address;
    private String street;
    private String zip;
    private float lat;
    private float lng;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Column(name = "address", nullable = false, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "street", nullable = false, length = 255)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "zip", nullable = false, length = 255)
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Column(name = "lat", nullable = true)
    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    @Column(name = "lng", nullable = true)
    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = true)
    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", nullable = true)
    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = true)
    public Cities getCities() {
        return cities;
    }

    public void setCities(Cities cities) {
        this.cities = cities;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.locationId);
        hash = 97 * hash + Objects.hashCode(this.countries);
        hash = 97 * hash + Objects.hashCode(this.states);
        hash = 97 * hash + Objects.hashCode(this.cities);
        hash = 97 * hash + Objects.hashCode(this.address);
        hash = 97 * hash + Objects.hashCode(this.street);
        hash = 97 * hash + Objects.hashCode(this.zip);
        hash = 97 * hash + Float.floatToIntBits(this.lat);
        hash = 97 * hash + Float.floatToIntBits(this.lng);
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
        final Locations other = (Locations) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Locations{" + "locationId=" + locationId + ", countries=" + countries + ", states=" + states + ", cities=" + cities + ", address=" + address + ", street=" + street + ", zip=" + zip + ", lat=" + lat + ", lng=" + lng + '}';
    }

}
