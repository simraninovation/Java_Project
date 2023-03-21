package com.saveAccountDetails.serviceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.saveAccountDetails.constent.AccountConstent;
import com.saveAccountDetails.entities.Account;
import com.saveAccountDetails.repository.AccountRepo;
import com.saveAccountDetails.service.AccountService;
import com.saveAccountDetails.utils.AccountUtils;


import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepo aaccountRepo;
	@Autowired
	AccountUtils aaccountUtils;
	

	@Override
	public ResponseEntity<String> addDetails(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try
		{
			if(validateAddnewAccounter(requestMap))
			{
				
				Account account = aaccountRepo.findByAccountNumber(requestMap.get("AccountNumber"));
				System.out.println(requestMap.get("AccountNumber"));
				if(Objects.isNull(account))
				{
					aaccountRepo.save(getAccountFromMap(requestMap));
				
				return aaccountUtils.getResponseEntity( "Account Added Succesfully", HttpStatus.OK);
			   }
			else
			{
				return aaccountUtils.getResponseEntity( "Account already exit", HttpStatus.BAD_REQUEST);
			}
			}
			else
			{
				return aaccountUtils.getResponseEntity(AccountConstent.INVALID_DATA, HttpStatus.BAD_REQUEST);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return aaccountUtils.getResponseEntity(AccountConstent.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	private boolean validateAddnewAccounter(Map<String,String> requestMap)
	{
		if(requestMap.containsKey("AccountNumber")&& requestMap.containsKey("Name")&&requestMap.containsKey("Branch")&& requestMap.containsKey("IFSC")&& requestMap.containsKey("createdDate"))
		{
			return true;
		}
		return false;
	}
	private Account getAccountFromMap(Map<String,String> requestMap)
	
	{
		
		Account account=new Account();
		
		account.setAccountNumber(requestMap.get("AccountNumber"));
		account.setBranch(requestMap.get("Branch"));
		account.setIFSC(requestMap.get("IFSC"));
		account.setName(requestMap.get("Name"));
		account.setCreatedDate(requestMap.get("createdDate"));
		return account;
	}
	@Override
	public ResponseEntity<List<Account>> getAllUser() {
		// TODO Auto-generated method stub
		try {
			
			List<Account>list = aaccountRepo.findAll();
			return new ResponseEntity<List<Account>>(list, HttpStatus.OK);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@Override
	public ResponseEntity<Account> getSingleUser(String AccountNumber)
	{
		Account account= aaccountRepo.findByAccountNumber(AccountNumber);
	try {
			
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ResponseEntity<Account>(account,HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
}
	

	
