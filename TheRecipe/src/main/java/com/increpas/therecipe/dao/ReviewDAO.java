package com.increpas.therecipe.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.increpas.therecipe.dto.EventListDTO;
import com.increpas.therecipe.dto.ReviewListDTO;
import com.increpas.therecipe.vo.ReviewVO;

/**
 * 후기리스트에 대한 DAO
 * 
 * @author 손대성
 *
 */
@Repository
public class ReviewDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 전체 후기 리스트 글 갯수 리턴
	 * @param eventListDTO
	 * @return sqlSessionTemplate.selectOne("review_ns.selectReviewCount", eventListDTO);
	 */	
	@Transactional
	public int selectReviewCount(ReviewListDTO reviewListDTO) {
		System.err.println("4. ▶▶▶ ReviewDAO : selectReviewCount");
		// 게시된 글 갯수를 리턴하기 때문에 'selectOne'임
		return sqlSessionTemplate.selectOne("review_ns.selectReviewCount", reviewListDTO);
	}
	
	/**
	 * 후기리스트에 대한 조건 검색
	 * 
	 * @param whereColumn : 검색 컬럼명
	 * @param word : 검색어
	 * @param sortColumn : 정렬 컬럼
	 * @param orderby : 정렬방식 ASC, DESC	 
	 * @return 
	 */
	@Transactional
	public List<ReviewVO> selectReviewSetList(ReviewListDTO reviewListDTO) {
		System.err.println("6. ▶▶▶▶ ReviewDAO = " + reviewListDTO.toString());
		return sqlSessionTemplate.selectList("review_ns.selectReviewSetList", reviewListDTO);
	}			
}
