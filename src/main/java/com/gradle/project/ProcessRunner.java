package com.gradle.project;

import com.gradle.project.helper.AddProduct;
import com.gradle.project.helper.DeleteProduct;
import com.gradle.project.helper.GetProduct;
import com.gradle.project.helper.UpdateProduct;

public class ProcessRunner {

    public void createProduct() {

        AddProduct addProduct = new AddProduct();

        addProduct.createProductInfo();

    }

    public void getAllProducts() {

        GetProduct getProduct = new GetProduct();

        getProduct.getAllProductsInfo();

    }

    public void deleteProduct() {

        DeleteProduct deleteProduct = new DeleteProduct();

        deleteProduct.deleteProductInfo();

    }

    public void updateProduct() {

        UpdateProduct updateProduct = new UpdateProduct();

        updateProduct.updateProductInfo();

    }


}
