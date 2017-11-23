package com.increpas.therecipe.vo;

import java.sql.Timestamp;

/**
 * 이벤트(tr_event)
 * @author 손가연
 *
 */
public class EventVO {
	private String e_evtcode;	/* 이벤트코드	VARCHAR2(20) NOT NULL */
	private String e_nttilte;	/* 제목 		VARCHAR2(100) */
	private String e_gubun;		/* 구분 		CHAR(1) */
	private Timestamp e_ntdate; /* 작성날짜 	DATE */
	private String e_ntcontens; /* 내용			VARCHAR2(2000) */
	private String e_ntimgname; /* 이미지		VARCHAR2(2000) */
	private int e_discount; 	/* 할인율 		NUMBER */
	private Timestamp e_startdate;	/* 시작날짜 DATE */
	private Timestamp e_enddate;	/* 종료날짜	DATE */

	
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
	public Timestamp getE_ntdate() {
		return e_ntdate;
	}
	public void setE_ntdate(Timestamp e_ntdate) {
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
	public Timestamp getE_startdate() {
		return e_startdate;
	}
	public void setE_startdate(Timestamp e_startdate) {
		this.e_startdate = e_startdate;
	}
	public Timestamp getE_enddate() {
		return e_enddate;
	}
	public void setE_enddate(Timestamp e_enddate) {
		this.e_enddate = e_enddate;
	}
	
	
	@Override
	public String toString() {
		return "EventVO [e_evtcode=" + e_evtcode + ", e_nttilte=" + e_nttilte + ", e_gubun=" + e_gubun + ", e_ntdate="
				+ e_ntdate + ", e_ntcontens=" + e_ntcontens + ", e_ntimgname=" + e_ntimgname + ", e_discount="
				+ e_discount + ", e_startdate=" + e_startdate + ", e_enddate=" + e_enddate + "]";
	}
	
	
}
