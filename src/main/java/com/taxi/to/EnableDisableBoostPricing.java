/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxi.to;

/**
 *
 * @author santopat
 */
public class EnableDisableBoostPricing {
    private Long id;
    private boolean boostEnable;
    private boolean surgeEnable;

    public boolean getBoostEnable() {
        return boostEnable;
    }

    public void setBoostEnable(boolean boostEnable) {
        this.boostEnable = boostEnable;
    }

    public boolean getSurgeEnable() {
        return surgeEnable;
    }

    public void setSurgeEnable(boolean surgeEnable) {
        this.surgeEnable = surgeEnable;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnableDisableBoostPricing(Long id, boolean boostEnable, boolean surgeEnable) {
        this.id = id;
        this.boostEnable = boostEnable;
        this.surgeEnable = surgeEnable;
    }

}
