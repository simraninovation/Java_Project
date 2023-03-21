package com.saveAccountDetails.rest;

import java.util.List;
import java.util.Map;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saveAccountDetails.entities.Account;

@RequestMapping("/Account")
public interface AccountRest {
   ;
	 @PostMapping(path = "/addNewAccounter")
  public ResponseEntity<String> addDetails(@RequestBody(required = true)Map<String,String> requestMap);
	 
	 @GetMapping(path ="/getAccountDetails")
	 public ResponseEntity<List<Account>> getAllUser();
	 
	 @GetMapping(path = "/{AccountNumber}")
	 public ResponseEntity<Account> getSingleUser(@PathVariable String AccountNumber);
	
	 
}
