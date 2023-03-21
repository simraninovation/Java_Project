package com.BankBalance.BalanceDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.BankBalance.BalanceDetails.entities.CustomerBalance;

public interface CustomerBalanceRepo extends JpaRepository<CustomerBalance, Integer>{ 
	
	CustomerBalance  findByCustomerAccountNumber(@Param("AccountNumber") String AccountNumber);
     List<CustomerBalance> getAllCustomer();
     
}
