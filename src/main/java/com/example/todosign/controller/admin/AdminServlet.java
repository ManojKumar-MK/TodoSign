package com.example.todosign.controller.admin;

import com.example.todosign.db.TodoDao;
import com.example.todosign.model.Admin;
import com.example.todosign.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet" , value = "/admin/Login")
public class AdminServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


            String username = request.getParameter("username");

            String password = request.getParameter("password");

            TodoDao todoDao = new TodoDao(getServletContext());
            Admin admin = null;
            try {
                admin = todoDao.adminlogin(username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }


            if (admin != null) {

                session.setAttribute("admin", admin);  // Session Set for Admin user
//
//                response.setContentType("text/html");
//                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/dashboard.jsp");
//                requestDispatcher.forward(request, response);

                response.sendRedirect("dashboard");



            }

             else {

                 response.setContentType("text/html");
                response.getWriter().println("Invalid Login");
                response.sendRedirect("login");

//
//                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/");
//                requestDispatcher.include(request, response);

            }


    }
}
