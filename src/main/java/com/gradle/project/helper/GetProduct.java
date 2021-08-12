package com.gradle.project.helper;


import com.gradle.project.dbconnection.DBConnection;
import com.gradle.project.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetProduct {

    private DBConnection connection;
    private ResultSet resultSet;
    private List<Product> productList;

    public List<Product> getAllProductsInfo() {

        productList = new ArrayList<Product>();

        try {

            String sql = "select * from products";

            connection = new DBConnection();
            connection.createConnection();

            resultSet = connection.getAllStudents(sql);

            while (resultSet.next()) {
                productList.add(new Product(resultSet.getInt(1),
                        resultSet.getBigDecimal(2),
                        resultSet.getString(3),
                        resultSet.getBigDecimal(4),
                        resultSet.getString(5),
                        resultSet.getTimestamp(6)));
            }

            System.out.println("Get All Products From Database...");
            System.out.println("Found products : " + productList.size());

            System.out.printf("\n %5s | %-15s | %-20s | %-15s | %-20s | %s ", "Id", "Product Number",
                    "Product Name", "Product Cost", "Product Category", "Last Updated On");

            for (Product product : productList) {

                System.out.printf("\n %5d | %-15s | %-20s | %-15s | %-20s | %s ", product.getId(), product.getProductNumber().toString(),
                        product.getProductName(), product.getProductCost().toString(), product.getProductCategory(), product.getLastUpdateTimestamp());

            }


        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
            e.printStackTrace();
        }

        return productList;
    }

    @Deprecated
    public void getProductById(int student_id) {

        try {

            /*String sql = "";

            connection = new DBConnection();
            connection.createConnection();
            resultSet = connection.getAllStudents(sql);

            connection.closeConnection();*/

        } catch (Exception e) {

            System.out.println("ERROR : " + e.getMessage());
            e.printStackTrace();

        }
    }
}
