package com.increpas.therecipe.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.vo.EventNoticeRegVO;
import com.increpas.therecipe.vo.ReviewVO;

/**
 * 관리자 답글(등록, 수정, 삭제)에 대한 DAO
 * @author 손대성
 *
 */
@Repository
public class ReviewUpdateDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
		
	/**
	 * 관리자의 답변 등록(사실은 수정)
	 * @param rVo
	 */
	public void ReviewRegUpDAO(ReviewVO rVo) {
		System.out.println("3. 관리자 답변 등록(수정)  : rVo.toString() : " + rVo.toString());			
		sqlSessionTemplate.update("review_ns.reviewAdminRegUp", rVo);		
	}
	
	/**
	 * 관리자의 답변 삭제(사실은 수정)
	 * @param rVo
	 */
	public void ReviewDeleteDAO(String r_rvcode) {
		System.out.println("3. 관리자 답변 삭제(수정)  : r_rvcode : " + r_rvcode);			
		sqlSessionTemplate.update("review_ns.reviewAdminDelete", r_rvcode);		
	}

	/**
	 * 리뷰 작성 동작 수행
	 * @param rVo
	 */
	public void reviewWrite(ReviewVO rVo) {
		
		 sqlSessionTemplate.insert("review_ns.reviewWrite", rVo);
	}

	
	
}
