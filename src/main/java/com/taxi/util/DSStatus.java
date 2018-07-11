package com.taxi.util;

public enum DSStatus {

    NEW("NEW", "New Item"),
    ASSIGNED("ASSIGNED", "Item is assigned"),
    ACCEPTED("ACCEPTED", "Item is accepted"),
    PICKED("PICKED", "Item is picked"),
    ONTHEWAY("ONTHEWAY", "Item is on the way"),
    DELIVERED("DELIVERED", "Item is delivered"),
    REJECTEDBYRECEIPTANT("REJECTED", "Item is rejected by receiptant"),
    REJECTEDBYDRIVER("REJECTEDBYDRIVER", "Item is rejected by driver"),
    CANCELED("CANCELED", "Item is cansled for picking");
    private final String statusName;
    private final String statusMsg;

    private DSStatus(String statusName, String statusMsg) {
        this.statusName = statusName;
        this.statusMsg = statusMsg;
    }

    public String getStatusName() {
        return statusName;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    @Override
    public String toString() {
        return statusName;
    }

    public static DSStatus findByNamespace(String statusName) {
        for (DSStatus s : DSStatus.values()) {
            if (s.getStatusName().equals(statusName)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unable to find service: " + statusName);
    }

}
