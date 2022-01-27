package com.example.todosign.controller.admin;

import com.example.todosign.db.TodoDao;
import com.example.todosign.model.User;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "EditServlet", value = "/admin/Edit" )

public class EditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");

        Integer id = Integer.valueOf(request.getParameter("id"));   // HIDDEN FORM FIELD


        String firstname =request.getParameter("firstname");

        String lastname =request.getParameter("lastname");

        String phone =request.getParameter("phone");

        String email =request.getParameter("email");

        String password =request.getParameter("password");

        User user = new User(firstname,lastname,phone,email,password);

        TodoDao todoDao = new TodoDao(getServletContext());
        int status = 0;
        try {
            status = todoDao.update(id,user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(status == 1) {
            response.setContentType("text/html");
            response.sendRedirect("dashboard");
        }

    }


}