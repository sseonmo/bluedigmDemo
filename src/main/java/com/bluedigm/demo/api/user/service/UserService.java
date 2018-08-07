package com.bluedigm.demo.api.user.service;

import java.util.List;

import com.bluedigm.demo.api.user.model.User;

public interface UserService {

	/*
	 * 아이디 중복체크
	 */
	public int selectUserId(String userId);

	/*
	 * 조회
	 */
	public User selectUserOne(String userId);
	
	/*
	 * 계정 저장
	 */
	public void insertUser(User userInfo);

	/*
	 * 권한 저장
	 */
	public void insertUserRule(User userInfo);
	
	/*
	 * 리스트
	 */
	public List<User> selectUserList();

	/*
	 * 삭제
	 */
	public String deleteUser(String userId);

}
