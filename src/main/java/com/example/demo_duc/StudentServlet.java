package com.example.demo_duc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/view")
public class StudentServlet extends HttpServlet {
     public static List<Students> students = new ArrayList<>();
     private  final ClassesManage classesManage =ClassesManage.getInstance();
     public   Classes classes;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Students students1 = new Students(1, "Duc",new Classes(1,"12A"));
        students.add(students1);
        request.setAttribute("arr", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student.jsp");
        requestDispatcher.forward(request, response);
    }

    public void creat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String className = request.getParameter("classname");
        classes=classesManage.getClasses(className);
        students.add(new Students(id, name,classes));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=UTF-8;");
        creat(request, response);
        request.setAttribute("arr", students);
        request.setAttribute("class",classesManage);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student.jsp");
        requestDispatcher.forward(request, response);

    }
}
