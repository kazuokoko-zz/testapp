package com.pt15305ud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pt15305ud.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String> {

	@Query("Select distinct au.account from Authority au where au.role.id in ('DIRE','STAF')")
	List<Account> getAdmins();

}
