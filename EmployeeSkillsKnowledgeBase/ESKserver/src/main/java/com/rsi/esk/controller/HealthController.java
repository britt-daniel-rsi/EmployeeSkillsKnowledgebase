package com.rsi.esk.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController // Spring MVC
@Path("/health")
public class HealthController {

    @GET
    @Produces({"application/json"})
    public Health jersey() {
        return Health.up().status("ESK: Jersey: Up and Running!").build();
    }

    @RequestMapping(value = "/spring-health", produces = "application/json")
    public Health springMvc() {
        return Health.up().status("ESK: Spring MVC: Up and Running!").build();
    }
}