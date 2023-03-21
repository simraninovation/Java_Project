package com.BankBalance.BalanceDetails.utils;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerBalanceUtils {
	
	private CustomerBalanceUtils()
	{
		
	}

public ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus)
{
  return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}", httpStatus);
}
}
