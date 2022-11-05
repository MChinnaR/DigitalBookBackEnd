package com.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@SpringBootApplication
@EnableEurekaServer
public class EurakaNetflixServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurakaNetflixServerApplication.class, args);
	}

}
