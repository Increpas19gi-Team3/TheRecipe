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
 * 관리자) 음식코드 등록관리 Query 제어
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
	 * 전체 음식 코드(tr_foodcode + subQuery : tr_food count() ) 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> selectAllFoodcodeWithFoodCnt(){
		return sqlSessionTemplate.selectList("adminFoodcode_ns.selectAllFoodcodeWithFoodCnt"); 
	}
	
	/**
	 * 1st 음식 코드(tr_foodcode + subQuery : tr_food count() ) 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> select1stFoodcodeWithFoodCnt(){
		return sqlSessionTemplate.selectList("adminFoodcode_ns.select1stFoodcodeWithFoodCnt"); 
	}
	
	/**
	 * 2nd 음식 코드(tr_foodcode + subQuery : tr_food count() ) 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> select2ndFoodcodeWithFoodCnt(){
		return sqlSessionTemplate.selectList("adminFoodcode_ns.select2ndFoodcodeWithFoodCnt"); 
	} 
	
	/**
	 * 3rd 음식 코드(tr_foodcode + subQuery : tr_food count() ) 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> select3rdFoodcodeWithFoodCnt(){
		return sqlSessionTemplate.selectList("adminFoodcode_ns.select3rdFoodcodeWithFoodCnt"); 
	}
	
	
	
	/**
	 * 전체 음식 코드 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> selectAllFoodcode(){
		return sqlSessionTemplate.selectList("adminFoodcode_ns.selectAllFoodcode"); 
	}
	
	/**
	 * 1st 음식 코드 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> select1stFoodcode(){
		return sqlSessionTemplate.selectList("adminFoodcode_ns.select1stFoodcode"); 
	}
	
	/**
	 * 2nd 음식 코드 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> select2ndFoodcode(){
		return sqlSessionTemplate.selectList("adminFoodcode_ns.select2ndFoodcode"); 
	} 
	
	/**
	 * 3rd 음식 코드 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> select3rdFoodcode(){
		return sqlSessionTemplate.selectList("adminFoodcode_ns.select3rdFoodcode"); 
	} 
	
	
	

	
	/**
	 * 선택한 2nd 음식 코드 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> selectSel2ndFoodcode(FoodcodeVO fcVO){
		// 개발용 Log
		String logMsg_01 = "selectSel2ndFoodcode()=";
		String logMsg_02 = "";
		logger.debug("▶▶▶▶++++++++++++ Log : {}, {}", "AdminCategoryMgrDAO.setFoodcodeVO()", fcVO.toString());
		
		
		List<FoodcodeVO> list = sqlSessionTemplate.selectList("adminFoodcode_ns.selectSel2ndFoodcode", fcVO);
		
		for(int i=0; i<list.size(); i++){
			System.out.println(i+"="+list.get(i).toString());
		}
		
		return list;
	} 
	
	/**
	 * 선택한 3rd 음식 코드 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> selectSel3rdFoodcode(FoodcodeVO fcVO){
		
		List<FoodcodeVO> list = sqlSessionTemplate.selectList("adminFoodcode_ns.selectSel3rdFoodcode", fcVO);
		
		for(int i=0; i<list.size(); i++){
			System.out.println(i+"="+list.get(i).toString());
		}
		
		return list; 
	} 
	
	
	
	
	
	
	
	
	/**
	 * 2nd Foodcode의 최고값 리턴
	 * @param : String foodcode1st 대분류코드값
	 * @return : int
	 */
	public int getMax2ndFoodcode(String foodcode1st){
		return sqlSessionTemplate.selectOne("adminFoodcode_ns.select2ndMax", foodcode1st);
	}
	
	
	/**
	 * 3rd Foodcode의 최고값 리턴
	 * @param : String foodcode1st 대분류코드값, String foodcode2st 중분류코드값
	 * @return : int
	 */
	public int getMax3rdFoodcode(String foodcode1st, String foodcode2st){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fc_1st", foodcode1st);
		map.put("fc_2nd", foodcode2st);
		
		return sqlSessionTemplate.selectOne("adminFoodcode_ns.select3rdMax", map);
	}
	
	
	/**
	 * 음식 코드 등록
	 * @param : FoodcodeVO
	 */
	public void insertFoodcode(FoodcodeVO fcVO){
		
		// 개발용 Log
		String logMsg_01 = "AdminCategoryMgrDAO";
		String logMsg_02 = "insertFoodcode()";
		logger.info("▶▶▶▶▶ DAO Log : {}, {}", logMsg_01, logMsg_02 +" " +fcVO.toString());
				
		
		if(fcVO.getFc_2nd() == 0){//2nd 등록
			sqlSessionTemplate.insert("adminFoodcode_ns.reg2ndFoodcode", fcVO);
		}else{//3rd 등록
			sqlSessionTemplate.insert("adminFoodcode_ns.reg3rdFoodcode", fcVO);
		}
	}
	
	
	/**
	 * 음식 코드 이름 수정
	 * @param : FoodcodeVO
	 */
	public void updateFoodcode(FoodcodeVO fcVO){
		
		// 개발용 Log
		String logMsg_01 = "AdminCategoryMgrDAO";
		String logMsg_02 = "updateFoodcode()";
		logger.info("▶▶▶▶▶ DAO Log : {}, {}", logMsg_01, logMsg_02 +" " +fcVO.toString());
		
		
		if(fcVO.getFc_3rd() == 0){//2nd 등록
			sqlSessionTemplate.update("adminFoodcode_ns.modify2ndFoodcode", fcVO);
			sqlSessionTemplate.update("adminFoodcode_ns.modify2ndTo3rdFoodcode", fcVO); //isblock 변경시 소속된 3rd 전부 isblock 값을 수정함
			
		}else{//3rd 등록
			sqlSessionTemplate.update("adminFoodcode_ns.modify3rdFoodcode", fcVO);
		}
	}
	
	
	
}
