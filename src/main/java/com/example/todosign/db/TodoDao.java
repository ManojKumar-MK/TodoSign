package com.example.todosign.db;

import com.example.todosign.model.Admin;
import com.example.todosign.model.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class TodoDao {

    private final ServletContext servletContext;
    public TodoDao(ServletContext servletContext)
    {
        this.servletContext = servletContext;
    }

    private Connection connection = null;

    private Connection getConnection() throws SQLException, IOException {

        Connection connection = (Connection) servletContext.getAttribute("Connection");
        return connection;

    }
    public int register(User user) throws SQLException, IOException {
        int rows = 0;
        String query = "INSERT INTO user(firstname,lastname,phone,email,password) VALUES (?,?,?,?,?)";

        System.out.println("register Method : "+user);
        if(check(user)) {
            System.out.println("In Check Verified");
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setString(3,user.getPhone());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5,user.getPassword());
            rows = preparedStatement.executeUpdate();

            log.println("Record Added");

            preparedStatement.close();

            return rows;
        }
       
        return rows;

    }
    private boolean check(User user) throws SQLException, IOException {
        String query = "SELECT * FROM user WHERE email = ? || phone = ? ";
        connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,user.getEmail());
        preparedStatement.setString(2,user.getPhone());

        ResultSet resultSet = preparedStatement.executeQuery();

        int rows = resultSetCount(resultSet);
        
        preparedStatement.close();
        
        
        if(rows!=0)
            return false;

        
        return true;        


    }


    
    
    public User login(String email,String passsword) throws SQLException, IOException {

        String query = "SELECT * FROM user WHERE email = ? && password = ?";

        connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,email);
        preparedStatement.setString(2,passsword);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next())
        {
            int id = resultSet.getInt(1);
            String firstname = resultSet.getString(2);
            String lastname = resultSet.getString(3);
            String phone = resultSet.getString(4);
            String emailId = resultSet.getString(5);
            String password = resultSet.getString(6);

            User user = new User(id,firstname,lastname,phone,emailId,password);
            System.out.println("Values : "+user);
            return user;
        }

        preparedStatement.close();
            return null;


    }

    public Admin adminlogin(String username, String passsword) throws SQLException, IOException {

        String query = "SELECT * FROM admin WHERE username = ? && password = ?";

        connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,passsword);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next())
        {
            int id = resultSet.getInt(1);
            String uname = resultSet.getString(2);
            String password = resultSet.getString(3);

            Admin admin = new Admin(id,uname,password);
            System.out.println("Values : "+admin);
            return admin;
        }

        preparedStatement.close();

        return null;


    }

    public User getUser(String id) throws SQLException, IOException {
        User user = null;
        String query = "SELECT * FROM user where id = ?";
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next())
        {
            int userid = resultSet.getInt(1);
            String firstname = resultSet.getString(2);
            String lastname = resultSet.getString(3);
            String phone = resultSet.getString(4);
            String emailId = resultSet.getString(5);
            String password = resultSet.getString(6);

            user = new User(userid,firstname,lastname,phone,emailId,password);
        }

        return user;

    }

    public List<User> getUsers() throws SQLException, IOException {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next())
        {
            int id = resultSet.getInt(1);
            String firstname = resultSet.getString(2);
            String lastname = resultSet.getString(3);
            String phone = resultSet.getString(4);
            String emailId = resultSet.getString(5);
            String password = resultSet.getString(6);

            userList.add(new User(id,firstname,lastname,phone,emailId,password));
        }

        preparedStatement.close();

        return userList;


    }

    public int update(Integer id , User user) throws SQLException, IOException {
        String query =
                "UPDATE user set firstName=? ,lastName =?, phone =?, email = ?, password = ? WHERE id = ?";
        connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,user.getFirstName());

        preparedStatement.setString(2,user.getLastName());

        preparedStatement.setString(3,user.getPhone());

        preparedStatement.setString(4,user.getEmail());

        preparedStatement.setString(5,user.getPassword());

        preparedStatement.setInt(6,id);

        int status = preparedStatement.executeUpdate();

        preparedStatement.close();
        return status;


    }


    public int delete(int id) throws SQLException, IOException {
        String query = "DELETE from user WHERE id = ?";
        connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);

        int rows = preparedStatement.executeUpdate();

        return rows;
    }

    private int resultSetCount(ResultSet resultSet) throws SQLException{
        try{
            int i = 0;
            while (resultSet.next()) {
                i++;
            }
            return i;
        } catch (Exception e){
            System.out.println("Error getting row count");
            e.printStackTrace();
        }
        return 0;
    }


}
