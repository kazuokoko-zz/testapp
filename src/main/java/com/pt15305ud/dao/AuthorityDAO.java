package com.pt15305ud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pt15305ud.entity.Account;
import com.pt15305ud.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {

	@Query("SELECT DISTINCT au FROM Authority au WHERE au.account in ?1")
	List<Authority> authoritiesOf(List<Account> accounts);

}
