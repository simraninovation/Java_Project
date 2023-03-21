package com.BankBalance.BalanceDetails.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.BankBalance.BalanceDetails.constent.CustomerConstent;
import com.BankBalance.BalanceDetails.entities.CustomerBalance;
import com.BankBalance.BalanceDetails.repository.CustomerBalanceRepo;
import com.BankBalance.BalanceDetails.service.CustomerBalanceService;
import com.BankBalance.BalanceDetails.utils.CustomerBalanceUtils;




@Service
public class CustomerBalanceServiceImpl implements CustomerBalanceService {
	
	@Autowired
	CustomerBalanceRepo customerBalanceRepo;
	@Autowired
	CustomerBalanceUtils customerBalanceUtils;

	
	@Override
	public ResponseEntity<String> addBalanceDetails(Map<String, String> requestMap){
	try
	{
		if(validateAddCustomerBalance(requestMap))
		{
			
			CustomerBalance customerBalance = customerBalanceRepo.findByCustomerAccountNumber(requestMap.get("AccountNumber"));
		
			if(Objects.isNull(customerBalance))
			{
				
				customerBalanceRepo.save(getAccountFromMap(requestMap));
			
			return customerBalanceUtils.getResponseEntity( "Balance Added Succesfully", HttpStatus.OK);
		   }
		else
		{
			return customerBalanceUtils.getResponseEntity( "", HttpStatus.BAD_REQUEST);
		}
		}
		else
		{
			return customerBalanceUtils.getResponseEntity(CustomerConstent.INVALID_DATA, HttpStatus.BAD_REQUEST);
		}
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return customerBalanceUtils.getResponseEntity(CustomerConstent.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
}
private boolean validateAddCustomerBalance(Map<String,String> requestMap)
{
	if(requestMap.containsKey("AccountNumber")&& requestMap.containsKey("Balance"))
	{
		return true;
	}
	return false;
}
private CustomerBalance getAccountFromMap(Map<String,String> requestMap)

{
	CustomerBalance customerBalance = new CustomerBalance();
	
	
	
	customerBalance.setAccountNumber(requestMap.get("AccountNumber"));
	customerBalance.setBalance(Integer.parseInt(requestMap.get("Balance")));
	
	return customerBalance;
}
@Override
public ResponseEntity<List<CustomerBalance>> getAllCustomer() {
	// TODO Auto-generated method stub
	try {
		
		List<CustomerBalance>list = customerBalanceRepo.findAll();
		return new ResponseEntity<List<CustomerBalance>>(list, HttpStatus.OK);
	}catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
}


@Override
public ResponseEntity<CustomerBalance> getSingleCustomer(String AccountNumber)
{
	CustomerBalance customerBalance = customerBalanceRepo.findByCustomerAccountNumber(AccountNumber);
try {
		
		return new ResponseEntity<CustomerBalance >(customerBalance , HttpStatus.OK);
	}catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return new ResponseEntity<CustomerBalance >(customerBalance ,HttpStatus.INTERNAL_SERVER_ERROR);

}

}




