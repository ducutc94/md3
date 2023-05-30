package com.example.demo_duc.service;

import com.example.demo_duc.model.Category;
import com.example.demo_duc.model.Products;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductsService {
    private static ProductsService productsService;
    private  final List<Products> productsList =new ArrayList<>();

    private ProductsService() {
        Products products=new Products(1,"Bim Bim",5500.0, LocalDate.now(),new Category(1,"VN"));
        Products products1=new Products(2,"Sữa",7500.0, LocalDate.now(),new Category(2,"Lào"));
        Products products2=new Products(3,"Bánh Mì",10500.0, LocalDate.now(),new Category(3,"Thái"));
        productsList.add(products);
        productsList.add(products1);
        productsList.add(products2);

    }
    public static ProductsService getInstance(){
        if(productsService==null){
            productsService=new ProductsService();
        }return productsService;
    }
    public  void create(Products products){
        if(products!=null){
            productsList.add(products);
        }
    }
    public List<Products> searchByName(String name) {
        List<Products> products1 = new ArrayList<>();
        for (Products products : productsList) {
            if (products.getName().contains(name)) {
                products1.add(products);
            }
        }
        return products1;
    }
    public void deleteByCategory(Category category) {
        List<Category> categories = new ArrayList<>();
        for (Products products : productsList) {
            if (products.getCategory().equals(category)) {
                categories.add(category);
            }
        }
        productsList.removeAll(categories);
    }
public Products getById(int id) {
    for (Products products : productsList) {
        if (products.getId()==id) {
            return products;
        }
    }
    return null;
}
    public void deleteById(int id) {
        Products products = getById(id);
        if (products != null) {
            productsList.remove(products);
        }
    }
    public List<Products> getProducts() {
        return productsList;
    }

    public void addProducts(Products products) {
        productsList.add(products);
    }

}
