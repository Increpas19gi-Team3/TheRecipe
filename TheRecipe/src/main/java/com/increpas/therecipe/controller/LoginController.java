package com.increpas.therecipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.increpas.therecipe.service.LoginService;

/**
 * 
 * @author 한범석, 박호진
 *
 */
@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/loginTest.do")
	public String testingMemberDB(Model model){
		
		System.out.println("loginTest.do :: ");
		model.addAttribute("memberList", loginService.selectAllMember());
		
		return "loginTestRS";
	}
	
	
}
