package com.core.spring.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.core.spring.entity.Department;

@Component
public class DepartmentMapper implements RowMapper<Department>{

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {

		Department dept = new Department();
		dept.setId(rs.getInt("id"));
		dept.setName(rs.getString("name"));
		dept.setCompanyId(rs.getInt("companyId"));
		
		return dept;
	}

}
