package com.increpas.therecipe.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.vo.FoodcodeVO;

/**
 * 음식 코드 가져오기
 * @author 손가연
 *
 */
@Repository
public class AdminCategoryMgrDAO {
	
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
}
