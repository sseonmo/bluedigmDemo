package com.bluedigm.demo.sample.service;

import com.bluedigm.demo.api.admin.model.Admin;
import com.bluedigm.demo.api.admin.model.AdminRule;
import com.bluedigm.demo.api.admin.service.AdminService;
import com.bluedigm.demo.api.menu.model.Menu;
import com.bluedigm.demo.api.menu.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AdminServiceImplTest {

	@Autowired
	private AdminService service;

	@Autowired
	private MenuService menuService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Test
	public void select() {
		String adminId = "mo0562";
		Admin admin = service.selectAdminOne(adminId);

		List<AdminRule> list = Optional.ofNullable(admin).map(Admin::getAdminRule).orElse(null);
		List<Menu> menus = menuService.selectMenuListByRuleId(list.stream().map(AdminRule::getRuleId).collect(toList()));

		assertThat(admin.getAdminId(), is("mo0562"));

	}

	@Test
	public void passwordEnCrypt(){

		String password = passwordEncoder.encode("password");
		String password1 = passwordEncoder.encode("password");

		System.out.println("@@@@@@@@@@@@@");
		System.out.println(password);
		System.out.println(password1);
		System.out.println("@@@@@@@@@@@@@");
		assertThat(password, is(password1));
	}

}
