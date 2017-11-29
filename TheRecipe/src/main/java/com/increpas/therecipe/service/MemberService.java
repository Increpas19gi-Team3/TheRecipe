package com.increpas.therecipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.MemberDAO;
import com.increpas.therecipe.vo.MemberVO;

/**
 * 
 * @author 박호진
 *
 */

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	
/*	 public int insertMember() {
		 return memberDAO.insertMember();
		 }*/
	
	/**
	 * 마이페이지로 이동
	 * @param m_userid 아이디
	 * @return MemberVO
	 */
	public MemberVO selectMyInfo(String m_userid){
		return memberDAO.selectMyInfo(m_userid);
	}
	//회원탈퇴
	/*public MemberVO deleteId(String m_userid){
		return memberDAO.deleteId(m_userid);
	}*/
	

}
