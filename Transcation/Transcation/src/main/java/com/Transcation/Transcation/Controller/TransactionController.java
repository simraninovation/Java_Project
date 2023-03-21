package com.Transcation.Transcation.Controller;

import java.math.BigDecimal;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Transcation.Transcation.Service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
@Autowired
private TransactionService transactionService;

@PostMapping("/Deposit")
public ResponseEntity<Transaction> deposit(@RequestBody DepositRequest request);
{
	Transaction transaction = transactionService.deposit(request.getAccountnumber(), request.getAmount());
}
@PostMapping("/Withdraw")
public ResponseEntity<Transaction> withdraw(@RequestBody WithdrawRequest request);
{
	Transaction transaction = transactionService.deposit(request.getAccountnumber(), request.getAmount());
	return ResponseEntity.ok(transaction);
}

public static class DepositRequest{
	private Long accountNumber;
	private BigDecimal amount;
}
public static class WithrawRequest{
	private Long accountNumber;
	private BigDecimal amount;
}

}
