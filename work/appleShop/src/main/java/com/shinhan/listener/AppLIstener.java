package com.shinhan.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppLIstener
 *
 */
@WebListener
public class AppLIstener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AppLIstener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         //System.out.println("웹프로그램종료~~~~");
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 

    	
    	String cpath = sce.getServletContext().getContextPath();
    	sce.getServletContext().setAttribute("version", "1.0");
    	
    	//System.out.println("ServletContextListener ... contextInitialized초기화" + cpath);
    	
    }
	
}
