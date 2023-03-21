package com.transactionPage.TransactionPage.Service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transactionPage.TransactionPage.repo.TransactionRepo;

@Service
public class TransactionService {
@Autowired
private TransactionRepo transactionRepo;

public List<Transaction> getTransByAccountNumber(String AccountNumber)
{
	return transactionRepo.findByTransAccountNumber(AccountNumber);
}

public void saveTransaction(Transaction transaction)
{
	
	transactionRepo.save(transaction);
}
}
