package com.bluedigm.demo.common.security;

import com.bluedigm.demo.api.admin.model.Admin;
import com.bluedigm.demo.api.menu.model.Menu;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

public class CustomUser extends User {

	private static final long serialVersionUID = 2881749479553418040L;

	private List<Menu> menus;

//	private static final String ROLE_PREFIX = "ROLE_";

	public CustomUser(Admin admin, List<Menu> menus) {
		super(admin.getAdminId(), admin.getAdminPassword(), makeGrantedAuthority());
		this.menus = menus;
	}

	private static List<GrantedAuthority> makeGrantedAuthority() {
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority("ADMIN"));
		return list;
	}

//		private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles){
//		List<GrantedAuthority> list = new ArrayList<>();
//		roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));
//		return list;
//	}
}
