package com.sample;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Validate {
    static Connection con;

    public static User checkUser(String username, String pass) {
        User user = new User();


        try {
            con = DataDB.getConnection();
            System.out.println("Connection is successfull!");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM `register` WHERE `username`=? and `pass`=?");
            ps.setString(1, username);
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

    public static void addUser(String username, String pass) throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        con = DataDB.getConnection();
        String sql = "INSERT INTO register VALUES (?,?)";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, pass);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
    }
}
