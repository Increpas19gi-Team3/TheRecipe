package com.increpas.therecipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.MemberDAO;

/**
 * 
 * @author 박호진
 *
 */

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	
	 public int insertMember() {
		 return memberDAO.insertMember();
		 }
	
	
	

}
