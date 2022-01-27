package com.example.todosign.filter.admin;

import com.example.todosign.model.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter({"/admin/dashboard","/admin/edit"})
public class AuthenticationFilter implements Filter {

    private static Logger logger = Logger.getLogger(String.valueOf(AuthenticationFilter.class));
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info(" : On Init ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        logger.info(" : On Do Filter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession(false);// don't create if it doesn't exist


        if(session != null && session.getAttribute("admin") !=null) {
                logger.info(" : On Do Filter Continued.");
                filterChain.doFilter(servletRequest, servletResponse);
        }


        else {
            logger.info(" : On Do Filter Not Authorized.");
            logger.info(" : On Do Filter Redirected.");
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect("login");
        }


    }

    @Override
    public void destroy() {
        logger.info(" : On destroyed ");
    }
}
