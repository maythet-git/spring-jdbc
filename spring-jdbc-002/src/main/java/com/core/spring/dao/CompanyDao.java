package com.core.spring.dao;

import java.util.List;

import com.core.spring.entity.Company;

public interface CompanyDao {

	void save(Company company);
	
	void update(Company company);
	
	void deleteById(Integer id);
	
	void deleteAll();
	
	Company findById(Integer id);
	
	List<Company> findByAll();
	
	Integer getCount();
}
