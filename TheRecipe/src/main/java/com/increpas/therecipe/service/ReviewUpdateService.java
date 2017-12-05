package com.increpas.therecipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.ReviewUpdateDAO;
import com.increpas.therecipe.vo.ReviewVO;

/**
 * 관리자의 답변(등록, 수정, 삭제)을 관리하기 위한 Service  
 * @author 손대성
 *
 */
@Service
public class ReviewUpdateService {

	@Autowired
	ReviewUpdateDAO ruDAO;	
	
	/**
	 * 관리자 답변(수정) 등록
	 * @param rVo
	 */
	public void ReviewRegUpS(ReviewVO rVo) {
		System.out.println("2. ▶▶▶▶ ReviewUpdateService : ReviewRegS >> 등록(수정)");		
		ruDAO.ReviewRegUpDAO(rVo);
	}
	
	/**
	 * 관리자 삭제(수정)
	 * @param Rcode
	 */
	public void ReviewDeleteS(String Rcode) {
		System.out.println("2. ▶▶▶▶ ReviewUpdateService : ReviewDeleteS >> 삭제");		
		ruDAO.ReviewDeleteDAO(Rcode);
	}
	
	
	
	
}
