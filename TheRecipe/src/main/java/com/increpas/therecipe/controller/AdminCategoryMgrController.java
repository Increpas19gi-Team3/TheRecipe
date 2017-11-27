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
import com.increpas.therecipe.util.NullToBlank;

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
	//public String regCategory_Do(@Valid @ModelAttribute("regFoodCode") FoodcodeVO fcVO, Errors errors, Model model, HttpServletRequest request){
	public String regCategory_Do(Model model, HttpServletRequest request){
	
		// 개발용 Log
		String logMsg_01 = "/regCategory.do";
		String logMsg_02 = "regCategory_Do()";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);

		
		String fc_ctgname = NullToBlank.doChange(request.getParameter("fc_ctgname"));
		String[] fc_1stArr = request.getParameterValues("fc_1st");
		System.out.println("fc_1st="+fc_1stArr[0]);
		
		String[] fc_2ndArr = request.getParameterValues("fc_2nd");
		System.out.println("fc_2nd="+fc_2ndArr[0]);
		
		
		//생성 구분자 - category2, category3 
		String newCategory = "";
		if(fc_2ndArr[0].equals("")) newCategory = fc_1stArr[0]; // 중분류 일때 : 대
		else newCategory = fc_2ndArr[0]; // 소분류 일때 : 대_중
		
		logger.debug("▶▶▶▶ Log : {}, newCategory={}", fc_ctgname, newCategory);

		//Error 처리
		if(fc_ctgname.length() == 0){
			model = getFoodcodeAll(model);
			return "adminCategoryReg";
		}
		
//		System.out.println("errors.hasErrors() = "+ errors.hasErrors());
//		if (errors.hasErrors()) {
//			model = getFoodcodeAll(model);
//			return "adminCategoryReg";
//		}
		
		// Foodcode 추가
		adminCategoryMgrService.addFoodcode(newCategory, fc_ctgname);
		
		
		model = getFoodcodeAll(model);//Foodcode 가져오는 메소드
		return "adminCategoryReg";
	}
	
	
	//<li><a href="regCategory.do"> 카테고리 관리(등록) </a></li>
	//<li><a href="modifyCategory.do"> 카테고리 관리(수정,삭제) </a></li>
	//return "redirect:index.jsp";
}
