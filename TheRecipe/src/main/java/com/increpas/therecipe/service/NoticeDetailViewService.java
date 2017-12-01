package com.increpas.therecipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.increpas.therecipe.dao.EventNoticeDAO;
import com.increpas.therecipe.dao.EventNoticeDetailDAO;
import com.increpas.therecipe.dto.EventListDTO;
import com.increpas.therecipe.vo.EventNoticeVO;
import com.increpas.therecipe.vo.EventVO;

/**
 * 공지사항과 이벤트 리스트와 상세보기를 관리하기 위한 Service
 * @author 손대성
 *
 */
@Service
public class NoticeDetailViewService {

	@Autowired
	EventNoticeDetailDAO endDAO;
	
	// 공지사항 상세보기 
	@Transactional	
	public EventVO getNoticeVODetail(int Ncode) {
		System.err.println("▶▶▶▶ NoticeDetailViewService : getNoticeVOList >> 들어옴");		
		return endDAO.NoticeDetailView(Ncode);
	}
	
	//이벤트 상세보기
	@Transactional	
	public EventNoticeVO getEventVODetail(int Ecode) {
		System.err.println("▶▶▶▶ NoticeDetailViewService : getEventVODetail >> 들어옴");		
		return endDAO.EventDetailView(Ecode);
	}	
}
