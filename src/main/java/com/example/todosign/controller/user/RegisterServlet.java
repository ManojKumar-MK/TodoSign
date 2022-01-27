package com.example.todosign.controller.user;

import com.example.todosign.db.TodoDao;
import com.example.todosign.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Logger;

@WebServlet(name = "RegisterServlet", value = "/Register" , initParams = {
        @WebInitParam(name = "success",value = "Register Successfull."),
        @WebInitParam(name = "error",value = "Record already exists with email or phone number.")
})
public class RegisterServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(String.valueOf(RegisterServlet.class));
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");


        String firstname =request.getParameter("firstname");

        String lastname =request.getParameter("lastname");

        String phone =request.getParameter("phone");

        String email =request.getParameter("email");

        String password =request.getParameter("password");

        User user = new User(firstname,lastname,phone,email,password);


        TodoDao todoDao = new TodoDao(getServletContext());
        int status  = 0;
        try {
            status = todoDao.register(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        logger.info(String.valueOf(status));


        if(status > 0)
        {
            String success = getServletConfig().getInitParameter("success");
            logger.info(success +" "+user);

            response.getWriter().println(success +" "+user );


            response.sendRedirect(request.getContextPath());

//
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
//            requestDispatcher.forward(request,response);
        }
        else
        {

            String error = getServletConfig().getInitParameter("error");
            logger.info(error);
            response.getWriter().println(error);

            response.sendRedirect(request.getContextPath()+"/register");


        }


    }
}
