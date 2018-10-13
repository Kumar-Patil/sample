package com.taxi.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author santopat
 */
@Entity
@Table(name = "boosting_fare")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EnableOrDisableBoostingFare implements Serializable{

    private Long id;
    private boolean boostEnable;
    private boolean surgeEnable;

    @Column(name = "boost_price", nullable = false)
    public boolean getBoostEnable() {
        return boostEnable;
    }

    public void setBoostEnable(boolean boostEnable) {
        this.boostEnable = boostEnable;
    }

    @Column(name = "surge_price", nullable = false)
    public boolean getSurgeEnable() {
        return surgeEnable;
    }

    public void setSurgeEnable(boolean surgeEnable) {
        this.surgeEnable = surgeEnable;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}
