package com.ddtech.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ddtech.springcloud.entitys.Dept;
import com.ddtech.springcloud.service.DeptService;

@RestController      //rest风格 ，及每个路径请求都返回json串
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	@PostMapping(value="/dept/add")
	public boolean add(@RequestBody Dept dept){
		return  deptService.add(dept);
	}
	@GetMapping(value="/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id){
		return  deptService.get( id);
	}
	@GetMapping(value="/dept/list")
	public List<Dept> list(){
		return  deptService.list();
	}
	
	
}
