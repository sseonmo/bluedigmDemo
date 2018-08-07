package com.bluedigm.demo.api.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedigm.demo.api.user.dao.UserMapper;
import com.bluedigm.demo.api.user.model.User;
import com.bluedigm.demo.api.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	public UserMapper userMapper;
    
	/**
	 * 리스트
	 */
	@Override
    public List<User> selectUserList() {
        return userMapper.selectUserList();
    }
	
	/**
	 * 조회
	 */
	@Override
	public User selectUserOne(String param){
		return userMapper.selectUserOne(param);
	}
	
	
	/**
	 * 아이디 중복체크
	 */
	@Override
    public int selectUserId(String param) {
        return userMapper.selectUserId(param);
    }
	
	
	 /**
     * 사용자 저장.     
     */
	@Override
    public void insertUser(User param) {
        
		if (param.getUserId() == null || "".equals(param.getUserId())) {
        	
			param.setCorId("admin");
			param.setMorId("admin");
			userMapper.insertUser(param);
        } else {
        	
        	param.setMorId("admin");
            userMapper.updateUser(param);
        }
    }
	
	  /**
     * 사용자 권한 저장.     
     */
	@Override
    public void insertUserRule(User param) {
        
		if (param.getUserId() == null || "".equals(param.getUserId())) {
        	
			param.setCorId("admin");
			param.setMorId("admin");
			userMapper.insertUserRule(param);
        } else {
        	
        	param.setMorId("admin");
            userMapper.updateUserRule(param);
        }
		
    }
	
	/**
	 * 삭제
	 * @return 
	 */
	@Override
	public String deleteUser(String param) {
		return userMapper.deleteUser(param);
	}

}
