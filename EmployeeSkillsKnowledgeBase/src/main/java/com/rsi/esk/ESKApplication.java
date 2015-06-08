package com.rsi.esk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties
//@Import({ ESKConfig.class, DaoConfig.class, ServiceConfig.class })
public class ESKApplication {

	public static void main(String[] args) {
		SpringApplication.run(ESKApplication.class, args);
	}


}
