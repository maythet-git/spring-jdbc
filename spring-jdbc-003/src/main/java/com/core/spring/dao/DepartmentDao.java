package com.core.spring.dao;

import java.util.List;

import com.core.spring.entity.Department;

public interface DepartmentDao {

	void save(Department dept);
	
	void update(Department dept);
	
	void deleteById(Integer id);
	
	void deleteAll();
	
	Department findById(Integer id);
	
	List<Department> findByAll();
}
