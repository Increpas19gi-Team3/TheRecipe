package com.increpas.therecipe.vo;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 음식 분류코드(tr_foodcode) + SubQuery(count() 함수 사용)
 * @author 손가연
 *
 */
public class FoodcodeWithFoodCntVO {
	
	private int fc_1st;			/* 지역:1 / TV:2	NUMBER NOT NULL */
	private int fc_2nd; 		/* 지역				NUMBER NOT NULL */
	private int fc_3rd; 		/* 구성				NUMBER NOT NULL */  
	
	@NotBlank(message="카테고리 이름을 입력해주세요")
	private String fc_ctgname;	/* 카테고리명	VARCHAR2(20) NOT NULL */
	
	private String fc_isblock;	/* 블록여부: 0정상/1:블락 NOT NULL CHAR(1) */
	
	private int regfoodcnt; // subQuery 데이터 : FoodCode 별 등록되어 있는 Food 데이터의 갯수 

	public FoodcodeWithFoodCntVO() {
		this(0, 0, 0, "", "", 0);
	}

	public FoodcodeWithFoodCntVO(int fc_1st, int fc_2nd, int fc_3rd, String fc_ctgname, String fc_isblock,
			int regfoodcnt) {
		super();
		this.fc_1st = fc_1st;
		this.fc_2nd = fc_2nd;
		this.fc_3rd = fc_3rd;
		this.fc_ctgname = fc_ctgname;
		this.fc_isblock = fc_isblock;
		this.regfoodcnt = regfoodcnt;
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

	public int getRegfoodcnt() {
		return regfoodcnt;
	}

	public void setRegfoodcnt(int regfoodcnt) {
		this.regfoodcnt = regfoodcnt;
	}

	@Override
	public String toString() {
		return "FoodcodeWithFoodCntVO [fc_1st=" + fc_1st + ", fc_2nd=" + fc_2nd + ", fc_3rd=" + fc_3rd + ", fc_ctgname="
				+ fc_ctgname + ", fc_isblock=" + fc_isblock + ", regfoodcnt=" + regfoodcnt + "]";
	}

	
	
}
