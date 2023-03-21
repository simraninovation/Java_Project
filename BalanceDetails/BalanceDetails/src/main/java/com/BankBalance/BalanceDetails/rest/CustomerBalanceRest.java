package com.BankBalance.BalanceDetails.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BankBalance.BalanceDetails.entities.CustomerBalance;


@RequestMapping("/CustomerBalanceDetails")
public interface CustomerBalanceRest {

	 @PostMapping(path = "/addCustomerBalance")
	  public ResponseEntity<String> addBalanceDetails(@RequestBody(required = true)Map<String,String> requestMap);
		 
		 @GetMapping(path ="/getCustomerDetails")
		 public ResponseEntity<List<CustomerBalance>> getAllCustomer();
		 
		 @GetMapping(path = "/{AccountNumber}")
		 public ResponseEntity<CustomerBalance> getSingleCustomer(@PathVariable String AccountNumber);

	
}


	
	 
