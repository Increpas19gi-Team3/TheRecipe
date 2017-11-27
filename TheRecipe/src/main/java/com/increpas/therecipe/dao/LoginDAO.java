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
	
	public  MemberVO selectLogin(String m_userid, String m_pw) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("m_userid", m_userid);
		map.put("m_pw", m_pw);
		return sqlSessionTemplate.selectOne("member_ns.selectLogin", map);
	}
}
