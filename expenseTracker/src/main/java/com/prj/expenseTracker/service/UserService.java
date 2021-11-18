package com.prj.expenseTracker.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.prj.expenseTracker.dto.UserRegistrationDto;
import com.prj.expenseTracker.model.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
