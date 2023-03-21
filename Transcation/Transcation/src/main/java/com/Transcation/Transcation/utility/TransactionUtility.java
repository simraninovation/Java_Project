package com.Transcation.Transcation.utility;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Transcation.Transcation.repo.TransactionRepository;

@Component
public class TransactionUtility {
	@Autowired
	private TransactionRepository transactionRepository;
	 
	public void recordDepositTransaction(String AccountNumber,BigDecimal amount)
	{
		Transaction transation= new Transaction(TransId,AccountNumber,amount,"Deposit");
		transactionRepository.save(transaction);
	}
	
	public void recordWithdrawalTransaction(String AccountNumber,BigDecimal amount)
	{
		Transaction transation= new Transaction(TransId,AccountNumber,amount,"Withdrawal");
		transactionRepository.save(transaction);
	}
	
	public List<Transaction> getTransactionByAccountNumber(String AccountNumber)
	{
		return transactionRepsoitory.findByAccountNumber(AccountNumber);
	}

}
