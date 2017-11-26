package com.increpas.therecipe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.increpas.therecipe.service.AdminCategoryMgrService;
import com.increpas.therecipe.vo.FoodcodeVO;

/**
 * 관리자) 지역음식, TV 레시피 카테고리 관리 컨트롤러
 * @author 손가연
 * 
 * 
 */
@Controller
public class AdminCategoryMgrController {

	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	AdminCategoryMgrService adminCategoryMgrService;
	
	
	/**
	 * 음식 코드 가져오는 메소드
	 * @param model
	 * @return
	 */
	public Model getFoodcodeAll(Model model){
		// 개발용 Log
		String logMsg_01 = "getFoodcodeAll()";
		String logMsg_02 = "";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		model.addAttribute("foodcodeAllList", adminCategoryMgrService.selectAllFoodcode());
		
		model.addAttribute("foodcode1stList", adminCategoryMgrService.select1stFoodcode());
		model.addAttribute("foodcode2ndList", adminCategoryMgrService.selec2ndFoodcode());
		model.addAttribute("foodcode3rdList", adminCategoryMgrService.selec3rdFoodcode());
		
		return model;
	}
	
	/**
	 * 음식 코드 등록 form
	 * @return
	 * adminCategoryMgr
	 */
	@RequestMapping(value="regCategory.do", method = RequestMethod.GET)
	public String regCategory_Form(Model model, HttpServletRequest request){

		// 개발용 Log
		String logMsg_01 = "regCategory.do";
		String logMsg_02 = "regCategory_Form()";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		model = getFoodcodeAll(model);//Foodcode 가져오는 메소드
		
		return "adminCategoryReg";
	}
	
	/**
	 * 음식 코드 등록 proc
	 * @return
	 */
	@RequestMapping(value="regCategory.do", method = RequestMethod.POST)
	public String regCategory_Do(@Valid @ModelAttribute("regFoodCode") FoodcodeVO fcVO, Errors errors, Model model, HttpServletRequest request){

		// 개발용 Log
		String logMsg_01 = "/regCategory.do";
		String logMsg_02 = "regCategory_Do()";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);

		
		
		String regFoodecode = request.getParameter("regFoodcode");
		logger.debug("▶▶▶▶ Log : {}, {}", fcVO.toString() , regFoodecode);

		if (errors.hasErrors()) {
			model = getFoodcodeAll(model);
			return "adminCategoryReg";
		}
		
		
		return "adminCategoryReg";
	}
	
	
	//<li><a href="regCategory.do"> 카테고리 관리(등록) </a></li>
	//<li><a href="modifyCategory.do"> 카테고리 관리(수정,삭제) </a></li>
	//return "redirect:index.jsp";
}
