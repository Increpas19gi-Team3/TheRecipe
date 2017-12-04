package com.increpas.therecipe.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.increpas.therecipe.service.UserMyOrderService;
import com.increpas.therecipe.vo.UserMyBasketVO;

/**
 * 주문관련 컨트롤러
 * 
 * @author 박호진
 *
 */

@Controller
public class UserMyOrderController {
	
	// slf4j 방식 로그
			Logger logger = LoggerFactory.getLogger(getClass());

			@Autowired
			UserMyOrderService userMyOrderService;
			
			@RequestMapping(value = "/orderWrite.do", method = RequestMethod.POST )
			public String orderWriteForm(HttpServletRequest request, UserMyBasketVO bVo, Model model) {
				
				String f_fdcode =  request.getParameter("f_fdcode");
				int o_buyprice = Integer.parseInt(request.getParameter("o_buyprice"));
				int o_amount = Integer.parseInt(request.getParameter("buy_cnt"));
				String title= request.getParameter("title");
				String thumname= request.getParameter("thumname");
				 model.addAttribute("f_fdcode", f_fdcode);
				 model.addAttribute("o_buyprice", o_buyprice);
				 model.addAttribute("o_amount", o_amount);
				 model.addAttribute("title", title);
				 model.addAttribute("thumname", thumname);
				
				
				return "myOrder_detail";
			}
			

}
