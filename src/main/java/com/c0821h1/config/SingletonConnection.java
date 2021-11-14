package com.c0821h1.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection connection;
    private SingletonConnection() {}

    private static String jdbcURL = "jdbc:mysql://localhost:3306/book?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "1234567890";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                //load driver và đăng kí nó với ứng dụng (Đăng ký gọi phương thức Class.forName("driverName")
                Class.forName("com.mysql.jdbc.Driver");
                //tạo kết nối (connection)
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                System.out.println("success");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
