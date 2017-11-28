package com.increpas.therecipe.service;


import java.util.List;

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

	@Autowired
	AdminCategoryMgrDAO adminCategoryMgrDAO;
	
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
	 * 음식코드 파라미터 파싱, dao에 쿼리 요청
	 * @param newCategory
	 */
	@Transactional
	public void insertFoodcode(String newCategory, String fc_ctgname){
		
		String[] categoryArr = newCategory.split("_");//_ 로 파싱
		
		//FoodcodeVO 설정 세팅
		FoodcodeVO fcVO = new FoodcodeVO();
		if(categoryArr.length == 2){
			fcVO.setFc_2nd(Integer.parseInt(categoryArr[1]));
		}
		fcVO.setFc_1st(Integer.parseInt(categoryArr[0]));
		fcVO.setFc_ctgname(fc_ctgname);
		System.out.println("fcVO.toString()="+fcVO.toString());
		
		
		adminCategoryMgrDAO.insertFoodcode(fcVO);
	}
	
	
	/**
	 * 음식 코드 수정
	 * @param newCategory
	 * @param fc_ctgname
	 */
	@Transactional
	public void updateFoodcode(String modifyCategory, String fc_ctgname){
		
		System.out.println(">>>> modifyCategory="+modifyCategory);
		
		String[] categoryArr = modifyCategory.split("_");//_ 로 파싱
		System.out.println(">>>> categoryArr.length="+categoryArr.length);
		
		//FoodcodeVO 설정 세팅
		FoodcodeVO fcVO = new FoodcodeVO();
		if(categoryArr.length == 3){
			fcVO.setFc_3rd(Integer.parseInt(categoryArr[2]));
		}
		fcVO.setFc_1st(Integer.parseInt(categoryArr[0]));
		fcVO.setFc_2nd(Integer.parseInt(categoryArr[1]));
		fcVO.setFc_ctgname(fc_ctgname);
		System.out.println("updateFoodcode() :: fcVO.toString()="+fcVO.toString());
		
		
		adminCategoryMgrDAO.updateFoodcode(fcVO);
	}
	
	
	public int checkBeforDelete(FoodcodeVO fcVO){
		
		//adminCategoryMgrDAO.
		
		return 0;
	}
	
}
