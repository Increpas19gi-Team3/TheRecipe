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
import com.increpas.therecipe.util.BlankChange;
import com.increpas.therecipe.util.NullChange;
import com.increpas.therecipe.util.NullToBlank;

/**
 * 관리자) 지역음식, TV 레시피 카테고리 관리 컨트롤러
 * @author 손가연
 * 
 * 
 * 차후 작업이 필요한 내용
 * - 2nd : 미사용등록 → 3rd 등록시, 사용으로 등록해도 미사용으로 자동변경 하도록 해야 함. : sql에서  처리
 */
@Controller
public class AdminCategoryMgrController {

	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	AdminCategoryMgrService adminCategoryMgrService;
	
	
	/**
	 * 음식 코드(tr_foodcode) 가져오는 메소드
	 * @param model : Model
	 * @return : Model
	 */
	public Model getFoodcodeOnlyAll(Model model){
		// 개발용 Log
		String logMsg_01 = "getFoodcodeAll()";
		String logMsg_02 = "";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		//model.addAttribute("foodcodeAllList", adminCategoryMgrService.selectAllFoodcode());		
		model.addAttribute("foodcode1stList", adminCategoryMgrService.select1stFoodcode());
		model.addAttribute("foodcode2ndList", adminCategoryMgrService.selec2ndFoodcode());
		model.addAttribute("foodcode3rdList", adminCategoryMgrService.selec3rdFoodcode());
		
		return model;
	}
	
	
	/**
	 * 음식 코드(tr_foodcode + subQuery : tr_food count() ) 가져오는 메소드
	 * @param model : Model
	 * @return : Model
	 */
	public Model getFoodcodeWithFoodCntAll(Model model){
		// 개발용 Log
		String logMsg_01 = "getFoodcodeAll()";
		String logMsg_02 = "";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		//model.addAttribute("foodcodeAllList", adminCategoryMgrService.selectAllFoodcodeWithFoodCnt());		
		model.addAttribute("foodcode1stList", adminCategoryMgrService.select1stFoodcodeWithFoodCnt());
		model.addAttribute("foodcode2ndList", adminCategoryMgrService.selec2ndFoodcodeWithFoodCnt());
		model.addAttribute("foodcode3rdList", adminCategoryMgrService.selec3rdFoodcodeWithFoodCnt());
		
		return model;
	}
	
	
	
	/**
	 * 음식 코드 등록 form
	 * @param model : Model
	 * @param request : HttpServletRequest
	 * @return : String jsp파일명
	 */
	@RequestMapping(value="regCategory.do", method = RequestMethod.GET)
	public String regCategory_Form(Model model, HttpServletRequest request){

		// 개발용 Log
		String logMsg_01 = "regCategory.do";
		String logMsg_02 = "regCategory_Form()";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		model = getFoodcodeWithFoodCntAll(model);//Foodcode 가져오는 메소드
		
		return "adminCategoryReg";
	}
	
	
	
	/**
	 * 음식 코드 등록 proc
	 * @param model : Model
	 * @param request : HttpServletRequest
	 * @return : String jsp파일명
	 */
	@RequestMapping(value="regCategory.do", method = RequestMethod.POST)
	public String regCategory_Do(Model model, HttpServletRequest request){
	
		// 개발용 Log
		String logMsg_01 = "/regCategory.do";
		String logMsg_02 = "regCategory_Do()";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		
		String fc_ctgname = NullChange.doBlank(request.getParameter("fc_ctgname")); 
		String fc_1st = BlankChange.doStringZero(NullChange.doBlank(request.getParameter("fc_1st")));//null→ "" → "0" 
		String fc_2nd = BlankChange.doStringZero(NullChange.doBlank(request.getParameter("fc_2nd")));
		String fc_3rd = BlankChange.doStringZero(NullChange.doBlank(request.getParameter("fc_3rd")));
		String fc_isblock = NullChange.doBlank(request.getParameter("fc_isblock"));	
		logger.debug("▶▶▶▶ Log : {} {}", "param", "fc_1st="+fc_1st+", fc_2nd="+fc_2nd+", fc_3rd="+fc_3rd+", fc_isblock="+fc_isblock+", fc_ctgname="+fc_ctgname);

		
		//Error 처리
		if(fc_ctgname.length() == 0){
			model = getFoodcodeWithFoodCntAll(model);
			return "adminCategoryReg";
		}
		
		// Foodcode 추가
		adminCategoryMgrService.insertFoodcode(fc_1st, fc_2nd, fc_3rd, fc_ctgname, fc_isblock);
		
		
		model = getFoodcodeWithFoodCntAll(model);//Foodcode 가져오는 메소드
		return "adminCategoryReg";
	}
	
	
	
	/**
	 * 음식 코드 수정 / 삭제 폼
	 * @param model
	 * @param request
	 * @return : String jsp파일명
	 */
	@RequestMapping(value="modifyCategory.do", method = RequestMethod.GET)
	public String modifyCategory_Form(Model model, HttpServletRequest request){

		// 개발용 Log
		String logMsg_01 = "modifyCategory.do";
		String logMsg_02 = "modifyCategory_Form()";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		
		model = getFoodcodeWithFoodCntAll(model);//Foodcode 가져오는 메소드		
		return "adminCategoryModify";
	}
	
	
	
	/**
	 * 음식 코드 수정 proc
	 * @param model : Model
	 * @param request : HttpServletRequest
	 * @return : String jsp파일명
	 */
	@RequestMapping(value="modifyCategory.do", method = RequestMethod.POST)
	public String modifyCategory_Do(Model model, HttpServletRequest request){
	
		// 개발용 Log
		String logMsg_01 = "/modifyCategory.do";
		String logMsg_02 = "modifyCategory_Do()";
		logger.info("▶▶▶▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);

		
		
		String fc_ctgname = NullChange.doBlank(request.getParameter("fc_ctgname")); 
		String fc_1st = BlankChange.doStringZero(NullChange.doBlank(request.getParameter("fc_1st")));//null→ "" → "0" 
		String fc_2nd = BlankChange.doStringZero(NullChange.doBlank(request.getParameter("fc_2nd")));
		String fc_3rd = BlankChange.doStringZero(NullChange.doBlank(request.getParameter("fc_3rd")));
		String fc_isblock = NullChange.doBlank(request.getParameter("fc_isblock"));	
		logger.debug("▶▶▶▶ Log : {} {}", "param", "fc_1st="+fc_1st+", fc_2nd="+fc_2nd+", fc_3rd="+fc_3rd+", fc_isblock="+fc_isblock+", fc_ctgname="+fc_ctgname);
		

		//Error 처리
		if(fc_ctgname.length() == 0){
			model = getFoodcodeWithFoodCntAll(model);
			return "adminCategoryModify";
		}
		
		
		// Foodcode 수정
		adminCategoryMgrService.updateFoodcode(fc_1st, fc_2nd, fc_3rd, fc_ctgname, fc_isblock);
		
		
		model = getFoodcodeWithFoodCntAll(model);//Foodcode 가져오는 메소드
		return "adminCategoryModify";
	}
	
	
	
}
