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
	 * 공지사항 or 이벤트 글 전체 검색
	 * 
	 * @return
	 */
	@Transactional
	public List<EventVO> SelectList() {
		return sqlSessionTemplate.selectList("event_ns.SelectList");		
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
		System.out.println("▶▶▶▶ EventNoticeDAO=" + eventListDTO.toString());
		return sqlSessionTemplate.selectList("event_ns.", eventListDTO);
	}

	/**
	 * 전체 글 갯수 리턴
	 * 
	 * @return
	 */
	public int selectCount(EventListDTO eventListDTO) {
		System.out.println("5. ▶▶▶ EventNoticeDAO : selectCount");
		return sqlSessionTemplate.selectOne("event_ns.selectCount", eventListDTO);
	}
}
