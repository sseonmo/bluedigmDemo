package com.bluedigm.demo.api.admin.service.impl;

import com.bluedigm.demo.api.admin.dao.AdminMapper;
import com.bluedigm.demo.api.admin.model.Admin;
import com.bluedigm.demo.api.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Admin service.
 */
@Service
public class AdminServiceImpl implements AdminService {

	/**
	 * The Mapper.
	 */
	@Autowired
	public AdminMapper mapper;

	@Override
	public int selectAdminId(String adminId) {
		return mapper.selectAdminId(adminId);
	}

	@Override
	public Admin selectAdminOne(String adminId) {
		return mapper.selectAdminOne(adminId);
	}

	@Override
	public void insertAdmin(Admin param) {
		mapper.insertAdmin(param);
	}

	@Override
	public void insertAdminRule(Admin param) {
		mapper.insertAdminRule(param);
	}

	@Override
	public List<Admin> selectAdminList() {
		return mapper.selectAdminList();
	}

	@Override
	public String deleteAdmin(String AdminId) {
		return mapper.deleteAdmin(AdminId);
	}
}
