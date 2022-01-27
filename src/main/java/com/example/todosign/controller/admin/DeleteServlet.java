package com.example.todosign.controller.admin;

import com.example.todosign.db.TodoDao;
import com.example.todosign.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DeleteServlet", value = "/admin/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        TodoDao todoDao = new TodoDao(getServletContext());
        int status = 0;
        try {
            status = todoDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(status == 1) {
            response.setContentType("text/html");
            response.sendRedirect("dashboard");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
