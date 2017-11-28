package com.increpas.therecipe.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.increpas.therecipe.dao.AdminCategoryMgrDAO;
import com.increpas.therecipe.vo.FoodcodeVO;

/**
 * 음식 코드를 관리하기 위한 Service 
 * @author 손가연
 *
 */
@Service
public class AdminCategoryMgrService {

	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	AdminCategoryMgrDAO adminCategoryMgrDAO;
	
	
	
	/**
	 * 전체 음식 코드(tr_foodcode + subQuery : tr_food count() ) 가져오기
	 * @return
	 */
	public List<FoodcodeVO> selectAllFoodcodeWithFoodCnt(){
		return adminCategoryMgrDAO.selectAllFoodcodeWithFoodCnt();
	}
	
	/**
	 * 1st 음식 코드(tr_foodcode + subQuery : tr_food count() ) 가져오기
	 * @return
	 */
	public List<FoodcodeVO> select1stFoodcodeWithFoodCnt(){
		return adminCategoryMgrDAO.select1stFoodcodeWithFoodCnt();
	}
	
	/**
	 * 2nd 음식 코드(tr_foodcode + subQuery : tr_food count() ) 가져오기
	 * @return
	 */
	public List<FoodcodeVO> selec2ndFoodcodeWithFoodCnt(){
		return adminCategoryMgrDAO.select2ndFoodcodeWithFoodCnt();
	}
	
	/**
	 * 3rd 음식 코드(tr_foodcode + subQuery : tr_food count() ) 가져오기
	 * @return
	 */
	public List<FoodcodeVO> selec3rdFoodcodeWithFoodCnt(){
		return adminCategoryMgrDAO.select3rdFoodcodeWithFoodCnt();
	}
	
	
	
	
	
	
	
	/**
	 * 전체 음식 코드 가져오기
	 * @return
	 */
	public List<FoodcodeVO> selectAllFoodcode(){
		return adminCategoryMgrDAO.selectAllFoodcode();
	}
	
	/**
	 * 1st 음식 코드 가져오기
	 * @return
	 */
	public List<FoodcodeVO> select1stFoodcode(){
		return adminCategoryMgrDAO.select1stFoodcode();
	}
	
	/**
	 * 2nd 음식 코드 가져오기
	 * @return
	 */
	public List<FoodcodeVO> selec2ndFoodcode(){
		return adminCategoryMgrDAO.select2ndFoodcode();
	}
	
	/**
	 * 3rd 음식 코드 가져오기
	 * @return
	 */
	public List<FoodcodeVO> selec3rdFoodcode(){
		return adminCategoryMgrDAO.select3rdFoodcode();
	}
	
	
	/**
	 * 입력받은 변수들 FoodCode에 맞게 값 설정 하는 메소드
	 * @param fc_1st
	 * @param fc_2nd
	 * @param fc_3rd
	 * @param fc_ctgname
	 * @param fc_isblock
	 * @return
	 */
	public FoodcodeVO setFoodcodeVO(String fc_1st, String fc_2nd, String fc_3rd, String fc_ctgname, String fc_isblock){
		
		FoodcodeVO fcVO = new FoodcodeVO();
		fcVO.setFc_1st(Integer.parseInt(fc_1st));
		
		String[] fc_2ndArr = fc_2nd.split("_");// 데이터가 1st_2nd 형태(구분자 '_')로 들어옴 예) 1_2
		fcVO.setFc_2nd(Integer.parseInt(fc_2ndArr[fc_2ndArr.length-1]));
		
		String[] fc_3rdArr = fc_3rd.split("_");// 데이터가 1st_2nd_3rd 형태(구분자 '_')로 들어옴 예) 1_2_3
		fcVO.setFc_3rd(Integer.parseInt(fc_3rdArr[fc_3rdArr.length-1]));
		
		fcVO.setFc_ctgname(fc_ctgname);
		fcVO.setFc_isblock(fc_isblock);
		
		logger.debug("▶▶▶▶ Log : {}, {}", "AdminCategoryMgrService.setFoodcodeVO()", fcVO.toString());
		
		return fcVO;
	}
	
	
	/**
	 * 음식코드 등록, dao에 쿼리 요청
	 * @param newCategory
	 */
	@Transactional
	public void insertFoodcode(String fc_1st, String fc_2nd, String fc_3rd, String fc_ctgname, String fc_isblock){
		
		adminCategoryMgrDAO.insertFoodcode(setFoodcodeVO(fc_1st, fc_2nd, fc_3rd, fc_ctgname, fc_isblock));
	}
	
	
	/**
	 * 음식 코드 수정
	 * @param newCategory
	 * @param fc_ctgname
	 * ★★★★★★ 2nd code 가 블록일때 하부 3rd도 블록으로 변경해야 하는지 회의 필요함.
	 */
	@Transactional
	public void updateFoodcode(String fc_1st, String fc_2nd, String fc_3rd, String fc_ctgname, String fc_isblock){
		
		adminCategoryMgrDAO.updateFoodcode(setFoodcodeVO(fc_1st, fc_2nd, fc_3rd, fc_ctgname, fc_isblock));
	}
	
	public FoodcodeVO setFoodCodeVO(){
		return new FoodcodeVO();
	}
	
}
