package com.ddtech.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //负载均衡需要和eureka整合
public class DeptConsumer80_App {
	 public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
