package com.core.spring.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.core.spring.dao.CompanyDao;
import com.core.spring.dao.mapper.CompanyMapper;
import com.core.spring.entity.Company;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CompanyMapper companyMapper;

	@Override
	public void save(Company company) {

		final String SQL_INSERT = "insert into company(id, name, address, phone) values(?, ?, ?, ?)";

		jdbcTemplate.update(SQL_INSERT, company.getId(), company.getName(), company.getAddress(), company.getPhone());
	}

	@Override
	public Company findById(Integer id) {

		String sql = "select * from company where id = ?";

		Company company = jdbcTemplate.queryForObject(sql, new Object[] { id }, companyMapper);

		return company;
	}

	@Override
	public void update(Company company) {

		final String SQL_UPDATE = "update company set name = ?, address = ?, phone = ? where id = ?";

		jdbcTemplate.update(SQL_UPDATE, company.getName(), company.getAddress(), company.getPhone(), company.getId());
	}

	@Override
	public void deleteById(Integer id) {
		String SQL_DELETE = "delete from company where id = ?";
		jdbcTemplate.update(SQL_DELETE, id);

	}

	@Override
	public void deleteAll() {
		String SQL_DELETE = "delete from company";
		jdbcTemplate.update(SQL_DELETE);

	}

	@Override
	public List<Company> findByAll() {
		String SQL_FindAll = "select * from company";
		List<Company> list = jdbcTemplate.query(SQL_FindAll, companyMapper);
		return list;
	}

	@Override
	public Integer getCount() {
		String SQL_Count = "select count(*) from company";
		Integer count = jdbcTemplate.queryForObject(SQL_Count, Integer.class);
		return count;
	}

}
