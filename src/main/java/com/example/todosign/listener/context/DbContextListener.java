package com.example.todosign.listener.context;

import com.example.todosign.db.ConnectionFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

@WebListener
public class DbContextListener implements ServletContextListener {

    static Logger logger = Logger.getLogger(String.valueOf(DbContextListener.class));

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("DbContextListener : Initialized.");
        ServletContext servletContext = sce.getServletContext();
        String dbUrl = servletContext.getInitParameter("dbUrl");
        String dbUsername = servletContext.getInitParameter("dbUsername");
        String dbPassword = servletContext.getInitParameter("dbPassword");

/*
         Mow Connection objet is created during context load and
         Availble for global
*/
        ConnectionFactory connectionFactory = new ConnectionFactory(dbUrl,dbUsername,dbPassword);
        try {
            servletContext.setAttribute("Connection",connectionFactory.getConnection());
            logger.info("Connecction attribute set...");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /*

        During Stop or Undeploy Connection is closed.

*/

        Connection connection = (Connection) sce.getServletContext().getAttribute("Connection");
        try {
            connection.close();
            logger.info("Connecction Closed...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("In DbContextListener : Destroyed.");


    }
}
