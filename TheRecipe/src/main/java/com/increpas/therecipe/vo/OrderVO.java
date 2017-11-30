package com.increpas.therecipe.vo;

import java.sql.Timestamp;

/**
 * 주문테이블(tr_order)
 * @author 손가연
 *
 */
public class OrderVO {
	private String o_orderid;	/* 주문코드 	VARCHAR2(20) NOT NULL */
	private String d_status;	/* 배송상태		CHAR(1) NOT NULL */
	private String m_userid;	/* 아이디 		VARCHAR2(20) NOT NULL */
	private String f_fdcode;	/* 상품코드		VARCHAR2(20) NOT NULL */
	private int o_buyprice; 	/* 구입가격 	NUMBER NOT NULL */
	private int o_amount; 		/* 구매수량		NUMBER NOT NULL */
	private Timestamp o_orderdate; /* 주문날짜	DATE NOT NULL */
	private String o_reciever; 	/* 수취인		VARCHAR2(20) NOT NULL */
	private String o_dvypost; 	/* 배송지우편번호 VARCHAR2(20) NOT NULL */
	private String o_dvyaddr; 	/* 배송지주소 	VARCHAR2(100) NOT NULL */
	private String ms_code;		/* 마스터코드: 4	CHAR(1) */
	
	
	public String getO_orderid() {
		return o_orderid;
	}
	public void setO_orderid(String o_orderid) {
		this.o_orderid = o_orderid;
	}
	public String getD_status() {
		return d_status;
	}
	public void setD_status(String d_status) {
		this.d_status = d_status;
	}
	public String getM_userid() {
		return m_userid;
	}
	public void setM_userid(String m_userid) {
		this.m_userid = m_userid;
	}
	public String getF_fdcode() {
		return f_fdcode;
	}
	public void setF_fdcode(String f_fdcode) {
		this.f_fdcode = f_fdcode;
	}
	public int getO_buyprice() {
		return o_buyprice;
	}
	public void setO_buyprice(int o_buyprice) {
		this.o_buyprice = o_buyprice;
	}
	public int getO_amount() {
		return o_amount;
	}
	public void setO_amount(int o_amount) {
		this.o_amount = o_amount;
	}
	public Timestamp getO_orderdate() {
		return o_orderdate;
	}
	public void setO_orderdate(Timestamp o_orderdate) {
		this.o_orderdate = o_orderdate;
	}
	public String getO_reciever() {
		return o_reciever;
	}
	public void setO_reciever(String o_reciever) {
		this.o_reciever = o_reciever;
	}
	public String getO_dvypost() {
		return o_dvypost;
	}
	public void setO_dvypost(String o_dvypost) {
		this.o_dvypost = o_dvypost;
	}
	public String getO_dvyaddr() {
		return o_dvyaddr;
	}
	public void setO_dvyaddr(String o_dvyaddr) {
		this.o_dvyaddr = o_dvyaddr;
	}
	public String getMs_code() {
		return ms_code;
	}
	public void setMs_code(String ms_code) {
		this.ms_code = ms_code;
	}

	@Override
	public String toString() {
		return "OrderVO [o_orderid=" + o_orderid + ", d_status=" + d_status + ", m_userid=" + m_userid + ", f_fdcode="
				+ f_fdcode + ", o_buyprice=" + o_buyprice + ", o_amount=" + o_amount + ", o_orderdate=" + o_orderdate
				+ ", o_reciever=" + o_reciever + ", o_dvypost=" + o_dvypost + ", o_dvyaddr=" + o_dvyaddr + ", ms_code="
				+ ms_code + "]";
	}

}
