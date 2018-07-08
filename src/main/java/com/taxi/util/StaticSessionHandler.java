package com.taxi.util;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Santosh
 */
public class StaticSessionHandler {

    public static ConcurrentHashMap<String, String> sessionMap = new ConcurrentHashMap<String, String>();

    public static boolean isValidAccessToken(String userId) {
        if (sessionMap.get(userId) == null) {
            return false;
        } else {
            return true;
        }
    }

    public static void remove(String userId) {
        sessionMap.remove(userId);
    }

    public static void sessionMap(String userId, String accessKey) {
        sessionMap.put(userId, accessKey);
    }
}
