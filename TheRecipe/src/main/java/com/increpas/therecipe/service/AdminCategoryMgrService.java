package com.increpas.therecipe.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

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
	 * 음식 코드(tr_foodcode) 가져오는 메소드
	 * @param model : Model
	 * @return : Model
	 */
	public Model getFoodcodeOnlyAll(Model model){
		// 개발용 Log
		String logMsg_01 = "getFoodcodeAll()";
		String logMsg_02 = "";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		//model.addAttribute("foodcodeAllList", adminCategoryMgrService.selectAllFoodcode());		
		model.addAttribute("foodcode1stList", select1stFoodcode());
		model.addAttribute("foodcode2ndList", select2ndFoodcode());
		model.addAttribute("foodcode3rdList", select3rdFoodcode());
		
		return model;
	}
	
	
	
	
	
	/**
	 * 전체 음식 코드(tr_foodcode + subQuery : tr_food count() ) 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> selectAllFoodcodeWithFoodCnt(){
		return adminCategoryMgrDAO.selectAllFoodcodeWithFoodCnt();
	}
	
	/**
	 * 1st 음식 코드(tr_foodcode + subQuery : tr_food count() ) 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> select1stFoodcodeWithFoodCnt(){
		return adminCategoryMgrDAO.select1stFoodcodeWithFoodCnt();
	}
	
	/**
	 * 2nd 음식 코드(tr_foodcode + subQuery : tr_food count() ) 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> selec2ndFoodcodeWithFoodCnt(){
		return adminCategoryMgrDAO.select2ndFoodcodeWithFoodCnt();
	}
	
	/**
	 * 3rd 음식 코드(tr_foodcode + subQuery : tr_food count() ) 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> selec3rdFoodcodeWithFoodCnt(){
		return adminCategoryMgrDAO.select3rdFoodcodeWithFoodCnt();
	}
	
	
	
	
	
	
	
	/**
	 * 전체 음식 코드 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> selectAllFoodcode(){
		return adminCategoryMgrDAO.selectAllFoodcode();
	}
	
	/**
	 * 1st 음식 코드 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> select1stFoodcode(){
		// 개발용 Log
				String logMsg_01 = "select1stFoodcode()=";
				String logMsg_02 = "";
				logger.info("▶▶▶>>>>>>>> Log : {}, {}", logMsg_01, logMsg_02);
				
		return adminCategoryMgrDAO.select1stFoodcode();
	}
	
	/**
	 * 2nd 음식 코드 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> select2ndFoodcode(){
		return adminCategoryMgrDAO.select2ndFoodcode();
	}
	
	/**
	 * 3rd 음식 코드 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> select3rdFoodcode(){
		return adminCategoryMgrDAO.select3rdFoodcode();
	}
	
	
	/**
	 * 선택한 2nd 음식 코드 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> selectSel2ndFoodcode(String fc_1st, String fc_2nd, String fc_3rd, String fc_ctgname, String fc_isblock){
		// 개발용 Log
		String logMsg_01 = "selectSel2ndFoodcode()=";
		String logMsg_02 = "";
		logger.info("▶▶▶>>>>>>>> Log : {}, {}", logMsg_01, "fc_1st="+fc_1st+", fc_2nd="+fc_2nd+", fc_3rd="+fc_3rd);
		
		return adminCategoryMgrDAO.selectSel2ndFoodcode(setFoodcodeVO(fc_1st, fc_2nd, fc_3rd, fc_ctgname, fc_isblock));
	}
	
	/**
	 * 선택한 3rd 음식 코드 가져오기
	 * @return : List<FoodcodeVO>
	 */
	public List<FoodcodeVO> selectSel3rdFoodcode(String fc_1st, String fc_2nd, String fc_3rd, String fc_ctgname, String fc_isblock){
		return adminCategoryMgrDAO.selectSel3rdFoodcode(setFoodcodeVO(fc_1st, fc_2nd, fc_3rd, fc_ctgname, fc_isblock));
	}
	
	
	/**
	 * 입력받은 변수들 FoodCode에 맞게 값 설정 하는 메소드
	 * @param String fc_1st : 대분류코드값
	 * @param String fc_2nd : 중분류코드값
	 * @param String fc_3rd : 소분류코드값
	 * @param String fc_ctgname : 분류 코드 이름
	 * @param String fc_isblock : 분류 코드 사용 여부(0:정상/블록:1)
	 * @return : FoodcodeVO
	 */
	public FoodcodeVO setFoodcodeVO(String fc_1st, String fc_2nd, String fc_3rd, String fc_ctgname, String fc_isblock){
		
		FoodcodeVO fcVO = new FoodcodeVO();
		fcVO.setFc_1st(Integer.parseInt(fc_1st));
		
		if(fc_2nd.contains("_")){
			String[] fc_2ndArr = fc_2nd.split("_");// 데이터가 1st_2nd 형태(구분자 '_')로 들어옴 예) 1_2
			fcVO.setFc_2nd(Integer.parseInt(fc_2ndArr[fc_2ndArr.length-1]));
		}else{
			fcVO.setFc_2nd(Integer.parseInt(fc_2nd));
		}
		
		if(fc_3rd.contains("_")){
			String[] fc_3rdArr = fc_3rd.split("_");// 데이터가 1st_2nd_3rd 형태(구분자 '_')로 들어옴 예) 1_2_3
			fcVO.setFc_3rd(Integer.parseInt(fc_3rdArr[fc_3rdArr.length-1]));
		}else{
			fcVO.setFc_3rd(Integer.parseInt(fc_3rd));
		}
		
		
		fcVO.setFc_ctgname(fc_ctgname);
		fcVO.setFc_isblock(fc_isblock);
		
		logger.debug("▶▶▶▶++++++++++++ Log : {}, {}", "AdminCategoryMgrService.setFoodcodeVO()", fcVO.toString());
		
		return fcVO;
	}
	
	
	/**
	 * 음식코드 등록, dao에 쿼리 요청
	 * @param String fc_1st : 대분류코드값
	 * @param String fc_2nd : 중분류코드값
	 * @param String fc_3rd : 소분류코드값
	 * @param String fc_ctgname : 분류 코드 이름
	 * @param String fc_isblock : 분류 코드 사용 여부(0:정상/블록:1)
	 */
	@Transactional
	public void insertFoodcode(String fc_1st, String fc_2nd, String fc_3rd, String fc_ctgname, String fc_isblock){
		
		adminCategoryMgrDAO.insertFoodcode(setFoodcodeVO(fc_1st, fc_2nd, fc_3rd, fc_ctgname, fc_isblock));
	}
	
	
	/**
	 * 음식 코드 수정
	 * @param String fc_1st : 대분류코드값
	 * @param String fc_2nd : 중분류코드값
	 * @param String fc_3rd : 소분류코드값
	 * @param String fc_ctgname : 분류 코드 이름
	 * @param String fc_isblock : 분류 코드 사용 여부(0:정상/블록:1)
	 */
	@Transactional
	public void updateFoodcode(String fc_1st, String fc_2nd, String fc_3rd, String fc_ctgname, String fc_isblock){
		
		adminCategoryMgrDAO.updateFoodcode(setFoodcodeVO(fc_1st, fc_2nd, fc_3rd, fc_ctgname, fc_isblock));
	}
		
}
