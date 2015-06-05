package com.rsi.esk;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ESKInitializer implements WebApplicationInitializer {
	public void onStartup(ServletContext servletContext) throws ServletException {  
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
System.out.println("config");
        ctx.register(ESKConfig.class);

        ctx.setServletContext(servletContext);    
        servletContext.addListener(new ContextLoaderListener(ctx));
        servletContext.addListener(new RequestContextListener());
        DispatcherServlet dispatcher = new DispatcherServlet(ctx);
        
        Dynamic dynamic = servletContext.addServlet("dispatcher", dispatcher);  
        dynamic.addMapping("ESK/");  
        dynamic.setLoadOnStartup(1);  
   }

}

