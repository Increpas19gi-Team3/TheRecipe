package com.increpas.therecipe.vo;

/**
 * 장바구니(tr_basket)
 * @author 손가연
 *
 */
public class BasketVO {
	private String m_userid; /* 아이디	VARCHAR2(20) NOT NULL */
	private String f_fdcode; /* 상품코드	VARCHAR2(20) NOT NULL  */
	private int b_amount; 	 /* 구매수량	NUMBER NOT NULL */

	
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
	public int getB_amount() {
		return b_amount;
	}
	public void setB_amount(int b_amount) {
		this.b_amount = b_amount;
	}
	
	@Override
	public String toString() {
		return "BasketVO [m_userid=" + m_userid + ", f_fdcode=" + f_fdcode + ", b_amount=" + b_amount + "]";
	}
	
}
