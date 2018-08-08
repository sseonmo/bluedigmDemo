package com.bluedigm.demo.api.admin.model;

import java.util.List;

public class Admin {

	private String adminId;			//관리자 아이디
	private String adminName;		//관리자 이름
	private String adminPassword;	//관리자 패스워드
	private String adminEmail;		//관리자 이메일
	private String adminPhone;		//관리자 전화번호
	private String deleteYn;		//삭제여부
	private String corId;			//생성자
	private String corDt;			//생성일자
	private String morId;			//수정자
	private String morDt;			//수정일자

	private List<AdminRule> adminRule;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public String getCorId() {
		return corId;
	}

	public void setCorId(String corId) {
		this.corId = corId;
	}

	public String getCorDt() {
		return corDt;
	}

	public void setCorDt(String corDt) {
		this.corDt = corDt;
	}

	public String getMorId() {
		return morId;
	}

	public void setMorId(String morId) {
		this.morId = morId;
	}

	public String getMorDt() {
		return morDt;
	}

	public void setMorDt(String morDt) {
		this.morDt = morDt;
	}

	public List<AdminRule> getAdminRule() {
		return adminRule;
	}

	public void setAdminRule(List<AdminRule> adminRule) {
		this.adminRule = adminRule;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
