package com.bluedigm.demo.api.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedigm.demo.api.manage.dao.ManageMapper;
import com.bluedigm.demo.api.manage.model.Manage;
import com.bluedigm.demo.api.manage.service.ManageService;

@Service
public class ManageServiceImpl implements ManageService{

	@Autowired
	private ManageMapper manageMapper;
	
	/**
	 * 리스트
	 */
	@Override
    public List<Manage> selectManageList() {
        return manageMapper.selectManageList();
    }
	
	/**
	 * 조회
	 */
	@Override
	public Manage selectManageOne(String param){
		return manageMapper.selectManageOne(param);
	}
	
	
	/**
    * 사용자 저장.     
    */
	@Override
	public void insertManage(Manage param) {
      
		if (param.getRuleId() == null || "".equals(param.getRuleId())) {
		  
			param.setCorId("admin");
			param.setMorId("admin");
		  
			manageMapper.insertManage(param);
		} else {
			param.setMorId("admin");
			manageMapper.updateManage(param);
		}
		
	}

	/**
	 * 삭제
	 * @return 
	 */
	@Override
	public String deleteManage(String param) {
		return manageMapper.deleteManage(param);
	}

}
