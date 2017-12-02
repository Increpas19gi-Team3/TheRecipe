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
	 * 대분류별 리스트 가져오기
	 * @param large : FC_1ST(대분류)
	 * @param startNum : 페이징 처리를 위한 ROWNUM
	 * @param endNum : 페이징 처리를 위한 ROWNUM
	 * @return List<FoodVO>
	 */
	public List<FoodVO> selectList(int large, int medium, int small, int startNum, int endNum){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("large", large);
		if(medium!=0)
			map.put("medium", medium);
		if(small!=0)
			map.put("small", small);
		map.put("startNum", startNum);
		map.put("endNum", endNum);

		System.out.println("KJH TEST >>>>>>>>>>>>> " + large+","+startNum+","+endNum);
		return sqlSessionTemplate.selectList("local_ns.selectLocalList", map); 
		
	}
	
	/**
	 * 대분류 음식 카운트 가져오기
	 * @param large : FC_1ST(대분류)
	 * @return int
	 */
	public int selectLargeCount(int large, int medium, int small){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("large", large);
		map.put("medium", medium);
		map.put("small", small);
		
		return sqlSessionTemplate.selectOne("local_ns.selectLargeCount", map); 
		
	}
	
	/**
	 * 중분별 리스트 가져오기
	 * @param large : FC_1ST(대분류)
	 * @param medium : FC_2ND(중분류)
	 * @param startNum : 페이징 처리를 위한 ROWNUM
	 * @param endNum : 페이징 처리를 위한 ROWNUM
	 * @return List<FoodVO>
	 */
	public List<FoodVO> selectLocalKindList(int large, int medium, int startNum, int endNum){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("large", large);
		map.put("medium", medium);
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return sqlSessionTemplate.selectList("local_ns.selectLocalKindList", map); 
		
	}
	
	/**
	 * 중분류 음식 카운트 가져오기
	 * @param large : FC_1ST(대분류)
	 * @param medium : FC_2ND(중분류)
	 * @return int
	 */
	public int selectMediumCount(int large, int medium){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("large", large);
		map.put("medium", medium);
		
		return sqlSessionTemplate.selectOne("local_ns.selectMediumCount", map); 
		
	}
	
	/**
	 * 소분류별 리스트 select 서비스
	 * @param large : FC_1ST(대분류)
	 * @param medium : FC_2ND(중분류)
	 * @param small : FC_3RD(소분류)
	 * @param startNum : 페이징 처리를 위한 ROWNUM
	 * @param endNum : 페이징 처리를 위한 ROWNUM
	 * @return List<FoodVO>
	 */
	public List<FoodVO> selectLocalItemList(int large, int medium, int small, int startNum, int endNum){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("large", large);
		map.put("medium", medium);
		map.put("small", small);
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return sqlSessionTemplate.selectList("local_ns.selectLocalItemList", map); 
		
	}
	
	/**
	 * 소분류 음식 카운트 가져오기
	 * @param large : FC_1ST(대분류)
	 * @param medium : FC_2ND(중분류)
	 * @param small : FC_3RD(소분류)
	 * @return int
	 */
	public int selectSmallCount(int large, int medium, int small){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("large", large);
		map.put("medium", medium);
		map.put("small", small);
		
		return sqlSessionTemplate.selectOne("local_ns.selectSmallCount", map); 
		
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
	 * @param large : FC_1ST(대분류)
	 * @param code : F_FDCODE(음식코드)
	 * @return FoodVO
	 */
	public FoodVO selectFood(int large, String code){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("large", large);
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
	 * 장바구니 상품 수량 증가
	 * @param userID : 로그인한 유저ID
	 * @param fdcode : F_FDCODE(음식코드)
	 * @param amount : 구매수량
	 * @return int
	 */
	@Transactional
	public int updateBasket(String userID, String fdcode, int amount){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("userID", userID);
		map.put("fdcode", fdcode);
		map.put("amount", amount);
		
		return sqlSessionTemplate.insert("local_ns.updateBasket", map); 
		
	}
	
	/**
	 * 장바구니에 이미 등록된 상품인지 조회
	 * @param userID : 로그인한 유저ID
	 * @param fdcode : F_FDCODE(음식코드)
	 * @return int
	 */
	public int selectExist(String userID, String fdcode){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("userID", userID);
		map.put("fdcode", fdcode);
		
		return sqlSessionTemplate.selectOne("local_ns.selectExist", map); 
		
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
