package com.increpas.therecipe.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.increpas.therecipe.vo.FoodMgrVO;

/**
 * 음식등록 DTO
 * @author 손가연
 *
 */
@Repository
public class AdminFoodRegDTO {

	// tr_food
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
	
	// tr_foodcode
	private String fc_ctgname;	/* 카테고리명	VARCHAR2(20) NOT NULL */
	private String fc_isblock;	/* 블록여부: 0정상/1:블락 NOT NULL CHAR(1) */
	
	// tr_event
	private String e_nttilte;		/* 제목		VARCHAR2(100) */
	private Date e_startdate;	/* 시작날짜 DATE */
	private Date e_enddate;	/* 종료날짜	DATE */
	private Date today;		/* 오늘날짜	SYSDATE */
	
	
	// 업로드 이미지
	MultipartFile f_imgname_1;	/* 이미지명		VARCHAR2(2000) */
	MultipartFile f_imgname_2;	/* 이미지명		VARCHAR2(2000) */
	MultipartFile f_imgname_3;	/* 이미지명		VARCHAR2(2000) */
	MultipartFile f_imgname_4;	/* 이미지명		VARCHAR2(2000) */
	MultipartFile f_imgname_5;	/* 이미지명		VARCHAR2(2000) */
	
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
	public MultipartFile getF_imgname_1() {
		return f_imgname_1;
	}
	public void setF_imgname_1(MultipartFile f_imgname_1) {
		this.f_imgname_1 = f_imgname_1;
	}
	public MultipartFile getF_imgname_2() {
		return f_imgname_2;
	}
	public void setF_imgname_2(MultipartFile f_imgname_2) {
		this.f_imgname_2 = f_imgname_2;
	}
	public MultipartFile getF_imgname_3() {
		return f_imgname_3;
	}
	public void setF_imgname_3(MultipartFile f_imgname_3) {
		this.f_imgname_3 = f_imgname_3;
	}
	public MultipartFile getF_imgname_4() {
		return f_imgname_4;
	}
	public void setF_imgname_4(MultipartFile f_imgname_4) {
		this.f_imgname_4 = f_imgname_4;
	}
	public MultipartFile getF_imgname_5() {
		return f_imgname_5;
	}
	public void setF_imgname_5(MultipartFile f_imgname_5) {
		this.f_imgname_5 = f_imgname_5;
	}
	@Override
	public String toString() {
		return "AdminFoodRegDTO [f_fdcode=" + f_fdcode + ", e_evtcode=" + e_evtcode + ", f_foodname=" + f_foodname
				+ ", fc_1st=" + fc_1st + ", fc_2nd=" + fc_2nd + ", fc_3rd=" + fc_3rd + ", f_price=" + f_price
				+ ", f_explan=" + f_explan + ", f_imgname=" + f_imgname + ", f_thumname=" + f_thumname + ", f_isblock="
				+ f_isblock + ", ms_code=" + ms_code + ", fc_ctgname=" + fc_ctgname + ", fc_isblock=" + fc_isblock
				+ ", e_nttilte=" + e_nttilte + ", e_startdate=" + e_startdate + ", e_enddate=" + e_enddate + ", today="
				+ today + ", f_imgname_1=" + f_imgname_1 + ", f_imgname_2=" + f_imgname_2 + ", f_imgname_3="
				+ f_imgname_3 + ", f_imgname_4=" + f_imgname_4 + ", f_imgname_5=" + f_imgname_5 + "]";
	}
	
}
