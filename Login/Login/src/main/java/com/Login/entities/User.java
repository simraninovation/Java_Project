package com.Login.entities;

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

@NamedQuery(name = "User.findByEmailId", query = "select u from User u where u.email=:email ")
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="user")
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="UserId", nullable = false, updatable =  false)
	private int userId;
	
	@Column(name="Email", nullable = false, unique = true, length = 45)
	private String email;
	
	@Column(name="Password", nullable = false, length = 64)
	private String password;
	
	@Column(name="FirstName",nullable = false,length=20)
	private String FirstName;
	
	@Column(name="LastName", nullable = false, length=20)
	private String LastName;
	
	@Column(name="PhoneNo")
	private String phoneNo;
	
    @Column(name="Status")
	private String Status;
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String email, String password, String firstName, String lastName, String phoneNo,
			String userName, String Status) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.phoneNo = phoneNo;
	
		this.Status = Status;
	}

	

	public String isStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

		public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

		public int getUserId() {
		return userId;
	}

	public void setUserId(int  userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	   public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", phoneNo=" + phoneNo + ", Status=" + Status + "]";
	}
	
	

		
		
		

	}


