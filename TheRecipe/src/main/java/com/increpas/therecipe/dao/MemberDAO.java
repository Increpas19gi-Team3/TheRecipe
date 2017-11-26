package com.increpas.therecipe.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 
 * @author  박호진
 *
 */
@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int insertMember() {
		return sqlSessionTemplate.insert("member_ns.insertMembers");
	}

}
