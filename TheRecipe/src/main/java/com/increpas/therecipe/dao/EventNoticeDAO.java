package com.increpas.therecipe.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.increpas.therecipe.dto.EventListDTO;
import com.increpas.therecipe.vo.EventNoticeVO;
import com.increpas.therecipe.vo.EventVO;

/**
 * (관리자, 일반인)이벤트와 공지사항에 대한 DAO
 * @author 손대성
 *
 */
@Repository
public class EventNoticeDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * (관리자, 일반인)전체 공지사항 글 갯수 리턴
	 * @param eventListDTO
	 * @return sqlSessionTemplate.selectOne("event_ns.selectNoticeCount", eventListDTO)
	 */	
	@Transactional
	public int selectNoticeCount(EventListDTO eventListDTO) {
		System.err.println("4. ▶▶▶ EventNoticeDAO : selectNoticeCount");
		// 게시된 글 갯수를 리턴하기 때문에 'selectOne'임
		return sqlSessionTemplate.selectOne("event_ns.selectNoticeCount", eventListDTO);
	}
	
	/**
	 * (관리자, 일반인)공지사항에 대한 조건 검색
	 * @param eventListDTO	 
	 * @return sqlSessionTemplate.selectList("event_ns.selectNoticeSetList", eventListDTO)
	 */
	@Transactional
	public List<EventNoticeVO> selectNoticeSetList(EventListDTO eventListDTO) {
		System.err.println("6. ▶▶▶▶ EventNoticeDAO=" + eventListDTO.toString());
		return sqlSessionTemplate.selectList("event_ns.selectNoticeSetList", eventListDTO);
	}	
	
	/*===============================이벤트 속성에 관한===============================================*/
		
	/**
	 * (관리자, 일반인)전체 이벤트 글 갯수 리턴
	 * @param eventListDTO
	 * @return sqlSessionTemplate.selectOne("event_ns.selectEventCount", eventListDTO)
	 */	
	@Transactional
	public int selectEventCount(EventListDTO eventListDTO) {
		System.err.println("4. ▶▶▶ EventNoticeDAO : selectEventCount");
		// 게시된 글 갯수를 리턴하기 때문에 'selectOne'임
		return sqlSessionTemplate.selectOne("event_ns.selectEventCount", eventListDTO);
	}
	
	/**
	 * (관리자, 일반인)전체 이벤트에 대한 조건 검색 	
	 * @return sqlSessionTemplate.selectList("event_ns.selectEventSetList", eventListDTO)
	 */
	@Transactional
	public List<EventNoticeVO> selectEventSetList(EventListDTO eventListDTO) {
		System.err.println("6. ▶▶▶▶ EventNoticeDAO=" + eventListDTO.toString());
		return sqlSessionTemplate.selectList("event_ns.selectEventSetList", eventListDTO);
	}	
}
