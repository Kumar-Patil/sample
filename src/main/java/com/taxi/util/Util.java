package com.taxi.util;

import com.taxi.email.MailUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.log4j.Logger;

/**
 *
 * @author
 */
public class Util {

    static final Logger LOG = Logger.getLogger(MailUtils.class);

    /**
     * This method generates random string
     *
     * @return
     */
    public static String generateRandomString() {

        StringBuffer randStr = new StringBuffer();
        for (int i = 0; i < Constants.RANDOM_STRING_LENGTH; i++) {
            int number = getRandomNumber();
            char ch = Constants.CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    /**
     * This method generates random numbers
     *
     * @return int
     */
    private static int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(Constants.CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }

    public static boolean containsAKeyword(String str, List<String> keywords) {
        for (String k : keywords) {
            if (str.contains(k)) {
                return true;
            }
        }
        return false;
    }

    public static List<com.taxi.to.Status> getStatusList() {
        List<com.taxi.to.Status> statusList = new ArrayList<>();
        statusList.add(new com.taxi.to.Status(1, "Active"));
        statusList.add(new com.taxi.to.Status(2, "InActive"));
        return statusList;
    }
}
