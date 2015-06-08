package com.rsi.esk;

import java.util.Locale;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;
import org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sun.faces.config.ConfigureListener;

@Configuration
public class ESKConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("view");
        registry.addViewController("/view").setViewName("view");
	}
	
	@Bean
	public PropertyPlaceholderConfigurer getPropertyPlaceHolderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("properties/hibernate.properties"));
		ppc.setIgnoreUnresolvablePlaceholders(true);

		return ppc;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:properties/search");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));
		resolver.setCookieName("myLocaleCookie");
		resolver.setCookieMaxAge(4800);
		return resolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("mylocale");
		registry.addInterceptor(interceptor);
	}
	
	@Bean
	public ControllerClassNameHandlerMapping controllerClassNameHandlerMapping() {
	    ControllerClassNameHandlerMapping hm = new ControllerClassNameHandlerMapping();
	    hm.setOrder(-1);
	    hm.setDefaultHandler (new UrlFilenameViewController() );
	    return hm;
	}
	
	 @Bean
	    public InternalResourceViewResolver internalResourceViewResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/view");
	        resolver.setSuffix(".xhtml");
	        return resolver;
	    }
	 
	 @Bean
	 public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		 return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
	 }

}
