package com.increpas.therecipe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.increpas.therecipe.service.UserMyOrderService;
import com.increpas.therecipe.vo.OrderVO;
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
			public String orderWriteForm(@ModelAttribute("orderup")HttpServletRequest request,OrderVO odVo, Model model, HttpSession session) {
				
				String title= request.getParameter("title");
				String thumname= request.getParameter("thumname");
				String m_userid = (String) session.getAttribute("m_userid");
				odVo.setF_fdcode(request.getParameter("f_fdcode"));
				odVo.setO_buyprice(Integer.parseInt(request.getParameter("o_buyprice")));
				odVo.setO_amount(Integer.parseInt(request.getParameter("o_amount")));
				
//				userMyOrderService.insertOrder(odVo);
				
				 model.addAttribute("title", title);
				 model.addAttribute("thumname", thumname);
				
				
				return "myOrder_detail";
			}
			

}
