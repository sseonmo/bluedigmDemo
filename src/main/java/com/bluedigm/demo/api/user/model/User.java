package com.bluedigm.demo.api.user.model;

import java.util.Arrays;

public class User {

	private String userId;	//관리자 아이디
	
	private String userName;	//관리자 이름	
	private String userPassword;	//관리자 패스워드
	private String userEmail;	//관리자 이메일
	private String userPhone;	//관리자 전화번호
	private String deleteYn;	//삭제여부
	private String corId;	//생성자
	private String corDt;	//생성일자
	private String morId;	//수정자
	private String morDt;	//수정일자

	private String ruleId;	//권한 그룹명
	private String ruleName;	//권한 그룹명
	
    private String searchKeyword = "";         // 검색 키워드
    private String searchType = "";            // 검색 필드: 제목, 내용  
    private String[] searchTypeArr;            // 검색 필드를 배열로 변환
    private String searchExt1 = "";            // 검색 확장 필드  
	
    public static final Integer ONE = 1;
    
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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 * @return the userPhone
	 */
	public String getUserPhone() {
		return userPhone;
	}
	/**
	 * @param userPhone the userPhone to set
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
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
	/**
	 * @return the searchKeyword
	 */
	public String getSearchKeyword() {
		return searchKeyword;
	}
	/**
	 * @param searchKeyword the searchKeyword to set
	 */
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	/**
	 * @return the searchType
	 */
	public String getSearchType() {
		return searchType;
	}
	/**
	 * @param searchType the searchType to set
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	/**
	 * @return the searchTypeArr
	 */
	public String[] getSearchTypeArr() {
		return searchTypeArr;
	}
	/**
	 * @param searchTypeArr the searchTypeArr to set
	 */
	public void setSearchTypeArr(String[] searchTypeArr) {
		this.searchTypeArr = searchTypeArr;
	}
	/**
	 * @return the searchExt1
	 */
	public String getSearchExt1() {
		return searchExt1;
	}
	/**
	 * @param searchExt1 the searchExt1 to set
	 */
	public void setSearchExt1(String searchExt1) {
		this.searchExt1 = searchExt1;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", userPhone=" + userPhone + ", deleteYn=" + deleteYn + ", corId=" + corId + ", corDt="
				+ corDt + ", morId=" + morId + ", morDt=" + morDt + ", ruleId=" + ruleId + ", ruleName=" + ruleName
				+ ", searchKeyword=" + searchKeyword + ", searchType=" + searchType + ", searchTypeArr="
				+ Arrays.toString(searchTypeArr) + ", searchExt1=" + searchExt1 + "]";
	}
	
   
	
	
}
