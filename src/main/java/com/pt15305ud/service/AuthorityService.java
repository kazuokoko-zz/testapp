package com.pt15305ud.service;

import java.util.List;

import com.pt15305ud.entity.Authority;

public interface AuthorityService {

	List<Authority> findAuthoritiesOfAdmins();

	List<Authority> findAll();

	Authority create(Authority authority);

	void delete(Integer id);

}
