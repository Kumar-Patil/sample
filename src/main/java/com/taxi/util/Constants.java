package com.taxi.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author
 */
public class Constants {

    public static final String CHAR_LIST
            = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    public static final int RANDOM_STRING_LENGTH = 100;
    public static String ERROR_RESPONCE = "error";
    public static String SUCESS_RESPONCE = "success";
    public static int STATUS_ACTVIE = 1;
    public static int STATUS_INACTIVE = 0;

    /**
     *
     * @return
     */
    public static Map<Integer, String> roles() {
        Map<Integer, String> roles = new HashMap<>();
        roles.put(1, "Supreme User");
        roles.put(2, "Super Vendor");
        roles.put(3, "Vendor");
        roles.put(4, "View");
        roles.put(5, "rider");
        return roles;
    }

    public static Map<Integer, String> status() {
        Map<Integer, String> status = new HashMap<>();
        status.put(1, "Active");
        status.put(0, "InActive");
        return status;
    }

    public static List<String> urls() {
        List<String> urls = new ArrayList<>();
        urls.add(".js");
        urls.add(".css");
        urls.add("configuration/ui");
        urls.add("swagger-resources");
        urls.add("api-docs");
        urls.add("security");
        urls.add("login/user");
        urls.add("sendOTP");
        urls.add("otpVerification");
        urls.add("changePassword");
        urls.add("swagger-ui.html");
        urls.add("swagger-resources");
        return urls;
    }

}
