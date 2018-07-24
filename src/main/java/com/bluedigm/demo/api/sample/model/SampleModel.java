package com.bluedigm.demo.api.sample.model;

public class SampleModel {

	String ADMN_ID;
	String ADMN_NM;
	String ADMN_PW;
	String ADMN_EMAL;
	String ADMN_PHNNUM;

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

	@Override
	public String toString() {
		return "SampleModel{" +
				"ADMN_ID='" + ADMN_ID + '\'' +
				", ADMN_NM='" + ADMN_NM + '\'' +
				", ADMN_PW='" + ADMN_PW + '\'' +
				", ADMN_EMAL='" + ADMN_EMAL + '\'' +
				", ADMN_PHNNUM='" + ADMN_PHNNUM + '\'' +
				'}';
	}
}


