package com.gradle.project.helper;

import com.gradle.project.dbconnection.DBConnection;
import com.gradle.project.model.UserInputType;

public class DeleteProduct {

    private DBConnection connection;

    public boolean deleteProductInfo() {

        int isUpdated = -1;

        try {

            UserInput userInput = new UserInput();

            Object input = userInput.getUserInput(UserInputType.DELETE_PRODUCT);

            if (input instanceof Integer) {

                int id = (Integer) input;

                connection = new DBConnection();

                connection.createConnection();

                System.out.println("CONNECTION CREATE....");

                String sql = "delete from products where id = ?;";

                isUpdated = connection.deleteProduct(sql, id);

                connection.closeConnection();

                System.out.println("CONNECTION CLOSE....");

            } else {

                System.out.println("****** INVALID INPUT ******");

            }

        } catch (Exception e) {

            System.out.println("ERROR : " + e.getMessage());
            e.printStackTrace();

        }

        return isUpdated == 1;
    }
}
