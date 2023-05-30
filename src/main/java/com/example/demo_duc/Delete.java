package com.example.demo_duc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo_duc.StudentServlet.students;

@WebServlet(name = "Delete", value = "/Delete")
public class Delete extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    int id=Integer.parseInt(request.getParameter("deleteid"));
        for (int i = 0; i < students.size(); i++) {
            if(id==students.get(i).getId()){
                students.remove(i);
            }

        }
        request.setAttribute("arr", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}
