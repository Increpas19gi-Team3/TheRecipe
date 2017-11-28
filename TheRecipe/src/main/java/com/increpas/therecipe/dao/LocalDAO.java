package com.increpas.therecipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.increpas.therecipe.vo.FoodVO;
import com.increpas.therecipe.vo.ReviewVO;



/**
 * 
 * 지역 관련 DAO
 * @author 김지현
 *
 */


@Repository
public class LocalDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public List<FoodVO> selectList(){
		
		return sqlSessionTemplate.selectList("local_ns.selectLocalList"); 
		
	}
	
	public List<FoodVO> selectLocalKindList(int kind, int local){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("kind", kind);
		map.put("local", local);
		
		return sqlSessionTemplate.selectList("local_ns.selectLocalKindList", map); 
		
	}
	
	//
	public List<FoodVO> selectTitleList(int kind, String title){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("kind", kind);
		map.put("title", title);
				
		return sqlSessionTemplate.selectList("local_ns.searchTitleList", map); 
		
	}
	
	public FoodVO selectFood(int kind, String code){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("kind", kind);
		map.put("code", code);

		return sqlSessionTemplate.selectOne("local_ns.selectFoodCode", map); 
		
	}
	
	public List<ReviewVO> selectReview(String code){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("code", code);
		
		return sqlSessionTemplate.selectList("local_ns.selectReview", map); 
		
	}
	
	@Transactional
	public int insertBasket(String userID, String fdcode, int buyPrice, int amount){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("userID", userID);
		map.put("fdcode", fdcode);
		map.put("buyPrice", buyPrice);
		map.put("amount", amount);
		
		return sqlSessionTemplate.insert("local_ns.insertBasket", map); 
		
	}
	
}
