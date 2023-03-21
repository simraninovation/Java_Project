package com.saveAccountDetails.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.saveAccountDetails.entities.Account;

public interface AccountService {
	ResponseEntity<String> addDetails(Map<String,String> requestMap);
	
	ResponseEntity<List<Account>> getAllUser();

	ResponseEntity<Account> getSingleUser(String AccountNumber);


}
