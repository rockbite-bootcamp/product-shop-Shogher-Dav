package com.bootcamp.Shop;

import java.util.List;
import java.util.ArrayList;

public class Category {

    /**
     * Category name
     */
    private String name;

    /**
     * List of products that categoty have
     */
    private List<Product> products = new ArrayList<>();

    public Category() {}


    public Category(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public List<Product> getProducts() {
        return products;
    }


    /**
     * Add list of Products to Category
     * @param products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }


    /**
     * Add one product to Category
     * @param product
     */
    public void addProduct(Product product) {
        this.products.add(product);
    }


    @Override
    public String toString() {
        return "Category [name=" + name + ", products=" + products + "]";
    }



}

