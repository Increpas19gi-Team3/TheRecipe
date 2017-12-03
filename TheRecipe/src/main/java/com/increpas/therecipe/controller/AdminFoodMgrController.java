package com.increpas.therecipe.controller;

import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;

import com.increpas.therecipe.dto.AdminFoodListDTO;
import com.increpas.therecipe.dto.AdminFoodRegDTO;
import com.increpas.therecipe.service.AdminCategoryMgrService;
import com.increpas.therecipe.service.AdminFoodMgrService;
import com.increpas.therecipe.util.BlankChange;
import com.increpas.therecipe.util.NullChange;
import com.increpas.therecipe.vo.FoodMgrVO;
import com.increpas.therecipe.vo.FoodcodeVO;

/**
 * 관리자) 지역음식, TV 레시피 음식 등록 관리 컨트롤러
 * @author 손가연
 * 
 * modifyFoodMgr.do
adminFoodModify.jsp
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
		
		logger.debug("▶▶▶▶ >>>>>>>> Log : {} {}", 
				"getAdminFoodListAll()=", "fc_1st="+fc_1st+", fc_2nd="+fc_2nd+", fc_3rd="+fc_3rd);
		FoodcodeVO fcVO = adminCategoryMgrService.setFoodcodeVO(fc_1st, fc_2nd, fc_3rd, "", "");
		
		// 음식 카테고리 설정
		model.addAttribute("foodcode1stList", adminCategoryMgrService.select1stFoodcode());
		model.addAttribute("foodcode2ndList", adminCategoryMgrService.selectSel2ndFoodcode(fcVO));
		model.addAttribute("foodcode3rdList", adminCategoryMgrService.selectSel3rdFoodcode(fcVO));
		
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
		//System.out.println("pageCutCount="+pageCutCount);
		model.addAttribute("pageCutCount", pageCutCount);
		
		String pn = NullChange.doBlank(request.getParameter("pn"));
		// 최종 모델 : BoardVOListModel, 페이지의 시작과 마지막 번호 // FC 에게 리턴
		int requestPageNumber = pn.equals("") ? 1 : Integer.parseInt(pn);
		//System.out.println("pn="+requestPageNumber);
		model.addAttribute("pn", requestPageNumber);
		
		
		AdminFoodListDTO foodListDTO = adminFoodMgrService.getFoodMgrVOList(pageCutCount, requestPageNumber, whereColumn, word, sortColumn, orderby, 
				fcVO.getFc_1st(), fcVO.getFc_2nd(), fcVO.getFc_3rd());
		model.addAttribute("foodList", foodListDTO);// 검색, 페이징을 적용한 DB 데이터
		
		model = getAdminFoodListAll(model, fc_1st, fc_2nd, fc_3rd); // 카테고리 정보를 가져옮
		
		
		// 페이지 네비게이션바 설정
		if (foodListDTO.getTotalPageCount() > 0) {
			
			// 리스트 화면의 페이지의 시작번호 
			int beginPageNumber = (foodListDTO.getRequestPage() - 1) / 10 * 10 + 1;
			// 리스트 화면의 페이지의 마지막번호
			int endPageNumber = beginPageNumber + 9;
			if (endPageNumber > foodListDTO.getTotalPageCount()) {
				endPageNumber = foodListDTO.getTotalPageCount();
			}
			
			model.addAttribute("beginPage", beginPageNumber);//글 시작페이지
			model.addAttribute("endPage", endPageNumber);
		}
		return "adminFoodList";
	}


	
	@RequestMapping(value="/adminFoodView.do")
	public String adminFoodView(Model model, HttpServletRequest request){
				
		String f_fdcode = BlankChange.doStringNumber(NullChange.doBlank(request.getParameter("no")), "0");//null → "" → "1"
		
		model.addAttribute("foodView", adminFoodMgrService.selFoodView(f_fdcode));
		
		return "adminFoodView";
	}
	
	
	/**
	 * 음식 등록 폼으로 이동
	 * @return adminFoodReg.jsp
	 */
	@RequestMapping(value="/regFoodMgr.do", method = RequestMethod.GET)
	public String adminFoodReg(Model model, HttpServletRequest request){
		
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
		
		
		
		model = getAdminFoodListAll(model, fc_1st, fc_2nd, fc_3rd); // 카테고리 정보를 가져옮
		
		return "adminFoodReg";
	}
	
	
	@RequestMapping(value="/regFoodMgr.do", method = RequestMethod.POST)
	public String adminFoodReg_Do(@Valid @ModelAttribute("foodReg") AdminFoodRegDTO adminFoodRegDTO, Errors errors, 
			Model model){
		
		
		
		int fc_1st = adminFoodRegDTO.getFc_1st();	//BlankChange.doStringNumber(NullChange.doBlank(request.getParameter("fc_1st")), "1");//null → "" → "1" 
		int fc_2nd = adminFoodRegDTO.getFc_2nd(); //BlankChange.doStringZero(NullChange.doBlank(request.getParameter("fc_2nd")));
		int fc_3rd = adminFoodRegDTO.getFc_3rd(); //BlankChange.doStringZero(NullChange.doBlank(request.getParameter("fc_3rd")));
		System.out.println(">>>>>>>>>>>>> fc_1st ="+fc_1st+", fc_2nd="+fc_2nd+", fc_3rd="+fc_3rd);
		
		String f_foodname = adminFoodRegDTO.getF_foodname(); //NullChange.doBlank(request.getParameter("f_foodname"));
		int f_price = adminFoodRegDTO.getF_price(); //NullChange.doBlank(request.getParameter("f_price"));
		String f_isblock = adminFoodRegDTO.getF_isblock(); //NullChange.doBlank(request.getParameter("f_isblock"));
		String f_explan = adminFoodRegDTO.getF_explan(); //NullChange.doBlank(request.getParameter("f_explan"));
		System.out.println(">>>>>>>>>> f_foodname="+f_foodname+", f_price="+f_price
				+", f_isblock=" + f_isblock+", f_explan="+f_explan);
		
		
		adminFoodMgrService.saveImagesSetting(adminFoodRegDTO, model);
		System.out.println("DATA : " + adminFoodRegDTO.toString());
		
		
		return "adminFoodList";
	}
}
