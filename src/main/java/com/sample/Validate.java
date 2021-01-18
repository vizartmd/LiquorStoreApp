package com.sample;

import java.sql.*;

public class Validate {
    static Connection con;

    public static User checkUser(String email, String pass) {
        User user = new User();


        try {
            con = DataDB.getConnection();
            System.out.println("Connection is successfull!");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM `register` WHERE `email`=? and `pass`=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));
            }
            return user;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return  user;
    }

    public static boolean addUser(String email, String pass) {
        final String SQL_INSERT = "INSERT INTO `register` VALUES (?,?)";

        try {
            con = DataDB.getConnection();

            PreparedStatement ps = con.prepareStatement(SQL_INSERT);

            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if(checkUser(email,pass) != null) {
                return  true;
            } else  {
                return false;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return  false;
    }
}
