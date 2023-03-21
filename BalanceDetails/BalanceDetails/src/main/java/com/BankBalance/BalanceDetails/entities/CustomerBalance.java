package com.BankBalance.BalanceDetails.entities;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NamedQuery(name = "CustomerBalance.findByCustomerAccountNumber", query = "select u from CustomerBalance u where u.AccountNumber=:AccountNumber")
@NamedQuery(name = "CustomerBalance.getSingleCustomer", query = " select u from CustomerBalance u where u.AccountNumber = :AccountNumber")
@NamedQuery(name = "CustomerBalance.getAllCustomer",query = "select new com.BankBalance.BalanceDetails.wraper.CustomerWraper( u.userId, u.AccountNumber, u.Balance) from CustomerBalance u where u.AccountNumber=:AccountNumber")
@Getter

@Setter
@Data
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Entity
@Table(name = "BalanceTable")

public class CustomerBalance implements Serializable {
	
	
	
	private static final long serialVersion = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="UserId")
	private Integer userId;
	
	@Id
	@Column(name="AccountNumber")
	private String AccountNumber;
	
	@Column(name="Balance")
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

	public static long getSerialversion() {
		return serialVersion;
	}

	public CustomerBalance(Integer userId, String accountNumber, int balance) {
		super();
		this.userId = userId;
		AccountNumber = accountNumber;
		Balance = balance;
	}

	public CustomerBalance() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerBalance [userId=" + userId + ", AccountNumber=" + AccountNumber + ", Balance=" + Balance + "]";
	}
	
	

	

	
}
