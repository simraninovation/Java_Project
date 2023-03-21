package com.BankManagement.Signup.impl;


import java.util.Map;
import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.BankManagement.Signup.constents.UserConstent;
import com.BankManagement.Signup.entities.User;

import com.BankManagement.Signup.repository.UserRepo;
import com.BankManagement.Signup.service.UserService;
import com.BankManagement.Signup.utils.UserUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	@Autowired
	UserUtils userUtils;
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		
		try {
		if(validateSignupMap(requestMap))
		{
			User user = userRepo.findByEmailId(requestMap.get("email"));
			System.out.println(requestMap.get("email"));
			if(Objects.isNull(user))	
			{
				userRepo.save(getUserFromMap(requestMap));
				return userUtils.getResponseEntity("Succefully Registered.", HttpStatus.OK );
			}
			else
			{
				return userUtils.getResponseEntity("Email already exit.",HttpStatus.BAD_REQUEST);
			}
		}
		else
		{
			return userUtils.getResponseEntity(UserConstent.INVALID_DATA, HttpStatus.BAD_REQUEST);
		}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return userUtils.getResponseEntity(UserConstent.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
		
	

	}

	

	private boolean validateSignupMap(Map<String, String> requestMap)
	{
		if(requestMap.containsKey("FirstName")&&requestMap.containsKey("LastName") &&requestMap.containsKey("PhoneNo") &&requestMap.containsKey("Email")&&requestMap.containsKey("Password")) {
			return true;
		}
		return false;
	
	}
	private User getUserFromMap(Map<String,String> requestMap)
	{
		User user = new User();
		user.setFirstName(requestMap.get("FirstName"));
		user.setLastName(requestMap.get("LastName"));
		user.setPhoneNo(requestMap.get("Phone No"));
		user.setEmail(requestMap.get("Email"));
		user.setPassword(requestMap.get("Password"));
		user.setStatus("false");
		return user;
	}

	

}
