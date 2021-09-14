package com.pt15305ud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt15305ud.dao.AccountDAO;
import com.pt15305ud.dao.AuthorityDAO;
import com.pt15305ud.entity.Account;
import com.pt15305ud.entity.Authority;
import com.pt15305ud.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	AuthorityDAO _auDAO;

	@Autowired
	AccountDAO _aDAO;

	@Override
	public List<Authority> findAuthoritiesOfAdmins() {
		List<Account> accounts = _aDAO.getAdmins();
		return _auDAO.authoritiesOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		return _auDAO.findAll();
	}

	@Override
	public Authority create(Authority authority) {
		return _auDAO.save(authority);
	}

	@Override
	public void delete(Integer id) {
		_auDAO.deleteById(id);
	}

}
