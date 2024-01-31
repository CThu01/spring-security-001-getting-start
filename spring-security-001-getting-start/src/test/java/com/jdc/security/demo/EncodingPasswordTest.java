package com.jdc.security.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodingPasswordTest {

	public static void main(String[] args) {

		var passwordEncoder = new BCryptPasswordEncoder();
		
		System.out.println(passwordEncoder.encode("admin"));
		System.out.println(passwordEncoder.encode("admin"));
		System.out.println(passwordEncoder.encode("admin"));
		System.out.println(passwordEncoder.encode("member"));
		
		System.out.println(passwordEncoder.matches("admin", "$2a$10$tY5XDXpfmdeUXnwp1hMqoeonz0bXfBh1MX3CLtCVfPrul2j00yTK6"));
	}

}
