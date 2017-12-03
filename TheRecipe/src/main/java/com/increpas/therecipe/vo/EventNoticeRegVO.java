package com.increpas.therecipe.vo;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

/**
 * 이벤트(tr_event) + SubQuery (tr_mastercode INNER JOIN tr_subcode)
 * @author 손가연
 *
 */
public class EventNoticeRegVO {
	
	private String e_evtcode;	/* 이벤트코드	VARCHAR2(20) NOT NULL */
	private String e_nttilte;	/* 제목 		VARCHAR2(100) */
	private String e_gubun;		/* 구분 		CHAR(1) */
	private Date e_ntdate; /* 작성날짜 	DATE */
	private String e_ntcontens; /* 내용			VARCHAR2(2000) */
	private String e_ntimgname; /* 이미지		VARCHAR2(2000) */
	private int e_discount; 	/* 할인율 		NUMBER */
	private Date e_startdate;	/* 시작날짜 DATE */
	private Date e_enddate;	/* 종료날짜	DATE */
	private String ms_code;		/* 마스터코드: 3	CHAR(1) */
	
	private String discount_value; // SubQuery : 할인율 

	MultipartFile upfile;	
	
	public MultipartFile getUpfile() {
		return upfile;
	}

	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}
	
	

	public String getE_evtcode() {
		return e_evtcode;
	}

	public void setE_evtcode(String e_evtcode) {
		this.e_evtcode = e_evtcode;
	}

	public String getE_nttilte() {
		return e_nttilte;
	}

	public void setE_nttilte(String e_nttilte) {
		this.e_nttilte = e_nttilte;
	}

	public String getE_gubun() {
		return e_gubun;
	}

	public void setE_gubun(String e_gubun) {
		this.e_gubun = e_gubun;
	}

	public Date getE_ntdate() {
		return e_ntdate;
	}

	public void setE_ntdate(Date e_ntdate) {
		this.e_ntdate = e_ntdate;
	}

	public String getE_ntcontens() {
		return e_ntcontens;
	}

	public void setE_ntcontens(String e_ntcontens) {
		this.e_ntcontens = e_ntcontens;
	}

	public String getE_ntimgname() {
		return e_ntimgname;
	}

	public void setE_ntimgname(String e_ntimgname) {
		this.e_ntimgname = e_ntimgname;
	}

	public int getE_discount() {
		return e_discount;
	}

	public void setE_discount(int e_discount) {
		this.e_discount = e_discount;
	}

	public Date getE_startdate() {
		return e_startdate;
	}

	public void setE_startdate(Date e_startdate) {
		this.e_startdate = e_startdate;
	}

	public Date getE_enddate() {
		return e_enddate;
	}

	public void setE_enddate(Date e_enddate) {
		this.e_enddate = e_enddate;
	}

	public String getMs_code() {
		return ms_code;
	}

	public void setMs_code(String ms_code) {
		this.ms_code = ms_code;
	}

	public String getDiscount_value() {
		return discount_value;
	}

	public void setDiscount_value(String discount_value) {
		this.discount_value = discount_value;
	}

	@Override
	public String toString() {
		return "EventNoticeVO [e_evtcode=" + e_evtcode + ", e_nttilte=" + e_nttilte + ", e_gubun=" + e_gubun
				+ ", e_ntdate=" + e_ntdate + ", e_ntcontens=" + e_ntcontens + ", e_ntimgname=" + e_ntimgname
				+ ", e_discount=" + e_discount + ", e_startdate=" + e_startdate + ", e_enddate=" + e_enddate
				+ ", ms_code=" + ms_code + ", discount_value=" + discount_value + "]";
	}
	
}
