package com.example.todosign.db;

import javax.servlet.ServletContext;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {


    private String db_url;
    private String db_password ;
    private String db_username;
    private Connection connection;


    public ConnectionFactory(String db_url,String db_username,String db_password)
    {
        this.db_url = db_url;
        this.db_username = db_username;
        this.db_password = db_password;

        try {

            // Connector Loaded and Registered
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(db_url,db_username,db_password);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() throws SQLException, IOException {
        return this.connection;

    }
}