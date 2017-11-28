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

	// 메인페이지로 이동
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String homeForm() {

		return "home";
	}
	// 로그인 뷰이동

	@RequestMapping(value = "/loginView.do", method = RequestMethod.GET)
	public String loginForm() {

		return "loginView";
	}

	// 로그인 기능
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
			return "loginView";

		} else {
			session.setAttribute("m_userid", m_userid);
			session.setAttribute("m_level", m_level);
		}
		return "home";
	}

	// 로그아웃
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.setAttribute("m_userid", null);
		return "redirect:home.do";
	}

	// 아이디찾기 뷰
	@RequestMapping(value = "/forgetId.do", method = RequestMethod.GET)
	public String findIdViewGet() {

		return "forgetId";
	}

	// 아이디 찾기
	@RequestMapping(value = "/fine_Id.do", method = RequestMethod.POST)
	public String findIdSubmit(@Valid @ModelAttribute("id_find") MemberVO vo, Errors errors, HttpSession session,
			Model model) {
		if (errors.hasErrors()) {
			logger.info("아이디 찾기 유효성체크 오류발생");
		}
		String m_email = vo.getM_email();
		vo = loginService.selectFindId(m_email);

		// 이메일 존재 여부 확인
		if (vo == null) {
			model.addAttribute("m_email", m_email);
			model.addAttribute("message", "존재하지 않는 이메일 입니다.");
			return "forgetId";

		} else {
			
			model.addAttribute("vo", vo);
		}
		//성공하면 보여줄 결과창
		return "resultId";
	}
	
	// 비밀번호 찾기 뷰
	@RequestMapping(value = "/forgetPw.do", method = RequestMethod.GET)
	public String findPwViewGet() {

		return "forgetPw";
	}

	// 비밀번호 찾기
	@RequestMapping(value = "/fine_Pw.do", method = RequestMethod.POST)
	public String findPwSubmit(@Valid @ModelAttribute("pw_find") MemberVO vo, Errors errors, Model model) {
		if (errors.hasErrors()) {
			logger.info("비밀번호 유효성체크 오류발생");
		}
		String m_userid = vo.getM_userid();
		vo = loginService.selectFindPw(m_userid);

		// 이메일 존재 여부 확인
		if (vo == null) {
			model.addAttribute("m_userid", m_userid);
			model.addAttribute("message", "존재하지 않는 아이디 입니다.");
			return "forgetPw";

		} else {
			
			model.addAttribute("vo", vo);
		}
		//성공하면 보여줄 결과창
		return "resultPw";
	}

}
