package com.bluedigm.demo.common.security;

import com.bluedigm.demo.api.admin.model.Admin;
import com.bluedigm.demo.api.admin.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

	@Autowired
	private AdminService adminService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Admin admin = adminService.selectAdminOne(userName);
		if(admin == null) throw new UsernameNotFoundException(userName);



		return null;
	}
}
