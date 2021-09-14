package com.pt15305ud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pt15305ud.dao.RoleDAO;
import com.pt15305ud.entity.Role;
import com.pt15305ud.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDAO _rDAO;
	
	@Override
	public List<Role> findAll() {
		return _rDAO.findAll();
	}

}
