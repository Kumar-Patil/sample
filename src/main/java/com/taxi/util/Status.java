package com.taxi.util;

/**
 *
 * @author
 */
public enum Status {

    ERROR("error", "Enter valid emailId ."),
    SUCESS("sucess", "OTP sent successfully");
    private final String name;
    private final String displayName;

    public String getDisplayName() {
        return displayName;
    }

    Status(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public static Status findByNamespace(String name) {
        for (Status s : Status.values()) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unable to find error: " + name);
    }

}
