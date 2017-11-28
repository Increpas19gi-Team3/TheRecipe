package com.increpas.therecipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.vo.MemberVO;

/**
 * 
 * @author 한범석, 박호진
 *
 */
@Repository
public class LoginDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<MemberVO> selectAllMember(){
		return sqlSessionTemplate.selectList("member_ns.selectAllMembers"); 
	} 
	
	//로그인
	public  MemberVO selectLogin(String m_userid, String m_pw) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("m_userid", m_userid);
		map.put("m_pw", m_pw);
		return sqlSessionTemplate.selectOne("member_ns.selectLogin", map);
	}
	//아이디 찾기
	public MemberVO selectFindId(String m_email) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("m_email", m_email);
		return sqlSessionTemplate.selectOne("member_ns.selectId", map);
	}
	//비밀번호 찾기
	public MemberVO selectFindPw(String m_userid) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("m_userid", m_userid);
		return sqlSessionTemplate.selectOne("member_ns.selectPw", map);
	}

}
