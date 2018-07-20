package com.whiz.quickloan.user.services;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whiz.quickloan.user.domain.QuickLoanUserDetails;
import com.whiz.quickloan.user.domain.User;
import com.whiz.quickloan.user.domain.UserRole;
import com.whiz.quickloan.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	
	/* Test users */
/*	@PostConstruct
	public void createNewUsers() {
		User user1 = new User();
		user1.setEmailId("whizit");
		user1.setPassword("whizit");
		
		user1.setRoles(Arrays.asList(new UserRole("CUSTOMER")));
		
		
		QuickLoanUserDetails quickLoanUserDetails1 = new QuickLoanUserDetails(user1);
		userRepository.save(user1);
		
		
		User user2 = new User();
		user2.setEmailId("gsit");
		user2.setPassword("gsit");
		
		user2.setRoles(Arrays.asList(new UserRole("USER")));
		
		
		QuickLoanUserDetails quickLoanUserDetails2 = new QuickLoanUserDetails(user2);
		userRepository.save(user2);
	}
*/
	
	public List<User> findAllUsers() {
		
		return (List<User>) userRepository.findAll();
	}
	
	public User findById(int id) {

		return userRepository.findById(id);
	}
	public void updateUser(User currentUser) {

		userRepository.save(currentUser);
	}
	public void deleteUserById(int id) {
		
		userRepository.deleteUserById(id);
		}
	public void saveUser(User user) {
		
		userRepository.save(user);
	}
	public boolean isUserExist(User user) {
	
		return userRepository.existsById(user.getId());
	}
	
}
