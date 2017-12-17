package com.increpas.therecipe.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.increpas.therecipe.dao.AdminCategoryMgrDAO;
import com.increpas.therecipe.dao.AdminMemberMgrDAO;
import com.increpas.therecipe.vo.FoodcodeVO;
import com.increpas.therecipe.vo.MemberInfoVO;
import com.increpas.therecipe.vo.MemberVO;

/**
 * 관리자) 회원을 관리하기 위한 Service 
 * @author 손가연
 *
 */
@Service
public class AdminMemberMgrService {

	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	AdminMemberMgrDAO adminMemberMgrDAO;
	
	
	/**
	 * 회원의 정보를 가져오는 메소드
	 * @param level : m_level 권한 등급
	 * @return
	 */
	public List<MemberInfoVO> selectAllMemberInfo(int level){
		return adminMemberMgrDAO.selectAllMemberInfo(level);
	}
	
	
	/**
	 * 회원의 권한을 변경하는 메소드
	 * @param targetId : 대상 회원 ID
	 * @param targetCode : 변경할 권한값
	 * @return
	 */
	@Transactional
	public int modifyMemberLevel(String targetId, String targetCode){
		return adminMemberMgrDAO.modifyMemberLevel(targetId, targetCode);
	}
}
