package com.increpas.therecipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.increpas.therecipe.dao.EventNoticeDetailDAO;
import com.increpas.therecipe.vo.EventNoticeRegVO;
import com.increpas.therecipe.vo.EventNoticeVO;
import com.increpas.therecipe.vo.EventVO;

/**
 * 공지사항과 이벤트 리스트와 상세보기를 관리하기 위한 Service
 * 
 * @author 손대성
 *
 */
@Service
public class EventNoticeViewRegService {

	@Autowired
	EventNoticeDetailDAO endDAO;

	// 공지사항 상세보기
	@Transactional
	public EventNoticeVO getNoticeVODetail(int Ncode) {
		System.out.println("▶▶▶▶ NoticeDetailViewService : getNoticeVOList >> 들어옴");
		return endDAO.NoticeDetailView(Ncode);
	}

	// 공지사항 등록
	@Transactional
	public void insertWrtNoticeVO(EventNoticeRegVO erVo) {
		System.out.println("▶▶▶▶ NoticeEventDetailViewService : insertWrtNoticeVO >> 공지사항 등록");
		endDAO.NoticeReg(erVo);
	}

	// ======================이벤트==========================================================================

	// 이벤트 상세보기
	@Transactional
	public EventNoticeVO getEventVODetail(int Ecode) {
		System.out.println("▶▶▶▶ NoticeDetailViewService : getEventVODetail >> 들어옴");
		return endDAO.EventDetailView(Ecode);
	}

	// 이벤트 등록
	@Transactional
	public void insertWrtEventVO(EventNoticeRegVO erVo) {
		System.out.println("▶▶▶▶ NoticeEventDetailViewService : insertWrtEventVO >> 이벤트 등록");
		endDAO.EventReg(erVo);
	}
}
