package com.increpas.therecipe.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.dto.AdminEventSetFoodListDTO;
import com.increpas.therecipe.dto.AdminFoodListDTO;
import com.increpas.therecipe.vo.EventInfoVO;
import com.increpas.therecipe.vo.EventSetFoodVO;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

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
	 * 오늘날짜 기준 전체 이벤트 가져오기
	 * @return
	 */
	public List<EventInfoVO> selectAllEventToday() {
		return sqlSessionTemplate.selectList("adminEventMgr_ns.selectAllEventToday");
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
	 * 전체 글 갯수 리턴
	 * @return
	 */
	public int listCount(AdminEventSetFoodListDTO listDTOListModel) {		
		System.out.println("▶▶▶▶ listDTO : selectCount");
		return sqlSessionTemplate.selectOne("adminEventMgr_ns.selectCount", listDTOListModel);
	}
	
	
	
	
	/**
	 * 선택한 이벤트가 걸린 음식정보 가져오기 : 페이징X, 검색X, 정렬X
	 * @param e_evtcode
	 * @return
	 */
	public List<EventSetFoodVO> selectSelEventFood(String e_evtcode) {
		System.out.println("******************************  e_evtcode="+e_evtcode);
		//EventSetFoodVO
		//System.out.println("esfVO.getE_evtcode()="+esfVO.getE_evtcode());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("evtcode", e_evtcode);
		return sqlSessionTemplate.selectList("adminEventMgr_ns.selectSelEventFood", map);
	}
	
	
	/**
	 * 선택한 이벤트가 걸린 음식정보 가져오기 : 페이징O, 검색O, 정렬O
	 * @param AdminEventSetFoodListDTO adminEventSetFoodListDTO
	 * @return List<EventSetFoodVO>
	 */
	public List<EventSetFoodVO> selectSelEventFoodList(AdminEventSetFoodListDTO adminEventSetFoodListDTO) {
		System.out.println("******************************  adminEventSetFoodListDTO="+adminEventSetFoodListDTO.toString());
		return sqlSessionTemplate.selectList("adminEventMgr_ns.selectSelEventFoodList", adminEventSetFoodListDTO);
	}
	
	
	
	/**
	 * 이벤트 설정
	 * @param String[] chk_fdcodeArr
	 * @param String setEventCode
	 * @return
	 */
	public int updateEventSetFood(String[] chk_fdcodeArr, String setEventCode){
		System.out.println("setEventCode="+setEventCode);
		System.out.println(Arrays.toString(chk_fdcodeArr));
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("setEventCode", setEventCode); // 이벤트 코드
		map.put("chk_fdcodeArr", chk_fdcodeArr);//음식코드 String Array 
		
		
		return sqlSessionTemplate.update("adminEventMgr_ns.updateEventSetFood", map);
	}
}
