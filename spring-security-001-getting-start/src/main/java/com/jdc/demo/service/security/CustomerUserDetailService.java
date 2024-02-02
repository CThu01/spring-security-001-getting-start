package com.jdc.demo.service.security;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jdc.demo.service.CustomerService;
import com.jdc.demo.service.dto.CustomerDto;

@Service
public class CustomerUserDetailService implements UserDetailsService{

	@Autowired
	private CustomerService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<CustomerDto> result = service.findByEmail(username);
		
		return result.map(customer -> User.withUsername(username)
				.authorities("Customer")
				.password(customer.getPassword())
				.disabled(!customer.isActivated())
				.accountLocked(customer.isLocked())
				.accountExpired(isExpired(customer))
				.credentialsExpired(isCredential(customer))
				.build())
				.orElseThrow(() -> new UsernameNotFoundException(username));
	}
	
	private Boolean isCredential(CustomerDto customer) {
		
		if(null != customer.getValidpass()) {
			var validDate = customer.getValidpass().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if(validDate.isBefore(LocalDate.now())) {
				return true;
			}
		}
		return false;
	}
	
	private Boolean isExpired(CustomerDto customer) {
		
		if(null != customer.getRetired()) {
			var validDate = customer.getRetired().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if(validDate.isBefore(LocalDate.now())) {
				return true;
			}
		}
		return false;
	}

}
