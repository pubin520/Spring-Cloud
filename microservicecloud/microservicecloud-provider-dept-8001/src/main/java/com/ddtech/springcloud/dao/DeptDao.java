package com.ddtech.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ddtech.springcloud.entitys.Dept;

//boot与mybatis要添加此注解

@Mapper
public interface DeptDao {
	public boolean addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();
}
