package com.pt15305ud.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pt15305ud.entity.Role;
import com.pt15305ud.service.RoleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RoleRestController {

	@Autowired
	RoleService _rSer;
	
	@GetMapping
	public List<Role> getAll(){
		return _rSer.findAll();
	}
	
}
