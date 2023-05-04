package com.example.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class ContextListener implements ServletContextAttributeListener {
    public void attributeAdded(ServletContextAttributeEvent event) {

        event.getServletContext().setAttribute("servletTimeInit", LocalDateTime.now());
    }
}
