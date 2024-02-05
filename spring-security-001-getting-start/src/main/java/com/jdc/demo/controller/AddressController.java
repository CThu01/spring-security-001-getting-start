package com.jdc.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.demo.service.AddressService;
import com.jdc.demo.service.dto.AddressDto;

@Controller
@RequestMapping("/customer/address/edit")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping
	public String edit() {
		
		return "addressEdit";
	}
	
	@PostMapping
	public String save(@ModelAttribute(name = "form") @Validated AddressDto form,BindingResult result) {
		
		if(result.hasErrors()) {
			return "addressEdit";
		}
		addressService.save(form);
		
		return "redirect:/customer";
	}
	
	@ModelAttribute("form")
	AddressDto data(@RequestParam("id") Optional<Integer> id) {
		
		if(id.isPresent())	{
			return addressService.findById(id.get());
		}
		
		var address = new AddressDto();
		address.setEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		return address;
	}
}
