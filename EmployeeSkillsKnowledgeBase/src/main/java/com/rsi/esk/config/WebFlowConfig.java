package com.rsi.esk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.faces.config.AbstractFacesFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowController;
import org.springframework.webflow.security.SecurityFlowExecutionListener;

@Configuration
public class WebFlowConfig extends AbstractFacesFlowConfiguration {

	@Bean
	public FlowExecutor flowExecutor() {
	    return getFlowExecutorBuilder(flowRegistry())
	            .addFlowExecutionListener(securityListener())
	            .build();
	}

	@Bean
	public FlowDefinitionRegistry flowRegistry() {
	    return getFlowDefinitionRegistryBuilder(flowBuilderServices())
	        .addFlowLocation("/WEB-INF/flow/admin-flow.xml")
	        .addFlowLocation("/WEB-INF/flow/devCenter-flow.xml")
	        .addFlowLocation("/WEB-INF/flow/employee-flow.xml")
	        .addFlowLocation("/WEB-INF/flow/login-flow.xml")
	        .addFlowLocation("/WEB-INF/flow/userSettings-flow.xml")
	        .build();
	}
	
	@Bean
	public FlowController flowController() {
		FlowController flowController = new FlowController();
		flowController.setFlowExecutor(flowExecutor());
		return flowController;
	}
	
	@Bean
	public FlowBuilderServices flowBuilderServices() {
	    return getFlowBuilderServicesBuilder().build();
	}
	
	@Bean SecurityFlowExecutionListener securityListener() {
		return new SecurityFlowExecutionListener(); 
	}

}
