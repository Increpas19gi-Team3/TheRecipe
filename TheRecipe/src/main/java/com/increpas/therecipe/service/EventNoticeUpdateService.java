package com.increpas.therecipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.increpas.therecipe.dao.EventNoticeUpdateDAO;
import com.increpas.therecipe.vo.EventNoticeRegVO;

/**
 * (관리자)공지사항과 이벤트 수정과 삭제를 관리하기 위한 Service 
 * @author 손대성
 */
@Service
public class EventNoticeUpdateService {

	@Autowired
	EventNoticeUpdateDAO enuDAO;
	
	/**
	 * (관리자)공지사항, 이벤트 수정을 위한 수정할 값 가져오기
	 * @param E_evtcode
	 * @return enuDAO.getSelectEvnetNotice(E_evtcode)
	 */
	@Transactional
	public EventNoticeRegVO getSelectNoticeEvent(String E_evtcode) {
		System.out.println("4. ▶▶▶▶ EventNoticeDetailViewService : getSelectNoticeEvent >> 공지사항, 이벤트 수정할 값가져오기");
		return enuDAO.getSelectEvnetNotice(E_evtcode);
	}
 
	/**
	 * 공지사항 수정
	 * @param enrVo
	 */
	@Transactional
	public void updatetWrtNoticeVO(EventNoticeRegVO enrVo) {
		System.out.println("6. ▶▶▶▶ EventNoticeDetailViewService : getUpdateNoticeVO >> 공지사항 수정");
		enuDAO.updatetWrtNotice(enrVo);
	}	
	
	/**
	 * 이벤트 삭제
	 * @param e_evtcode
	 */
	@Transactional
	public void DeleteNotice(String e_evtcode) {
		System.out.println("2. ▶▶▶▶ EventNoticeDetailViewService : DeleteNotice >> 공지사항 삭제");
		enuDAO.deleteNotice(e_evtcode);
	}	
 
	/**
	 * 이벤트 수정
	 * @param enrVo
	 */
	@Transactional
	public void updatetWrtEventVO(EventNoticeRegVO enrVo) {
		System.out.println("6. ▶▶▶▶ EventNoticeDetailViewService : updatetWrtEventVO >> 이벤트 수정");
		enuDAO.updatetWrtEvent(enrVo);
	}
	 
	/**
	 * 이벤트 삭제
	 * @param e_evtcode
	 */
	@Transactional
	public void DeleteEvent(String e_evtcode) {
		System.out.println("2. ▶▶▶▶ EventNoticeDetailViewService : DeleteEvent >> 이벤트 삭제");
		enuDAO.deleteEvent(e_evtcode);
	}
}
