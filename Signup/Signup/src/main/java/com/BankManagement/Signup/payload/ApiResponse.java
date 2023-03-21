package com.BankManagement.Signup.payload;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
  private String message;
  private boolean succes;
  private HttpStatus status;
public static Object builder() {
	// TODO Auto-generated method stub
	return null;
}
  
}
