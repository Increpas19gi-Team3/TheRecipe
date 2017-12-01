package com.increpas.therecipe.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class UserMyBasketVO {
	//basket vo
	
	private String f_fdcode; /* 상품코드	VARCHAR2(20) NOT NULL  */ 
	private int b_amount; 	 /* 구매수량	NUMBER NOT NULL */ 
	
	//event vo
	
	private String e_nttilte;	/* 이벤트제목 		VARCHAR2(100) */ 
	private Date e_startdate;	/* 시작날짜 	  DATE */ 
	private Date e_enddate;		/* 종료날짜	 DATE */ 
	private Date today;         /* sysdate   DATE*/
	
	// food vo
	private String f_foodname;	/* 상품명		VARCHAR2(100) NOT NULL */ 
	private int f_price;		/* 가격			NUMBER NOT NULL */ 
	private String f_isblock;	/* 블록 여부:0정상/블록:1  NOT NULL CHAR(1) */ 
	private String f_thumname;	/* 썸네일명		VARCHAR2(2000) */
	

	//쪼인 vo
	private String discount_value; 
	
	private String name1st;
	private String name2nd;
	private String name3rd;
	
	private String f_isblockname;

	public String getF_fdcode() {
		return f_fdcode;
	}

	public void setF_fdcode(String f_fdcode) {
		this.f_fdcode = f_fdcode;
	}

	public int getB_amount() {
		return b_amount;
	}

	public void setB_amount(int b_amount) {
		this.b_amount = b_amount;
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

	public String getF_foodname() {
		return f_foodname;
	}

	public void setF_foodname(String f_foodname) {
		this.f_foodname = f_foodname;
	}

	public int getF_price() {
		return f_price;
	}

	public void setF_price(int f_price) {
		this.f_price = f_price;
	}

	public String getF_isblock() {
		return f_isblock;
	}

	public void setF_isblock(String f_isblock) {
		this.f_isblock = f_isblock;
	}

	public String getF_thumname() {
		return f_thumname;
	}

	public void setF_thumname(String f_thumname) {
		this.f_thumname = f_thumname;
	}

	public String getDiscount_value() {
		return discount_value;
	}

	public void setDiscount_value(String discount_value) {
		this.discount_value = discount_value;
	}

	public String getName1st() {
		return name1st;
	}

	public void setName1st(String name1st) {
		this.name1st = name1st;
	}

	public String getName2nd() {
		return name2nd;
	}

	public void setName2nd(String name2nd) {
		this.name2nd = name2nd;
	}

	public String getName3rd() {
		return name3rd;
	}

	public void setName3rd(String name3rd) {
		this.name3rd = name3rd;
	}

	public String getF_isblockname() {
		return f_isblockname;
	}

	public void setF_isblockname(String f_isblockname) {
		this.f_isblockname = f_isblockname;
	}

	@Override
	public String toString() {
		return "UserMyBasketVO [f_fdcode=" + f_fdcode + ", b_amount=" + b_amount + ", e_nttilte=" + e_nttilte
				+ ", e_startdate=" + e_startdate + ", e_enddate=" + e_enddate + ", today=" + today + ", f_foodname="
				+ f_foodname + ", f_price=" + f_price + ", f_isblock=" + f_isblock + ", f_thumname=" + f_thumname
				+ ", discount_value=" + discount_value + ", name1st=" + name1st + ", name2nd=" + name2nd + ", name3rd="
				+ name3rd + ", f_isblockname=" + f_isblockname + "]";
	}

	
	
}
