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
public class TestIndexController {

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
	
	
	@RequestMapping("admin_SampleTable.do")
	public String goadmin_SampleTable(){
		
		// 개발용 Log
		String logMsg_01 = "admin_SampleTable.do";
		String logMsg_02 = "goadmin_SampleTable()";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		
		return "admin_SampleTable";//관리자 index 페이지로 보냄
	}
	
	@RequestMapping("admin_SampleUpdate.do")
	public String goadmin_SampleUpdate(){
		
		// 개발용 Log
		String logMsg_01 = "admin_SampleUpdate.do";
		String logMsg_02 = "goadmin_SampleUpdate()";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		
		return "admin_SampleUpdate";//관리자 index 페이지로 보냄
	}
	
	@RequestMapping("admin_SampleWrite.do")
	public String goadmin_SampleWrite(){
		
		// 개발용 Log
		String logMsg_01 = "admin_SampleWrite.do";
		String logMsg_02 = "goadmin_SampleWrite()";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		
		return "admin_SampleWrite";//관리자 index 페이지로 보냄
	}
	
}
