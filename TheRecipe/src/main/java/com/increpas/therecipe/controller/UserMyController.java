package com.increpas.therecipe.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.increpas.therecipe.service.UserMyService;

/**
 * 장바구니보기 주문조회 후기등록 관련 컨트롤러
 * 
 * @author 박호진
 *
 */

@Controller
public class UserMyController {
	
	// slf4j 방식 로그
		Logger logger = LoggerFactory.getLogger(getClass());

		@Autowired
		UserMyService userMyService;
		
		@RequestMapping(value = "/BasketForm.do", method = RequestMethod.GET)
		public String BasketForm( HttpSession session , Model model) {
			// 장바구니 리스트 조회(아이디)
			
			String m_userid = (String) session.getAttribute("m_userid");
			
			
			model.addAttribute("basket", userMyService.selectBasket(m_userid));

			return "cart";
		}

}
