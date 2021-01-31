package com.core.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.core.spring.dao.CompanyDao;
import com.core.spring.entity.Company;
import com.core.spring.service.CompanyService;

@Component
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao dao;


	@Override
	public Company findById(Integer id) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println("START---" + methodName);

		Company company = this.dao.findById(id);

		System.out.println("Successfully");
		System.out.println("END---" + methodName);

		return company;
	}

}
