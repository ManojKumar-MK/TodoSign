package com.example.todosign.controller.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "Logout" , urlPatterns = {"/admin/logout"})
public class LogoutServlet extends HttpServlet {

    static Logger logger = Logger.getLogger(String.valueOf(LogoutServlet.class));
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("On Logout");

        Cookie [] cookies = req.getCookies();
        if(cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if(cookie.getName().equals("JSESSIONID"))
                {
                    logger.info("JSESSIONID : "+cookie.getValue());
                    break;
                }
            }
        }

        // Invalidate the Session attribute

        HttpSession session = req.getSession(false);
        logger.info("Values : "+session.getAttribute("admin"));

        if(session != null)
        {
            if(session.getAttribute("admin") != null)
                session.removeAttribute("admin");

                  session.invalidate();
            resp.sendRedirect(req.getContextPath());
        }


    }
}
