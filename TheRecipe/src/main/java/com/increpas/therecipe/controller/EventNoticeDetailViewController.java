package com.increpas.therecipe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.increpas.therecipe.dto.EventListDTO;
import com.increpas.therecipe.service.NoticeDetailViewService;
import com.increpas.therecipe.vo.EventVO;



/**
 * 공지사항과 이벤트의 상세보기 Controller
 * @author 손대성
 *
 */
@Controller
public class EventNoticeDetailViewController {

	@Autowired
	NoticeDetailViewService ndvs;

	/**
	 * 공지사항 상세보기
	 * @param model
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/NoticeDetailView.do", method = RequestMethod.GET)
	public String GET_NoticeDetailView(Model model, HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("1. '공시사항 상세페이지' 입니다.");
		int Ncode = Integer.parseInt(req.getParameter("e_evtcode"));		
		EventVO nVo = ndvs.getNoticeVODetail(Ncode);
		model.addAttribute("nVo", nVo);
		return "NoticeDetailView";
	}
	
	/**
	 * 이벤트 상세보기
	 * @param model
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/EventDetailView.do", method = RequestMethod.GET)
	public String GET_EventDetailView(Model model, HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("1. '이벤트 상세페이지'입니다.");
		int Ecode = Integer.parseInt(req.getParameter("e_evtcode"));		
		EventVO eVo = ndvs.getEventVODetail(Ecode);		
		model.addAttribute("eVo", eVo);
		return "EventDetailView";
	}	
}
