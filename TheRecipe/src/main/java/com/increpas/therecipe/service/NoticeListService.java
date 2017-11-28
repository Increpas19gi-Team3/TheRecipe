package com.increpas.therecipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.EventNoticeDAO;
import com.increpas.therecipe.dto.EventListDTO;
import com.increpas.therecipe.vo.EventVO;

/**
 * 공지사항을 관리하기 위한 Service
 * 
 * @author 손대성
 *
 */
@Service
public class NoticeListService {

	@Autowired
	EventNoticeDAO eventNoticeDAO;

	@Autowired
	EventListDTO eventListDTO;

	/**
	 * 전체 게시글 목록 가져오기 DAO 활용
	 * 
	 * @return
	 */
	public List<EventVO> getNoticeListAll() {
		System.err.println("▶▶▶▶▶▶▶ ListService : getNoticeListAll >> 전체 검색 들어옴");
		return eventNoticeDAO.noticeSelectList();
	}

	/**
	 * 조건 별로 게시글 목록 가져오기
	 * 
	 * @param whereColumn
	 * @param word
	 * @param sortColumn
	 * @param orderby
	 * @param isBlock
	 * @return
	 */
	public List<EventVO> getSetList(String whereColumn, String word, String sortColumn, String orderby,
			String GUBUN) {

		System.err.println("▶▶▶▶ ListService : getSetList >> 조건 검색 들어옴");

		eventListDTO.setWhereColumn(whereColumn);
		eventListDTO.setWord(word);
		eventListDTO.setSortColumn(sortColumn);
		eventListDTO.setOrderby(orderby);
		eventListDTO.setGUBUN(GUBUN);

		return eventNoticeDAO.selectSetList(eventListDTO);
	}
	
	public EventListDTO getBoardVOList(int pageCutCount, int requestPageNumber, String whereColumn, String word,
			String sortColumn, String orderby, String GUBUN) {

		System.err.println("▶▶▶▶ ListService : getBoardVOList >> 조건 검색 들어옴");

		eventListDTO.setWhereColumn(whereColumn);
		eventListDTO.setWord(word);
		eventListDTO.setSortColumn(sortColumn);
		eventListDTO.setOrderby(orderby);
		eventListDTO.setGUBUN(GUBUN);

		// 페이징 처리
		if (requestPageNumber < 0) {
			throw new IllegalArgumentException("page number < 0 : " + requestPageNumber);
		}

		// DAO에게 DB의 전체 글 개수조회 요청
		int totalBoardVOCount = eventNoticeDAO.selectCount(eventListDTO);

		if (totalBoardVOCount == 0) { // 글의 개수가 '0'이면			
			return new EventListDTO(); 
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

		eventListDTO.setStartRow(firstRow);
		eventListDTO.setEndRow(endRow);

		// 'DAO'에게 "DB Select" 요청
		List<EventVO> boardDTOList = eventNoticeDAO.selectSetList(eventListDTO);

		// BoardVOListModel 결과 모델을 생성
		EventListDTO boardVOListView = new EventListDTO(boardDTOList, whereColumn, word, sortColumn, orderby, GUBUN,
				pageCutCount, requestPageNumber, totalPageCount, firstRow, endRow);

		// boardVOList,requestPageNumber, totalPageCount, firstRow, endRow);

		return boardVOListView;
	}	

	private int calculateTotalPageCount(int pageCutCount, int totalBoardVOCount) {
		if (totalBoardVOCount == 0) {
			return 0;
		}

		// 글 갯수 ÷ 페이지당 글 갯수 : 예) 2/10 = 0
		int pageCount = totalBoardVOCount / pageCutCount;

		// 나머지가 있으면 페이지수를 +1 증가
		if (totalBoardVOCount % pageCutCount > 0) {
			pageCount++;
		}

		return pageCount;
	}
}
