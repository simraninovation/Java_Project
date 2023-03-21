package com.Transcation.Transcation.Service;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Transcation.Transcation.repo.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepository;
	
	public void deposit(Transaction transaction, double amount)
	{
		transaction.setBalance(transaction.getBalance()+amount);
		Transaction transaction = new Transaction(transaction.getAccountNumber(),"Deposit",amount);
		transactionRepository.save(transaction);
	}
	public void withdraw(Transaction transaction, double amount)
	{
		if(transaction.getBalance()<amount)
		{
			throw new InsufficientBalanceException("Insufficient balance");
		}
		transaction.setBalance(transaction.getBalance()-amount);
		Transaction transaction = new Transaction(transaction.getAccountNumber(),"Withdraw",amount);
		transactionRepository.save(transaction);
	}
}
