package com.increpas.therecipe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.increpas.therecipe.service.AdminCategoryMgrService;

/**
 * 관리자) 이벤트 등록 관리 컨트롤러
 * @author 손가연
 * 
 * Ajax 테스트용 파일
 */
@Controller
public class AdminEventMgrController {

	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	AdminCategoryMgrService adminCategoryMgrService;
	
	
	@RequestMapping(value="/adminEventMgr.do")
	public String testingAjax(Model model){
		
		// 개발용 Log
		String logMsg_01 = "/adminEventMgr.do";
		String logMsg_02 = "testingAjax()";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		//model.addAttribute("memberList", adminCategoryMgrService.selectAllMember());
		
		return "adminEventMgrList";
	}
	
	
}
