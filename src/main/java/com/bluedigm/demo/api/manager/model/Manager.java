package com.bluedigm.demo.api.manager.model;

public class Manager {

	private String adminId;
	
	private String adminName;	//관리자 아이디
	private String adminPassword;	//관리자 이름
	private String adminEmail;	//관리자 이메
	private String adminPhone;	//관리자 전화번호
	private String deleteYn;	//삭제여부
	private String corId;	//생성자
	private String corDt;	//생성일자
	private String morId;	//수정자
	private String morDt;	//수정일자
	
    private String searchKeyword = "";         // 검색 키워드
    private String searchType = "";            // 검색 필드: 제목, 내용  
    private String[] searchTypeArr;            // 검색 필드를 배열로 변환
    private String searchExt1 = "";            // 검색 확장 필드  
	
    /**
	 * @return the adminId
	 */
	public String getAdminId() {
		return adminId;
	}
	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	/**
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}
	/**
	 * @param adminName the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	/**
	 * @return the adminPassword
	 */
	public String getAdminPassword() {
		return adminPassword;
	}
	/**
	 * @param adminPassword the adminPassword to set
	 */
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	/**
	 * @return the adminEmail
	 */
	public String getAdminEmail() {
		return adminEmail;
	}
	/**
	 * @param adminEmail the adminEmail to set
	 */
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	/**
	 * @return the adminPhone
	 */
	public String getAdminPhone() {
		return adminPhone;
	}
	/**
	 * @param adminPhone the adminPhone to set
	 */
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
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

	
	
}
