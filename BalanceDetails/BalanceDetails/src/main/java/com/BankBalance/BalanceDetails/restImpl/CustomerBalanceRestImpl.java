package com.BankBalance.BalanceDetails.restImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.BankBalance.BalanceDetails.constent.CustomerConstent;
import com.BankBalance.BalanceDetails.entities.CustomerBalance;
import com.BankBalance.BalanceDetails.rest.CustomerBalanceRest;
import com.BankBalance.BalanceDetails.service.CustomerBalanceService;
import com.BankBalance.BalanceDetails.utils.CustomerBalanceUtils;


@RestController
public class CustomerBalanceRestImpl implements CustomerBalanceRest {
	
	   @Autowired
		CustomerBalanceService customerBalanceService;
	   
	   @Autowired
	   CustomerBalanceUtils customerBalanceUtils;
	 
	   
	 
	   
	   
		@Override
		public ResponseEntity<String> addBalanceDetails(Map<String, String> requestMap) {
			// TODO Auto-generated method stub
			
			try
			{
				return customerBalanceService.addBalanceDetails(requestMap);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return customerBalanceUtils.getResponseEntity(CustomerConstent.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		@Override
		public  ResponseEntity<List<CustomerBalance>> getAllCustomer()
		{
			return customerBalanceService.getAllCustomer();
		}
		
	
		@Override
		public ResponseEntity<CustomerBalance> getSingleCustomer(String AccountNumber) {
			// TODO Auto-generated method stub
			return customerBalanceService.getSingleCustomer(AccountNumber);
		}
		
		
		
		

	


}
