package com.increpas.therecipe.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.increpas.therecipe.vo.MemberVO;

/**
 * 회원등록 회원탈퇴 회원정보 조회,수정 관련 DAO
 * 
 * @author 박호진
 *
 */
@Repository
public class MemberDAO {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 회원가입 동작수행
	 * @param vo MemberVO
	 */
	 public void insertMember(MemberVO vo) { 
		 vo.setM_level(1);
	  sqlSessionTemplate.insert("member_ns.insertMember",vo); }
	 
	//아이디 체크 
	 public String checkId(String m_userid) {
		 logger.info(m_userid.toString());
		return sqlSessionTemplate.selectOne("member_ns.checkId", m_userid);
	}
	 
	 
	/**
	 * 마이페이지로 이동
	 * @param m_userid 아이디
	 * @return MemberVO
	 */
	public MemberVO selectMyInfo(String m_userid) {

		return sqlSessionTemplate.selectOne("member_ns.selectMyInfo", m_userid);
	}
	/**
	 * 마이페이지 수정동작수행
	 * @param vo MemberVO
	 */
	public void updateMyInfo(MemberVO vo){
		logger.info(vo.toString());
		sqlSessionTemplate.update("member_ns.updateMyInfo", vo); 
	} 

	/**
	 * 회원탈퇴 동작 수행
	 * @param m_userid 아이디
	 */
	  public  void deleteId(String m_userid) {
	 logger.info(m_userid.toString());
	 sqlSessionTemplate.delete("member_ns.deleteMember", m_userid);
	 }
	
}
