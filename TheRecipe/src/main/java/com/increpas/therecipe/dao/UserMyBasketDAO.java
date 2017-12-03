package com.increpas.therecipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.vo.BasketVO;
import com.increpas.therecipe.vo.UserMyBasketVO;


/**
 * 장바구니보기 주문조회 후기등록 관련 DAO
 * @author 박호진
 *
 */

@Repository
public class UserMyBasketDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<UserMyBasketVO> selectBasket(String m_userid) {
		
		return sqlSessionTemplate.selectList("userbasket_ns.selectBasket", m_userid);
	}

	public void deleteBasket(String m_userid,String f_fdcode) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("m_userid", m_userid);
		map.put("f_fdcode", f_fdcode);
		// TODO Auto-generated method stub
		 sqlSessionTemplate.delete("userbasket_ns.deleteBasket", map);
	}



}
