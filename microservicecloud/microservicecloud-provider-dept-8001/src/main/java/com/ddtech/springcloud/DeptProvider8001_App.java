package com.ddtech.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptProvider8001_App {
	/**
	 * 将微服务客服端，注入到erueka服务
	 * （1）pom文件添加客服端gav
	 * （2）启动类中启用
	 * （3）application.yml中写入注册到指定服务
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8001_App.class, args);
	}
}
