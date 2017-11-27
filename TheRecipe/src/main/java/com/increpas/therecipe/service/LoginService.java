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
	
	public MemberVO selectLogin(String m_userid, String m_pw){
		return loginDAO.selectLogin(m_userid, m_pw);
	}
	
	
	
	
	
}
