package org.asapromu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class AsapromuwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsapromuwebApplication.class, args);
	}

}
