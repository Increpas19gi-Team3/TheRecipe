package com.increpas.therecipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.increpas.therecipe.vo.FoodVO;
import com.increpas.therecipe.vo.FoodcodeVO;
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
	

	/**
	 * 지역관련 전체 리스트 가져오기
	 * @return List<FoodVO>
	 */
	public List<FoodVO> selectList(){
		
		return sqlSessionTemplate.selectList("local_ns.selectLocalList"); 
		
	}
	
	/**
	 * 중분별 리스트 가져오기
	 * @param kind : FC_1ST(대분류)
	 * @param local : FC_2ND(중분류)
	 * @return List<FoodVO>
	 */
	public List<FoodVO> selectLocalKindList(int kind, int local){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("kind", kind);
		map.put("local", local);
		
		return sqlSessionTemplate.selectList("local_ns.selectLocalKindList", map); 
		
	}
	
	/**
	 * 소분류별 리스트 select 서비스
	 * @param kind : FC_1ST(대분류)
	 * @param local : FC_2ND(중분류)
	 * @param item : FC_3RD(소분류)
	 * @return List<FoodVO>
	 */
	public List<FoodVO> selectLocalItemList(int kind, int local, int item){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("kind", kind);
		map.put("local", local);
		map.put("item", item);
		
		return sqlSessionTemplate.selectList("local_ns.selectLocalItemList", map); 
		
	}
	
	/**
	 * 음식명으로 검색하기
	 * @param fisrt : FC_1ST(대분류)
	 * @param second : FC_2ND(중분류)
	 * @param third : FC_3RD(소분류)
	 * @param title : 검생명
	 * @return List<FoodVO>
	 */
	public List<FoodVO> selectTitleList(int fisrt, int second, int third, String title){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("fisrt", fisrt);
		map.put("second", second);
		map.put("third", third);
		map.put("title", title);
				
		return sqlSessionTemplate.selectList("local_ns.searchTitleList", map); 
		
	}
	
	/**
	 * 음식코드로 음식정보 가져오기
	 * @param kind : FC_1ST(대분류)
	 * @param code : F_FDCODE(음식코드)
	 * @return FoodVO
	 */
	public FoodVO selectFood(int kind, String code){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("kind", kind);
		map.put("code", code);

		return sqlSessionTemplate.selectOne("local_ns.selectFoodCode", map); 
		
	}
	
	/**
	 * 음식코드로 등록된 리뷰 가져오기
	 * @param code : F_FDCODE(음식코드)
	 * @return List<ReviewVO>
	 */
	public List<ReviewVO> selectReview(String code){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("code", code);
		
		return sqlSessionTemplate.selectList("local_ns.selectReview", map); 
		
	}
	
	/**
	 * 장바구니에 상품 등록
	 * @param userID : 로그인한 유저ID
	 * @param fdcode : F_FDCODE(음식코드)
	 * @param buyPrice : 음식 가격
	 * @param amount : 구매수량
	 * @return int
	 */
	@Transactional
	public int insertBasket(String userID, String fdcode, int buyPrice, int amount){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("userID", userID);
		map.put("fdcode", fdcode);
		map.put("buyPrice", buyPrice);
		map.put("amount", amount);
		
		return sqlSessionTemplate.insert("local_ns.insertBasket", map); 
		
	}
	
	
	/**
	 * 대분류, 중분류, 소분류로 카테고리명
	 * @param fstcode : FC_1ST(대분류)
	 * @param sndcode : FC_2ND(중분류)
	 * @param trdcode : FC_3RD(소분류)
	 * @return List<FoodcodeVO>
	 */
	public List<FoodcodeVO> searchFoodCode(String fstcode, String sndcode, String trdcode){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("fstcode", fstcode);
		if(!sndcode.equals("0"))
			map.put("sndcode", sndcode);
		if(!trdcode.equals("0"))
			map.put("trdcode", trdcode);
		
		
		return sqlSessionTemplate.selectList("local_ns.searchFoodCode", map); 
		
	}
	
	
}
