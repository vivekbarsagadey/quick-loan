package com.whiz.quickloan.user.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.whiz.quickloan.user.domain.QuickLoanUserDetails;
import com.whiz.quickloan.user.domain.User;
import com.whiz.quickloan.user.repository.UserRepository;

 @Service
public class QuickLoanUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private QuickLoanUserDetailsService crmUserDetailsService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        User user = userRepository.findByEmailId(emailId);
        if(user == null){
            throw new UsernameNotFoundException("UserName "+emailId+" not found");
        }
        return new QuickLoanUserDetails(user);
    }	
   
 
}