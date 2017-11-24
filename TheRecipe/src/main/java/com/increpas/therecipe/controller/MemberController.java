package com.increpas.therecipe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.increpas.therecipe.service.MemberService;

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
		
		
	
}
