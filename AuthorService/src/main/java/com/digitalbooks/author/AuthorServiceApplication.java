package com.digitalbooks.author;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition
@EnableFeignClients("com.digitalbooks.author")
public class AuthorServiceApplication {

	public static String ipAddress = "";

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication.run(AuthorServiceApplication.class, args);
		AuthorServiceApplication.getIpAddress();
	}

	public static void getIpAddress() throws UnknownHostException {
		ipAddress = InetAddress.getLocalHost().getHostAddress();
	}
}
