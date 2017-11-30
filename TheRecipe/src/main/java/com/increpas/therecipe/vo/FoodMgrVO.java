package com.increpas.therecipe.vo;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 상품테이블(tr_food) + Join + 이벤트(tr_event) + SubQuery(음식 분류코드(tr_foodcode))
 * @author 손가연
 *
 */
public class FoodMgrVO {
	
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
	private String ms_code;		/* 마스터코드: 2	CHAR(1) */
	
	// tr_foodcode
	private String fc_ctgname;	/* 카테고리명	VARCHAR2(20) NOT NULL */
	private String fc_isblock;	/* 블록여부: 0정상/1:블락 NOT NULL CHAR(1) */
	
	// tr_event
	private String e_nttilte;		/* 제목		VARCHAR2(100) */
	private Date e_startdate;	/* 시작날짜 DATE */
	private Date e_enddate;	/* 종료날짜	DATE */
	private Date today;		/* 오늘날짜	SYSDATE */
	
	
	private String fcname_1st;	// 서브쿼리로 가져온 fc_1st 의 fc_ctgname
	private String fcname_2nd;	// 서브쿼리로 가져온 fc_2nd 의 fc_ctgname
	private String fcname_3rd;	// 서브쿼리로 가져온 fc_3rd 의 fc_ctgname
	
	

	
//	private String e_gubun;		/* 구분 		CHAR(1) */
//	private Timestamp e_ntdate; /* 작성날짜 	DATE */
//	private String e_ntcontens; /* 내용			VARCHAR2(2000) */
//	private String e_ntimgname; /* 이미지		VARCHAR2(2000) */
//	private int e_discount; 	/* 할인율 		NUMBER */
	
	
	
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
	public String getMs_code() {
		return ms_code;
	}
	public void setMs_code(String ms_code) {
		this.ms_code = ms_code;
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
	public Date getToday() {
		return today;
	}
	public void setToday(Date today) {
		this.today = today;
	}
	public String getFcname_1st() {
		return fcname_1st;
	}
	public void setFcname_1st(String fcname_1st) {
		this.fcname_1st = fcname_1st;
	}
	public String getFcname_2nd() {
		return fcname_2nd;
	}
	public void setFcname_2nd(String fcname_2nd) {
		this.fcname_2nd = fcname_2nd;
	}
	public String getFcname_3rd() {
		return fcname_3rd;
	}
	public void setFcname_3rd(String fcname_3rd) {
		this.fcname_3rd = fcname_3rd;
	}
	@Override
	public String toString() {
		return "FoodMgrVO [f_fdcode=" + f_fdcode + ", e_evtcode=" + e_evtcode + ", f_foodname=" + f_foodname
				+ ", fc_1st=" + fc_1st + ", fc_2nd=" + fc_2nd + ", fc_3rd=" + fc_3rd + ", f_price=" + f_price
				+ ", f_explan=" + f_explan + ", f_imgname=" + f_imgname + ", f_thumname=" + f_thumname + ", f_isblock="
				+ f_isblock + ", ms_code=" + ms_code + ", fc_ctgname=" + fc_ctgname + ", fc_isblock=" + fc_isblock
				+ ", e_nttilte=" + e_nttilte + ", e_startdate=" + e_startdate + ", e_enddate=" + e_enddate + ", today="
				+ today + ", fcname_1st=" + fcname_1st + ", fcname_2nd=" + fcname_2nd + ", fcname_3rd=" + fcname_3rd
				+ "]";
	}
	
}
