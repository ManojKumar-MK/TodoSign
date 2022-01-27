package com.example.todosign.error;

import com.example.todosign.util.ErrorCodeUtil;
import com.example.todosign.util.ExceptionUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;

@WebServlet(name = "ErrorServlet", value = "/errorServlet" )
public class ErrorServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(String.valueOf(ErrorServlet.class));
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // WHEN ERROR OCCURED OR EXCEPTION THIS WILL DO SOME STUFF


        logger.warning("ON ERROR SERVLET : doGet");

        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        String message = (String) request.getAttribute("javax.servlet.error.message");



        response.setContentType("text/html");

            if(statusCode != null) // 4xx and Some  500 is Internal Error
            {
                if(statusCode == 404)
                {
                    statusCode = 500;
                    message = "The Requested service temporarily unavailable";
                }
                ErrorCodeUtil errorCodeUtil = new ErrorCodeUtil(statusCode,message); //  WHUCH SERVLET REQUEST MAKES
                request.setAttribute("error",errorCodeUtil); // SETTING ATTRIBUTE FOR ADDING IN JSP
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
                requestDispatcher.forward(request,response);


            }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
