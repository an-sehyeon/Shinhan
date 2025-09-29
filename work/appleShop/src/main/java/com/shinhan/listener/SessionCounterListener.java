package com.shinhan.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCounterListener
 *
 */
@WebListener
public class SessionCounterListener implements HttpSessionListener {
	
	private static int activeSessions = 0;
    
    public SessionCounterListener() {
        // TODO Auto-generated constructor stub
    }
    
    // 세션이 생성될때 호출
    public void sessionCreated(HttpSessionEvent se)  { 
    	activeSessions++;
    	ServletContext app = se.getSession().getServletContext();
    	app.setAttribute("activeSessions", activeSessions);
    	System.out.println("sessionCreated 접속자수 : " + activeSessions);
    }

	// 세션이 무효화될때 호출 invalidate()
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	if(activeSessions > 0)
    		activeSessions--;
    	ServletContext app = se.getSession().getServletContext();
    	app.setAttribute("activeSessions", activeSessions);
    	System.out.println("sessionDestroyed 접속자수 : " + activeSessions);
    }
	
}
