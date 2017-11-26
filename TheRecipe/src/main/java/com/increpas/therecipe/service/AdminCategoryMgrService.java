package com.increpas.therecipe.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
