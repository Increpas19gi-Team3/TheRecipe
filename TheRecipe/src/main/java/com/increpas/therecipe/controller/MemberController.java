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

import com.increpas.therecipe.service.MemberService;
import com.increpas.therecipe.vo.MemberVO;

/**
 * 회원등록 회원탈퇴 회원정보 조회,수정 관련 컨트롤러
 * 
 * @author 박호진
 *
 */

@Controller
public class MemberController {

	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	MemberService memberService;

	/**
	 * 회원가입페이지로 이동
	 * 
	 * @return 회원가입페이지
	 */
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String joinForm() {

		return "join";
	}

	/**
	 * 회원가입
	 * 
	 * @param mVo
	 *            MemberVO
	 * @param request
	 *            HttpServletRequest
	 * @return 로그인뷰로 이동
	 */
	@RequestMapping(value = "/joinReg.do", method = RequestMethod.POST)
	public String jonReg(@ModelAttribute("memberjoin") MemberVO mVo, HttpServletRequest request) {

		String repw = request.getParameter("m_repw");
		String m_pw = request.getParameter("m_pw");

		if (!repw.equals(m_pw)) {

			return "join";
		}

		else {
			System.err.println(mVo.toString());
			memberService.insertMember(mVo);

			return "loginView";
		}

	}

	/**
	 * 마이페이지로 이동
	 * 
	 * @param model
	 *            model
	 * @param session
	 *            세션사용
	 * @return 마이페이지로 이동
	 */
	@RequestMapping(value = "/mypageInfo.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String mypageInfo(Model model, HttpSession session) {

		String m_userid = (String) session.getAttribute("m_userid");

		MemberVO mVo = memberService.selectMyInfo(m_userid);
		System.out.println(">>>>  mVo=" + mVo.toString());
		model.addAttribute("mVo", mVo);

		// 성공하면 보여줄 결과창
		return "myPage";
	}

	/**
	 * 내정보 수정
	 * 
	 * @param mVo
	 *            MemberVO
	 * @param model
	 *            Model
	 * @return 내 정보 보기페이지로 이동
	 */
	@RequestMapping(value = "/mypageupdate.do", method = RequestMethod.POST)
	public String mypageupdate(@ModelAttribute("memberup") MemberVO mVo, HttpServletRequest request) {
		logger.info(mVo.toString());

		String repw = request.getParameter("m_repw");
		String m_pw = request.getParameter("m_pw");

		if (!repw.equals(m_pw)) {

			return "home";
		}

		else {
			memberService.updateMyInfo(mVo);

			return "redirect:mypageInfo.do";
		}

	}

	/**
	 * 
	 * 아이디 중복 체크로 이동
	 * 
	 * @return 아이디 중복 체크 페이지로 이동
	 */
	@RequestMapping(value = "/idcheck.do", method = RequestMethod.GET)
	public String IdCheck() {

		return "idcheck";
	}

	/**
	 * 
	 * @param model
	 * 				Model model
	 * @param request
	 * 				HttpServletRequest request
	 * @return 회원가입 페이지로 이동
	 */
	@RequestMapping(value = "/idchecksuccess.do", method = RequestMethod.POST)
	public String IdCheck(Model model, HttpServletRequest request) {

		String checkId = request.getParameter("checkid");

		int userCnt = Integer.parseInt(memberService.checkId(checkId));

		String msg = "";
		if (userCnt >= 1) {
			msg = "사용중인 아이디 입니다.";
		} else {
			msg = "사용하실 수 있는 아이디 입니다.";
		}
		model.addAttribute("msg", msg);

		return "join";
	}

	/**
	 * 
	 * 회원탈퇴
	 * 
	 * @return 회원탈퇴 페이지(비밀번호)로 이동
	 */

	@RequestMapping(value = "/delete_Id.do", method = RequestMethod.GET)
	public String deleteIdViewGet() {
		return "deleteRePw";
	}


	/**
	 * 
	 * @param vo
	 * 			  MemberVO vo
	 * @param errors
	 * 			  Errors errors
	 * @param request
	 * 			  HttpServletRequest
	 * @param session
	 * 		      HttpSession session
	 * @return 회원탈퇴 성공 시 홈 화면으로 이동
	 */
	@RequestMapping(value = "/delete_Id_Go.do", method = RequestMethod.POST)
	public String deleteIdViewPost(@Valid MemberVO vo, Errors errors, HttpServletRequest request, HttpSession session) {
		if (errors.hasErrors()) {
			logger.info("회원탈퇴 유효성체크 오류발생");
		}

		String repw = request.getParameter("m_repw");
		String m_pw = request.getParameter("m_pw");

		if (!repw.equals(m_pw)) {

			return "deleteRePw";

		} else {

			String m_userid = (String) session.getAttribute("m_userid");

			memberService.deleteId(m_userid);
			session.invalidate();
			return "home";
		}

	}

}