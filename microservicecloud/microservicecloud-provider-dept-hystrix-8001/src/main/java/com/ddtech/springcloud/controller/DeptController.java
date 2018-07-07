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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController      //rest风格 ，及每个路径请求都返回json串
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	@PostMapping(value="/dept/add")
	public boolean add(@RequestBody Dept dept){
		return  deptService.add(dept);
	}
	@GetMapping(value="/dept/get/{id}")
	//一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id){
		Dept dept=  deptService.get( id);
		if(dept==null){
			throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
		}
		return dept;
	}
	public Dept processHystrix_Get(@PathVariable("id" ) Long id){
	//	return new Dept() .setId(id) 
		//return new Dept().setId(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
		Dept dept=new Dept();
		dept.setId(id);
		dept.setDept_name("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand");
		dept.setDb_source("no this database in MySQL");
		return dept;
	}
	@GetMapping(value="/dept/list")
	public List<Dept> list(){
		return  deptService.list();
	}
	
	
}
