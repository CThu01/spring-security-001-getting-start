package com.jdc.demo.service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddressDto {

	private int id;
	private String email;
	
	@NotBlank(message = "Please Enter Name")
	private String name;

	@NotBlank(message = "Please Enter Building name")
	private String building;
	@NotBlank(message = "Please Enter Street name")
	private String street;
	@NotBlank(message = "Please Enter Township")
	private String township;
	@NotBlank(message = "Please Enter Division")
	private String division;
}
