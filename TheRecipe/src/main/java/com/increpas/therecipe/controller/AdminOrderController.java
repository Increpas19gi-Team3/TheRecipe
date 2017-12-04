package com.increpas.therecipe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.increpas.therecipe.service.ADminOrderService;
import com.increpas.therecipe.vo.AdminOrderVO;


/**
 * 관리자 주문 관리 컨트롤러
 * @author 김지현
 *
 */
@Controller
public class AdminOrderController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ADminOrderService adminodlService;
	
	
	@RequestMapping(value = "/adminOrder.do", method = RequestMethod.GET)
	public String orderlist(@Valid @ModelAttribute("icmd")AdminOrderVO odVo, Model model){

		List<AdminOrderVO> odvo = adminodlService.selectOrder();
		
		model.addAttribute("odvo", odvo);
		
		return "adminOrderList";
		
	}
		
	@RequestMapping(value = "/adminOrderList.do", method = RequestMethod.GET)
	public String orderStatusList(@Valid @ModelAttribute("icmd")AdminOrderVO odVo, Model model, HttpServletRequest request){
		
		String orderid = (String)request.getParameter("orderid");
		AdminOrderVO odvo = adminodlService.selectOrderBycode(orderid);

		model.addAttribute("odvo", odvo);
		
		return "adminOrderUpdate";
		
	}
	
	@RequestMapping(value = "/adminOrderUpt.do", method = RequestMethod.POST)
	public String orderStatusUpt(@Valid @ModelAttribute("icmd")AdminOrderVO odVo, Model model, HttpServletRequest request){
		
		String userid = (String)request.getParameter("userid");
		String orderid = (String)request.getParameter("orderid");
		String dvystatus = (String)request.getParameter("dvystatus");
		
		int upt = adminodlService.uptOrderStatus(orderid,dvystatus);
		List<AdminOrderVO> odvo = adminodlService.selectOrder();
		
		model.addAttribute("odvo", odvo);
		
		return "adminOrderList";
		
	}

}
