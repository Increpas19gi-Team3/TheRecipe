package com.increpas.therecipe.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.UserMyBasketDAO;
import com.increpas.therecipe.vo.UserMyBasketVO;

/**
 * 장바구니보기 주문조회 후기등록 관련 서비스
 * @author 박호진
 *
 */

@Service
public class UserMyBasketService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	UserMyBasketDAO userMyDAO;
	public List<UserMyBasketVO> selectBasket(String m_userid) {
		return userMyDAO.selectBasket(m_userid);
		
	}
	

	public void deleteBasket(String m_userid,String f_fdcode) {
		 userMyDAO.deleteBasket(m_userid,f_fdcode);
	}

}
