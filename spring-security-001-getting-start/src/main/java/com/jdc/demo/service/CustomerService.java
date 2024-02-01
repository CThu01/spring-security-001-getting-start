package com.jdc.demo.service;

import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jdc.demo.service.dto.CustomerDto;

@Service
public class CustomerService {
	
	private JdbcTemplate jdbcTemplate;
	
	public CustomerService(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Optional<CustomerDto> findByEmail(String email) {
		
	 	var customer =  jdbcTemplate.queryForObject(
	 												"select * from CUSTOMER where email=?", 
	 												new BeanPropertyRowMapper<>(CustomerDto.class), 
	 												email);
		return Optional.ofNullable(customer);
	}

}
