package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {

    public static boolean checkUser(String email, String pass)
    {
        boolean st = false;

        try {
            //loading drivers for mysql
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating connection with the database
            String password = "uNiFuN_123";
            String username = "vic1";
            String url = "jdbc:mysql://192.168.1.115/test?serverTimezone=Europe/Moscow&useSSL=false";
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM `register` WHERE `email`=? and `pass`=?");
            ps.setString(1, "vic@gmail.com");
            ps.setString(2, "free");
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                st = true;
            }
//            st = rs.next();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;
    }
}
