package com.core.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.spring.dao.CompanyDao;
import com.core.spring.dao.DepartmentDao;
import com.core.spring.entity.Company;
import com.core.spring.entity.Department;
import com.core.spring.service.MyService;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveCompanyAndDept() {

		Company company = new Company();
		company.setName("GIC");
		company.setAddress("Tokyo,Japan");
		company.setPhone("012345");
		
		Integer companyId = this.companyDao.save(company);
		
		Department dept = new Department();
		dept.setName("Dept-Name");
		dept.setCompanyId(companyId);
		
		this.departmentDao.save(dept);
		
		System.out.println("Successfully....");
		
	}

}
