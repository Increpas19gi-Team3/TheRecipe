package com.increpas.therecipe.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.UserMyOrderDAO;
import com.increpas.therecipe.vo.MyOrderVO;
import com.increpas.therecipe.vo.OrderVO;

/**
 *주문조회 서비스
 * 
 * @author 박호진
 *
 */

@Service
public class UserMyOrderService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	UserMyOrderDAO userMyOrderDAO;
	/**
	 * 내 주문 등록 동작 수행
	 * @param odVo OrderVO
	 */
	public void insertOrder(OrderVO odVo) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+odVo.toString());
		userMyOrderDAO.insertOrder(odVo);
		
	}
	/**
	 * 내 주문 보기
	 * @param m_userid 아이디
	 * @return m_userid
	 */
	public List<MyOrderVO> selectMyOrder(String m_userid) {	
		return userMyOrderDAO.selectMyOrder(m_userid); 
	}

	/**
	 * 내 주문 상세 보기 동작 수행
	 * @param o_orderid 주문코드
	 * @return o_orderid
	 */
	public MyOrderVO selectMyOrderDetail(String o_orderid) {
		return userMyOrderDAO.selectMyOrderDetail(o_orderid); 
	}


}
