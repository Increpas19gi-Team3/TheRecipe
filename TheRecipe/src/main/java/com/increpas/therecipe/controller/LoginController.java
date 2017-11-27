package com.increpas.therecipe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.increpas.therecipe.service.LoginService;
import com.increpas.therecipe.vo.MemberVO;

/**
 * 
 * @author 한범석, 박호진
 *
 *         로그인 컨트롤러
 * 
 * 
 * 
 */
@Controller
public class LoginController {

	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/loginView.do", method = RequestMethod.GET)
	public String loginForm() {

		return "loginView";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginSubmit(@Valid @ModelAttribute("member") MemberVO vo, Errors errors, HttpSession session,
			Model model) {
		if (errors.hasErrors()) {
			logger.info("로그인 유효성체크 오류발생");

			return "loginView";
		}

		String m_userid = vo.getM_userid();
		String m_pw = vo.getM_pw();
		int m_level = vo.getM_level();

		vo = loginService.selectLogin(m_userid, m_pw);

		// 아이디 존재 여부 확인
		if (vo == null) {
			model.addAttribute("m_userid", m_userid);
			model.addAttribute("message", "존재하지 않는 아이디 입니다.");

		} else{
			session.setAttribute("m_userid", m_userid);
			session.setAttribute("m_level", m_level);
		}
		return "redirect:home";
	}

}
