package com.increpas.therecipe.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.vo.EventInfoVO;

/**
 * 이벤트 설정 관리를 위한 DAO
 * @author 손가연
 *
 */
@Repository
public class AdminEventMgrDAO {


	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public List<EventInfoVO> selectAllEvent() {
		return sqlSessionTemplate.selectList("adminEventMgr_ns.selectAllEvent");
	}
}
