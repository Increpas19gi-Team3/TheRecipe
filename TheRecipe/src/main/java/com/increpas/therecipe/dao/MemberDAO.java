package com.increpas.therecipe.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.vo.MemberVO;


/**
 * 
 * @author  박호진
 *
 */
@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

/*	public int insertMember() {
		return sqlSessionTemplate.insert("member_ns.insertMembers");
	}*/
	
	//mypage
public MemberVO selectMyInfo(String m_userid ) {
	
	return sqlSessionTemplate.selectOne("member_ns.selectMyInfo", m_userid);
}

/*	//mypage
public MemberVO selectAllMembers(MemberVO mVo) {
	
	Map<String, String> map = new HashMap<String, String>();
	map.put("m_pw", mVo.setM_pw(m_pw);
	map.put("m_name", m_name);
	map.put("m_email", m_email);
	map.put("m_post", m_post);
	map.put("m_addr", m_addr);
	map.put("m_phone", m_phone);
	return sqlSessionTemplate.selectOne("member_ns.selectAllMembers", map);
}*/

//회원탈퇴
/*public MemberVO deleteId(String m_userid) {
	
	Map<String, String> map = new HashMap<String, String>();
	map.put("m_userid", m_userid);
	return sqlSessionTemplate.selectOne("member_ns.deleteMember", map);
}	

*/
	

}
