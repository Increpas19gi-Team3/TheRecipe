package com.increpas.therecipe.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.vo.MyOrderVO;
import com.increpas.therecipe.vo.OrderVO;

/**
 *주문조회  DAO
 * 
 * @author 박호진
 *
 */
@Repository
public class UserMyOrderDAO {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;


	public void insertOrder(OrderVO odVo) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+odVo.toString());
		sqlSessionTemplate.insert("order_ns.insertOrder", odVo);
		
	}


	public List<MyOrderVO> selectMyOrder(String m_userid) {
		return sqlSessionTemplate.selectList("order_ns.selectMyOrder", m_userid);
	}

}
