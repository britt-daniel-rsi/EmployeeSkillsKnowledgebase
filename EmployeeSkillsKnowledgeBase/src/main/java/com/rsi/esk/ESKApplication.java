package com.rsi.esk;

import java.util.HashMap;

import javax.faces.webapp.FacesServlet;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import com.rsi.esk.util.ViewScope;

@Configuration
@ComponentScan
@EnableConfigurationProperties
@EnableAutoConfiguration(exclude={WebMvcAutoConfiguration.class,DispatcherServletAutoConfiguration.class })
//@Import({ ESKConfig.class, DaoConfig.class, ServiceConfig.class })
public class ESKApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ESKApplication.class, ESKInitializer.class);
    }
    
	
	public static void main(String[] args) {
		SpringApplication.run(ESKApplication.class, args);
	}
	
    @Bean
    public ServletRegistrationBean facesServletRegistrationBean() {
    	FacesServlet servlet = new FacesServlet();
        ServletRegistrationBean registration = 
        		new ServletRegistrationBean(servlet, "*.jsf","/faces/*","*.faces","*.xhtml");
        registration.setLoadOnStartup(1);
        registration.setName("FacesServlet");
        return registration;
    }
    
    @Bean
	public static ViewScope viewScope() {
		return new ViewScope();
	}
    
    @Bean
	public static CustomScopeConfigurer scopeConfigurer() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("view", viewScope());
		configurer.setScopes(hashMap);
		return configurer;
	}


}
