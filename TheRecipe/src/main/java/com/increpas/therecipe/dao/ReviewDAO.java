package com.increpas.therecipe.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.increpas.therecipe.dto.EventListDTO;
import com.increpas.therecipe.vo.EventVO;

/**
 * 후기 리스트에 대한 'DAO'
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
	 * @return 
	 */	
	@Transactional
	public int selectReviewCount(EventListDTO eventListDTO) {
		System.err.println("4. ▶▶▶ EventNoticeDAO : selectNoticeCount");
		// 게시된 글 갯수를 리턴하기 때문에 'selectOne'임
		return sqlSessionTemplate.selectOne("event_ns.selectNoticeCount", eventListDTO);
	}
	
	/**
	 * 공지사항에 대한 조건 검색
	 * 
	 * @param whereColumn : 검색 컬럼명
	 * @param word : 검색어
	 * @param sortColumn : 정렬 컬럼
	 * @param orderby : 정렬방식 ASC, DESC
	 * @param isBlock : 전체 or 제목 글 검색
	 * @return sqlSessionTemplate.selectList("event_ns.selectNoticeSetList", eventListDTO);
	 */
	@Transactional
	public List<EventVO> selectNoticeSetList(EventListDTO eventListDTO) {
		System.err.println("6. ▶▶▶▶ EventNoticeDAO=" + eventListDTO.toString());
		return sqlSessionTemplate.selectList("event_ns.selectNoticeSetList", eventListDTO);
	}	
	
	/*===============================이벤트 속성에 관한===============================================*/
		
	/**
	 * 전체 이벤트 글 갯수 리턴
	 * @param eventListDTO
	 * @return sqlSessionTemplate.selectOne("event_ns.selectNoticeCount", eventListDTO);
	 */	
	@Transactional
	public int selectEventCount(EventListDTO eventListDTO) {
		System.err.println("4. ▶▶▶ EventNoticeDAO : selectEventCount");
		// 게시된 글 갯수를 리턴하기 때문에 'selectOne'임
		return sqlSessionTemplate.selectOne("event_ns.selectEventCount", eventListDTO);
	}
	
	/**
	 * 전체 이벤트에 대한 조건 검색
	 * 
	 * @param whereColumn : 검색 컬럼명
	 * @param word : 검색어
	 * @param sortColumn : 정렬 컬럼
	 * @param orderby : 정렬방식 ASC, DESC
	 * @param isBlock : 전체 or 제목 글 검색
	 * @return sqlSessionTemplate.selectList("event_ns.selectEventSetList", eventListDTO);
	 */
	@Transactional
	public List<EventVO> selectEventSetList(EventListDTO eventListDTO) {
		System.err.println("6. ▶▶▶▶ EventNoticeDAO=" + eventListDTO.toString());
		return sqlSessionTemplate.selectList("event_ns.selectEventSetList", eventListDTO);
	}	
}
