package com.bluedigm.demo.api.manage.model;

public class Manage {

	private String ruleId;	//그룹권한 아이디
	private String ruleName;	//그룹권한명	
	private String ruleExpl;	//그룹권한 설명
	private String deleteYn;	//삭제여부
	private String ruleCount;	//사용자수
	
	private String corId;
	private String corDt;
	private String morId;
	private String morDt;
	
	/**
	 * @return the ruleCount
	 */
	public String getRuleCount() {
		return ruleCount;
	}
	/**
	 * @param ruleCount the ruleCount to set
	 */
	public void setRuleCount(String ruleCount) {
		this.ruleCount = ruleCount;
	}
	/**
	 * @return the ruleId
	 */
	public String getRuleId() {
		return ruleId;
	}
	/**
	 * @param ruleId the ruleId to set
	 */
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	/**
	 * @return the ruleName
	 */
	public String getRuleName() {
		return ruleName;
	}
	/**
	 * @param ruleName the ruleName to set
	 */
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	/**
	 * @return the ruleExpl
	 */
	public String getRuleExpl() {
		return ruleExpl;
	}
	/**
	 * @param ruleExpl the ruleExpl to set
	 */
	public void setRuleExpl(String ruleExpl) {
		this.ruleExpl = ruleExpl;
	}
	/**
	 * @return the deleteYn
	 */
	public String getDeleteYn() {
		return deleteYn;
	}
	/**
	 * @param deleteYn the deleteYn to set
	 */
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	/**
	 * @return the corId
	 */
	public String getCorId() {
		return corId;
	}
	/**
	 * @param corId the corId to set
	 */
	public void setCorId(String corId) {
		this.corId = corId;
	}
	/**
	 * @return the corDt
	 */
	public String getCorDt() {
		return corDt;
	}
	/**
	 * @param corDt the corDt to set
	 */
	public void setCorDt(String corDt) {
		this.corDt = corDt;
	}
	/**
	 * @return the morId
	 */
	public String getMorId() {
		return morId;
	}
	/**
	 * @param morId the morId to set
	 */
	public void setMorId(String morId) {
		this.morId = morId;
	}
	/**
	 * @return the morDt
	 */
	public String getMorDt() {
		return morDt;
	}
	/**
	 * @param morDt the morDt to set
	 */
	public void setMorDt(String morDt) {
		this.morDt = morDt;
	}


}
