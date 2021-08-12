package com.gradle.project.helper;

import com.gradle.project.model.Product;
import com.gradle.project.model.UserInputType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserInput {

    private Scanner scanner;
    private List<Product> productList;

    public Object getUserInput(UserInputType userInputType) {

        try {

            scanner = new Scanner(System.in);
            productList = new ArrayList<Product>();

            int input;
            switch (userInputType) {

                case CREATE_PRODUCT:

                    System.out.println("Enter number of product you want to add (Integer values only)...\n");

                    input = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < input; i++) {

                        Product productInfo = this.getProductInfoFromUser();

                        productList.add(productInfo);

                    }

                    return productList;

                case UPDATE_PRODUCT:

                    System.out.println("Enter which product id you want to update (Integer values only)...\n");
                    input = Integer.parseInt(scanner.nextLine());

                    Product updatedProductInfo = this.getProductInfoFromUser();

                    updatedProductInfo.setId(input);

                    productList.add(updatedProductInfo);

                    return productList;


                case DELETE_PRODUCT:

                    System.out.println("Enter which product id you want to delete (Integer values only)...\n");
                    input = Integer.parseInt(scanner.nextLine());


                    return input;

            }

        } catch (Exception e) {

            System.out.println("ERROR : " + e.getMessage());
            e.printStackTrace();

        }
        return null;
    }

    private Product getProductInfoFromUser() {

        System.out.println("ENTER Product Number (Numeric Value Only)...\n");
        BigDecimal productNumber = new BigDecimal(scanner.nextLine());


        System.out.println("ENTER Product Name...\n");
        String productName = scanner.nextLine();

        System.out.println("ENTER Product Cost (Numeric Value Only)...\n");
        BigDecimal productCost = new BigDecimal(scanner.nextLine());

        System.out.println("ENTER Product Category...\n");
        String productCategory = scanner.nextLine();


        return new Product(productNumber, productName, productCost, productCategory);
    }

}
