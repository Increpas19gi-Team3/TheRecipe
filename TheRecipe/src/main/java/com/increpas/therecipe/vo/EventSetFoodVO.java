package com.increpas.therecipe.vo;

import java.sql.Date;

/**
 * 음식에 이벤트를 설정 관리 하기 위한 tr_food + tr_event VO
 * @author 손가연
 *
 */
public class EventSetFoodVO {

	private String f_fdcode; 
	private String e_evtcode; 
	private String e_nttilte; 
	private Date e_startdate; 
	private Date today; 
	private Date e_enddate; 
	private int fc_1st; 
	private String fcname_1st; 
	private int fc_2nd;
	private String fcname_2nd; 
	private int fc_3rd;
	private String fcname_3rd; 
	private String fc_isblock; 
	private String f_foodname; 
	private int f_price;
	private String f_isblock; 
	private String ms_code;
	private String e_discount;
	private String discount_value;
	
	
	
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
	public int getFc_1st() {
		return fc_1st;
	}
	public void setFc_1st(int fc_1st) {
		this.fc_1st = fc_1st;
	}
	public String getFcname_1st() {
		return fcname_1st;
	}
	public void setFcname_1st(String fcname_1st) {
		this.fcname_1st = fcname_1st;
	}
	public int getFc_2nd() {
		return fc_2nd;
	}
	public void setFc_2nd(int fc_2nd) {
		this.fc_2nd = fc_2nd;
	}
	public String getFcname_2nd() {
		return fcname_2nd;
	}
	public void setFcname_2nd(String fcname_2nd) {
		this.fcname_2nd = fcname_2nd;
	}
	public int getFc_3rd() {
		return fc_3rd;
	}
	public void setFc_3rd(int fc_3rd) {
		this.fc_3rd = fc_3rd;
	}
	public String getFcname_3rd() {
		return fcname_3rd;
	}
	public void setFcname_3rd(String fcname_3rd) {
		this.fcname_3rd = fcname_3rd;
	}
	public String getFc_isblock() {
		return fc_isblock;
	}
	public void setFc_isblock(String fc_isblock) {
		this.fc_isblock = fc_isblock;
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
	public String getMs_code() {
		return ms_code;
	}
	public void setMs_code(String ms_code) {
		this.ms_code = ms_code;
	}
	public String getE_discount() {
		return e_discount;
	}
	public void setE_discount(String e_discount) {
		this.e_discount = e_discount;
	}
	public String getDiscount_value() {
		return discount_value;
	}
	public void setDiscount_value(String discount_value) {
		this.discount_value = discount_value;
	}

	@Override
	public String toString() {
		return "EventSetFoodVO [f_fdcode=" + f_fdcode + ", e_evtcode=" + e_evtcode + ", e_nttilte=" + e_nttilte
				+ ", e_startdate=" + e_startdate + ", e_enddate=" + e_enddate + ", today=" + today + ", fc_1st="
				+ fc_1st + ", fcname_1st=" + fcname_1st + ", fc_2nd=" + fc_2nd + ", fcname_2nd=" + fcname_2nd
				+ ", fc_3rd=" + fc_3rd + ", fcname_3rd=" + fcname_3rd + ", fc_isblock=" + fc_isblock + ", f_foodname="
				+ f_foodname + ", f_price=" + f_price + ", f_isblock=" + f_isblock + ", ms_code=" + ms_code
				+ ", e_discount=" + e_discount + ", discount_value=" + discount_value + "]";
	}
	
}
