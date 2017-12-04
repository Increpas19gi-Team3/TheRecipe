package com.increpas.therecipe.dto;

import java.util.ArrayList;
import java.util.List;

import com.increpas.therecipe.vo.UserMyBasketVO;

public class UserMyOrderDTO {
	
	private List<UserMyBasketVO> listVO;
	
	private String o_orderid;	/* 주문코드 	VARCHAR2(20) NOT NULL */
	private String d_status;	/* 배송상태		CHAR(1) NOT NULL */
	private int o_buyprice; 	/* 구입가격 	NUMBER NOT NULL */
	private int o_amount; 		/* 구매수량		NUMBER NOT NULL */
	private String o_orderdate; /* 주문날짜	DATE NOT NULL */
	private String o_reciever; 	/* 수취인		VARCHAR2(20) NOT NULL */
	private String o_dvypost; 	/* 배송지우편번호 VARCHAR2(20) NOT NULL */
	private String o_dvyaddr; 	/* 배송지주소 	VARCHAR2(100) NOT NULL */
	private String ms_code;		/* 마스터코드: 4	CHAR(1) */
	
	// DB의 저장된 전체글의 개수가 0일때 리턴할 게시글 모델
	public UserMyOrderDTO() {
			this(new ArrayList<UserMyBasketVO>(), "", "", 0,0,"", "","","","");
		}

	public UserMyOrderDTO(List<UserMyBasketVO> listVO,String o_orderid,String d_status,int o_buyprice,
			int o_amount,String o_orderdate, String o_reciever,String o_dvypost,String o_dvyaddr,String ms_code) {
			super();
			this.listVO = listVO;
			this.o_orderid=o_orderid;
			this.d_status=d_status ;	
			this.o_buyprice=o_buyprice; 	
			this.o_amount=o_amount; 		
			this.o_orderdate=o_orderdate; 
			this.o_reciever=o_reciever; 	
			this.o_dvypost=o_dvypost; 
			this.o_dvyaddr=o_dvyaddr; 
			this.ms_code=ms_code;			
		}

	public List<UserMyBasketVO> getListVO() {
		return listVO;
	}
	public void setListVO(List<UserMyBasketVO> listVO) {
		this.listVO = listVO;
	}
	public String getO_orderid() {
		return o_orderid;
	}
	public void setO_orderid(String o_orderid) {
		this.o_orderid = o_orderid;
	}
	public String getD_status() {
		return d_status;
	}
	public void setD_status(String d_status) {
		this.d_status = d_status;
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
	public String getO_orderdate() {
		return o_orderdate;
	}
	public void String(String o_orderdate) {
		this.o_orderdate = o_orderdate;
	}
	public String getO_reciever() {
		return o_reciever;
	}
	public void setO_reciever(String o_reciever) {
		this.o_reciever = o_reciever;
	}
	public String getO_dvypost() {
		return o_dvypost;
	}
	public void setO_dvypost(String o_dvypost) {
		this.o_dvypost = o_dvypost;
	}
	public String getO_dvyaddr() {
		return o_dvyaddr;
	}
	public void setO_dvyaddr(String o_dvyaddr) {
		this.o_dvyaddr = o_dvyaddr;
	}
	public String getMs_code() {
		return ms_code;
	}
	public void setMs_code(String ms_code) {
		this.ms_code = ms_code;
	}
	@Override
	public String toString() {
		return "UserMyOrderDTO [listVO=" + listVO + ", o_orderid=" + o_orderid + ", d_status=" + d_status
				+ ", o_buyprice=" + o_buyprice + ", o_amount=" + o_amount + ", o_orderdate=" + o_orderdate
				+ ", o_reciever=" + o_reciever + ", o_dvypost=" + o_dvypost + ", o_dvyaddr=" + o_dvyaddr + ", ms_code="
				+ ms_code + "]";
	}

	
}
