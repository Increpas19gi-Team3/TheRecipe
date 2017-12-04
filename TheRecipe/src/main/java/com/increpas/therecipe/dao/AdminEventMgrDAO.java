package com.increpas.therecipe.dao;

import java.util.HashMap;
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
	
	
	/**
	 * 전체 이벤트 가져오기
	 * @return
	 */
	public List<EventInfoVO> selectAllEvent() {
		return sqlSessionTemplate.selectList("adminEventMgr_ns.selectAllEvent");
	}
	
	
	/**
	 * 선택 이벤트 가져오기
	 * @param e_evtcode
	 * @return
	 */
	public List<EventInfoVO> selectSelEvent(String e_evtcode) {
		return sqlSessionTemplate.selectList("adminEventMgr_ns.selectSelEvent", e_evtcode);
	}
	
	
	
	/**
	 * 선택한 이벤트가 걸린 음식정보 가져오기
	 * @param e_evtcode
	 * @return
	 */
	public List<EventInfoVO> selectSelEventFood(String e_evtcode) {
		System.out.println("******************************  e_evtcode="+e_evtcode);
		return sqlSessionTemplate.selectList("adminEventMgr_ns.selectSelEventFood", e_evtcode);
	}
}
