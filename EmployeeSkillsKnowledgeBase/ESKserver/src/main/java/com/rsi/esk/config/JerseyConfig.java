package com.rsi.esk.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.context.annotation.Configuration;

import com.rsi.esk.controller.DevCenterController;
import com.rsi.esk.controller.HealthController;

@Configuration
@ApplicationPath("/ESK/jersey")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		packages("com.rsi.esk.controller");
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(ServerProperties.JSON_PROCESSING_FEATURE_DISABLE, false);
        property(ServerProperties.MOXY_JSON_FEATURE_DISABLE, true);
        property(ServerProperties.WADL_FEATURE_DISABLE, true);
        
        register(HealthController.class);
        register(DevCenterController.class);
	}
}
