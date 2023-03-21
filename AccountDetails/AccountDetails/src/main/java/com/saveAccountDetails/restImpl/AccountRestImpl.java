package com.saveAccountDetails.restImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;


import com.saveAccountDetails.constent.AccountConstent;
import com.saveAccountDetails.entities.Account;
import com.saveAccountDetails.rest.AccountRest;
import com.saveAccountDetails.service.AccountService;
import com.saveAccountDetails.utils.AccountUtils;

@RestController
public class AccountRestImpl implements AccountRest {
   @Autowired
	AccountService accountService;
   
   @Autowired
   AccountUtils accountUtils;
 
   
 
   
   
	@Override
	public ResponseEntity<String> addDetails(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		System.out.println("Simran Sethi");
		try
		{
			return accountService.addDetails(requestMap);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return accountUtils.getResponseEntity(AccountConstent.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	public  ResponseEntity<List<Account>> getAllUser()
	{
		return accountService.getAllUser();
	}
	
	public ResponseEntity<Account> getSingleUser( String AccountNumber)
{
		return accountService.getSingleUser(AccountNumber);
	}
	
	
	
	

}
