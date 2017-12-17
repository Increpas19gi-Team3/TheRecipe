package com.increpas.therecipe.vo;


/**
 * 회원테이블(tr_Member) _ 관리용
 * @author 손가연
 *
 */


public class MemberInfoVO {
	private String m_userid;/* 아이디	VARCHAR2(20) NOT NULL */
	private String m_pw ; 	/* 패스워드	VARCHAR2(20) NOT NULL */
	private String m_name ; /* 이름		VARCHAR2(20) NOT NULL */
	private String m_email;	/* 이메일	VARCHAR2(50) NOT NULL */
	private String m_post;	/* 우편번호	VARCHAR2(20) NOT NULL */
	private String m_addr;	/* 주소		VARCHAR2(100) NOT NULL*/
	private String m_phone;	/* 전화번호	VARCHAR2(20) NOT NULL */
	private int m_level;	/* 등급		NUMBER NOT NULL */
	private String ms_code;		/* 마스터코드: 1	CHAR(1) */
	
	private String gubun;	/* 등급 설명, 서브쿼리 */

	public String getM_userid() {
		return m_userid;
	}

	public void setM_userid(String m_userid) {
		this.m_userid = m_userid;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_post() {
		return m_post;
	}

	public void setM_post(String m_post) {
		this.m_post = m_post;
	}

	public String getM_addr() {
		return m_addr;
	}

	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public int getM_level() {
		return m_level;
	}

	public void setM_level(int m_level) {
		this.m_level = m_level;
	}

	public String getMs_code() {
		return ms_code;
	}

	public void setMs_code(String ms_code) {
		this.ms_code = ms_code;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	@Override
	public String toString() {
		return "MemberInfoVO [m_userid=" + m_userid + ", m_pw=" + m_pw + ", m_name=" + m_name + ", m_email=" + m_email
				+ ", m_post=" + m_post + ", m_addr=" + m_addr + ", m_phone=" + m_phone + ", m_level=" + m_level
				+ ", ms_code=" + ms_code + ", gubun=" + gubun + "]";
	}
	
}
