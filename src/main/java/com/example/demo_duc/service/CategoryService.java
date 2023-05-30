package com.example.demo_duc.service;

import com.example.demo_duc.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private static CategoryService categoryService;
    private  final List<Category> categoryList =new ArrayList<>();
    private CategoryService(){
        categoryList.add(new Category(1,"VN"));
    }
    public static CategoryService getInstance(){
        if(categoryService == null){
            categoryService=new CategoryService();
        }return categoryService;
    }
    public List<Category> getCategory() {
        return categoryList;
    }

    public void addCategory(Category category) {
        categoryList.add(category);
    }

    public Category getById(int id) {
        for (Category category : categoryList) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        Category category = getById(id);
        if (category != null) {
            categoryList.remove(category);
        }
    }
}
