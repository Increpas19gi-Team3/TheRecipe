package com.increpas.therecipe.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.MemberDAO;
import com.increpas.therecipe.vo.MemberVO;

/**
 * 회원등록 회원탈퇴 회원정보 조회,수정 관련 서비스
 * @author 박호진
 *
 */

@Service
public class MemberService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MemberDAO memberDAO;
	
	/**
	 * 회원가입
	 * @param vo MemberVO
	 */
    public void insertMember(MemberVO vo) {
		  memberDAO.insertMember(vo);
		 }
	
/*    //아이디 중복 체크
	public boolean checkId(String m_userid) {
		return memberDAO.checkId(m_userid);
	}*/
    
    /**
	 * 마이페이지로 이동
	 * @param m_userid 아이디
	 * @return MemberVO
	 */
	public MemberVO selectMyInfo(String m_userid){
		return memberDAO.selectMyInfo(m_userid);
	}
	
	/**
	 * 마이페이지수정
	 * @param vo MemberVO
	 */
	public void updateMyInfo (MemberVO vo) {
		logger.info(vo.toString());
		memberDAO.updateMyInfo(vo);
	}

	/**
	 * 회원탈퇴
	 * @param m_userid 아이디
	 */
	public void deleteId(String m_userid){
		memberDAO.deleteId(m_userid);
	}
	

}
