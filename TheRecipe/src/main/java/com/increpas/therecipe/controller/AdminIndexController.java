package com.increpas.therecipe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 개발용 - 관리자 페이지 분기용 컨트롤러
 * @author 손가연
 *
 */
@Controller
public class AdminIndexController {

	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("adminIndex.do")
	public String goIndex(){
		
		// 개발용 Log
		String logMsg_01 = "adminIndex.do";
		String logMsg_02 = "goIndex()";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		
		return "adminIndex";//관리자 index 페이지로 보냄
	}
}
