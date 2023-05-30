package com.example.demo_duc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo_duc.StudentServlet.students;

@WebServlet(name = "Update", value = "/Update")
public class Update extends HttpServlet {
    int index;
    private final ClassesManage classesManage = ClassesManage.getInstance();
    public Classes classes;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        Students student = new Students();
        for (int i = 0; i < students.size(); i++) {
            if (id == students.get(i).getId()) {
                student = students.get(i);
                index = i;
            }

        }
        request.setAttribute("student", student);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("update.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        students.get(index).setId(id);
        String name = request.getParameter("name");
        students.get(index).setName(name);
        String className = request.getParameter("classname");
        classes = classesManage.getClasses(className);
        students.get(index).setClasses(classes);
        request.setAttribute("arr", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student.jsp");
        requestDispatcher.forward(request, response);
    }
}
