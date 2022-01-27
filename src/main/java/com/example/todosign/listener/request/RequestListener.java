package com.example.todosign.listener.request;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {



        ServletRequest request = sre.getServletRequest();
        System.out.println("Servlet Request Destroyed. Remote IP =  "+request.getRemoteAddr() +"Time : "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));



    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        ServletRequest request = sre.getServletRequest();
        System.out.println("Servlet Request Initialized. Remote IP =  "+request.getRemoteAddr() +"Time : "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));

    }
}
