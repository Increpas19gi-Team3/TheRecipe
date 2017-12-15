package com.increpas.therecipe.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.vo.MemberVO;

/**
 * 로그인 로그아웃 아이디찾기 비밀번호찾기 DAO
 * @author 한범석, 박호진
 *
 */
@Repository
public class LoginDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 로그인 DAO 
	 * @param m_userid 아이디	
	 * @param m_pw 비밀번호
	 * @return MemberVO
	 */
	public MemberVO selectLogin(String m_userid, String m_pw) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("m_userid", m_userid);
		map.put("m_pw", m_pw);
		return sqlSessionTemplate.selectOne("member_ns.selectLogin", map);
	}
	/**
	 * 아이디찾기
	 * @param m_email 이메일
	 * @return MemberVO
	 */
	public MemberVO selectFindId(String m_email) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("m_email", m_email);
		return sqlSessionTemplate.selectOne("member_ns.selectId", map);
	}
	/**
	 * 비밀번호 찾기
	 * @param m_userid 아이디, 전화번호 로 검색
	 * @return MemberVO
	 */
	public MemberVO selectFindPw(MemberVO mVO) {
		
		return sqlSessionTemplate.selectOne("member_ns.findPw", mVO);
	}

}
