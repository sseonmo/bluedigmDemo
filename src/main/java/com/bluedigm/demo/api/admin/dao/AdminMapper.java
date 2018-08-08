package com.bluedigm.demo.api.admin.dao;

import com.bluedigm.demo.api.admin.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {

	//아이디 중복체크
	public int selectAdminId(String adminId);

	//사용자 읽기
	public Admin selectAdminOne(String adminId);
	
	//사용자 리스트
	public List<Admin> selectAdminList();

	//사용자 저장
	public void insertAdmin(Admin param);

	//사용자 권한 저장
	public void insertAdminRule(Admin param);
	
	//사용자 수정
	public void updateAdmin(Admin param);
	
	//사용자 권한 수정
	public void updateAdminRule(Admin param);
	
	//사용자 삭제
	public String deleteAdmin(String param);

}