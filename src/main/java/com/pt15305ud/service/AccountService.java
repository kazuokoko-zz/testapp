package com.pt15305ud.service;

import java.util.List;

import com.pt15305ud.entity.Account;

public interface AccountService {

	Account findById(String username);

	List<Account> getAdmins();

	List<Account> findAll();
}
