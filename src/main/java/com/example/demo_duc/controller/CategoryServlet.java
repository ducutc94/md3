package com.example.demo_duc.controller;

import com.example.demo_duc.model.Category;
import com.example.demo_duc.service.CategoryService;
import com.example.demo_duc.service.ProductsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CategoryServlet", value = "/CategoryServlet")
public class CategoryServlet extends HttpServlet {
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
        }
    }
    private void findAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Category/home.jsp");
        request.setAttribute("category", categoryService.getCategory());
        requestDispatcher.forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/Category/create.jsp");
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        Category category = new Category(id, name);
        categoryService.addCategory(category);
        response.sendRedirect("/Category");
    }

    private void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Category category = categoryService.getById(id);

        if (category != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Category/update.jsp");
            request.setAttribute("category", category);
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        Category category = categoryService.getById(id);

        if (category != null) {
            category.setName(name);
            response.sendRedirect("/Category");
        } else {
            response.sendRedirect("/404.jsp");
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id =Integer.parseInt(request.getParameter("id"));

        Category category = categoryService.getById(id);
        if (category != null) {
            categoryService.deleteById(id);
            productsService.deleteByCategory(category);
            response.sendRedirect("/Category");
        } else {
            response.sendRedirect("/404.jsp");
        }
    }
}
