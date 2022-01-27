package com.example.todosign.listener.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {

        System.out.println("Session attribute added : "+ event.getName() + "  , " + event.getValue() );

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

        System.out.println("Session attribute removed : "+ event.getName() + "  , " + event.getValue() );
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {


        System.out.println("Session attribute replaced : "+ event.getName() + "  , " + event.getValue() );
    }
}
