package com.rsi.esk;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

@Configuration
public class WebFilterConfig {

    @Bean
    public Filter openEntityManagerInViewFilter() {
        return new OpenEntityManagerInViewFilter();
    }
}
