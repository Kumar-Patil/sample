package com.taxi.to;

/**
 *
 * @author
 */
public class State {

    private int stateId;
    private String stateName;
    private String stateCode;
    private int countriId;

   

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public State(int stateId, String stateName, String stateCode, int countriId) {
        this.stateId = stateId;
        this.stateName = stateName;
        this.stateCode = stateCode;
        this.countriId = countriId;
    }

   

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public int getCountriId() {
        return countriId;
    }

    public void setCountriId(int countriId) {
        this.countriId = countriId;
    }
}
