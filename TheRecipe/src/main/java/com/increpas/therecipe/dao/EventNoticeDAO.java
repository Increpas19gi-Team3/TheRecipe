package com.increpas.therecipe.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.increpas.therecipe.dto.EventListDTO;
import com.increpas.therecipe.vo.EventVO;

/**
 * 이벤트와 공지사항에 대한 DAO
 * 
 * @author 손대성
 *
 */
@Repository
public class EventNoticeDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 이벤트 글 전체 검색
	 * 
	 * @return
	 */
	@Transactional
	public List<EventVO> eventSelectList() {
		return sqlSessionTemplate.selectList("event_ns.eventSelectList");		
	}
	
	/**
	 * 공지사항 글 전체 검색
	 * 
	 * @return
	 */
	@Transactional
	public List<EventVO> noticeSelectList() {
		return sqlSessionTemplate.selectList("event_ns.noticeSelectList");		
	}

	/**
	 * 조건 검색
	 * 
	 * @param whereColumn
	 *            : 검색 컬럼명
	 * @param word
	 *            : 검색어
	 * @param sortColumn
	 *            : 정렬 컬럼
	 * @param orderby
	 *            : 정렬방식 ASC, DESC
	 * @param isBlock
	 *            : 전체글 검색, 블록글 검색
	 * @return - List<BoardDTO>
	 */
	public List<EventVO> selectSetList(EventListDTO eventListDTO) {
		System.out.println("▶▶▶▶ eventListDTO=" + eventListDTO.toString());
		return sqlSessionTemplate.selectList("event_ns.", eventListDTO);
	}

	/**
	 * 전체 글 갯수 리턴
	 * 
	 * @return
	 */
	public int selectCount(EventListDTO eventListDTO) {
		System.out.println("▶▶▶▶ eventListDTO : selectCount");
		return sqlSessionTemplate.selectOne("event_ns.", eventListDTO);
	}
}
