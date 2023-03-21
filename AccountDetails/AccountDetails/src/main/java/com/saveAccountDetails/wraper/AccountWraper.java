package com.saveAccountDetails.wraper;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AccountWraper {
	private Integer userId;
	private String AccountNumber;
	private String Branch;
	private String Name;
	private String IFSC;
	private String createdDate;
	public AccountWraper() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public AccountWraper(Integer userId, String accountNumber, String branch, String name, String iFSC,
			String createdDate) {
		super();
		this.userId = userId;
		AccountNumber = accountNumber;
		Branch = branch;
		Name = name;
		IFSC = iFSC;
		this.createdDate = createdDate;
	}
  
	
	
	
}
