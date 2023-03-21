package com.Login.impl;

import java.util.Map;
import java.util.Objects;
import org.slf4j.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.Login.JWT.CustomerUsersDetailsService;
import com.Login.JWT.JwtUtil;
import com.Login.Service.UserService;
import com.Login.constent.UserConstent;
import com.Login.entities.User;
import com.Login.repo.UserRepo;
import com.Login.utils.UserUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	private static final Logger log= LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserRepo userRepo;
	@Autowired
	UserUtils userUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	CustomerUsersDetailsService customerUsersDetailsService;
	@Autowired
	JwtUtil jwtUtil;
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
		user.setEmail(requestMap.get("email"));
		user.setPassword(requestMap.get("password"));
		user.setStatus("false");
		return user;
	}

	
	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap)
	{
		System.out.println("IN the api");
		log.info("Inside login");
		try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestMap.get("email"), requestMap.get("password")));
            if (auth.isAuthenticated()) {
                    return new ResponseEntity<String>(
                            "{\"token\":\"" + jwtUtil.generateToken(
                                    customerUsersDetailsService.getUserDetails().getEmail(), null) + "\"}",
                            HttpStatus.OK);

            }
            else
                return new ResponseEntity<String>("{\"message\":\"" + "You are not authorized." + "\"}", HttpStatus.BAD_REQUEST);

                
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<String>("{\"message\":\"" + "Something Went Wrong" + "\"}", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

	
	
	
	
