package com.increpas.therecipe.dao;

import java.util.List;

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
public class AdminCategoryMgrDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<MemberVO> selectAllMember(){
		return sqlSessionTemplate.selectList("member_ns.selectAllMembers"); 
	} 
}
