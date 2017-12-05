package com.increpas.therecipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.increpas.therecipe.vo.AdminOrderVO;

/**
 * 
 * 관리자 주문 관리 DAO
 * @author 김지현
 *
 */
@Repository
public class AdminOrderDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 주문 내역 조회
	 * @return List<AdminOrderVO>
	 */
	public List<AdminOrderVO> selectOrder(){

		return sqlSessionTemplate.selectList("admin_order.selectOrder"); 
		
	}
	
	/**
	 * 주문코드로 특정 주문 내역 조회
	 * @param orderid : 주문코드
	 * @return AdminOrderVO
	 */
	public AdminOrderVO selectOrderBycode(String orderid){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("orderid", orderid);
		
		return sqlSessionTemplate.selectOne("admin_order.selectOrderBycode", map); 
		
	}
	
	/**
	 * 주문내역의 배송 상태 업데이트
	 * @param orderid : 주문코드
	 * @param dvystatus : 배송상태
	 * @return int
	 */
	@Transactional
	public int uptOrderStatus(String orderid, String dvystatus){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("orderid", orderid);
		map.put("dvystatus", dvystatus);
		
		return sqlSessionTemplate.update("admin_order.uptOrderStatus", map); 
		
	}
}
