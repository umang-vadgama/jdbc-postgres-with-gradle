package com.gradle.project.helper;

import com.gradle.project.dbconnection.DBConnection;
import com.gradle.project.model.Product;
import com.gradle.project.model.UserInputType;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddProduct {

    private DBConnection connection;
    private ResultSet resultSet;
    private List<Product> productList;

    public void createProductInfo() {

        try {

            UserInput getNames = new UserInput();

            productList = new ArrayList<Product>();

            Object input = getNames.getUserInput(UserInputType.CREATE_PRODUCT);

            if (input instanceof Collection) {

                productList = new ArrayList<>((Collection<Product>) input);

                connection = new DBConnection();

                connection.createConnection();

                System.out.println("CONNECTED...");

                String sql = "insert into products (product_number ,product_name " +
                        ",\"cost\" ,category,lastupdate  ) values ( ?, ?, ?, ?, ?);";
                for (Product product : productList) {

                    int status = connection.createProduct(sql, product.getProductNumber(), product.getProductName(), product.getProductCost(), product.getProductCategory());

                    System.out.println("STATUS : " + status);
                }

                connection.closeConnection();

                System.out.println("DISCONNECTED SERVER...");
            } else {

                System.out.println("****** INVALID INPUT ******");
            }

        } catch (Exception e) {

            System.out.println("ERROR : " + e.getMessage());
            e.printStackTrace();

        }
    }

}
