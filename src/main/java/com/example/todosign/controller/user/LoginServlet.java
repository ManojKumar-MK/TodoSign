package com.example.todosign.controller.user;

import com.example.todosign.db.TodoDao;
import com.example.todosign.model.User;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"} , initParams = {
        @WebInitParam(name = "success",value = "Login Successfull."),
        @WebInitParam(name = "error",value = "Account Not Exists.")
})
public class LoginServlet extends HttpServlet {

        static Logger logger = Logger.getLogger(String.valueOf(LoginServlet.class));
       @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


           System.out.println("Requested URL :" +request.getRequestURL());

           System.out.println("Requested URI :" +request.getRequestURI());

           System.out.println("Content-Type :"+request.getContentType());

           System.out.println("accept :"+request.getHeader("accept"));





               String email = request.getParameter("email");

               String password = request.getParameter("password");


               logger.log(Level.INFO, "Email : " + email);

               logger.log(Level.INFO, "Password : " + password);


               TodoDao todoDao = new TodoDao(getServletContext());
               User user = null;
               try {
                   user = todoDao.login(email, password);
               } catch (SQLException e) {
                   e.printStackTrace();
               }

               if (user != null) {

                   response.setContentType("text/html");

                   HttpSession session = request.getSession();
                   session.setAttribute("user", user);

                   String sucess = getServletConfig().getInitParameter("success");
                   logger.info(sucess);

                   session.setAttribute("success", sucess);
                   response.sendRedirect("userdashboard");

               }
               else {


                   String error = getServletConfig().getInitParameter("error");
                   logger.info(error);
                   HttpSession session = request.getSession();
                   session.setAttribute("error", error);
                   response.sendRedirect("login");


           }



    }
}
