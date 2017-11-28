package com.increpas.therecipe.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.increpas.therecipe.service.MemberService;
import com.increpas.therecipe.vo.MemberVO;

/**
 * 
 * @author 박호진
 *
 *         회원가입 회원탈퇴 정보수정
 * 
 */

@Controller
public class MemberController {

	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	MemberService memberService;

	/*
	 * @RequestMapping(value="/reg.do") public String
	 * regMember(@Valid @ModelAttribute("member") MemberVO mVo, Errors errors) {
	 * 
	 * // 개발용 Log String logMsg_01 = "/reg.do"; String logMsg_02 =
	 * "regMember()"; logger.info("▶▶▶ Log : {}, {}", logMsg_01, logMsg_02);
	 * 
	 * if (errors.hasErrors()) { return "regform"; }
	 * 
	 * int rownum = memberService.insertMember();
	 * 
	 * 
	 * // model.addAttribute(, memberService.insertMember());
	 * 
	 * return "loginTestRS";
	 * 
	 * }
	 */

	// mypage 정보 전송
	@RequestMapping(value = "/mypageInfo.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String mypageInfo(Model model, HttpSession session) {

		String m_userid = (String) session.getAttribute("m_userid");
		
		MemberVO mVo = memberService.selectMyInfo(m_userid);
		System.out.println(">>>>  mVo="+mVo.toString());
		model.addAttribute("mVo", mVo);
		

		// 성공하면 보여줄 결과창
		return "myPage";
	}

	/*
	 * // 회원탈퇴 뷰
	 * 
	 * @RequestMapping(value = "/id_Delete.do", method = RequestMethod.GET)
	 * public String id_DeleteGet() {
	 * 
	 * return "id_Delete"; }
	 * 
	 * //회원탈퇴
	 * 
	 * @RequestMapping(value = "/delete_Id.do", method = RequestMethod.POST)
	 * public String deleteIdViewGet(@Valid @ModelAttribute("id_delete")
	 * MemberVO vo, Errors errors, HttpSession session, Model model){ if
	 * (errors.hasErrors()){ logger.info("회원탈퇴 유효성체크 오류발생"); } String m_userid =
	 * vo.getM_userid(); vo = loginService.deleteId(m_userid);
	 * 
	 * return "forgetDelete"; }
	 */

}
