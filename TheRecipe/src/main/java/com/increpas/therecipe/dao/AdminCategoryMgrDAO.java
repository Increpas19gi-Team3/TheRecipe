package com.increpas.therecipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.service.AdminCategoryMgrService;
import com.increpas.therecipe.vo.FoodcodeVO;

/**
 * 음식 코드 가져오기
 * @author 손가연
 *
 */
@Repository
public class AdminCategoryMgrDAO {
	
	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
		
		
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 전체 음식 코드 가져오기
	 * @return
	 */
	public List<FoodcodeVO> selectAllFoodcode(){
		return sqlSessionTemplate.selectList("foodcode_ns.selectAllFoodcode"); 
	}
	
	/**
	 * 1st 음식 코드 가져오기
	 * @return
	 */
	public List<FoodcodeVO> select1stFoodcode(){
		return sqlSessionTemplate.selectList("foodcode_ns.select1stFoodcode"); 
	}
	
	/**
	 * 2nd 음식 코드 가져오기
	 * @return
	 */
	public List<FoodcodeVO> select2ndFoodcode(){
		return sqlSessionTemplate.selectList("foodcode_ns.select2ndFoodcode"); 
	} 
	
	/**
	 * 3rd 음식 코드 가져오기
	 * @return
	 */
	public List<FoodcodeVO> select3rdFoodcode(){
		return sqlSessionTemplate.selectList("foodcode_ns.select3rdFoodcode"); 
	} 
	
	/**
	 * 2nd Foodcode의 최고값 리턴
	 * @param Foodcode1st
	 * @return
	 */
	public int getMax2ndFoodcode(String foodcode1st){
		return sqlSessionTemplate.selectOne("foodcode_ns.select2ndMax", foodcode1st);
	}
	
	/**
	 * 3rd Foodcode의 최고값 리턴
	 * @param Foodcode2st
	 * @return
	 */
	public int getMax3rdFoodcode(String foodcode1st, String foodcode2st){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fc_1st", foodcode1st);
		map.put("fc_2nd", foodcode2st);
		
		return sqlSessionTemplate.selectOne("foodcode_ns.select3rdMax", map);
	}
	
	/**
	 * 음식 코드 등록
	 * @param fcVO
	 */
	public void insertFoodcode(FoodcodeVO fcVO){
		
		// 개발용 Log
		String logMsg_01 = "AdminCategoryMgrDAO";
		String logMsg_02 = "insertFoodcode()";
		logger.info("▶▶▶▶▶ DAO Log : {}, {}", logMsg_01, logMsg_02 +" " +fcVO.toString());
				
		
		if(fcVO.getFc_2nd() == 0){//2nd 등록
			sqlSessionTemplate.selectOne("foodcode_ns.reg2ndFoodcode", fcVO);
		}else{//3rd 등록
			sqlSessionTemplate.selectOne("foodcode_ns.reg3rdFoodcode", fcVO);
		}
	}
	
	
}
