package com.bluedigm.demo.common.security;

import com.bluedigm.demo.api.admin.model.Admin;
import com.bluedigm.demo.api.admin.model.AdminRule;
import com.bluedigm.demo.api.admin.service.AdminService;
import com.bluedigm.demo.api.menu.model.Menu;
import com.bluedigm.demo.api.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

	@Autowired
	private AdminService adminService;

	@Autowired
	private MenuService menuService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<Admin> admin = Optional.ofNullable(adminService.selectAdminOne(userName));
		admin.orElseThrow( () -> new UsernameNotFoundException(userName));

		List<Integer> ruleIds = admin.map(Admin::getAdminRule).get().stream().map(AdminRule::getRuleId).collect(toList());

		List<Menu> menus = null;

		if(ruleIds.size() > 0)	menus = menuService.selectMenuListByRuleId(ruleIds);

		return new CustomUser(admin.get(), menus);
	}
}
