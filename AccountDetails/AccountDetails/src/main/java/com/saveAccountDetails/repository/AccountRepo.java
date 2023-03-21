package com.saveAccountDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import com.saveAccountDetails.entities.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>{
	//
	Account findByAccountNumber(@Param("AccountNumber") String AccountNumber);

	List<Account> getAllUser();
}
