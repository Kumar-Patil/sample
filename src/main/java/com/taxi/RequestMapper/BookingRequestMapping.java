package com.taxi.RequestMapper;

/**
 *
 * @author santopat
 */
public class BookingRequestMapping {

    private String mobileNo;
    private String name;
    private Long cust_id;
    private String address;
    private String emai;
    private String remarks;
    private String source;
    private String destination;
    private float sourceLattitude;
    private float sourceLngitude;
    private float destinationLattitud;
    private float destinationLngitude;

    public float getSourceLattitude() {
        return sourceLattitude;
    }

    public void setSourceLattitude(float sourceLattitude) {
        this.sourceLattitude = sourceLattitude;
    }

    public float getSourceLngitude() {
        return sourceLngitude;
    }

    public void setSourceLngitude(float sourceLngitude) {
        this.sourceLngitude = sourceLngitude;
    }

    public float getDestinationLattitud() {
        return destinationLattitud;
    }

    public void setDestinationLattitud(float destinationLattitud) {
        this.destinationLattitud = destinationLattitud;
    }

    public float getDestinationLngitude() {
        return destinationLngitude;
    }

    public void setDestinationLngitude(float destinationLngitude) {
        this.destinationLngitude = destinationLngitude;
    }

    
    private Long driverId;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

}
