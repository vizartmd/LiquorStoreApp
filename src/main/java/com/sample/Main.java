package com.sample;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Main {
  public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//      Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//
//      //creating connection with the database
//      String password = "ReVeRs123";
//      String username = "root";
//      String url = "jdbc:mysql://localhost/test?serverTimezone=Europe/Moscow&useSSL=false";
//      Connection con = DriverManager.getConnection(url, username, password);
//      System.out.println("Connection is successfull!");
//      PreparedStatement ps = con.prepareStatement("SELECT * FROM `register` WHERE `email`=? and `pass`=?");
//      ps.setString(1, "vic@gmail.com");
//      ps.setString(2, "free");
//
//      ResultSet rs=ps.executeQuery();
//
//      while(rs.next()){
//          System.out.println(rs.getString(1));
//          System.out.println(rs.getString(2));
//      }
}
}
