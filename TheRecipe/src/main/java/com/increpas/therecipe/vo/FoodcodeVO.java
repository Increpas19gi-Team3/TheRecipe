package com.increpas.therecipe.vo;

/**
 * 분류코드(tr_foodcode)
 * @author 손가연
 *
 */
public class FoodcodeVO {
	private int fc_1st;			/* 대분류	NUMBER NOT NULL */
	private int fc_2nd; 		/* 중분류	NUMBER NOT NULL */
	private String fc_ctgname;	/* 카테고리명	VARCHAR2(20) NOT NULL */
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
	public String getFc_ctgname() {
		return fc_ctgname;
	}
	public void setFc_ctgname(String fc_ctgname) {
		this.fc_ctgname = fc_ctgname;
	}
	
	
	@Override
	public String toString() {
		return "FoodcodeVO [fc_1st=" + fc_1st + ", fc_2nd=" + fc_2nd + ", fc_ctgname=" + fc_ctgname + "]";
	}
	
}
