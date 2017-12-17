package com.increpas.therecipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.service.AdminCategoryMgrService;
import com.increpas.therecipe.vo.FoodcodeVO;
import com.increpas.therecipe.vo.MemberInfoVO;

/**
 * 관리자) 회원 등급관리 Query 제어
 * @author 손가연
 *
 */
@Repository
public class AdminMemberMgrDAO {
	
	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
		
		
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	/**
	 * 회원의 정보를 가져오는 메소드
	 * @param level : m_level 권한 등급
	 * @return
	 */
	public List<MemberInfoVO> selectAllMemberInfo(int level){
		if(level == 2){//일반 관리자
			return sqlSessionTemplate.selectList("MemberInfo_ns.selectAllMemberInfo");
		}else{// 최고 관리자
			return sqlSessionTemplate.selectList("MemberInfo_ns.selectAllMemberInfoAdmin");
		}
	}
	
	
	/**
	 * 회원의 권한을 변경하는 메소드
	 * @param targetId : 대상 회원 ID
	 * @param targetCode : 변경할 권한 값
	 * @return
	 */
	public int modifyMemberLevel(String targetId, String targetCode){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("targetId", targetId);
		map.put("targetCode", targetCode);
		
		return sqlSessionTemplate.update("MemberInfo_ns.modifyMemberLevel", map);
	}
	
	
	
	
	
}
