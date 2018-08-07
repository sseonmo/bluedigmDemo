package com.bluedigm.demo.api.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.bluedigm.demo.api.user.model.User;

@Mapper
@Repository
public interface UserMapper {

	//아이디 중복체크
	public int selectUserId(String param);

	//사용자 읽기
	public User selectUserOne(String param);
	
	//사용자 리스트
	public List<User> selectUserList();

	//사용자 저장
	public void insertUser(User param);

	//사용자 권한 저장
	public void insertUserRule(User param);
	
	//사용자 수정
	public void updateUser(User param);
	
	//사용자 권한 수정
	public void updateUserRule(User param);
	
	//사용자 삭제
	public String deleteUser(String param);


	
}