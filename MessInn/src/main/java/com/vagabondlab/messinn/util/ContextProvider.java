package com.vagabondlab.messinn.util;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.vagabondlab.messinn.util.properties.PropertyFactory;

/**
 * 
 * @author Shaiful Islam palash | <kuvic16@gmail.com>
 * @since version 0.0.1
 */
public class ContextProvider implements ServletContextListener{
	
	private static ServletContext servletContext;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		servletContext = arg0.getServletContext();
        ContextInfo.setContextRealPath(servletContext.getRealPath("/"));
        ContextInfo.setContextPath(servletContext.getContextPath());
        
        System.out.println(".................MessInn application is Starting....................");
        System.out.println("Context Path: " + servletContext.getContextPath());
        
        /* Initializing property file. */
        String propertiesFileAbsolutePath = servletContext.getRealPath(File.separator)
               + File.separator + "WEB-INF" + File.separator + "system.properties";
        PropertyFactory.init(propertiesFileAbsolutePath);
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		
	}

}
