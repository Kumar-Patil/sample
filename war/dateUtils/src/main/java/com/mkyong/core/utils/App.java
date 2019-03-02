package com.mkyong.core.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;

public class App {

    private static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {

        System.out.println(getLocalCurrentDate());
        getJDBC();
    }

    private static String getLocalCurrentDate() {

        if (logger.isDebugEnabled()) {
            logger.debug("getLocalCurrentDate() is executed!");
        }

        LocalDate date = new LocalDate();
        return date.toString();

    }

    public static void getJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/taxi", "root", "root");
//here sonoo is database name, root is username and password  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            System.out.println("Connection estab;ished");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Connection Fail");
            System.out.println(e);
        }
    }

}
