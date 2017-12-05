package com.increpas.therecipe.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.AdminEventMgrDAO;
import com.increpas.therecipe.dto.AdminEventSetFoodListDTO;
import com.increpas.therecipe.dto.AdminFoodListDTO;
import com.increpas.therecipe.vo.EventInfoVO;
import com.increpas.therecipe.vo.EventSetFoodVO;
import com.increpas.therecipe.vo.FoodMgrVO;

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
	
	@Autowired
	AdminEventSetFoodListDTO adminEventSetFoodListDTO;
	
	/**
	 * 전체 이벤트 가져오기
	 * @return List<EventInfoVO>
	 */
	public List<EventInfoVO> selectAllEvent() {
		return adminEventMgrDAO.selectAllEvent();
	}
	
	

	/**
	 * 전체 이벤트 가져오기
	 * @return List<EventInfoVO> 
	 */
	public List<EventInfoVO> selectAllEventToday() {
		return adminEventMgrDAO.selectAllEventToday();
	}
	
	
	/**
	 * 선텍 이벤트 가져오기
	 * @param String e_evtcode
	 * @return List<EventInfoVO>
	 */
	public List<EventInfoVO> selectSelEvent(String e_evtcode) {
		return adminEventMgrDAO.selectSelEvent(e_evtcode);
	}
	
	
	/**
	 * 선택한 이벤트가 걸린 음식정보 가져오기
	 * @param String e_evtcode
	 * @return List<EventSetFoodVO>
	 */
	public List<EventSetFoodVO> selectSelEventFood(String e_evtcode) {
		return adminEventMgrDAO.selectSelEventFood(e_evtcode);
	}
	
	
	/**
	 * 음식 정보 + 이벤트 정보 가져오기 : 페이징O, 검색O 
	 * @param int pageCutCount
	 * @param int requestPageNumber
	 * @param String whereColumn
	 * @param String word
	 * @param String sortColumn
	 * @param String orderby
	 * @param int fc_1st
	 * @param int fc_2nd
	 * @param int fc_3rd
	 * @param String selEventCode
	 * @return AdminEventSetFoodListDTO
	 */
	public AdminEventSetFoodListDTO getEventSetFoodList(int pageCutCount, int requestPageNumber, 
			String whereColumn, String word, 
			String sortColumn, String orderby,
			int fc_1st, int fc_2nd, int fc_3rd,
			String selEventCode){
		
		
		adminEventSetFoodListDTO.setWhereColumn(whereColumn);
		adminEventSetFoodListDTO.setWord(word);
		adminEventSetFoodListDTO.setSortColumn(sortColumn);
		adminEventSetFoodListDTO.setOrderby(orderby);
		adminEventSetFoodListDTO.setFc_1st(fc_1st);
		adminEventSetFoodListDTO.setFc_2nd(fc_2nd);
		adminEventSetFoodListDTO.setFc_3rd(fc_3rd);
		adminEventSetFoodListDTO.setSelEventCode(selEventCode);
		
		
		// 페이징 처리
		if (requestPageNumber < 0) {
			throw new IllegalArgumentException("page number < 0 : "
					+ requestPageNumber);
		}
		
		// DAO에게 DB의 전체 글 개수조회 요청
		int totalBoardVOCount = getTotalBoardVOCount(adminEventSetFoodListDTO); //adminEventMgrDAO.listCount(adminEventSetFoodListDTO);
		//System.out.println("---------------------- 전체 글 갯수 " + totalBoardVOCount);
		
		if (totalBoardVOCount == 0) {//글의 개수가 0이면
			//모델 : BoardVOListModel : 게시글 목록화면 VO 
			return new AdminEventSetFoodListDTO();// AC에게 되돌려줄 모델(게시글 목록 화면) 리턴
		}
		
		// 전체 페이지 계산(게시글 보기 설정값으로 계산)
		int totalPageCount = calculateTotalPageCount(pageCutCount, totalBoardVOCount);
		
		
		// 예) (1-1) * 10 + 1 = 1 
		int firstRow = (requestPageNumber - 1) * pageCutCount + 1;
		// 예) 1 + 10 - 1 = 10
		int endRow = firstRow + pageCutCount - 1;

		// 예) 10 > 2
		if (endRow > totalBoardVOCount) {
			
			// 예) 전체글번호 = 2
			endRow = totalBoardVOCount;
		}
		
		adminEventSetFoodListDTO.setStartRow(firstRow);
		adminEventSetFoodListDTO.setEndRow(endRow);
		
		// DAO에게 DB Select 요청
		List<EventSetFoodVO> boardDTOList = adminEventMgrDAO.selectSelEventFoodList(adminEventSetFoodListDTO);
		//System.out.println("---------------------- DB에서 값 가져오기 성공 ");
		
		//BoardVOListModel 결과 모델을 생성
		AdminEventSetFoodListDTO eventSetFoodVOList = new AdminEventSetFoodListDTO(boardDTOList, 
				whereColumn, word, sortColumn, orderby, pageCutCount, 
				requestPageNumber, totalPageCount, firstRow, endRow, 
				fc_1st, fc_2nd, fc_3rd, 
				selEventCode);
		return eventSetFoodVOList;
	}
	
	
	/**
	 * 전체 게시글 수 리턴
	 * @param AdminEventSetFoodListDTO adminEventSetFoodListDTO
	 * @return int
	 */
	public int getTotalBoardVOCount(AdminEventSetFoodListDTO adminEventSetFoodListDTO){
		return adminEventMgrDAO.listCount(adminEventSetFoodListDTO);
	}
	
	
	/**
	 * 전체 페이지 계산(게시글 보기 설정값으로 계산)
	 * @param int pageCutCount
	 * @param int totalBoardVOCount
	 * @return int
	 */
	private int calculateTotalPageCount(int pageCutCount, int totalBoardVOCount) {
		if (totalBoardVOCount == 0) {
			return 0;
		}
		
		// 글 갯수 ÷ 페이지당 글 갯수 : 예) 2/10 = 0
		int pageCount = totalBoardVOCount / pageCutCount;
		
		//나머지가 있으면 페이지수를 +1 증가
		if (totalBoardVOCount % pageCutCount > 0) {
			pageCount++;
		}
		
		return pageCount;
	}
	
	
	/**
	 * 이벤트 설정
	 * @param String[] chk_fdcodeArr : 이벤트를 설정할 음식 코드
	 * @param String setEventCode : 이벤트 코드
	 */
	public void updateEventSetFood(String[] chk_fdcodeArr, String setEventCode){
		adminEventMgrDAO.updateEventSetFood(chk_fdcodeArr, setEventCode);
	}
}
