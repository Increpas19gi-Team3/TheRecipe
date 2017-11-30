package com.increpas.therecipe.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.increpas.therecipe.service.AdminCategoryMgrService;
import com.increpas.therecipe.service.AdminFoodMgrService;

/**
 * 관리자) 지역음식, TV 레시피 음식 등록 관리 컨트롤러
 * @author 손가연
 * 
 * 
 */
@Controller
public class AdminFoodMgrController {

	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	AdminFoodMgrService adminFoodMgrService;
	
	@Autowired
	AdminCategoryMgrService adminCategoryMgrService;
	
	
	
	public Model getAdminFoodListAll(Model model){
		// 개발용 Log
		String logMsg_01 = "getAdminFoodListAll()";
		String logMsg_02 = "";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		
		model = adminCategoryMgrService.getFoodcodeOnlyAll(model);//카테고리관리 서비스에서 카테고리 정보를 가져옮
		model.addAttribute("foodAllList", adminFoodMgrService.selectAdminFoodListAll());
		
		return model;
	}
	
	
	
	
	
	@RequestMapping(value="/adminFoodMgr.do")
	public String adminFoodList(Model model, HttpServletRequest request){
		// 개발용 Log
		String logMsg_01 = "/adminFoodMgr.do";
		String logMsg_02 = "adminFoodList()";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		model = getAdminFoodListAll(model);
		
		return "adminFoodList";
	}

	
}
