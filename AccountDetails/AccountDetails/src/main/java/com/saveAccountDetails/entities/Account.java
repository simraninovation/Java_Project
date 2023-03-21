package com.saveAccountDetails.entities;



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
@NamedQuery(name = "Account.findByAccountNumber", query = "select u from Account u where u.AccountNumber=:AccountNumber")
@NamedQuery(name = "Account.getAllUser",query = "select new com.saveAccountDetails.wraper.AccountWraper( u.userId, u.AccountNumber, u.Branch, u.Name, u.IFSC,u.createdDate) from Account u where u.AccountNumber=:AccountNumber")
@Data
@NamedQuery(name = "Account.getSingleUser", query = " select u from Account u where u.AccountNumber = :AccountNumber")

@Getter
@Setter

@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Entity
@Table(name = "Account")
public class Account implements Serializable {
	private static final long serialVersion = 1L;
	

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="UserId", nullable = false, updatable =  false)
	private Integer userId;
	
	@Id
	@Column(name="AccountNumber",nullable = false, length=12)
	private String AccountNumber;
	
	@Column(name="Branch", nullable = false)
	private String Branch;
	
	@Column(name="IFSC", nullable = false,length=11)
	private String IFSC;
	@Column(name="Name", nullable = false)
	private String Name;
	
	//@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="createdDate", nullable = false)
	private String createdDate;
	

	
	
	


	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Account [userId=" + userId + ", AccountNumber=" + AccountNumber + ", Branch=" + Branch + ", IFSC="
				+ IFSC + ", Name=" + Name + ", createdDate=" + createdDate + "]";
	}

	



	

	
	

}
