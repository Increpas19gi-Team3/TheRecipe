package com.increpas.therecipe.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.dto.AdminFoodListDTO;
import com.increpas.therecipe.dto.AdminFoodRegDTO;
import com.increpas.therecipe.vo.FoodMgrVO;
import com.increpas.therecipe.vo.FoodcodeVO;

/**
 * 관리자) 음식 등록관리 Query 제어
 * @author 손가연
 *
 */
@Repository
public class AdminFoodMgrDAO {
	
	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
		
		
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	/**
	 * 전체 등록 데이터 가져오기
	 * @return : List<FoodMgrVO>
	 */
	public List<FoodMgrVO> selectAdminFoodListAll(){
		return sqlSessionTemplate.selectList("adminFoodMgr_ns.selectAdminFoodListAll");
	}
	
	/**
	 * 선택한 등록 데이터 가져오기
	 * @param FoodcodeVO fcVO
	 * @return List<FoodMgrVO>
	 */
	public List<FoodMgrVO> selectAdminFoodListSel(FoodcodeVO fcVO){
		return sqlSessionTemplate.selectList("adminFoodMgr_ns.selectAdminFoodListSel", fcVO);
	}


	
	/**
	 * 선택한 등록 데이터 가져오기 - 페이징, 검색
	 * @param FoodcodeVO fcVO
	 * @return List<FoodMgrVO>
	 */
	public List<AdminFoodListDTO> selectSetAdminFoodList(FoodcodeVO fcVO){
		return sqlSessionTemplate.selectList("adminFoodMgr_ns.selectSetAdminFoodList", fcVO);
	}
	
	
	
	
	/**
	 * 선택한 등록 데이터 가져오기 - 페이징, 검색
	 * @param FoodcodeVO fcVO
	 * @return List<FoodMgrVO>
	 */
	public List<FoodMgrVO> selectSetAdminFoodList(AdminFoodListDTO adminFoodListDTO){
		return sqlSessionTemplate.selectList("adminFoodMgr_ns.selectSetAdminFoodList", adminFoodListDTO);
	}
	
	
	/**
	 * 전체 글 갯수 리턴
	 * @return
	 */
	public int listCount(AdminFoodListDTO listDTOListModel) {		
		return sqlSessionTemplate.selectOne("adminFoodMgr_ns.selectCount", listDTOListModel);
	}
	
	
	/**
	 * 선택한 음식정보 상세보기
	 * @param String f_fdcode
	 * @return FoodMgrVO
	 */
	public FoodMgrVO selFoodView(String f_fdcode){
		return sqlSessionTemplate.selectOne("adminFoodMgr_ns.selFoodView", f_fdcode);
	}
	
	
	/**
	 * DB에 음식데이터 저장
	 * @param AdminFoodRegDTO adminFoodRegDTO
	 * @return int
	 */
	public int insertAdminFoodReg(AdminFoodRegDTO adminFoodRegDTO){
		return sqlSessionTemplate.insert("adminFoodMgr_ns.insertFoodReg", adminFoodRegDTO);
	}
	
	/**
	 * DB에 음식 데이터 수정
	 * @param AdminFoodRegDTO adminFoodRegDTO
	 * @return int
	 */
	public int updateAdminFoodReg(AdminFoodRegDTO adminFoodRegDTO){
		return sqlSessionTemplate.insert("adminFoodMgr_ns.updateFoodModify", adminFoodRegDTO);
	}
}
