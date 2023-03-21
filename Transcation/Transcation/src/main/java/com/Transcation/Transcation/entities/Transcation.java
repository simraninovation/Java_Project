package com.Transcation.Transcation.entities;

import java.math.BigDecimal;
import java.security.Timestamp;

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
public class Transcation {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TransId", nullable = false, updatable =  false)
	private int TransId;
	
	private String fromAccountNumber;
	private String toAccountNumber;
	private BigDecimal Amount;

	
}
