package com.increpas.therecipe.vo;

import java.sql.Timestamp;

/**
 * 상품테이블(tr_food) + Join + 음식 분류코드(tr_foodcode) + Join + 이벤트(tr_event)
 * @author 손가연
 *
 */
public class FoodJoinFoodcodeJoinEventVO {
	
	// tr_food
	private String f_fdcode;	/* 상품코드	 	VARCHAR2(20) NOT NULL*/
	private String e_evtcode;	/* 이벤트코드	VARCHAR2(20) */
	private String f_foodname;	/* 상품명		VARCHAR2(100) NOT NULL */
	private int fc_1st;			/* 지역:1 / TV:2	NUMBER NOT NULL */
	private int fc_2nd; 		/* 지역				NUMBER NOT NULL */
	private int fc_3rd; 		/* 구성			NUMBER NOT NULL */
	private int f_price;		/* 가격			NUMBER NOT NULL */
	private String f_explan;	/* 상세설명		VARCHAR2(1000) */
	private String f_imgname;	/* 이미지명		VARCHAR2(2000) */
	private String f_thumname;	/* 썸네일명		VARCHAR2(2000) */
	private String f_isblock;	/* 블록 여부:0정상/블록:1  NOT NULL CHAR(1) */
	
	// tr_foodcode
	private String fc_ctgname;	/* 카테고리명	VARCHAR2(20) NOT NULL */
	private String fc_isblock;	/* 블록여부: 0정상/1:블락 NOT NULL CHAR(1) */
	
	// tr_event
	private String e_nttilte;	/* 제목 		VARCHAR2(100) */
	private String e_gubun;		/* 구분 		CHAR(1) */
	private Timestamp e_ntdate; /* 작성날짜 	DATE */
	private String e_ntcontens; /* 내용			VARCHAR2(2000) */
	private String e_ntimgname; /* 이미지		VARCHAR2(2000) */
	private int e_discount; 	/* 할인율 		NUMBER */
	private Timestamp e_startdate;	/* 시작날짜 DATE */
	private Timestamp e_enddate;	/* 종료날짜	DATE */
	
	
	
	public String getF_fdcode() {
		return f_fdcode;
	}
	public void setF_fdcode(String f_fdcode) {
		this.f_fdcode = f_fdcode;
	}
	public String getE_evtcode() {
		return e_evtcode;
	}
	public void setE_evtcode(String e_evtcode) {
		this.e_evtcode = e_evtcode;
	}
	public String getF_foodname() {
		return f_foodname;
	}
	public void setF_foodname(String f_foodname) {
		this.f_foodname = f_foodname;
	}
	public int getFc_1st() {
		return fc_1st;
	}
	public void setFc_1st(int fc_1st) {
		this.fc_1st = fc_1st;
	}
	public int getFc_2nd() {
		return fc_2nd;
	}
	public void setFc_2nd(int fc_2nd) {
		this.fc_2nd = fc_2nd;
	}
	public int getFc_3rd() {
		return fc_3rd;
	}
	public void setFc_3rd(int fc_3rd) {
		this.fc_3rd = fc_3rd;
	}
	public int getF_price() {
		return f_price;
	}
	public void setF_price(int f_price) {
		this.f_price = f_price;
	}
	public String getF_explan() {
		return f_explan;
	}
	public void setF_explan(String f_explan) {
		this.f_explan = f_explan;
	}
	public String getF_imgname() {
		return f_imgname;
	}
	public void setF_imgname(String f_imgname) {
		this.f_imgname = f_imgname;
	}
	public String getF_thumname() {
		return f_thumname;
	}
	public void setF_thumname(String f_thumname) {
		this.f_thumname = f_thumname;
	}
	public String getF_isblock() {
		return f_isblock;
	}
	public void setF_isblock(String f_isblock) {
		this.f_isblock = f_isblock;
	}
	public String getFc_ctgname() {
		return fc_ctgname;
	}
	public void setFc_ctgname(String fc_ctgname) {
		this.fc_ctgname = fc_ctgname;
	}
	public String getFc_isblock() {
		return fc_isblock;
	}
	public void setFc_isblock(String fc_isblock) {
		this.fc_isblock = fc_isblock;
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
		return "FoodJoinFoodcodeJoinEventVO [f_fdcode=" + f_fdcode + ", e_evtcode=" + e_evtcode + ", f_foodname="
				+ f_foodname + ", fc_1st=" + fc_1st + ", fc_2nd=" + fc_2nd + ", fc_3rd=" + fc_3rd + ", f_price="
				+ f_price + ", f_explan=" + f_explan + ", f_imgname=" + f_imgname + ", f_thumname=" + f_thumname
				+ ", f_isblock=" + f_isblock + ", fc_ctgname=" + fc_ctgname + ", fc_isblock=" + fc_isblock
				+ ", e_nttilte=" + e_nttilte + ", e_gubun=" + e_gubun + ", e_ntdate=" + e_ntdate + ", e_ntcontens="
				+ e_ntcontens + ", e_ntimgname=" + e_ntimgname + ", e_discount=" + e_discount + ", e_startdate="
				+ e_startdate + ", e_enddate=" + e_enddate + "]";
	}

}
