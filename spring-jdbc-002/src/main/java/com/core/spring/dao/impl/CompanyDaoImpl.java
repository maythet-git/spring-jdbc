package com.core.spring.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.core.spring.dao.CompanyDao;
import com.core.spring.dao.mapper.CompanyMapper;
import com.core.spring.entity.Company;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private CompanyMapper companyMapper;

	@Override
	public void save(Company company) {

		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT");
		sb.append(" INTO");
		sb.append(" COMPANY");
		sb.append(" (");
		sb.append(" id");
		sb.append(" ,name");
		sb.append(" ,address");
		sb.append(" ,phone");
		sb.append(" )");
		sb.append(" VALUES");
		sb.append(" (");
		sb.append(" :id");
		sb.append(" ,:name");
		sb.append(" ,:address");
		sb.append(" ,:phone");
		sb.append(" )");
		
		String sql = sb.toString();
		
		System.out.println(sql);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", company.getId());
		params.put("name", company.getName());
		params.put("address", company.getAddress());
		params.put("phone", company.getPhone());
		
		SqlParameterSource paramSource = new MapSqlParameterSource(params);
		jdbcTemplate.update(sql, paramSource);

	}

	@Override
	public Company findById(Integer id) {

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append(" *");
		sb.append(" FROM");
		sb.append(" COMPANY");
		sb.append(" WHERE");
		sb.append(" id = :id");
		
		String sql = sb.toString();
		
		System.out.println(sql);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		
		SqlParameterSource paramSource = new MapSqlParameterSource(params);
		Company company = jdbcTemplate.queryForObject(sql, paramSource, companyMapper);

		return company;
	}

	@Override
	public void update(Company company) {

		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE");
		sb.append(" COMPANY");
		sb.append(" SET");
		sb.append(" id = :id");
		sb.append(" ,name = :name");
		sb.append(" ,address = :address");
		sb.append(" ,phone = :phone");
		sb.append(" WHERE");
		sb.append(" id = :id");
		
		String sql = sb.toString();
		
		System.out.println(sql);
		
		SqlParameterSource paramSource = new MapSqlParameterSource()
		.addValue("name", company.getName())
		.addValue("address", company.getAddress())
		.addValue("phone", company.getPhone())
		.addValue("id", company.getId());
		jdbcTemplate.update(sql, paramSource);
	}

	@Override
	public void deleteById(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE");
		sb.append(" FROM");
		sb.append(" COMPANY");
		sb.append(" WHERE");
		sb.append(" id = :id");
		
		String sql = sb.toString();
		
		System.out.println(sql);
		
		SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", id);
		jdbcTemplate.update(sql, paramSource);

	}

	@Override
	public void deleteAll() {
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE");
		sb.append(" FROM");
		sb.append(" COMPANY");
		
		String sql = sb.toString();
		
		System.out.println(sql);
		
		SqlParameterSource paramSource = new MapSqlParameterSource();
		jdbcTemplate.update(sql, paramSource);

	}

	@Override
	public List<Company> findByAll() {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append(" *");
		sb.append(" FROM");
		sb.append(" COMPANY");
		
		String sql = sb.toString();
		
		System.out.println(sql);
		
		List<Company> list = jdbcTemplate.query(sql, companyMapper);
		return list;
	}

	/**
	 *
	 */
	@Override
	public Integer getCount() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append(" COUNT(*)");
		sb.append(" FROM");
		sb.append(" COMPANY");
		
		String sql = sb.toString();
		
		System.out.println(sql);
		
		Integer count = jdbcTemplate.queryForObject(sql, new MapSqlParameterSource(), Integer.class);
		return count;
	}

}
