package com.increpas.therecipe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.increpas.therecipe.dto.ReviewListDTO;
import com.increpas.therecipe.service.ReviewListService;
import com.increpas.therecipe.util.NullToBlank;
import com.increpas.therecipe.vo.ReviewVO;

/**
 * (일반인)후기 게시판 리스트 컨트롤러 기능 : 
 * 검색(제목), 페이징, 정렬(기간) 
 * 1. 단순 리스트 출력 
 * 2. 상세보기로 들어가기 위한 연결 링크
 * @author 손대성
 *
 */
@Controller
public class userReviewListController {

	// 공지사항 서블릿
	@Autowired
	ReviewListService reviewListService;
	
	@Autowired
	ReviewListService rlService;
	
	/**
	 * (일반인) 후기 리스트
	 * "/userReviewList.do"로 요청 받음	
	 * @param model
	 * @param req 요청
	 * @param resp 응답
	 * @return "/userReviewList" : 공지사항 페이지로 이동
	 */	
	@RequestMapping(value = "/userReviewList.do")
	public String getNoticeList(Model model, HttpServletRequest req, HttpServletResponse resp) {

		// 공지사항에 대한 검색, 정렬, 페이징 정보도 받아와야 함.
		System.err.println("▶▶▶▶▶▶  1. ReviewList.do");

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
		
		System.err.println("2.before ▶▶▶▶ ReviewListDTO ReviewList = reviewListService.getReviewVOList()");
		
		ReviewListDTO ReviewList = reviewListService.getReviewVOList(pageCutCount, requestPageNumber, whereColumn, word, sortColumn, orderby);
		model.addAttribute("ReviewList", ReviewList);	

		// 페이지 네비게이션바 설정
		if (ReviewList.getTotalPageCount() > 0) {

			// 리스트 화면의 페이지의 시작번호
			int beginPageNumber = (ReviewList.getRequestPage() - 1) / 10 * 10 + 1;
			
			// 리스트 화면의 페이지의 마지막번호
			int endPageNumber = beginPageNumber + 9;
			if (endPageNumber > ReviewList.getTotalPageCount()) {
				endPageNumber = ReviewList.getTotalPageCount();
			}

			model.addAttribute("beginPage", beginPageNumber); // 글 시작페이지
			model.addAttribute("endPage", endPageNumber);
		}
		
		return "/userReviewList";
	}
	
	/**
	 * (일반인)후기 상세보기(get)
	 * @param model
	 * @param req
	 * @param resp
	 * @return "userReviewDetailView"
	 */
	@RequestMapping(value = "/userReviewDetailView.do", method = RequestMethod.GET)
	public String GET_ReviewDetailView(Model model, HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("1. 후기 상세페이지와 조회수 작업중 입니다.");
		int Rcode = Integer.parseInt(req.getParameter("r_rvcode"));	
		ReviewVO rVo = rlService.getReviewVODetail(Rcode);
		model.addAttribute("rVo", rVo);
		return "userReviewDetailView";
	}
}
