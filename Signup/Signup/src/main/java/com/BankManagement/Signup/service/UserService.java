package com.BankManagement.Signup.service;


import java.util.Map;

import org.springframework.http.ResponseEntity;



public interface UserService {
	ResponseEntity<String> signUp(Map<String , String> requestMap);
  
  
   //get all user
  
 

  
  
}
