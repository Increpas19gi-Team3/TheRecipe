package com.increpas.therecipe.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.increpas.therecipe.dao.AdminFoodMgrDAO;
import com.increpas.therecipe.vo.FoodJoinFoodcodeJoinEventVO;

/**
 * 관리자) 음식 관리 하기 위한 Service 
 * @author 손가연
 *
 */
@Service
public class AdminFoodMgrService {

	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	AdminFoodMgrDAO adminFoodMgrDAO;
	
	
	/**
	 * 전체 등록 데이터 가져오기
	 * @return : List<FoodJoinFoodcodeVO>
	 */
	public List<FoodJoinFoodcodeJoinEventVO> selectAdminFoodListAll(){
		return adminFoodMgrDAO.selectAdminFoodListAll();
	}
	
		
}
