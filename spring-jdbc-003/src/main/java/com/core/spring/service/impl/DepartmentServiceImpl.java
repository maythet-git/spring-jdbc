package com.core.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.core.spring.dao.DepartmentDao;
import com.core.spring.entity.Department;
import com.core.spring.service.DepartmentService;

@Component
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao dao;


	@Override
	public Department findById(Integer id) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println("START---" + methodName);

		Department dept = this.dao.findById(id);

		System.out.println("Successfully");
		System.out.println("END---" + methodName);

		return dept;
	}

}
