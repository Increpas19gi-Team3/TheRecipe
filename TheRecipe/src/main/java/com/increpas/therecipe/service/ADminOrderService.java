package com.increpas.therecipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.AdminOrderDAO;
import com.increpas.therecipe.vo.AdminOrderVO;

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
	
	public List<AdminOrderVO> selectOrder(){
		
		return orderDAO.selectOrder();
	}
	
	public AdminOrderVO selectOrderBycode(String orderid){
		
		return orderDAO.selectOrderBycode(orderid);
	}
	
	public int uptOrderStatus(String orderid, String dvystatus){
		
		return orderDAO.uptOrderStatus(orderid, dvystatus);
	}
}
