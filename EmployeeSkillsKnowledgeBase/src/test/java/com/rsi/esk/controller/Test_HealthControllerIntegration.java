package com.rsi.esk.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.rsi.esk.ESKApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ESKApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class Test_HealthControllerIntegration {

	private RestTemplate restTemplate = new TestRestTemplate("britt",
			"ESKPassword");

	@Test
	public void health() {

		ResponseEntity<String> entity = restTemplate.getForEntity(
				"http://localhost:9000/ESK/jersey/health", String.class);

		assertThat(entity.getStatusCode().is2xxSuccessful()).isTrue();
		assertThat(entity.getBody()).contains("Jersey: Up and Running!");
	}
}