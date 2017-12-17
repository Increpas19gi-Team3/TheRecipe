package com.increpas.therecipe.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.increpas.therecipe.service.AdminCategoryMgrService;
import com.increpas.therecipe.service.AdminMemberMgrService;
import com.increpas.therecipe.vo.MemberInfoVO;

/**
 * 관리자) 관리자 회원 관리 컨트롤러
 * @author 손가연
 *
 */

@Controller
public class AdminMemberMgrController {

	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	AdminMemberMgrService adminMemberMgrService; 
	
	
	
	/**
	 * 회원 정보 가져와서 출력
	 * @param model : Model
	 * @param request : HttpServletRequest
	 * @return
	 */
	@RequestMapping(value = "adminMember.do", method = RequestMethod.GET)
	public String getMemberList(Model model, HttpServletRequest request){
		
		// 1: 최고 관리자, 2: 일반 관리자
		int m_level = (Integer)request.getSession().getAttribute("m_level");
		List<MemberInfoVO> list = adminMemberMgrService.selectAllMemberInfo(m_level);
		
		model.addAttribute("list", list);
		
		return "adminMemberMgrList";
	}
	
	
	/**
	 * 관리자 권한 변경
	 * @param model : Model
	 * @param request : HttpServletRequest
	 * @return
	 */
	@RequestMapping(value = "adminMemberSet.do", method = RequestMethod.GET)
	public String setMemberLevel(Model model, HttpServletRequest request){
		
		String targetId = request.getParameter("targetId");
		String targetCode = request.getParameter("targetCode");
		//System.out.println("targetId="+targetId+", targetCode="+targetCode);
		
		
		// 관리자 권한 변경
		adminMemberMgrService.modifyMemberLevel(targetId, targetCode);
		
		return "redirect:adminMember.do";
	}
	
}
