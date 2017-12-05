package com.increpas.therecipe.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.increpas.therecipe.dto.AdminEventSetFoodListDTO;
import com.increpas.therecipe.service.AdminCategoryMgrService;
import com.increpas.therecipe.service.AdminEventMgrService;
import com.increpas.therecipe.util.BlankChange;
import com.increpas.therecipe.util.NullChange;
import com.increpas.therecipe.vo.FoodcodeVO;

/**
 * 관리자) 이벤트 등록 관리 컨트롤러
 * @author 손가연
 * 
 * 
 */
@Controller
public class AdminEventMgrController {

	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	AdminEventMgrService adminEventMgrService;
	
	@Autowired
	AdminCategoryMgrService adminCategoryMgrService; //카테고리 정보를 가져오기 위한 컨트롤러
	
	
	
	/**
	 * 카테고리 가져오기
	 * @param model
	 * @param fc_1st
	 * @param fc_2nd
	 * @param fc_3rd
	 * @return
	 */
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
	
	
	/**
	 * 
	 * @param model : Model
	 * @return : String jsp파일명
	 */
	@RequestMapping(value="/adminEventMgr.do")
	public String adminEventMgr(Model model, HttpServletRequest request){
		
		// 개발용 Log
		String logMsg_01 = "/adminEventMgr.do";
		String logMsg_02 = "adminEventMgr()";
		logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
		
		
		String reg_selEventCode = NullChange.doBlank(request.getParameter("selEventCode"));
		String selEventCode = reg_selEventCode.equals("") ? "ALL" : reg_selEventCode; 
		model.addAttribute("selEventCode", selEventCode);
				
		
		// 카테고리 작업
		String fc_1st = BlankChange.doStringNumber(NullChange.doBlank(request.getParameter("fc_1st")), "1");//null → "" → "1" 
		String fc_2nd = BlankChange.doStringZero(NullChange.doBlank(request.getParameter("fc_2nd")));
		String fc_3rd = BlankChange.doStringZero(NullChange.doBlank(request.getParameter("fc_3rd")));
		//String fc_ctgname = NullChange.doBlank(request.getParameter("fc_ctgname"));
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
		
		
		
		model.addAttribute("eventAllList", adminEventMgrService.selectAllEvent());//이벤트 목록 설정
		//model.addAttribute("eventSelFoodList", adminEventMgrService.selectSelEventFood(selEventCode)); //게시글 가져오기 페이징X, 검색X, 정렬X
		
		AdminEventSetFoodListDTO eventSetFoodListDTO = adminEventMgrService.getEventSetFoodList(pageCutCount, requestPageNumber, 
					whereColumn, word, sortColumn, orderby, 
					fcVO.getFc_1st(), fcVO.getFc_2nd(), fcVO.getFc_3rd(), selEventCode);
		model.addAttribute("eventSelFoodList", eventSetFoodListDTO);
		
		
		model = getAdminFoodListAll(model, fc_1st, fc_2nd, fc_3rd); // 카테고리 정보를 가져옮
		
		
		// 페이지 네비게이션바 설정
		if (eventSetFoodListDTO.getTotalPageCount() > 0) {
			
			// 리스트 화면의 페이지의 시작번호 
			int beginPageNumber = (eventSetFoodListDTO.getRequestPage() - 1) / 10 * 10 + 1;
			// 리스트 화면의 페이지의 마지막번호
			int endPageNumber = beginPageNumber + 9;
			if (endPageNumber > eventSetFoodListDTO.getTotalPageCount()) {
				endPageNumber = eventSetFoodListDTO.getTotalPageCount();
			}
			
			model.addAttribute("beginPage", beginPageNumber);//글 시작페이지
			model.addAttribute("endPage", endPageNumber);
		}
		
		model.addAttribute("totalBoardVOCount", adminEventMgrService.getTotalBoardVOCount(eventSetFoodListDTO));
		model.addAttribute("eventAllListToday", adminEventMgrService.selectAllEventToday());//오늘기준 이벤트 목록 설정
		
		return "adminEventMgrList";
	}
	
	

	/**
	 * 이벤트 설정 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/adminEventsetFood.do")
	public String adminEventsetFood_Do(Model model, HttpServletRequest request){
		
		String[] chk_fdcodeArr = request.getParameterValues("chk_fdcode");

		/*if(chk_fdcodeArr != null){
			for(int i=0; i< chk_fdcodeArr.length; i++){
				System.out.println("********************************* chk_fdcodeArr["+i+"] = "+ chk_fdcodeArr[i]);
			}
		}*/
		
		if(chk_fdcodeArr != null){
			String setEventCode = request.getParameter("setEventCode");
			// 설정하기
			adminEventMgrService.updateEventSetFood(chk_fdcodeArr, setEventCode);
		}
		
		return "redirect:/adminEventMgr.do";
	}
}
