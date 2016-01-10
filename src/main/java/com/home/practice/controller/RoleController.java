package com.home.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.practice.domain.Role;

@Controller
public class RoleController {
	
	@RequestMapping(value="/addRole",method=RequestMethod.GET)
	public String getRole(@ModelAttribute("addRole")Role role)
	{
		return "helloworld";
	}

}
