package com.increpas.therecipe.vo;

import java.sql.Date;

/**
 * 이벤트 설정을 위한 이벤트 데이터를 가져오는 Event VO
 * @author 손가연
 * 
 */
public class EventInfoVO {

	private String e_evtcode;
	private String e_nttilte; 
	private String e_gubun;
	private Date e_startdate; 
	private Date today; 
	private Date e_enddate;
	private String discount_value; //DB Sub Query
	
	
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
	public Date getE_startdate() {
		return e_startdate;
	}
	public void setE_startdate(Date e_startdate) {
		this.e_startdate = e_startdate;
	}
	public Date getToday() {
		return today;
	}
	public void setToday(Date today) {
		this.today = today;
	}
	public Date getE_enddate() {
		return e_enddate;
	}
	public void setE_enddate(Date e_enddate) {
		this.e_enddate = e_enddate;
	}
	public String getDiscount_value() {
		return discount_value;
	}
	public void setDiscount_value(String discount_value) {
		this.discount_value = discount_value;
	}
	
	@Override
	public String toString() {
		return "EventInfoVO [e_evtcode=" + e_evtcode + ", e_nttilte=" + e_nttilte + ", e_gubun=" + e_gubun
				+ ", e_startdate=" + e_startdate + ", today=" + today + ", e_enddate=" + e_enddate + ", discount_value="
				+ discount_value + "]";
	}
	
}
