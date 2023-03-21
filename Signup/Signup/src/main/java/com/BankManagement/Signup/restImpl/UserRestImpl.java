package com.BankManagement.Signup.restImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.BankManagement.Signup.constents.UserConstent;
import com.BankManagement.Signup.rest.UserRest;
import com.BankManagement.Signup.service.UserService;
import com.BankManagement.Signup.utils.UserUtils;

@RestController
public class UserRestImpl implements UserRest{
     
	@Autowired
	UserService userService;
	@Autowired
	UserUtils userUtils;
	@Override
	public ResponseEntity<String> signup(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		try {
			return userService.signUp(requestMap);
		}
		catch(Exception ex){
			ex.printStackTrace();
			
		}
		return userUtils.getResponseEntity(UserConstent.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
