package com.bluedigm.demo.api.menu.model;

public class Menu {

	/** 메뉴 아이디. MENU_ID*/
	private String menuId;
	
	/** 부모 메뉴 아이디. PRNT_MENU_ID*/
	private String prntMenuId;
	
	/** 메뉴명. MENU_NM*/
	private String  menuName;
	
	/** 메뉴 Url. MENU_URL*/
	private String  menuUrl;
	
	/** 메뉴 depth.stepNo MENU_DEPTH*/	
	private String  menuDepth;
	
	/** 메뉴 타입 코드. MENU_TYPE_CD*/	
	private String  menuTypCd;
	
	/** 메뉴 레벨 번호. MENU_LVL_NUM*/	
	private String  menuLvlNum;	

	/** 메뉴 설명. description MENU_EXPL*/
	private String menuExpl;
	
	/** 정렬순서. displayOrder ORD_SEQ*/
	private String menuOrder;
	
	/** 표시여부. isfolder DSPLY_YN*/
	private String displayYn;
	
	/** 삭제여부. DEL_YN*/
	private String deleteYn;
	
	/** 생성자 아이디. COR_ID*/
	private String corId;
	
	/** 생성 일시. CRT_DT*/
	private String corDt;
	
	/** 수정자 아이디. MOR_ID*/
	private String morId;
	
	/** 수정 일시. MDF_DT*/	
	private String morDt;


	/**
	 * @return the menuId
	 */
	public String getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the prntMenuId
	 */
	public String getPrntMenuId() {
		return prntMenuId;
	}

	/**
	 * @param prntMenuId the prntMenuId to set
	 */
	public void setPrntMenuId(String prntMenuId) {
		this.prntMenuId = prntMenuId;
	}

	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * @param menuName the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * @return the menuUrl
	 */
	public String getMenuUrl() {
		return menuUrl;
	}

	/**
	 * @param menuUrl the menuUrl to set
	 */
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	/**
	 * @return the menuDepth
	 */
	public String getMenuDepth() {
		return menuDepth;
	}

	/**
	 * @param menuDepth the menuDepth to set
	 */
	public void setMenuDepth(String menuDepth) {
		this.menuDepth = menuDepth;
	}

	/**
	 * @return the menuTypCd
	 */
	public String getMenuTypCd() {
		return menuTypCd;
	}

	/**
	 * @param menuTypCd the menuTypCd to set
	 */
	public void setMenuTypCd(String menuTypCd) {
		this.menuTypCd = menuTypCd;
	}

	/**
	 * @return the menuLvlNum
	 */
	public String getMenuLvlNum() {
		return menuLvlNum;
	}

	/**
	 * @param menuLvlNum the menuLvlNum to set
	 */
	public void setMenuLvlNum(String menuLvlNum) {
		this.menuLvlNum = menuLvlNum;
	}

	/**
	 * @return the menuExpl
	 */
	public String getMenuExpl() {
		return menuExpl;
	}

	/**
	 * @param menuExpl the menuExpl to set
	 */
	public void setMenuExpl(String menuExpl) {
		this.menuExpl = menuExpl;
	}

	/**
	 * @return the menuOrder
	 */
	public String getMenuOrder() {
		return menuOrder;
	}

	/**
	 * @param menuOrder the menuOrder to set
	 */
	public void setMenuOrder(String menuOrder) {
		this.menuOrder = menuOrder;
	}

	/**
	 * @return the displayYn
	 */
	public String getDisplayYn() {
		return displayYn;
	}

	/**
	 * @param displayYn the displayYn to set
	 */
	public void setDisplayYn(String displayYn) {
		this.displayYn = displayYn;
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
