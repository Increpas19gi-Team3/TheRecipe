package com.increpas.therecipe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.increpas.therecipe.service.ReviewListService;
import com.increpas.therecipe.service.ReviewUpdateService;
import com.increpas.therecipe.vo.EventNoticeVO;
import com.increpas.therecipe.vo.ReviewVO;

/**
 * 후기에 관한 Controller
 * 
 * @author 손대성
 *
 */
@Controller
public class ReviewDetailViewController {

	@Autowired
	ReviewListService rlService;
	
	@Autowired
	ReviewUpdateService ruService;
	
	/**
	 * 후기 상세보기(get)
	 * @param model
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/ReviewDetailView.do", method = RequestMethod.GET)
	public String GET_ReviewDetailView(Model model, HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("1. 후기 상세페이지와 조회수 작업중 입니다.");
		int Rcode = Integer.parseInt(req.getParameter("r_rvcode"));	
		ReviewVO rVo = rlService.getReviewVODetail(Rcode);
		model.addAttribute("rVo", rVo);
		return "reviewDetailView";
	}	
	
	/**
	 * 후기 관리자 답변 등록을 위한 글 찾기
	 */
	@RequestMapping(value = "/reviewAdminRegUpdate.do", method = RequestMethod.GET)
	public String GET_ReviewAdminRegUP(Model model, HttpServletRequest req, HttpServletResponse resp) {		
		System.out.println("1. GET_후기 관리자 답변 등록(수정)을 위한 r_rvcode 값을 찾는 작업중입니다.");		
		int Rcode = Integer.parseInt(req.getParameter("r_rvcode"));
		ReviewVO rVo = rlService.getReviewVODetail(Rcode);
		model.addAttribute("rVo", rVo);
		return "reviewAdminRegUp";
	}	
	
	/**
	 * 후기 관리자 답변 등록(수정)
	 * @param rVo	
	 * @return
	 */
	@RequestMapping(value = "/reviewAdminRegUpdate.do", method = RequestMethod.POST)
	public String POST_ReviewAdminRegUP(ReviewVO rVo) {
		System.out.println("1. POST_후기 관리자 답변 등록(수정) 작업중입니다.");
		ruService.ReviewRegUpS(rVo);		
		return "redirect:ReviewList.do";
	}	
	
	/**
	 * 관리자의 답글 삭제
	 * @param model
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/reviewAdminDelete.do", method = RequestMethod.GET)
	public String GET_ReviewAdminDelete(HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("1. 후기 관리자 답글 삭제 입니다.");
		String Rcode = req.getParameter("r_rvcode");	
		ruService.ReviewDeleteS(Rcode);		
		return "redirect:ReviewList.do";
	}	
	
}
