package com.increpas.therecipe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.increpas.therecipe.service.ReviewListService;
import com.increpas.therecipe.service.ReviewUpdateService;
import com.increpas.therecipe.vo.EventNoticeVO;
import com.increpas.therecipe.vo.OrderVO;
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
	@RequestMapping(value = "/adminReviewDetailView.do", method = RequestMethod.GET)
	public String GET_ReviewDetailView(Model model, HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("1. 후기 상세페이지와 조회수 작업중 입니다.");
		int Rcode = Integer.parseInt(req.getParameter("r_rvcode"));	
		ReviewVO rVo = rlService.getReviewVODetail(Rcode);
		model.addAttribute("rVo", rVo);
		return "adminReviewDetailView";
	}	
	
	/**
	 * 후기 관리자 답변 등록을 위한 글 찾기
	 */
	@RequestMapping(value = "/adminReviewRegUpdate.do", method = RequestMethod.GET)
	public String GET_ReviewAdminRegUP(Model model, HttpServletRequest req, HttpServletResponse resp) {		
		System.out.println("1. GET_후기 관리자 답변 등록(수정)을 위한 r_rvcode 값을 찾는 작업중입니다.");		
		int Rcode = Integer.parseInt(req.getParameter("r_rvcode"));
		ReviewVO rVo = rlService.getReviewVODetail(Rcode);
		model.addAttribute("rVo", rVo);
		return "adminReviewRegUpdate";
	}	
	
	/**
	 * 후기 관리자 답변 등록(수정)
	 * @param rVo	
	 * @return
	 */
	@RequestMapping(value = "/adminReviewRegUpdate.do", method = RequestMethod.POST)
	public String POST_ReviewAdminRegUP(ReviewVO rVo) {
		System.out.println("1. POST_후기 관리자 답변 등록(수정) 작업중입니다.");
		ruService.ReviewRegUpS(rVo);		
		return "redirect:adminReviewList.do";
	}	
	
	/**
	 * 관리자의 답글 삭제
	 * @param model
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/adminReviewDelete.do", method = RequestMethod.GET)
	public String GET_ReviewAdminDelete(HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("1. 후기 관리자 답글 삭제 입니다.");
		String Rcode = req.getParameter("r_rvcode");	
		ruService.ReviewDeleteS(Rcode);		
		return "redirect:adminReviewList.do";
	}
	
	
	//=======================================호진이 작업 구간=============================================
	
	
	/**
	 * 유저 리뷰작성 폼으로 이동
	 * @param f_fdcode String f_fdcode(음식코드)
	 * @param model  Model
	 * @return 리뷰작성폼
	 */
	@RequestMapping(value = "/reviewWriteForm.do", method = RequestMethod.GET)
	public String reviewWriteForm(@RequestParam("f_fdcode") String f_fdcode , Model model) {
		model.addAttribute("f_fdcode", f_fdcode);
		return "reviewWrite";
	}
	/**
	 * 리뷰작성 동작 수행
	 * @param rVo ReviewVO
	 * @param f_fdcode String f_fdcode(음식코드)
	 * @param session HttpSession session(세션사용)
	 * @return 홈으로 이동
	 */
	@RequestMapping(value = "/reviewWrite.do", method = RequestMethod.POST )
	public String reviewWrite(@ModelAttribute("reviewWr") ReviewVO rVo ,@RequestParam("f_fdcode") String f_fdcode ,HttpSession session) {
		rVo.setM_userid((String)session.getAttribute("m_userid"));
		rVo.setF_fdcode(f_fdcode);

		ruService.reviewWrite(rVo);
	   
		return "redirect:home.do";
	}
	
}
