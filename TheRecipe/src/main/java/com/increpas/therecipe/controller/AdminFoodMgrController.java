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
import com.increpas.therecipe.util.BlankChange;
import com.increpas.therecipe.util.NullChange;
import com.increpas.therecipe.vo.FoodcodeVO;

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
	
	
	
	public Model getAdminFoodListAll(Model model, String fc_1st, String fc_2nd, String fc_3rd){
		// 개발용 Log
		String logMsg_01 = "getAdminFoodListAll()";
		String logMsg_02 = "";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		
		//model = adminCategoryMgrService.getFoodcodeOnlyAll(model);//카테고리관리 서비스에서 카테고리 정보를 가져옮
		
		logger.debug("▶▶▶▶ >>>>>>>> Log : {} {}", "getAdminFoodListAll()=", "fc_1st="+fc_1st+", fc_2nd="+fc_2nd+", fc_3rd="+fc_3rd);
		
		model.addAttribute("foodcode1stList", adminCategoryMgrService.select1stFoodcode());
		System.out.println("************************** 여기까이 이상 없음1");
		model.addAttribute("foodcode2ndList", adminCategoryMgrService.selectSel2ndFoodcode(fc_1st, fc_2nd, fc_3rd, "", ""));
		System.out.println("************************** 여기까이 이상 없음2");
//		model.addAttribute("foodcode3rdList", adminCategoryMgrService.selectSel3rdFoodcode(fc_1st, fc_2nd, fc_3rd, "", ""));
//		
//		model.addAttribute("foodAllList", adminFoodMgrService.selectAdminFoodListAll());
		
		return model;
	}
	
	
	
	
	
	@RequestMapping(value="/adminFoodMgr.do")
	public String adminFoodList(Model model, HttpServletRequest request){
		// 개발용 Log
		String logMsg_01 = "/adminFoodMgr.do";
		String logMsg_02 = "adminFoodList()";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		//글보기 설정
				
		//String fc_ctgname = NullChange.doBlank(request.getParameter("fc_ctgname")); 
		String fc_1st = BlankChange.doStringNumber(NullChange.doBlank(request.getParameter("fc_1st")), "1");//null → "" → "1" 
		String fc_2nd = BlankChange.doStringZero(NullChange.doBlank(request.getParameter("fc_2nd")));
		String fc_3rd = BlankChange.doStringZero(NullChange.doBlank(request.getParameter("fc_3rd")));
		//String fc_isblock = NullChange.doBlank(request.getParameter("fc_isblock"));	
		//logger.debug("▶▶▶▶ Log : {} {}", "param", "fc_1st="+fc_1st+", fc_2nd="+fc_2nd+", fc_3rd="+fc_3rd+", fc_isblock="+fc_isblock+", fc_ctgname="+fc_ctgname);
		logger.debug("▶▶▶▶ Log : {} {}", "param", "fc_1st="+fc_1st+", fc_2nd="+fc_2nd+", fc_3rd="+fc_3rd);
		
		FoodcodeVO fcVO = adminCategoryMgrService.setFoodcodeVO(fc_1st, fc_2nd, fc_3rd, "", "");
		model.addAttribute("fc_1st", fcVO.getFc_1st());
		model.addAttribute("fc_2nd", fcVO.getFc_2nd());
		model.addAttribute("fc_3rd", fcVO.getFc_3rd());
		
		
		//정렬
		String sortColumn = NullChange.doBlank(request.getParameter("sortColumn"));
		String orderby = NullChange.doBlank(request.getParameter("orderby"));
		System.out.println("sortColumn="+sortColumn+", orderby="+orderby);
		model.addAttribute("sortColumn", sortColumn);
		model.addAttribute("orderby", orderby);
		
		//검색
		String whereColumn = NullChange.doBlank(request.getParameter("whereColumn")); 
		String word = NullChange.doBlank(request.getParameter("word"));
		System.out.println("whereColumn="+whereColumn+", word="+word);
		model.addAttribute("whereColumn", whereColumn);
		model.addAttribute("word", word);
		
		
		
		//페이징  처리
		String cutCount = NullChange.doBlank(request.getParameter("pageCutCount"));
		int pageCutCount =  cutCount.equals("") ? 5 : Integer.parseInt(cutCount);//표시할 게시글 갯수
		System.out.println("pageCutCount="+pageCutCount);		
		
		String pn = NullChange.doBlank(request.getParameter("pn"));
		// 최종 모델 : BoardVOListModel, 페이지의 시작과 마지막 번호 // FC 에게 리턴
		int requestPageNumber = pn.equals("") ? 1 : Integer.parseInt(pn);
		System.out.println("pn="+requestPageNumber);
		
		
		
		
		
		model = getAdminFoodListAll(model, fc_1st, fc_2nd, fc_3rd);
		
		return "adminFoodList";
	}

	
}
