package com.Login.restImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.Login.Service.UserService;
import com.Login.constent.UserConstent;
import com.Login.rest.UserRest;
import com.Login.utils.UserUtils;



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
	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap)
	{
		try
		{
			return userService.login(requestMap);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 return userUtils.getResponseEntity(UserConstent.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
