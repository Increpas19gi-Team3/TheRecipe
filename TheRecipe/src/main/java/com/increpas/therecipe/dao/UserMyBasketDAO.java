package com.increpas.therecipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	/**
	 * 장바구니 등록 상품 보기 동작 수행
	 * @param m_userid 아이디
	 * @return m_userid
	 */
	public List<UserMyBasketVO> selectBasket(String m_userid) {
		
		return sqlSessionTemplate.selectList("userbasket_ns.selectBasket", m_userid);
	}

	/**
	 * 장바구니 삭제 동작 수행
	 * @param m_userid 아이디
	 * @param f_fdcode 상품코드
	 */
	public void deleteBasket(String m_userid,String f_fdcode) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("m_userid", m_userid);
		map.put("f_fdcode", f_fdcode);
		// TODO Auto-generated method stub
		 sqlSessionTemplate.delete("userbasket_ns.deleteBasket", map);
	}



}
