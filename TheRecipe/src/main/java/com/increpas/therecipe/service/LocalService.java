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
	 * 대분류별 리스트 select 서비스
	 * @param large : FC_1ST(대분류)
	 * @param startNum : 페이징 처리를 위한 ROWNUM
	 * @param endNum : 페이징 처리를 위한 ROWNUM
	 * @return List<FoodVO>
	 */
	public List<FoodVO> selectAllList(int large, int medium, int small, int startNum, int endNum){
		
		return lDao.selectList(large,medium,small,startNum,endNum);
	}
	
	/**
	 * 대분류 음식 카운트 가져오기
	 * @param large : FC_1ST(대분류)
	 * @return int
	 */
	public int selectLargeCount(int large, int medium, int small){
		
		return lDao.selectLargeCount(large,medium,small);
	}
	
	/**
	 * 중분류별 리스트 select 서비스
	 * @param large : FC_1ST(대분류)
	 * @param medium : FC_2ND(중분류)
	 * @param startNum : 페이징 처리를 위한 ROWNUM
	 * @param endNum : 페이징 처리를 위한 ROWNUM
	 * @return List<FoodVO>
	 */
	public List<FoodVO> selectKindList(int large, int medium, int startNum, int endNum){
		
		return lDao.selectLocalKindList(large, medium,startNum,endNum);
	}
	
	/**
	 * 중분류 음식 카운트 가져오기
	 * @param large : FC_1ST(대분류)
	 * @param medium : FC_2ND(중분류)
	 * @return int
	 */
	public int selectMediumCount(int large, int medium){
		
		return lDao.selectMediumCount(large, medium);
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
	public List<FoodVO> selectItemList(int large, int medium, int small, int startNum, int endNum){
		
		return lDao.selectLocalItemList(large, medium, small,startNum,endNum);
	}
	
	/**
	 * 소분류 음식 카운트 가져오기
	 * @param large : FC_1ST(대분류)
	 * @param medium : FC_2ND(중분류)
	 * @param small : FC_3RD(소분류)
	 * @return int
	 */
	public int selectSmallCount(int large, int medium, int small){
		
		return lDao.selectSmallCount(large, medium, small);
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
		
		return lDao.selectTitleList(fisrt, second, third, title);
	}
	
	/**
	 * 음식코드로 음식정보 가져오기
	 * @param large : FC_1ST(대분류)
	 * @param code : F_FDCODE(음식코드)
	 * @return FoodVO
	 */
	public FoodVO selectFood(int large, String code){
		
		return lDao.selectFood(large, code);
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
	 * 장바구니 상품 수량 증가
	 * @param userID : 로그인한 유저ID
	 * @param fdcode : F_FDCODE(음식코드)
	 * @param amount : 구매수량
	 * @return int
	 */
	public int updateBasket(String userID, String fdcode, int amount){
		
		return lDao.updateBasket(userID, fdcode, amount);
	}
	
	/**
	 * 장바구니에 이미 등록된 상품인지 조회
	 * @param userID : 로그인한 유저ID
	 * @param fdcode : F_FDCODE(음식코드)
	 * @return int
	 */
	public int selectExist(String userID, String fdcode){
		
		return lDao.selectExist(userID, fdcode);
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
