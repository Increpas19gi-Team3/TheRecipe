package com.increpas.therecipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.vo.FoodMgrVO;
import com.increpas.therecipe.vo.FoodcodeVO;

/**
 * 관리자) 음식 등록관리 Query 제어
 * @author 손가연
 *
 */
@Repository
public class AdminFoodMgrDAO {
	
	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
		
		
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	/**
	 * 전체 등록 데이터 가져오기
	 * @return : List<FoodJoinFoodcodeVO>
	 */
	public List<FoodMgrVO> selectAdminFoodListAll(){
		return sqlSessionTemplate.selectList("adminFoodMgr_ns.selectAdminFoodListAll");
	}
	
	
	
	public List<FoodMgrVO> selectAdminFoodListSel(FoodcodeVO fcVO){
		return sqlSessionTemplate.selectList("adminFoodMgr_ns.selectAdminFoodListSel", fcVO);
	}
}
