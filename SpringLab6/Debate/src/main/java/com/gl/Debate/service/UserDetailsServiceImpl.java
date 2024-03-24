package com.gl.Debate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gl.Debate.model.User;
import com.gl.Debate.repository.UserRepository;
import com.gl.Debate.security.MyUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userrepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userrepo.getUserByUsername(username);
        
        if (user == null) {
        	System.out.println("USERNAME " + username);
            throw new UsernameNotFoundException("Could not find user");
        }
        return new MyUserDetails(user);

	}
	

}
