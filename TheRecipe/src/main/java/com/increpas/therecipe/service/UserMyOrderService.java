package com.increpas.therecipe.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.UserMyOrderDAO;
import com.increpas.therecipe.vo.BasketVO;

/**
 *주문조회 후기등록 서비스
 * 
 * @author 박호진
 *
 */

@Service
public class UserMyOrderService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
/*	@Autowired
	UserMyOrderDAO userMyOrderDAO;
	public List<BasketVO> findTitle(String f_fdcode){
		return userMyOrderDAO.findTitle(f_fdcode);
		
	};*/

}
