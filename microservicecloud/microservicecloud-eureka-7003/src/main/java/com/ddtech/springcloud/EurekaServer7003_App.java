package com.ddtech.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer        //启用eureka服务
public class EurekaServer7003_App {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7003_App.class, args);
	}
}
