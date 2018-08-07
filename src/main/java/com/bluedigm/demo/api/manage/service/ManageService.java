package com.bluedigm.demo.api.manage.service;

import java.util.List;

import com.bluedigm.demo.api.manage.model.Manage;

public interface ManageService {

	/**
	 * 등록/수정
	 */
	public void insertManage(Manage manageInfo);

	/**
	 * 리스트
	 */
	public List<Manage> selectManageList();

	/**
	 * 삭제
	 */
	public String deleteManage(String ruleId);

	/**
	 * 조회
	 */
	public Manage selectManageOne(String ruleId);



	
}
