package com.bluedigm.demo.api.commonCode.model;

import java.util.Date;

public class CommonCodeModel {
	
	/**
	 * COLUMN : 	CD_ID
	 * TYPE : 		VARCHAR(20)
	 * COMMENTS : 	코드 아이디
	 */
	String cdId;

	/**
	 * COLUMN : 	GRP_CD_ID
	 * TYPE : 		VARCHAR(20)
	 * COMMENTS : 	그룹 코드 아이디
	 */
	String grpCdId;
	
	/**
	 * COLUMN : 	CD
	 * TYPE : 		VARCHAR(6)
	 * COMMENTS : 	코드
	 */
	String cd;
	
	/**
	 * COLUMN : 	CD_NM
	 * TYPE : 		VARCHAR(100)
	 * COMMENTS : 
	 */
	String cdNm;
	
	/**
	 * COLUMN : 	CD_EXPLNATN
	 * TYPE : 		VARCHAR(100)
	 * COMMENTS : 	코드 설명
	 */
	String cdExplnatn;
	
	/**
	 * COLUMN : 	CD_ORD_NM
	 * TYPE : 		INT(5)
	 * COMMENTS : 	코드 정렬 번호
	 */
	int cdOrdNm;
	
	/**
	 * COLUMN : 	CD_USE_YN
	 * TYPE : 		VARCHAR(1)
	 * COMMENTS : 	코드 사용 여부
	 */
	String cdUseYn;
	
	/**
	 * COLUMN : 	DEL_YN
	 * TYPE : 		VARCHAR(1)
	 * COMMENTS : 	삭제 여부
	 */
	String delYn;
	
	/**
	 * COLUMN : 	FERNC_CD
	 * TYPE : 		VARCHAR(20)
	 * COMMENTS : 	참조 코드
	 */
	String ferncCd;
	
	/**
	 * COLUMN : 	COR_ID
	 * TYPE : 		VARCHAR(50)
	 * COMMENTS : 	생성자 아이디
	 */
	String corId;
	
	/**
	 * COLUMN : 	CRT_DT
	 * TYPE : 		DATETIME
	 * COMMENTS : 	생성 일시
	 */
	Date crtDt;
	
	/**
	 * COLUMN : 	MOR_ID
	 * TYPE : 		VARCHAR(50)
	 * COMMENTS : 	변경자 아이디
	 */
	String morId;
	
	/**
	 * COLUMN : 	MDF_DT
	 * TYPE : 		DATETIME
	 * COMMENTS : 	변경 일시
	 */
	Date mdfId;

	public String getCdId() {
		return cdId;
	}

	public void setCdId(String cdId) {
		this.cdId = cdId;
	}

	public String getGrpCdId() {
		return grpCdId;
	}

	public void setGrpCdId(String grpCdId) {
		this.grpCdId = grpCdId;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getCdNm() {
		return cdNm;
	}

	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}

	public String getCdExplnatn() {
		return cdExplnatn;
	}

	public void setCdExplnatn(String cdExplnatn) {
		this.cdExplnatn = cdExplnatn;
	}

	public int getCdOrdNm() {
		return cdOrdNm;
	}

	public void setCdOrdNm(int cdOrdNm) {
		this.cdOrdNm = cdOrdNm;
	}

	public String getCdUseYn() {
		return cdUseYn;
	}

	public void setCdUseYn(String cdUseYn) {
		this.cdUseYn = cdUseYn;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getFerncCd() {
		return ferncCd;
	}

	public void setFerncCd(String ferncCd) {
		this.ferncCd = ferncCd;
	}

	public String getCorId() {
		return corId;
	}

	public void setCorId(String corId) {
		this.corId = corId;
	}

	public Date getCrtDt() {
		return crtDt;
	}

	public void setCrtDt(Date crtDt) {
		this.crtDt = crtDt;
	}

	public String getMorId() {
		return morId;
	}

	public void setMorId(String morId) {
		this.morId = morId;
	}

	public Date getMdfId() {
		return mdfId;
	}

	public void setMdfId(Date mdfId) {
		this.mdfId = mdfId;
	}
	
}
