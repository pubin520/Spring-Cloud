package com.ddtech.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ddtech.springcloud.entitys.Dept;

@RestController
public class DeptController_Consumer {
	/**
	 * 消费者
	 * 通过rest api调用生成者
	 */
	//private static final String REST_URL_PREFIX="http://localhost:8001";
	//通过微服务名称去调用
	private static final String REST_URL_PREFIX="http://MICROSERVICECLOUD-DEPT";

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept){
		return  restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, boolean.class);
	}
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept ge(@PathVariable("id") long id){
		return  restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list(){
		return  restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
	}
}
