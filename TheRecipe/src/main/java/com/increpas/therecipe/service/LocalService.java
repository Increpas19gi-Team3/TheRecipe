package com.increpas.therecipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.LocalDAO;
import com.increpas.therecipe.vo.FoodVO;
import com.increpas.therecipe.vo.FoodcodeVO;
import com.increpas.therecipe.vo.ReviewVO;

/**
 * 
 * 지역 관련 service
 * @author 김지현
 *
 */

@Service
public class LocalService {
	@Autowired
	LocalDAO lDao;
	
	/**
	 * 지역관련 전체 리스트 select 서비스
	 * @return List<FoodVO>
	 */
	public List<FoodVO> selectAllList(){
		
		return lDao.selectList();
	}
	
	/**
	 * 지역>종류별 리스트 select 서비스
	 * @param kind : FC_1ST(대분류)
	 * @param local : FC_2ND(중분류)
	 * @return List<FoodVO>
	 */
	public List<FoodVO> selectKindList(int kind, int local){
		
		return lDao.selectLocalKindList(kind, local);
	}
	
	/**
	 * 음식명으로 검색하기
	 * @param kind : FC_1ST(대분류)
	 * @param title : 검생명
	 * @return List<FoodVO>
	 */
	public List<FoodVO> selectTitleList(int kind, String title){
		
		return lDao.selectTitleList(kind, title);
	}
	
	/**
	 * 음식코드로 음식정보 가져오기
	 * @param kind : FC_1ST(대분류)
	 * @param code : F_FDCODE(음식코드)
	 * @return FoodVO
	 */
	public FoodVO selectFood(int kind, String code){
		
		return lDao.selectFood(kind, code);
	}
	
	/**
	 * 음식코드로 등록된 리뷰 가져오기
	 * @param code : F_FDCODE(음식코드)
	 * @return List<ReviewVO>
	 */
	public List<ReviewVO> selectReview(String code){
		
		return lDao.selectReview(code);
	}
	
	/**
	 * 장바구니에 상품 등록
	 * @param userID : 로그인한 유저ID
	 * @param fdcode : F_FDCODE(음식코드)
	 * @param buyPrice : 음식 가격
	 * @param amount : 구매수량
	 * @return int
	 */
	public int insertBasket(String userID, String fdcode, int buyPrice, int amount){
		
		return lDao.insertBasket(userID, fdcode, buyPrice, amount);
	}
	
	/**
	 * 대분류, 중분류, 소분류로 카테고리명
	 * @param fstcode : FC_1ST(대분류)
	 * @param sndcode : FC_2ND(중분류)
	 * @param trdcode : FC_3RD(소분류)
	 * @return List<FoodcodeVO>
	 */
	public List<FoodcodeVO> searchFoodCode(String fstcode, String sndcode, String trdcode){
		
		return lDao.searchFoodCode(fstcode,sndcode,trdcode);
	}
}
