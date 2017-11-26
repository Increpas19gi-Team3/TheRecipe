package com.increpas.therecipe.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.increpas.therecipe.service.MemberService;
import com.increpas.therecipe.vo.MemberVO;

/**
 * 
 * @author 박호진
 *
 *	회원가입 회원탈퇴 정보수정
 * 
 */

@Controller
public class MemberController {
	
	// slf4j 방식 로그
		Logger logger = LoggerFactory.getLogger(getClass());
		
		@Autowired
		MemberService memberService;
		
		@RequestMapping(value="/reg.do")
		public String regMember(@Valid @ModelAttribute("member") MemberVO mVo, Errors errors) {
		
			// 개발용 Log
			String logMsg_01 = "/reg.do";
			String logMsg_02 = "regMember()";
			logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
			
			if (errors.hasErrors()) {
				return "regform";
			}
			
			int rownum = memberService.insertMember();
			
			
//			model.addAttribute(, memberService.insertMember());
			
			return "loginTestRS";
			
		}
	
}
