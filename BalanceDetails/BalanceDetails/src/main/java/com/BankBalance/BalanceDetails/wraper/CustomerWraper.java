package com.BankBalance.BalanceDetails.wraper;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CustomerWraper {
	private Integer userId;
	private String AccountNumber;
	public CustomerWraper() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int Balance;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}
	public CustomerWraper(Integer userId, String accountNumber, int balance) {
		super();
		this.userId = userId;
		AccountNumber = accountNumber;
		Balance = balance;
	}
	
	
	
}
