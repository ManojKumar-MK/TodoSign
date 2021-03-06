package com.example.todosign.listener.context;


import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextAttributeListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("ServletContext attribute added : "+ event.getName() + "  , " + event.getValue() );
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {

        System.out.println("ServletContext attribute removed : "+ event.getName() + "  , " + event.getValue() );
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("ServletContext attribute replaced : "+ event.getName() + "  , " + event.getValue() );
    }
}
