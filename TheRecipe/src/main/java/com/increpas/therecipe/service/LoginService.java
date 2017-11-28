package com.increpas.therecipe.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.LoginDAO;
import com.increpas.therecipe.vo.MemberVO;

/**
 * 
 * @author 한범석, 박호진
 *
 */
@Service
public class LoginService {

	@Autowired
	LoginDAO loginDAO; 
	
	//로그인
	public MemberVO selectLogin(String m_userid, String m_pw){
		return loginDAO.selectLogin(m_userid, m_pw);
	}
	//아이디 찾기
	public MemberVO selectFindId(String m_email){
		return loginDAO.selectFindId(m_email);
	}
	//비밀번호 찾기
	public MemberVO selectFindPw(String m_userid){
		return loginDAO.selectFindPw(m_userid);
	}

}
