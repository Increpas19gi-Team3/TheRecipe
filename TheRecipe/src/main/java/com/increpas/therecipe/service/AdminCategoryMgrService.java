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
	public void addFoodcode(String newCategory, String fc_ctgname){
				
		String[] CategoryArr = newCategory.split("_");//_ 로 파싱
		/*
		System.out.println(CategoryArr.toString());
		for(int i=0; i<CategoryArr.length; i++){
			System.out.println(">>>> CategoryArr["+i+"]="+CategoryArr[i]);
		}
		*/
		
		if(CategoryArr.length == 1){
			adminCategoryMgrDAO.insertFoodcode(CategoryArr[0], "", fc_ctgname);
		}else{
			adminCategoryMgrDAO.insertFoodcode(CategoryArr[0], CategoryArr[1], fc_ctgname);
		}
	}
}
