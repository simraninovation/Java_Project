package com.Login.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.Login.entities.User;



public interface UserRepo extends JpaRepository<User,Integer>{
	User findByEmailId(@Param("email") String email);

}
