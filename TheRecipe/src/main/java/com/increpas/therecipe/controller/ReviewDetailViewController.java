//package com.increpas.therecipe.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.increpas.therecipe.dto.EventListDTO;
//import com.increpas.therecipe.service.NoticeDetailViewService;
//import com.increpas.therecipe.service.ReviewDetailViewService;
//import com.increpas.therecipe.vo.EventNoticeVO;
//import com.increpas.therecipe.vo.EventVO;
//import com.increpas.therecipe.vo.ReviewVO;
//
//
//
///**
// * 후기 상세보기 Controller
// * @author 손대성
// *
// */
//@Controller
//public class ReviewDetailViewController {
//
//	@Autowired
//	ReviewDetailViewService rdvs;
//
//	/**
//	 * 후기 상세보기
//	 * @param model
//	 * @param req
//	 * @param resp
//	 * @return
//	 */
//	@RequestMapping(value = "/ReviewDetailView.do", method = RequestMethod.GET)
//	public String GET_ReviewDetailView(Model model, HttpServletRequest req, HttpServletResponse resp) {
//
//		System.out.println("1. '후기 상세페이지' 입니다.");
//		int Rcode = Integer.parseInt(req.getParameter("r_rvcode"));		
//		ReviewVO nVo = rdvs.getNoticeVODetail(Rcode);
//		model.addAttribute("nVo", nVo);
//		return "xxxNoticeDetailView";
//	}
//	
//	/**
//	 * 이벤트 상세보기
//	 * @param model
//	 * @param req
//	 * @param resp
//	 * @return
//	 */
//	@RequestMapping(value = "/EventDetailView.do", method = RequestMethod.GET)
//	public String GET_EventDetailView(Model model, HttpServletRequest req, HttpServletResponse resp) {
//
//		System.out.println("1. '이벤트 상세페이지'입니다.");
//		int Ecode = Integer.parseInt(req.getParameter("e_evtcode"));		
//		EventNoticeVO eVo = ndvs.getEventVODetail(Ecode);
//		System.out.println(">>>>>>>>>>> eVo = " + eVo.toString());
//		model.addAttribute("eVo", eVo);
//		return "xxxEventDetailView";
//	}	
//}
