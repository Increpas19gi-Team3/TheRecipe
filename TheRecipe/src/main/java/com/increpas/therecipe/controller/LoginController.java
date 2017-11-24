package com.increpas.therecipe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.increpas.therecipe.service.LoginService;

/**
 * 
 * @author 한범석, 박호진
 *
 */
@Controller
 public class LoginController {

	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	LoginService loginService;
	
	
	@RequestMapping(value="/loginTest.do")
	public String testingMemberDB(Model model){
		
		// 개발용 Log
		String logMsg_01 = "/loginTest.do";
		String logMsg_02 = "testingMemberDB()";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		model.addAttribute("memberList", loginService.selectAllMember());
		
		return "loginTestRS";
	}
	
	
}
