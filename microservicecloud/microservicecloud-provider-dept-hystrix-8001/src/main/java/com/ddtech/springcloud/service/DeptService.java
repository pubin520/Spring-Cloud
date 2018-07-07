package com.ddtech.springcloud.service;

import java.util.List;

import com.ddtech.springcloud.entitys.Dept;

public interface DeptService {
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
