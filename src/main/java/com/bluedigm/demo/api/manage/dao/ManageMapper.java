package com.bluedigm.demo.api.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.bluedigm.demo.api.manage.model.Manage;

@Mapper
@Repository
public interface ManageMapper {

	/**
	 * 등록
	 */
	public void insertManage(Manage param);
	
	/**
	 * 수정
	 */
	public void updateManage(Manage param);
	
	/**
	 * 리스트
	 */
	public List<Manage> selectManageList();

	/**
	 * 삭제
	 */
	public String deleteManage(String param);

	/**
	 * 조회
	 */
	public Manage selectManageOne(String param);

	
}