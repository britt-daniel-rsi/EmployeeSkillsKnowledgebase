package com.rsi.esk;

import java.util.HashMap;
import java.util.Map;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;
import org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.rsi.esk.util.ViewScope;
import com.sun.faces.config.ConfigureListener;

@Configuration
public class WebJsfConfig implements ServletContextAware {

	@Bean
	public ControllerClassNameHandlerMapping controllerClassNameHandlerMapping() {
	    ControllerClassNameHandlerMapping hm = new ControllerClassNameHandlerMapping();
	    hm.setOrder(-1);
	    hm.setDefaultHandler (new UrlFilenameViewController() );
	    return hm;
	}
	
    @Bean
    public static CustomScopeConfigurer getViewScopeConfigurer() {
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        Map<String, Object> view = new HashMap<String,Object>();
        view.put("view", viewScope());
        customScopeConfigurer.setScopes(view);
        return customScopeConfigurer;
    }

    @Bean
    public static ViewScope viewScope() {
        return new ViewScope();
    }

    @Bean
    public FacesServlet facesServlet() {
        return new FacesServlet();
    }

    @Bean
    public ServletRegistrationBean facesServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                facesServlet(), "*.xhtml", "*.jsf");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean
    public ConfigureListener configureListener() {
        return new ConfigureListener();
    }

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsf");
        return resolver;
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<>(
                new ConfigureListener());
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
    }
}