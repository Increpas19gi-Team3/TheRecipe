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
	
	/**
	 * 주문 내역 조회
	 * @return List<AdminOrderVO>
	 */
	public List<AdminOrderVO> selectOrder(){
		
		return orderDAO.selectOrder();
	}
	
	/**
	 * 주문코드로 특정 주문 내역 조회
	 * @param orderid : 주문코드
	 * @return AdminOrderVO
	 */
	public AdminOrderVO selectOrderBycode(String orderid){
		
		return orderDAO.selectOrderBycode(orderid);
	}
	
	/**
	 * 주문내역의 배송 상태 업데이트
	 * @param orderid : 주문코드
	 * @param dvystatus : 배송상태
	 * @return int
	 */
	public int uptOrderStatus(String orderid, String dvystatus){
		
		return orderDAO.uptOrderStatus(orderid, dvystatus);
	}
}
