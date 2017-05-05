package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class DemoApplication {

	public static void main(String[] args) {
		 ApplicationContext context =SpringApplication.run(DemoApplication.class, args);
		 System.out.println(( (DemoClient) context.getBean("restClient")).getAllEmployees());
    
	}
	@Bean
    public RestTemplate geRestTemplate() {
        return new RestTemplate();
    }
}
