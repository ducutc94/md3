package com.example.demo_duc.controller;

import com.example.demo_duc.model.Category;
import com.example.demo_duc.model.Products;
import com.example.demo_duc.service.CategoryService;
import com.example.demo_duc.service.ProductsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ProductsServlet", value = "/ProductsServlet")
public class ProductsServlet extends HttpServlet {
    private final ProductsService productsService = ProductsService.getInstance();
    private final CategoryService categoryService = CategoryService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createGet(request, response);
                break;
            case "update":
                updateGet(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                findAdd(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createPost(request, response);
                break;
            case "update":
                updatePost(request, response);
                break;
            case "search":
                search(request, response);
                break;
        }
    }
    private void findAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", productsService.getProducts());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Products/home.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("category", categoryService.getCategory());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Products/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        LocalDate date = LocalDate.now();
        int categoryID = Integer.parseInt(request.getParameter("category"));

        Category category = categoryService.getById(categoryID);
        if (category != null) {
            Products student = new Products(id, name, price, date, category);
            productsService.addProducts(student);
            response.sendRedirect("/Products/create.jsp");
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Products products = productsService.getById(id);
        if (products != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Products/update.jsp");
            request.setAttribute("products", products);
            request.setAttribute("category", categoryService.getCategory());
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("gender"));
        LocalDate date = LocalDate.now();
        int categoryID = Integer.parseInt(request.getParameter("category"));

        Category category = categoryService.getById(categoryID);
        Products products = productsService.getById(id);

        if (products != null && category != null) {
            products.setName(name);
            products.setPrice(price);
            products.setDate(date);
            products.setCategory(category);
            response.sendRedirect("/Products/update.jsp");
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productsService.deleteById(id);
        response.sendRedirect("/Products/home.jsp");
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Products> products = productsService.searchByName(search);
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Products/home.jsp");
        requestDispatcher.forward(request, response);
    }
}
