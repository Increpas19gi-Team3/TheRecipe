package com.increpas.therecipe.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.vo.EventNoticeRegVO;

/**
 * 이벤트와 공지사항에 대한 DAO
 * @author 손대성
 *
 */
@Repository
public class EventNoticeUpdateDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 공지사항 이벤트 수정을 위한 값 가져오기
	 * @param Ncode 화면에서 입력받은 공시사항, 이벤트 코드값
	 * @return
	 */
	public EventNoticeRegVO getSelectEvnetNotice(String E_evtcode) {
		System.out.println("5. E_evtcode : " +E_evtcode);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("E_evtcode", E_evtcode);// 글번호 맵에 저장		
		return sqlSessionTemplate.selectOne("event_ns.selectWrtByNum", map);		
	}
	
	/**
	 * 공지사항 수정
	 * @param eVo
	 */
	public void updatetWrtNotice(EventNoticeRegVO erVo) {
		System.out.println("7. erVo.toString() : "+erVo.toString());
		sqlSessionTemplate.update("event_ns.updatetNotice", erVo);		
	}
	
	/**
	 * 공지사항 삭제
	 * @param eVo
	 */
	public void deleteNotice(String e_evtcode) {
		System.out.println("4. 공지사항 삭제 e_evtcode : "+ e_evtcode);
		sqlSessionTemplate.delete("event_ns.deleteNotice", e_evtcode);		
	}
	
	/**
	 * 이벤트 수정
	 * @param eVo
	 */
	public void updatetWrtEvent(EventNoticeRegVO erVo) {
		System.out.println("7. erVo.toString() : "+erVo.toString());
		int result = sqlSessionTemplate.update("event_ns.updatetEvent", erVo);
		System.out.println("8. update 결과 :"+result);
	}
	
	/**
	 * 이벤트 삭제
	 * @param eVo
	 */
	public void deleteEvent(String e_evtcode) {
		System.out.println("4. 이벤트 삭제 e_evtcode : "+ e_evtcode);
		sqlSessionTemplate.delete("event_ns.deleteEvent", e_evtcode);		
	}
}
