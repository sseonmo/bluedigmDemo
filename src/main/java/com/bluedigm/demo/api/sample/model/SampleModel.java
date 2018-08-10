package com.bluedigm.demo.api.sample.model;

import java.time.LocalDate;

public class SampleModel {

	String ADMN_ID;
	String ADMN_NM;
	String ADMN_PW;
	String ADMN_EMAL;
	String ADMN_PHNNUM;
	String COR_ID;
	LocalDate COR_DT;
	String MOR_ID;
	LocalDate MOR_DT;
	Boolean DEL_YN;

	public SampleModel(String ADMN_ID, String ADMN_NM, String ADMN_PW, String ADMN_EMAL, String ADMN_PHNNUM, Boolean DEL_YN, LocalDate COR_DT) {
		this.ADMN_ID = ADMN_ID;
		this.ADMN_NM = ADMN_NM;
		this.ADMN_PW = ADMN_PW;
		this.ADMN_EMAL = ADMN_EMAL;
		this.ADMN_PHNNUM = ADMN_PHNNUM;
		this.DEL_YN = DEL_YN;
		this.COR_DT = COR_DT;
	}

	public SampleModel() {}

	public String getADMN_ID() {
		return ADMN_ID;
	}

	public void setADMN_ID(String ADMN_ID) {
		this.ADMN_ID = ADMN_ID;
	}

	public String getADMN_NM() {
		return ADMN_NM;
	}

	public void setADMN_NM(String ADMN_NM) {
		this.ADMN_NM = ADMN_NM;
	}

	public String getADMN_PW() {
		return ADMN_PW;
	}

	public void setADMN_PW(String ADMN_PW) {
		this.ADMN_PW = ADMN_PW;
	}

	public String getADMN_EMAL() {
		return ADMN_EMAL;
	}

	public void setADMN_EMAL(String ADMN_EMAL) {
		this.ADMN_EMAL = ADMN_EMAL;
	}

	public String getADMN_PHNNUM() {
		return ADMN_PHNNUM;
	}

	public void setADMN_PHNNUM(String ADMN_PHNNUM) {
		this.ADMN_PHNNUM = ADMN_PHNNUM;
	}


	public String getCOR_ID() {
		return COR_ID;
	}

	public void setCOR_ID(String COR_ID) {
		this.COR_ID = COR_ID;
	}

	public LocalDate getCOR_DT() {
		return COR_DT;
	}

	public void setCOR_DT(LocalDate COR_DT) {
		this.COR_DT = COR_DT;
	}

	public String getMOR_ID() {
		return MOR_ID;
	}

	public void setMOR_ID(String MOR_ID) {
		this.MOR_ID = MOR_ID;
	}

	public LocalDate getMOR_DT() {
		return MOR_DT;
	}

	public void setMOR_DT(LocalDate MOR_DT) {
		this.MOR_DT = MOR_DT;
	}

	public Boolean getDEL_YN() {
		return DEL_YN;
	}

	public void setDEL_YN(Boolean DEL_YN) {
		this.DEL_YN = DEL_YN;
	}

	@Override
	public String toString() {
		return "SampleModel{" +
				"ADMN_ID='" + ADMN_ID + '\'' +
				", ADMN_NM='" + ADMN_NM + '\'' +
				", ADMN_PW='" + ADMN_PW + '\'' +
				", ADMN_EMAL='" + ADMN_EMAL + '\'' +
				", ADMN_PHNNUM='" + ADMN_PHNNUM + '\'' +
				", COR_ID='" + COR_ID + '\'' +
				", COR_DT='" + COR_DT + '\'' +
				", MOR_ID='" + MOR_ID + '\'' +
				", MOR_DT='" + MOR_DT + '\'' +
				", DEL_YN='" + DEL_YN + '\'' +
				'}';
	}
}


