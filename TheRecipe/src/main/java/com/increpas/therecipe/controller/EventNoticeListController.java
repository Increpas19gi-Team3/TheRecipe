package com.increpas.therecipe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.increpas.therecipe.dto.EventListDTO;
import com.increpas.therecipe.service.EventListService;
import com.increpas.therecipe.service.NoticeListService;
import com.increpas.therecipe.util.NullToBlank;

/**
 * (관리자)공지사항, 이벤트 게시판 리스트 컨트롤러 기능 : 
 * 검색(제목), 페이징, 정렬(기간) 
 * 1. 단순 리스트 출력 
 * 2. 상세보기로 들어가기 위한 연결 링크
 * @author 손대성
 *
 */
@Controller
public class EventNoticeListController {

	// 공지사항 서블릿
	@Autowired
	NoticeListService noticeListService;

	// 이벤트 서블릿
	@Autowired
	EventListService eventListService;
	
	/**
	 * "/adminNoticeList.do"로 요청 받음
	 * @param model
	 * @param req 요청
	 * @param resp 응답
	 * @return "/adminNoticeList" : 공지사항 페이지로 이동
	 */	
	@RequestMapping(value = "/adminNoticeList.do")
	public String getNoticeList(Model model, HttpServletRequest req, HttpServletResponse resp) {

		// 공지사항에 대한 검색, 정렬, 페이징 정보도 받아와야 함.
		System.err.println("▶▶▶▶▶▶  1. NoticeList.do");

		// 정렬
		String sortColumn = NullToBlank.doChange(req.getParameter("sortColumn"));
		String orderby = NullToBlank.doChange(req.getParameter("orderby"));
		System.out.println("sortColumn = " + sortColumn + ", orderby = " + orderby);
		model.addAttribute("sortColumn", sortColumn);
		model.addAttribute("orderby", orderby);

		// 검색
		String whereColumn = NullToBlank.doChange(req.getParameter("whereColumn"));
		String word = NullToBlank.doChange(req.getParameter("word"));
		System.out.println("whereColumn = " + whereColumn + ", word = " + word);
		model.addAttribute("whereColumn", whereColumn);
		model.addAttribute("word", word);

		// 'GUBUN'이 공지사항의 글인지 이벤트 글인지를 확인하는 값
		String GUBUN = NullToBlank.doChange(req.getParameter("GUBUN"));
		System.out.println("GUBUN = " + GUBUN);
		model.addAttribute("GUBUN", GUBUN);

		// 페이징 처리
		String cutCount = NullToBlank.doChange(req.getParameter("pageCutCount"));
		
		// 표시할 게시글 갯수
		int pageCutCount = cutCount.equals("") ? 5 : Integer.parseInt(cutCount);
		System.out.println("pageCutCount=" + pageCutCount);

		// 'pn' 이거 어디서 받는거지?
		String pn = NullToBlank.doChange(req.getParameter("pn"));

		// 최종 모델 : BoardVOListModel, 페이지의 시작과 마지막 번호
		// FC 에게 리턴
		int requestPageNumber = pn.equals("") ? 1 : Integer.parseInt(pn);
		System.out.println("pn = " + requestPageNumber);

		model.addAttribute("pageCutCount", pageCutCount);
		model.addAttribute("pn", requestPageNumber);
		
		System.err.println("2.before ▶▶▶▶ EventListDTO noticeList = noticeListService.getBoardVOList()");
		
		// 명칭은 'EventListDTO'이지만, 공지사항도 처리함
		EventListDTO noticeList = noticeListService.getBoardVOList(pageCutCount, requestPageNumber, whereColumn, word, sortColumn, orderby, GUBUN);
		model.addAttribute("noticeList", noticeList);
		

		// 페이지 네비게이션바 설정
		if (noticeList.getTotalPageCount() > 0) {

			// 리스트 화면의 페이지의 시작번호
			int beginPageNumber = (noticeList.getRequestPage() - 1) / 10 * 10 + 1;
			
			// 리스트 화면의 페이지의 마지막번호
			int endPageNumber = beginPageNumber + 9;
			if (endPageNumber > noticeList.getTotalPageCount()) {
				endPageNumber = noticeList.getTotalPageCount();
			}

			model.addAttribute("beginPage", beginPageNumber); // 글 시작페이지
			model.addAttribute("endPage", endPageNumber);
		}
		
		return "/adminNoticeList";
	}
	
	
	/**
	 * (관리자)이벤트 리스트를 출력하기 위한 컨트롤러
	 * "EventList.do"로 요청 받음
	 * @param model
	 * @param req 요청
	 * @param resp 응답
	 * @return "/adminEventList" : 이벤트 페이지로 이동
	 */	
	@RequestMapping(value = "/adminEventList.do")
	public String getEventist(Model model, HttpServletRequest req, HttpServletResponse resp) {

		// 공지사항에 대한 검색, 정렬, 페이징 정보도 받아와야 함.
		System.err.println("▶▶▶▶▶▶  1. EventList.do");

		// 정렬
		String sortColumn = NullToBlank.doChange(req.getParameter("sortColumn"));
		String orderby = NullToBlank.doChange(req.getParameter("orderby"));
		System.out.println("sortColumn = " + sortColumn + ", orderby = " + orderby);
		model.addAttribute("sortColumn", sortColumn);
		model.addAttribute("orderby", orderby);

		// 검색
		String whereColumn = NullToBlank.doChange(req.getParameter("whereColumn"));
		String word = NullToBlank.doChange(req.getParameter("word"));
		System.out.println("whereColumn = " + whereColumn + ", word = " + word);
		model.addAttribute("whereColumn", whereColumn);
		model.addAttribute("word", word);

		// 'GUBUN'이 공지사항의 글인지 이벤트 글인지를 확인하는 값
		String GUBUN = NullToBlank.doChange(req.getParameter("GUBUN"));
		System.out.println("GUBUN = " + GUBUN);
		model.addAttribute("GUBUN", GUBUN);

		// 페이징 처리
		String cutCount = NullToBlank.doChange(req.getParameter("pageCutCount"));
		// 표시할 게시글 갯수
		int pageCutCount = cutCount.equals("") ? 5 : Integer.parseInt(cutCount);
		System.out.println("pageCutCount=" + pageCutCount);

		// 'pn' 이거 어디서 받는거지?
		String pn = NullToBlank.doChange(req.getParameter("pn"));

		// 최종 모델 : BoardVOListModel, 페이지의 시작과 마지막 번호
		// FC 에게 리턴
		int requestPageNumber = pn.equals("") ? 1 : Integer.parseInt(pn);
		System.out.println("pn = " + requestPageNumber);

		model.addAttribute("pageCutCount", pageCutCount);
		model.addAttribute("pn", requestPageNumber);
		
		System.err.println("2.before ▶▶▶▶ EventListDTO eventList = eventListService.getBoardVOList()");
		
		// 명칭은 'EventListDTO'이지만, 공지사항도 처리함
		EventListDTO eventList = eventListService.getBoardVOList(pageCutCount, requestPageNumber, whereColumn, word, sortColumn, orderby, GUBUN);
		model.addAttribute("eventList", eventList);
		

		// 페이지 네비게이션바 설정
		if (eventList.getTotalPageCount() > 0) {

			// 리스트 화면의 페이지의 시작번호
			int beginPageNumber = (eventList.getRequestPage() - 1) / 10 * 10 + 1;
			
			// 리스트 화면의 페이지의 마지막번호
			int endPageNumber = beginPageNumber + 9;
			if (endPageNumber > eventList.getTotalPageCount()) {
				endPageNumber = eventList.getTotalPageCount();
			}

			model.addAttribute("beginPage", beginPageNumber); // 글 시작페이지
			model.addAttribute("endPage", endPageNumber);
		}
		
		return "/adminEventList";
	}
}
