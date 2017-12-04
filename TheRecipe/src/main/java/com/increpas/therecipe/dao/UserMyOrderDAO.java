package com.increpas.therecipe.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.vo.BasketVO;

/**
 *주문조회 후기등록 DAO
 * 
 * @author 박호진
 *
 */
@Repository
public class UserMyOrderDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	/*
	public List<BasketVO> findTitle(String f_fdcode){
		return sqlSessionTemplate.selectList("userorder_ns.findTitle", f_fdcode);
	}*/

}
