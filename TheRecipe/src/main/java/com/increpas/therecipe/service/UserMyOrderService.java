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
	
	public void insertOrder(OrderVO odVo) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+odVo.toString());
		userMyOrderDAO.insertOrder(odVo);
		
	}

	public List<MyOrderVO> selectMyOrder(String m_userid) {	
		return userMyOrderDAO.selectMyOrder(m_userid); 
	}

	public MyOrderVO selectMyOrderDetail(String o_orderid) {
		return userMyOrderDAO.selectMyOrderDetail(o_orderid); 
	}


}
