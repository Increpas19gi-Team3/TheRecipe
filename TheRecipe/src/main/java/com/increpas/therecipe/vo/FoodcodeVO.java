package com.increpas.therecipe.vo;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 음식 분류코드(tr_foodcode)
 * @author 손가연
 *
 */
public class FoodcodeVO {
	
	private int fc_1st;			/* 지역:1 / TV:2	NUMBER NOT NULL */
	private int fc_2nd; 		/* 지역				NUMBER NOT NULL */
	private int fc_3rd; 		/* 구성			NUMBER NOT NULL */
	
	@NotBlank(message="카테고리 이름을 입력해주세요")
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
	public int getFc_3rd() {
		return fc_3rd;
	}
	public void setFc_3rd(int fc_3rd) {
		this.fc_3rd = fc_3rd;
	}
	public String getFc_ctgname() {
		return fc_ctgname;
	}
	public void setFc_ctgname(String fc_ctgname) {
		this.fc_ctgname = fc_ctgname;
	}
	
	@Override
	public String toString() {
		return "FoodcodeVO [fc_1st=" + fc_1st + ", fc_2nd=" + fc_2nd + ", fc_3rd=" + fc_3rd + ", fc_ctgname="
				+ fc_ctgname + "]";
	}
	
}
