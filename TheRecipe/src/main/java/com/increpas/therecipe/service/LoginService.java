package com.increpas.therecipe.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.LoginDAO;
import com.increpas.therecipe.vo.MemberVO;

/**
 * 로그인 로그아웃 아이디찾기 비밀번호찾기 서비스
 * @author 한범석, 박호진
 *
 */
@Service
public class LoginService {

	@Autowired
	LoginDAO loginDAO; 
	
	/**
	 * 로그인 DAO 
	 * @param m_userid 아이디	
	 * @param m_pw 비밀번호
	 * @return MemberVO
	 */
	public MemberVO selectLogin(String m_userid, String m_pw){
		return loginDAO.selectLogin(m_userid, m_pw);
	}
	/**
	 * 아이디찾기
	 * @param m_email 이메일
	 * @return MemberVO
	 */
	public MemberVO selectFindId(String m_email){
		return loginDAO.selectFindId(m_email);
	}
	/**
	 * 비밀번호 찾기
	 * @param m_userid 아이디
	 * @return MemberVO
	 */
	public MemberVO selectFindPw(MemberVO mVO){
		return loginDAO.selectFindPw(mVO);
	}

}
