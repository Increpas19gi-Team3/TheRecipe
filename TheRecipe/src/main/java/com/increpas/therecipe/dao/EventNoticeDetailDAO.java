package com.increpas.therecipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.increpas.therecipe.dto.EventListDTO;
import com.increpas.therecipe.vo.EventNoticeRegVO;
import com.increpas.therecipe.vo.EventNoticeVO;
import com.increpas.therecipe.vo.EventVO;

/**
 * 이벤트와 공지사항에 대한 DAO
 * @author 손대성
 *
 */
@Repository
public class EventNoticeDetailDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 공지사항 상세글 보기
	 * @param Ncode 화면에서 입력받은 공시사항 코드값
	 * @return
	 */
	public EventVO NoticeDetailView(int Ncode) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Ncode", Ncode);// 글번호 맵에 저장
		return sqlSessionTemplate.selectOne("event_ns.selectNoticeDetail", map);		
	}
	
	/**
	 * 공지사항 등록
	 * @param eVo
	 */
	public void NoticeReg(EventNoticeRegVO erVo) {				
		sqlSessionTemplate.insert("event_ns.NoticeInsertWrite", erVo);		
	}
	
	
	
	
	/**
	 * 상세글 보기
	 * @param Ecode 화면에서 입력받은 이벤트 코드값
	 * @return
	 */
	public EventNoticeVO EventDetailView(int Ecode) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Ecode", Ecode);// 글번호 맵에 저장
		return sqlSessionTemplate.selectOne("event_ns.selectEventDetail", map);		
	} 		
}
