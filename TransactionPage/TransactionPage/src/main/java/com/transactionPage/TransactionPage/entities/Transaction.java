package com.transactionPage.TransactionPage.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="Transaction")
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TranscationId", nullable = false, updatable =  false)
	private int TranscationId;
	
	private String AccountNumber;
	private Date date;
	private String description;
	private Double amount;
	public int getTranscationId() {
		return TranscationId;
	}
	public void setTranscationId(int transcationId) {
		TranscationId = transcationId;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Transaction(int transcationId, String accountNumber, Date date, String description, Double amount) {
		super();
		TranscationId = transcationId;
		AccountNumber = accountNumber;
		this.date = date;
		this.description = description;
		this.amount = amount;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Transaction [TranscationId=" + TranscationId + ", AccountNumber=" + AccountNumber + ", date=" + date
				+ ", description=" + description + ", amount=" + amount + "]";
	}
	
	
}
