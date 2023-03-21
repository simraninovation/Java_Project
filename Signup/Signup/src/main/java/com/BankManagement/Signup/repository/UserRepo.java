package com.BankManagement.Signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.BankManagement.Signup.entities.User;


public interface UserRepo extends JpaRepository<User,Integer> {

	User findByEmailId(@Param("email") String email);
}
