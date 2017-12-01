package com.increpas.therecipe.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.vo.BasketVO;

/**
 * 장바구니보기 주문조회 후기등록 관련 DAO
 * @author 박호진
 *
 */

@Repository
public class UserMyDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<BasketVO> selectBasket(String m_userid) {
		
		return sqlSessionTemplate.selectList("userbasket_ns.selectBasket", m_userid);
	}

}
