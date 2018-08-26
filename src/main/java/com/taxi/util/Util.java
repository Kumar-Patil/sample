package com.taxi.util;

import com.taxi.email.MailUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    /*
    Date date = new Date();
        Calendar cal = Calendar.getInstance();

        Timestamp startDate = new Timestamp(beginOfDay(date).getTime());
        System.out.println("startDate{}" + startDate);

        //System.out.println(endOfDay(new Date()) );
        Timestamp endDate = new Timestamp(getEndOfDay(date, cal).getTime());
        System.out.println("ts1{}" + endDate);
     */
    public static Date getEndOfDay(Date day, Calendar cal) {
        if (day == null) {
            day = new Date();
        }
        cal.setTime(day);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMaximum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    public static Date beginOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }
}
