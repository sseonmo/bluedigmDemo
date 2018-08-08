package com.bluedigm.demo.sample.service;

import com.bluedigm.demo.api.admin.model.Admin;
import com.bluedigm.demo.api.admin.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AdminServiceImplTest {

	@Autowired
	private AdminService service;

	@Test
	public void select() {
		String adminId = "mo0562";
		Admin admin = service.selectAdminOne(adminId);

		assertThat(admin.getAdminId(), is("mo0562"));

	}
}
