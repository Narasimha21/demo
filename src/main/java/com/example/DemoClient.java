package com.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component("restClient")
public class DemoClient {
	@Autowired
    private RestTemplate restTemplate;
	 public String getAllEmployees() {
	        return restTemplate.getForObject("http://localhost:8080/v1/api/courses", String.class);
	    }
}
