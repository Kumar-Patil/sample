package com.taxi.to;

/**
 *
 * @author
 */
public class City {

    private int cityId;
    private String citieName;
    private int stateId;

    public City(int cityId, String citieName, int stateId) {
        this.cityId = cityId;
        this.citieName = citieName;
        this.stateId = stateId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCitieName() {
        return citieName;
    }

    public void setCitieName(String citieName) {
        this.citieName = citieName;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

}
