package com.increpas.therecipe.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.increpas.therecipe.service.AdminCategoryMgrService;
import com.increpas.therecipe.service.AdminEventMgrService;
import com.increpas.therecipe.util.BlankChange;
import com.increpas.therecipe.util.NullChange;

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
		
		
		String selEventCode = NullChange.doBlank(request.getParameter("selEventCode"));
		String e_evtcode = selEventCode.equals("") ? "ALL" : selEventCode; 
		
				
		
		String fc_ctgname = NullChange.doBlank(request.getParameter("fc_ctgname")); 
		String fc_1st = BlankChange.doStringZero(NullChange.doBlank(request.getParameter("fc_1st")));//null→ "" → "0" 
		String fc_2nd = BlankChange.doStringZero(NullChange.doBlank(request.getParameter("fc_2nd")));
		String fc_3rd = BlankChange.doStringZero(NullChange.doBlank(request.getParameter("fc_3rd")));
		String fc_isblock = NullChange.doBlank(request.getParameter("fc_isblock"));	
		logger.debug("▶▶▶▶ Log : {} {}", "param", "fc_1st="+fc_1st+", fc_2nd="+fc_2nd+", fc_3rd="+fc_3rd+", fc_isblock="+fc_isblock+", fc_ctgname="+fc_ctgname);
		
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
		
		
		
		model.addAttribute("eventAllList", adminEventMgrService.selectAllEvent());
		//model.addAttribute("eventSelFoodList", adminEventMgrService.selectSelEventFood(e_evtcode));
		
		return "adminEventMgrList";
	}
	
	
}
