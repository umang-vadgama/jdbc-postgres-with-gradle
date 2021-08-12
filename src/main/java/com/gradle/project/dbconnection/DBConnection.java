package com.gradle.project.dbconnection;

import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;

public class DBConnection {


    private Connection connection;
    private PreparedStatement ps;
    private static final SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void createConnection() {

        String host = "jdbc:postgresql://localhost:5432/postgres?currentSchema=ecom";

        String username = "postgres";
        String password = "123";

        try {

            connection = DriverManager.getConnection(host, username, password);

        } catch (SQLException e) {

            System.out.println("ERROR : " + e.getMessage());
            e.printStackTrace();

        }


    }

    public int createProduct(String sql, BigDecimal productNumber, String productName, BigDecimal productCost, String productCategory) {


        try {

            ps = connection.prepareStatement(sql);

            ps.setBigDecimal(1, productNumber);
            ps.setString(2, productName);
            ps.setBigDecimal(3, productCost);
            ps.setString(4, productCategory);

            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            Timestamp timestamp = Timestamp.valueOf(TIMESTAMP_FORMAT.format(currentTimestamp));

            ps.setTimestamp(5, timestamp);

            System.out.println(sql);
            int status = ps.executeUpdate();

            return status;

        } catch (SQLException e) {

            System.out.println("ERROR : " + e.getMessage());
            e.printStackTrace();
            return -1;

        }
    }

    public ResultSet getAllStudents(String sql) {

        try {

            ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            return rs;

        } catch (SQLException e) {

            System.out.println("ERROR : " + e.getMessage());
            return null;

        }

    }

    public int updateProductInfo(String sql, BigDecimal productNumber, String productName, BigDecimal productCost, String productCategory, int id) {

        try {

            ps = connection.prepareStatement(sql);
            ps.setBigDecimal(1, productNumber);
            ps.setString(2, productName);
            ps.setBigDecimal(3, productCost);
            ps.setString(4, productCategory);

            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            Timestamp timestamp = Timestamp.valueOf(TIMESTAMP_FORMAT.format(currentTimestamp));

            ps.setTimestamp(5, timestamp);
            ps.setInt(6, id);

            int sId = ps.executeUpdate();

            return sId;

        } catch (Exception e) {

            System.out.println("ERROR : " + e.getMessage());
            e.printStackTrace();
            return -1;

        }
    }

    public int deleteProduct(String sql, int id) {

        int status = -1;

        try {

            ps = connection.prepareStatement(sql);

            ps.setInt(1, id);

            status = ps.executeUpdate();

            return status;

        } catch (Exception e) {

            System.out.println("ERROR : " + e.getMessage());
            e.printStackTrace();
            return status;

        }


    }

    public void closeConnection() {

        try {

            connection.close();

        } catch (SQLException e) {

            System.out.println("ERROR : " + e.getMessage());
            e.printStackTrace();

        }
    }
}
