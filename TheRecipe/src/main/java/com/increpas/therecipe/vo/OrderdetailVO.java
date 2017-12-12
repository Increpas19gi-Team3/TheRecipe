package com.increpas.therecipe.vo;



/**
 * 주문 상세 테이블(tr_orderdetail)
 * @author 손가연
 * 2017.12.12 - 주문테이블 + 주문상세 테이블 분리
 * 주문 코드 : TO_CHAR(SYSTIMESTAMP, 'YYYYMMDDHH24MISSFF3') : 20171124024614598 = 2017-11-24 02:46:14.598
 */
public class OrderdetailVO {

	private String o_orderid; 	/* 주문코드(FK) 	VARCHAR2(20) NOT NULL */
	private String f_fdcode; 	/* 상품코드			VARCHAR2(20) NOT NULL */
	private int o_buyprice; 	/* 구입가격			NUMBER NOT NULL */
	private int o_amount; 		/* 구매수량 		NUMBER NOT NULL */
	
	
	public String getO_orderid() {
		return o_orderid;
	}
	public void setO_orderid(String o_orderid) {
		this.o_orderid = o_orderid;
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
	
	@Override
	public String toString() {
		return "OrderdetailVO [o_orderid=" + o_orderid + ", f_fdcode=" + f_fdcode + ", o_buyprice=" + o_buyprice
				+ ", o_amount=" + o_amount + "]";
	}
	
}
