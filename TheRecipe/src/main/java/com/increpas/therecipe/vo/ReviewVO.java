package com.increpas.therecipe.vo;

import java.sql.Timestamp;

/**
 * 후기테이블(tr_review)
 * @author 손가연
 *
 */
public class ReviewVO {
	private String r_rvcode; 	/* 후기코드 VARCHAR2(20) NOT NULL */
	private String m_userid; 	/* 아이디 	VARCHAR2(20) NOT NULL */
	private String f_fdcode; 	/* 상품코드 VARCHAR2(20) NOT NULL */
	private String r_rvcontents; /* 후기 	VARCHAR2(3000) NOT NULL */
	private int r_grade; 		/* 평점 	NUMBER */
	private String r_rvimgname; /* 이미지명 VARCHAR2(1000) */
	private int r_rvcount; 		/* 조회수 	NUMBER */
	private Timestamp r_rvdate; /* 글등록시간	DATE */
	private String r_admincmt; 	/* 관리자댓글 VARCHAR2(100) */
	private Timestamp r_admindate; /* 관리자댓글시간	DATE */
	
	
	public String getR_rvcode() {
		return r_rvcode;
	}
	public void setR_rvcode(String r_rvcode) {
		this.r_rvcode = r_rvcode;
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
	public String getR_rvcontents() {
		return r_rvcontents;
	}
	public void setR_rvcontents(String r_rvcontents) {
		this.r_rvcontents = r_rvcontents;
	}
	public int getR_grade() {
		return r_grade;
	}
	public void setR_grade(int r_grade) {
		this.r_grade = r_grade;
	}
	public String getR_rvimgname() {
		return r_rvimgname;
	}
	public void setR_rvimgname(String r_rvimgname) {
		this.r_rvimgname = r_rvimgname;
	}
	public int getR_rvcount() {
		return r_rvcount;
	}
	public void setR_rvcount(int r_rvcount) {
		this.r_rvcount = r_rvcount;
	}
	public Timestamp getR_rvdate() {
		return r_rvdate;
	}
	public void setR_rvdate(Timestamp r_rvdate) {
		this.r_rvdate = r_rvdate;
	}
	public String getR_admincmt() {
		return r_admincmt;
	}
	public void setR_admincmt(String r_admincmt) {
		this.r_admincmt = r_admincmt;
	}
	public Timestamp getR_admindate() {
		return r_admindate;
	}
	public void setR_admindate(Timestamp r_admindate) {
		this.r_admindate = r_admindate;
	}
	
	
	@Override
	public String toString() {
		return "ReviewVO [r_rvcode=" + r_rvcode + ", m_userid=" + m_userid + ", f_fdcode=" + f_fdcode
				+ ", r_rvcontents=" + r_rvcontents + ", r_grade=" + r_grade + ", r_rvimgname=" + r_rvimgname
				+ ", r_rvcount=" + r_rvcount + ", r_rvdate=" + r_rvdate + ", r_admincmt=" + r_admincmt
				+ ", r_admindate=" + r_admindate + "]";
	}
	
}
