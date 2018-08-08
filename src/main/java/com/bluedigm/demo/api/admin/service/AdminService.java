package com.bluedigm.demo.api.admin.service;

import com.bluedigm.demo.api.admin.model.Admin;

import java.util.List;

/**
 * The interface Admin service.
 */
public interface AdminService {

	/**
	 * Select admin id int.
	 *
	 * @param AdminId the admin id
	 * @return the int
	 */
	public int selectAdminId(String AdminId);

	/**
	 * Select admin one admin.
	 *
	 * @param AdminId the admin id
	 * @return the admin
	 */
	public Admin selectAdminOne(String AdminId);

	/**
	 * Insert admin.
	 *
	 * @param param the param
	 */
	public void insertAdmin(Admin param);

	/**
	 * Insert admin rule.
	 *
	 * @param param the param
	 */
	public void insertAdminRule(Admin param);

	/**
	 * Select admin list list.
	 *
	 * @return the list
	 */
	public List<Admin> selectAdminList();

	/**
	 * Delete admin string.
	 *
	 * @param AdminId the admin id
	 * @return the string
	 */
	public String deleteAdmin(String AdminId);

}
