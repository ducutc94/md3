package com.example.demo_duc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static com.example.demo_duc.StudentServlet.students;

@WebServlet(name = "CreateServlet", value = "/CreateServlet")
public class CreateServlet extends HttpServlet {
    private  final ClassesManage classesManage =ClassesManage.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("arrayList",classesManage.classesList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/creat.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}
