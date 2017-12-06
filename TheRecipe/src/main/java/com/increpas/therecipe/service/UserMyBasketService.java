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
 * 
 * @author 박호진
 *
 */

@Service
public class UserMyBasketService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	UserMyBasketDAO userMyDAO;

	/**
	 * 장바구니 등록 상품 보기 동작 수행
	 * 
	 * @param m_userid 아이디
	 * @return m_userid
	 */
	public List<UserMyBasketVO> selectBasket(String m_userid) {
		return userMyDAO.selectBasket(m_userid);

	}

	/**
	 * 장바구니 삭제
	 * 
	 * @param m_userid 아이디
	 * @param f_fdcode 상품코드
	 */
	public void deleteBasket(String m_userid, String f_fdcode) {
		userMyDAO.deleteBasket(m_userid, f_fdcode);
	}

}
