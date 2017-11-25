package com.increpas.therecipe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserIndexController {

	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("userIndex.do")
	public String goIndex(){
		
		// 개발용 Log
		String logMsg_01 = "adminIndex.do";
		String logMsg_02 = "goIndex()";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		
		return "userIndex";
	}
}
