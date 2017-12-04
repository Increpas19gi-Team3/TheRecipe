package com.increpas.therecipe.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.AdminEventMgrDAO;
import com.increpas.therecipe.vo.EventInfoVO;

/**
 * 이벤트 설정 관리를 위한 Service
 * @author 손가연
 *
 */
@Service
public class AdminEventMgrService {
	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	AdminEventMgrDAO adminEventMgrDAO;
	
	/**
	 * 전체 이벤트 가져오기
	 * @return
	 */
	public List<EventInfoVO> selectAllEvent() {
		return adminEventMgrDAO.selectAllEvent();
	}
	
	
	/**
	 * 선텍 이벤트 가져오기
	 * @param e_evtcode
	 * @return
	 */
	public List<EventInfoVO> selectSelEvent(String e_evtcode) {
		return adminEventMgrDAO.selectSelEvent(e_evtcode);
	}
	
	
	/**
	 * 선택한 이벤트가 걸린 음식정보 가져오기
	 * @param e_evtcode
	 * @return
	 */
	public List<EventInfoVO> selectSelEventFood(String e_evtcode) {
		return adminEventMgrDAO.selectSelEventFood(e_evtcode);
	}
}
