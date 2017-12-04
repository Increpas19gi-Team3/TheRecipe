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

	public List<AdminOrderVO> selectOrder(){

		return sqlSessionTemplate.selectList("admin_order.selectOrder"); 
		
	}
	
	public AdminOrderVO selectOrderBycode(String orderid){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("orderid", orderid);
		
		return sqlSessionTemplate.selectOne("admin_order.selectOrderBycode", map); 
		
	}
	
	@Transactional
	public int uptOrderStatus(String orderid, String dvystatus){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("orderid", orderid);
		map.put("dvystatus", dvystatus);
		
		return sqlSessionTemplate.update("admin_order.uptOrderStatus", map); 
		
	}
}
