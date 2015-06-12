package com.rsi.esk.config;

import java.util.Locale;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.faces.mvc.JsfView;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.sun.faces.config.ConfigureListener;

@Configuration
public class ESKConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("view");
		registry.addViewController("/view").setViewName("view");
		registry.addViewController("/login").setViewName("login");
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

//	@Bean
//	public ControllerClassNameHandlerMapping ControllerClassNameHandlerMapping() {
//		ControllerClassNameHandlerMapping hm = new ControllerClassNameHandlerMapping();
//		hm.setOrder(2);
//		hm.setDefaultHandler(new UrlFilenameViewController());
//		return hm;
//	}

	@Bean
	public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
		SimpleUrlHandlerMapping hm = new SimpleUrlHandlerMapping();
		Properties mappings = new Properties();

		mappings.put("/index", "flowController");
		mappings.put("/admin", "flowController");
		mappings.put("/searchEmployee", "flowController");
		mappings.put("/login", "flowController");
		mappings.put("/saveEmployee", "flowController");
		mappings.put("/userSettings", "flowController");
		mappings.put("/devCenter", "flowController");
		mappings.put("/saveDevCenter", "flowController");

		hm.setMappings(mappings);
		hm.setOrder(1);
		hm.setDefaultHandler(new UrlFilenameViewController());

		return hm;
	}

	@Bean
	public UrlBasedViewResolver faceletsViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(JsfView.class);
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".xhtml");
		return resolver;
	}

	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<ConfigureListener>(
				new ConfigureListener());
	}

}
