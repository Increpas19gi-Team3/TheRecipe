package com.increpas.therecipe.vo;

/**
 * 서브 코드 테이블(2017.11.30 추가 테이블)
 * @author 손가연
 *
 *  ms_code  -  subcode  -  sub_name

	회원
	1  -  0  -  일반유저
	1  -  1  -  최고 관리자
	1  -  2  -  일반 관리자
	
	상품
	2  -  0  -  정상상품(미사용)
	2  -  1  -  블락상품(사용)
	
	이벤트
	3  -  0  -  공지사항
	3  -  1  -  이벤트
	3  -  2  -  할인율 10%
	3  -  3  -  할인율 20%
	3  -  4  -  할인율 30%
	
	주문(배송코드)
	4  -  0  -  입금대기
	4  -  1  -  입금확인
	4  -  2  -  상품준비
	4  -  3  -  배송준비
	4  -  4  -  배송중
	4  -  5  -  배송완료
 */

public class SubcodeVO {
	private String ms_code;  /* 마스터코드	NOT NULL CHAR(1) */      
	private String sub_code; /* 서브코드	NOT NULL CHAR(1) */
	private String sub_name; /* 코드명	NOT NULL VARCHAR2(50) */
	
	
	public String getMs_code() {
		return ms_code;
	}
	public void setMs_code(String ms_code) {
		this.ms_code = ms_code;
	}
	public String getSub_code() {
		return sub_code;
	}
	public void setSub_code(String sub_code) {
		this.sub_code = sub_code;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	
	@Override
	public String toString() {
		return "SubcodeVO [ms_code=" + ms_code + ", sub_code=" + sub_code + ", sub_name=" + sub_name + "]";
	}
	
}
