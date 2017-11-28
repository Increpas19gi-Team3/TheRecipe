package com.increpas.therecipe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.increpas.therecipe.dto.EventListDTO;
import com.increpas.therecipe.service.EventNoticeListService;
import com.increpas.therecipe.util.NullToBlank;

/**
 * 공지사항 게시판 리스트 컨트롤러 기능 : 
 * 검색(제목), 페이징, 정렬(기간) 
 * 1. 단순 리스트 출력 
 * 2. 상세보기로 들어가기 위한 연결 링크
 * 
 * @author 손대성
 *
 */

@Controller
public class EventNoticeListController {

	@Autowired
	EventNoticeListService noticeListService;

	@RequestMapping(value = "/NoticeList.do")
	public String getList(Model model, HttpServletRequest req, HttpServletResponse resp) {

		// 공지사항에 대한 검색, 정렬, 페이징 정보도 받아와야 함.
		System.out.println("▶▶▶▶▶▶  1. NoticeList.do");

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

		// 'isBlock'이 공지사항의 글인지 이벤트 글인지를 확인하는 값
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
		
		System.out.println("2.before ▶▶▶▶ EventListDTO noticeList = noticeListService.getBoardVOList()");
		
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

		// 리턴 값을 다시 설정해주기 바람
		return "/noticeList";
	}
}
