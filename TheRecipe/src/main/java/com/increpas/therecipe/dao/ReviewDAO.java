package com.increpas.therecipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.increpas.therecipe.dto.EventListDTO;
import com.increpas.therecipe.dto.ReviewListDTO;
import com.increpas.therecipe.vo.ReviewVO;

/**
 * (관리자, 일반인)후기리스트에 대한 DAO
 * @author 손대성
 */
@Repository
public class ReviewDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * (관리자, 일반인)전체 후기 리스트 글 갯수 리턴
	 * @param reviewListDTO
	 * @return sqlSessionTemplate.selectOne("review_ns.selectReviewCount", reviewListDTO)
	 */	
	@Transactional
	public int selectReviewCount(ReviewListDTO reviewListDTO) {
		System.err.println("4. ▶▶▶ ReviewDAO : selectReviewCount");
		// 게시된 글 갯수를 리턴하기 때문에 'selectOne'임
		return sqlSessionTemplate.selectOne("review_ns.selectReviewCount", reviewListDTO);
	}
	
	/**
	 * (관리자, 일반인)후기리스트에 대한 조건 검색 
	 * @param reviewListDTO		 
	 * @return sqlSessionTemplate.selectList("review_ns.selectReviewSetList", reviewListDTO)
	 */
	@Transactional
	public List<ReviewVO> selectReviewSetList(ReviewListDTO reviewListDTO) {
		System.out.println("6. ▶▶▶▶ ReviewDAO = " + reviewListDTO.toString());
		return sqlSessionTemplate.selectList("review_ns.selectReviewSetList", reviewListDTO);
	}
	
	/**
	 * (관리자, 일반인)조회수 증가
	 * @param r_rvcode
	 */
	public void updateHitCount(int r_rvcode) {
		sqlSessionTemplate.update("review_ns.updateHitCount", r_rvcode);
	}
	
	/**
	 * (관리자, 일반인)후기 상세보기
	 * @param Ncode
	 * @return sqlSessionTemplate.selectOne("review_ns.reviewWrtByNum", map)
	 */
	@Transactional
	public ReviewVO ReviewDetailView(int Ncode) {
		System.out.println("3. ▶▶▶▶ ReviewDetailView  = " + Ncode);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("r_rvcode", Ncode);		
		return sqlSessionTemplate.selectOne("review_ns.reviewWrtByNum", map);
	}	
}
