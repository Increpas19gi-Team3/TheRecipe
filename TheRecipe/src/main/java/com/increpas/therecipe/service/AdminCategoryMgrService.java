package com.increpas.therecipe.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.LoginDAO;
import com.increpas.therecipe.vo.MemberVO;

/**
 * 
 * @author 손가연
 *
 */
@Service
public class AdminCategoryMgrService {

	@Autowired
	LoginDAO loginDAO; 
	
	public List<MemberVO> selectAllMember(){
		return loginDAO.selectAllMember();
	}
}
