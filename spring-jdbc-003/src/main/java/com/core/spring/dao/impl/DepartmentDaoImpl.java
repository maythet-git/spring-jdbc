package com.core.spring.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.core.spring.dao.DepartmentDao;
import com.core.spring.dao.mapper.DepartmentMapper;
import com.core.spring.entity.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private DepartmentMapper deptMapper;

	@Override
	public void save(Department dept) {

		findById(100);
		
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT");
		sb.append(" INTO");
		sb.append(" DEPARTMENT");
		sb.append(" (");
		sb.append(" name");
		sb.append(" ,companyId");
		sb.append(" )");
		sb.append(" VALUES");
		sb.append(" (");
		sb.append(" :name");
		sb.append(" ,:companyId");
		sb.append(" )");

		String sql = sb.toString();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", dept.getName());
		params.put("companyId", dept.getCompanyId());

		SqlParameterSource paramSource = new MapSqlParameterSource(params);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(sql, paramSource, keyHolder);
		
	}

	@Override
	public Department findById(Integer id) {

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append(" *");
		sb.append(" FROM");
		sb.append(" DEPARTMENT");
		sb.append(" WHERE");
		sb.append(" id = :id");

		String sql = sb.toString();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		SqlParameterSource paramSource = new MapSqlParameterSource(params);
		Department dept = jdbcTemplate.queryForObject(sql, paramSource, deptMapper);

		return dept;
	}

	@Override
	public void update(Department dept) {

		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE");
		sb.append(" DEPARTMENT");
		sb.append(" SET");
		sb.append(" id = :id");
		sb.append(" ,name = :name");
		sb.append(" ,companyId = :companyId");
		sb.append(" WHERE");
		sb.append(" id = :id");
		
		String sql = sb.toString();
		
		// @formatter:off
		SqlParameterSource paramSource = new MapSqlParameterSource()
		.addValue("name", dept.getName())
		.addValue("companyId", dept.getCompanyId())
		.addValue("id", dept.getId());
		jdbcTemplate.update(sql, paramSource);
		// @formatter:on


	}

	@Override
	public void deleteById(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE");
		sb.append(" FROM");
		sb.append(" DEPARTMENT");
		sb.append(" WHERE");
		sb.append(" id = :id");

		String sql = sb.toString();

		SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", id);
		jdbcTemplate.update(sql, paramSource);

	}

	@Override
	public void deleteAll() {
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE");
		sb.append(" FROM");
		sb.append(" DEPARTMENT");

		String sql = sb.toString();

		SqlParameterSource paramSource = new MapSqlParameterSource();
		jdbcTemplate.update(sql, paramSource);

	}

	@Override
	public List<Department> findByAll() {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append(" *");
		sb.append(" FROM");
		sb.append(" DEPARTMENT");

		String sql = sb.toString();

		List<Department> list = jdbcTemplate.query(sql, deptMapper);
		return list;
	}
}
