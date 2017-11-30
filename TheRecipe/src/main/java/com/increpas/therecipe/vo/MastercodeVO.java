package com.increpas.therecipe.vo;


/**
 * 마스터 코드 테이블(2017.11.30 추가 테이블)
 * @author 손가연
 *
 *	ms_code  -  ms_name
		1  -  회원
		2  -  상품
		3  -  이벤트
		4  -  주문
 */
public class MastercodeVO {

	private String ms_code;	/* 코드	 	NOT NULL CHAR(1) */      
	private String ms_name; /* 코드명	NOT NULL VARCHAR2(50) */
	
	public String getMs_code() {
		return ms_code;
	}
	public void setMs_code(String ms_code) {
		this.ms_code = ms_code;
	}
	public String getMs_name() {
		return ms_name;
	}
	public void setMs_name(String ms_name) {
		this.ms_name = ms_name;
	}
	
	@Override
	public String toString() {
		return "MastercodeVO [ms_code=" + ms_code + ", ms_name=" + ms_name + "]";
	}
	
}
