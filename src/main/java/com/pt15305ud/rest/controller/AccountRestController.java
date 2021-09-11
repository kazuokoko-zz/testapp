package com.pt15305ud.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pt15305ud.entity.Account;
import com.pt15305ud.service.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	
	@Autowired
	AccountService _aSer;
	
	@GetMapping
	public List<Account> getAccounts(@RequestParam("admin") Optional<Boolean> admin){
		if(admin.orElse(false)) {
			return _aSer.getAdmins();
		}
		return _aSer.findAll();
		
	}

}
