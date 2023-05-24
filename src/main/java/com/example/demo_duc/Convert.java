package com.example.demo_duc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Convert", value = "/Convert")
public class Convert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher= getServletContext().getRequestDispatcher("C:\\Users\\Tien\\Desktop\\Module2\\demo_duc\\src\\main\\webapp\\baitap.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      String name=request.getParameter("Username");
      String password=request.getParameter("Password");
      if("admin".equals(name)&&"123".equals(password)){
          response.sendRedirect("admin.jsp");
      }
      else {
          response.sendRedirect("user.jsp");
      }
    }

}
