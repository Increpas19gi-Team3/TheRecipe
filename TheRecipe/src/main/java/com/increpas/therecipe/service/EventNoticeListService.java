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
public class EventNoticeListService {

	@Autowired
	EventNoticeDAO eventNoticeDAO;

	@Autowired
	EventListDTO eventListDTO;
		
	/**
	 * 
	 * @param pageCutCount ; 게시글 보기 수
	 * @param requestPageNumber ; 요청 페이지 번호
	 * @param whereColumn ; 검색 컬럼명
	 * @param word ; 검색어
	 * @param sortColumn ; 정렬 컬럼
	 * @param orderby ; 정렬방식 ASC, DESC
	 * @param GUBUN ;  공지사항:0, 이벤트:1
	 * @return
	 */
	public EventListDTO getBoardVOList(int pageCutCount, int requestPageNumber, String whereColumn, String word,
			String sortColumn, String orderby, String GUBUN) {

		System.err.println("3. ▶▶▶▶ EventNoticeListService : getBoardVOList >> 조건 검색 들어옴");

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
		// 4....
		int totalBoardVOCount = eventNoticeDAO.selectNoticeCount(eventListDTO);

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

		System.err.println("5. before ▶▶▶▶ List<EventVO> boardDTOList = eventNoticeDAO.selectSetList(eventListDTO);");
		// 'DAO'에게 "DB Select" 요청
		// 6..
		List<EventVO> boardDTOList = eventNoticeDAO.selectNoticeSetList(eventListDTO);

		// BoardVOListModel 결과 모델을 생성
		EventListDTO boardVOListView = new EventListDTO(boardDTOList, whereColumn, word, sortColumn, orderby, GUBUN,
				pageCutCount, requestPageNumber, totalPageCount, firstRow, endRow);

		// boardVOList,requestPageNumber, totalPageCount, firstRow, endRow);

		return boardVOListView;
	}
	
	/**
	 * 조건 별로 게시글 목록 가져오기
	 * 
	 * @param whereColumn ; 검색 컬럼명
	 * @param word ; 검색할 단어
	 * @param sortColumn ; 정렬 컬럼
	 * @param orderby ; 정렬방식 ASC, DESC
	 * @param GUBUN ; 공지사항:0, 이벤트:1 
	 * @return eventNoticeDAO.selectNoticeSetList(eventListDTO)
	 */
	public List<EventVO> getSetList(String whereColumn, String word, String sortColumn, String orderby,
			String GUBUN) {

		System.err.println("4. ▶▶▶▶ EventNoticeListService : getSetList >> 조건 검색 들어옴");

		eventListDTO.setWhereColumn(whereColumn);
		eventListDTO.setWord(word);
		eventListDTO.setSortColumn(sortColumn);
		eventListDTO.setOrderby(orderby);
		eventListDTO.setGUBUN(GUBUN);

		return eventNoticeDAO.selectNoticeSetList(eventListDTO);
	}

	/**
	 * 전체 페이지 갯수 계산
	 * @param pageCutCount;
	 * @param totalBoardVOCount;
	 * @return pageCount;
	 */
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
