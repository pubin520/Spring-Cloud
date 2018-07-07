package com.ddtech.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddtech.springcloud.entitys.Dept;
import com.ddtech.springcloud.service.DeptClientService;

@RestController
public class DeptController_Consumer {
	/**
	 * feign是一种借口+注解的方式负载均衡，符合传统的面向借口变成方式
	 */
		@Autowired
		private DeptClientService deptClientService;	
		@RequestMapping(value="/consumer/dept/add")
		public boolean add(Dept dept){
			return  deptClientService.add(dept);
		}
		@RequestMapping(value="/consumer/dept/get/{id}")
		public Dept ge(@PathVariable("id") long id){
			return   deptClientService.get(id);
		}
		@SuppressWarnings("unchecked")
		@RequestMapping(value="/consumer/dept/list")
		public List<Dept> list(){
			return deptClientService.list();
		}
}
