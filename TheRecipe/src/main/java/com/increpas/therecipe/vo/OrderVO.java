package com.increpas.therecipe.vo;

import java.sql.Timestamp;

/**
 * 주문테이블(tr_order)
 * @author 손가연
 * 2017.12.12 - 주문테이블 + 주문상세 테이블 분리
 * 주문 코드 : TO_CHAR(SYSTIMESTAMP, 'YYYYMMDDHH24MISSFF3') : 20171124024614598 = 2017-11-24 02:46:14.598
 */
public class OrderVO {

	private String o_orderid; 		/* 주문코드			VARCHAR2(20) NOT NULL */
	private String m_userid; 		/* 아이디			VARCHAR2(20) NOT NULL */
	private Timestamp o_orderdate;	/* 주문날짜			DATE NOT NULL */
	private Timestamp o_depositdate;/* 입금확인시간		DATE */
	private Timestamp o_readydate; 	/* 상품준비시간		DATE */
	private Timestamp o_dvyrddate; 	/* 배송준비시간		DATE */
	private Timestamp o_dvydate; 	/* 배송중시간		DATE */
	private Timestamp o_dvyenddate; /* 배송완료시간		DATE */
	private String d_status; 		/* 상태코드			CHAR(1) NOT NULL */
	private String o_reciever; 		/* 수취인			VARCHAR2(20) NOT NULL */
	private String o_dvypost; 		/* 배송지우편번호	VARCHAR2(20) NOT NULL */
	private String o_dvyaddr; 		/* 배송지주소		VARCHAR2(100) NOT NULL */
	private String ms_code; 		/* 마스터코드값: 4	CHAR(1) NOT NULL */

	
	public String getO_orderid() {
		return o_orderid;
	}
	public void setO_orderid(String o_orderid) {
		this.o_orderid = o_orderid;
	}
	public String getM_userid() {
		return m_userid;
	}
	public void setM_userid(String m_userid) {
		this.m_userid = m_userid;
	}
	public Timestamp getO_orderdate() {
		return o_orderdate;
	}
	public void setO_orderdate(Timestamp o_orderdate) {
		this.o_orderdate = o_orderdate;
	}
	public Timestamp getO_depositdate() {
		return o_depositdate;
	}
	public void setO_depositdate(Timestamp o_depositdate) {
		this.o_depositdate = o_depositdate;
	}
	public Timestamp getO_readydate() {
		return o_readydate;
	}
	public void setO_readydate(Timestamp o_readydate) {
		this.o_readydate = o_readydate;
	}
	public Timestamp getO_dvyrddate() {
		return o_dvyrddate;
	}
	public void setO_dvyrddate(Timestamp o_dvyrddate) {
		this.o_dvyrddate = o_dvyrddate;
	}
	public Timestamp getO_dvydate() {
		return o_dvydate;
	}
	public void setO_dvydate(Timestamp o_dvydate) {
		this.o_dvydate = o_dvydate;
	}
	public Timestamp getO_dvyenddate() {
		return o_dvyenddate;
	}
	public void setO_dvyenddate(Timestamp o_dvyenddate) {
		this.o_dvyenddate = o_dvyenddate;
	}
	public String getD_status() {
		return d_status;
	}
	public void setD_status(String d_status) {
		this.d_status = d_status;
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
		return "OrderVO [o_orderid=" + o_orderid + ", m_userid=" + m_userid + ", o_orderdate=" + o_orderdate
				+ ", o_depositdate=" + o_depositdate + ", o_readydate=" + o_readydate + ", o_dvyrddate=" + o_dvyrddate
				+ ", o_dvydate=" + o_dvydate + ", o_dvyenddate=" + o_dvyenddate + ", d_status=" + d_status
				+ ", o_reciever=" + o_reciever + ", o_dvypost=" + o_dvypost + ", o_dvyaddr=" + o_dvyaddr + ", ms_code="
				+ ms_code + "]";
	}

}
