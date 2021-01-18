package com.sample;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataDB {
    public static Connection getConnection() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

        //creating connection with the database
        String password = "ReVeRs123";
        String username = "root";
        String url = "jdbc:mysql://localhost/test?serverTimezone=Europe/Moscow&useSSL=false";
        Connection con = DriverManager.getConnection(url, username, password);

        return con;
    }
}
