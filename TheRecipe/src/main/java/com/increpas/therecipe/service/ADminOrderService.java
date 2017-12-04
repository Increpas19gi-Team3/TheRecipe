package com.increpas.therecipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.AdminOrderDAO;
import com.increpas.therecipe.dao.LocalDAO;
import com.increpas.therecipe.vo.FoodVO;
import com.increpas.therecipe.vo.FoodcodeVO;
import com.increpas.therecipe.vo.OrderVO;
import com.increpas.therecipe.vo.ReviewVO;

/**
 * 
 * 관리자 주문 관리 service
 * @author 김지현
 *
 */

@Service
public class ADminOrderService {
	@Autowired
	AdminOrderDAO orderDAO;
	
	public List<OrderVO> selectOrder(){
		
		return orderDAO.selectOrder();
	}
	
	public OrderVO selectOrderBycode(String orderid){
		
		return orderDAO.selectOrderBycode(orderid);
	}
}
