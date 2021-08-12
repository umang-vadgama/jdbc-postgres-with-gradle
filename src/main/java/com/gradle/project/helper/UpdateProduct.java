package com.gradle.project.helper;

import com.gradle.project.dbconnection.DBConnection;
import com.gradle.project.model.Product;
import com.gradle.project.model.UserInputType;

import java.util.*;

public class UpdateProduct {

    private DBConnection connection;
    private List<Product> productList;

    public void updateProductInfo() {

        try {

            connection = new DBConnection();

            UserInput userInput = new UserInput();

            Object input = userInput.getUserInput(UserInputType.UPDATE_PRODUCT);

            if (input instanceof Collection) {

                productList = new ArrayList<>((Collection<Product>) input);

                Product updatedProduct = productList.get(0);

                String sql = "update products set product_number = ? , product_name = ? , \"cost\" = ? , category = ? ,lastupdate = ? where id = ?;";

                connection.createConnection();

                System.out.println("CONNECTION CREATE....");
                int updatedId = connection.updateProductInfo(sql, updatedProduct.getProductNumber(),
                        updatedProduct.getProductName(),
                        updatedProduct.getProductCost(),
                        updatedProduct.getProductCategory(),
                        updatedProduct.getId());

                System.out.println("Product updated product info associate with product id : " + updatedId);
                connection.closeConnection();
                System.out.println("CONNECTION CLOSED....");
            } else {

                System.out.println("****** INVALID INPUT ******");

            }
        } catch (Exception e) {

            System.out.println("ERROR : " + e.getMessage());
            e.printStackTrace();

        }

    }
}
