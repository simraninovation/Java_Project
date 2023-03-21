package com.transactionPage.TransactionPage.Controller;

import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transactionPage.TransactionPage.Service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;

@GetMapping("/{AccountNumber}")
public List<Transaction> getTransByAccountNumber(@PathVariable String AccountNumber)
{
	return transactionService.getTransByAccountNumber(AccountNumber);
}

@PostMapping
public void  saveTransaction(@RequestBody Transaction transaction)
{
	 transactionService.saveTransaction(transaction);
}

}
