package com.increpas.therecipe.vo;


/**
 * 상품 테이블 + 이벤트 테이블
 * @author 김지현
 *
 */
public class FoodListVO {
	
	private String f_fdcode;	/* 상품코드	 	VARCHAR2(20) NOT NULL*/
	private String e_evtcode;	/* 이벤트코드	VARCHAR2(20) */
	private String f_foodname;	/* 상품명		VARCHAR2(100) NOT NULL */
	private int fc_1st;			/* 지역:1 / TV:2	NUMBER NOT NULL */
	private int fc_2nd; 		/* 지역				NUMBER NOT NULL */
	private int fc_3rd; 		/* 구성			NUMBER NOT NULL */
	private int f_price;		/* 가격			NUMBER NOT NULL */
	private String f_explan;	/* 상세설명		VARCHAR2(1000) */
	private String f_imgname;	/* 이미지명		VARCHAR2(2000) */
	private String f_thumname;	/* 썸네일명		VARCHAR2(2000) */
	private String f_isblock;	/* 블록 여부:0정상/블록:1  NOT NULL CHAR(1) */
	private String ms_code;		/* 마스터코드: 2	CHAR(1) */
	
	private String e_nttilte;	/* 제목 		VARCHAR2(100) */
	private int e_discount; 	/* 할인율 		NUMBER */
	private String sub_name; /* 코드명	NOT NULL VARCHAR2(50) */
	
	
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
	public String getF_foodname() {
		return f_foodname;
	}
	public void setF_foodname(String f_foodname) {
		this.f_foodname = f_foodname;
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
	public int getF_price() {
		return f_price;
	}
	public void setF_price(int f_price) {
		this.f_price = f_price;
	}
	public String getF_explan() {
		return f_explan;
	}
	public void setF_explan(String f_explan) {
		this.f_explan = f_explan;
	}
	public String getF_imgname() {
		return f_imgname;
	}
	public void setF_imgname(String f_imgname) {
		this.f_imgname = f_imgname;
	}
	public String getF_thumname() {
		return f_thumname;
	}
	public void setF_thumname(String f_thumname) {
		this.f_thumname = f_thumname;
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
	public String getE_nttilte() {
		return e_nttilte;
	}
	public void setE_nttilte(String e_nttilte) {
		this.e_nttilte = e_nttilte;
	}
	public int getE_discount() {
		return e_discount;
	}
	public void setE_discount(int e_discount) {
		this.e_discount = e_discount;
	}
	
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	@Override
	public String toString() {
		return "FoodListVO [f_fdcode=" + f_fdcode + ", e_evtcode=" + e_evtcode + ", f_foodname=" + f_foodname
				+ ", fc_1st=" + fc_1st + ", fc_2nd=" + fc_2nd + ", fc_3rd=" + fc_3rd + ", f_price=" + f_price
				+ ", f_explan=" + f_explan + ", f_imgname=" + f_imgname + ", f_thumname=" + f_thumname + ", f_isblock="
				+ f_isblock + ", ms_code=" + ms_code + ", e_nttilte=" + e_nttilte + ", e_discount=" + e_discount
				+ ", sub_name=" + sub_name + "]";
	}
	
	
}
