package com.BankBalance.BalanceDetails.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.BankBalance.BalanceDetails.entities.CustomerBalance;
;

public interface CustomerBalanceService {
	
	ResponseEntity<String> addBalanceDetails(Map<String,String> requestMap);
	
	ResponseEntity<List<CustomerBalance>> getAllCustomer();

	ResponseEntity<CustomerBalance> getSingleCustomer(String AccountNumber);
	
	

}
