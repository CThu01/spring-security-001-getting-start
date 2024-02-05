package com.jdc.demo.service;

import java.util.List;

import javax.sql.DataSource;

import org.eclipse.tags.shaded.org.apache.xalan.xsltc.compiler.Template;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.jdc.demo.service.dto.AddressDto;

@Service
public class AddressService {

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert simpleJdbcInsert;
	
	public AddressService(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
		simpleJdbcInsert.withTableName("address");
		simpleJdbcInsert.usingGeneratedKeyColumns("id");
		simpleJdbcInsert.setColumnNames(List.of("email","name","building","street","township","division"));
	}
	
	public List<AddressDto> findAddressByEmail(){
		
		var authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication.isAuthenticated()) {
			var sql = "select * from address where email = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<AddressDto>(AddressDto.class), authentication.getName());
		}
		return null;
	}

	public void save(AddressDto form) {

		if(form.getId() == 0) {
			 simpleJdbcInsert.execute(new BeanPropertySqlParameterSource(form));
			var sql = """
					update address set name=?, street=?, building=?, township=?, division=? where id=?
					""";
			
			 jdbcTemplate.update(sql, form.getName(),form.getStreet(),form.getBuilding(),form.getTownship(),form.getDivision(),form.getId());
		}		
	}

	public AddressDto findById(Integer id) {
		var sql = "select * from address where id=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<AddressDto>(AddressDto.class), id);
	}
}
