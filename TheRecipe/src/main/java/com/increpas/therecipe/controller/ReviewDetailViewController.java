package com.increpas.therecipe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.increpas.therecipe.service.ReviewListService;
import com.increpas.therecipe.vo.EventNoticeVO;
import com.increpas.therecipe.vo.ReviewVO;

/**
 * 후기 상세보기 Controller
 * 
 * @author 손대성
 *
 */
@Controller
public class ReviewDetailViewController {

	@Autowired
	ReviewListService rlService;

	/**
	 * 후기 상세보기(get)
	 * 
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
	
	
}
