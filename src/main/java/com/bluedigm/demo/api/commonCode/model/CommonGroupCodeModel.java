/**
 * 
 */
package com.bluedigm.demo.api.commonCode.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Ayeon
 *
 */
public class CommonGroupCodeModel {

	/**
	 * COLUMN : 	GRP_CD_ID
	 * TYPE : 		VARCHAR(20)
	 * COMMENTS : 	그룹 코드 아이디
	 */
	public String grpCdId;
	
	/**
	 * COLUMN : 	GRP_CD
	 * TYPE : 		VARCHAR(6)
	 * COMMENTS : 	그룹 코드
	 */
	public String grpCd;
	
	/**
	 * COLUMN : 	GRP_CD_NM
	 * TYPE : 		VARCHAR(100)
	 * COMMENTS : 	그룹 코드 이름
	 */
	public String grpCdNm;
	
	/**
	 * COLUMN : 	GRP_CD_EXPLNATN
	 * TYPE : 		VARCHAR(100)
	 * COMMENTS : 	그룹 코드 설명
	 */
	public String grpCdExplnatn;
	
	/**
	 * COLUMN : 	GRP_CD_LNGTH
	 * TYPE : 		INT(5)
	 * COMMENTS : 	그룹 코드 길이
	 */
	public int grpCdLngth;
	
	/**
	 * COLUMN : 	DEL_YN
	 * TYPE : 		VARCHAR(1)
	 * COMMENTS : 	삭제 여부
	 */
	public String delYn;
	
	/**
	 * COLUMN : 	COR_ID
	 * TYPE : 		VARCHAR(50)
	 * COMMENTS : 	생성자 아이디
	 */
	public String corId;
	
	/**
	 * COLUMN : 	CRT_DT
	 * TYPE : 		DATETIME
	 * COMMENTS : 	생성 일시
	 */
	public Date crtDt;
	
	/**
	 * COLUMN : 	MOR_ID
	 * TYPE : 		VARCHAR(50)
	 * COMMENTS : 	변경자 아이디
	 */
	public String morId;
	
	/**
	 * COLUMN : 	MDF_DT
	 * TYPE : 		DATETIME
	 * COMMENTS : 	변경 일시
	 */
	public Date mdfDt;

	public String getGrpCdId() {
		return grpCdId;
	}

	public void setGrpCdId(String grpCdId) {
		this.grpCdId = grpCdId;
	}

	public String getGrpCd() {
		return grpCd;
	}

	public void setGrpCd(String grpCd) {
		this.grpCd = grpCd;
	}

	public String getGrpCdNm() {
		return grpCdNm;
	}

	public void setGrpCdNm(String grpCdNm) {
		this.grpCdNm = grpCdNm;
	}

	public String getGrpCdExplnatn() {
		return grpCdExplnatn;
	}

	public void setGrpCdExplnatn(String grpCdExplnatn) {
		this.grpCdExplnatn = grpCdExplnatn;
	}

	public int getGrpCdLngth() {
		return grpCdLngth;
	}

	public void setGrpCdLngth(int grpCdLngth) {
		this.grpCdLngth = grpCdLngth;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
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

	public Date getMdfDt() {
		return mdfDt;
	}

	public void setMdfDt(Date mdfDt) {
		this.mdfDt = mdfDt;
	}
	
}
