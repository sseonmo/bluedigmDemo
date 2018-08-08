package com.bluedigm.demo.api.admin.model;

public class AdminRule {

	private String ruleId;			//ruleId
	private String adminId;			//adminId
	private String corId;			//생성자
	private String corDt;			//생성일자
	private String morId;			//수정자
	private String morDt;			//수정일자

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
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

	@Override
	public String toString() {
		return super.toString();
	}
}
