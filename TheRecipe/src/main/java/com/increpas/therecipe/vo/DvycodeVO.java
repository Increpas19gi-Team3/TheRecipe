package com.increpas.therecipe.vo;

/**
 * 배송코드(tr_dvycode)
 * @author 손가연
 *
 */
public class DvycodeVO {
	private String d_status; /* 배송상태 	CHAR(1) NOT NULL */
	private String d_stname; /* 상태명 		VARCHAR2(12) */
	
	
	public String getD_status() {
		return d_status;
	}
	public void setD_status(String d_status) {
		this.d_status = d_status;
	}
	public String getD_stname() {
		return d_stname;
	}
	public void setD_stname(String d_stname) {
		this.d_stname = d_stname;
	}
	
	@Override
	public String toString() {
		return "DvycodeVO [d_status=" + d_status + ", d_stname=" + d_stname + "]";
	}
	
	
}
