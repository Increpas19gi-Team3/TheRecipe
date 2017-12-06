package com.increpas.therecipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.increpas.therecipe.dao.ReviewDAO;
import com.increpas.therecipe.dto.EventListDTO;
import com.increpas.therecipe.dto.ReviewListDTO;
import com.increpas.therecipe.vo.EventVO;
import com.increpas.therecipe.vo.ReviewVO;

/**
 * (관리자, 일반인)후기 리스트, 상세보기, 조회수 관리하기 위한 Service
 * @author 손대성
 */
@Service
public class ReviewListService {

	@Autowired
	ReviewDAO reviewDAO;

	@Autowired
	ReviewListDTO reviewListDTO;
		
	/**
	 * (관리자, 일반인)후기 리스트
	 * @param pageCutCount ; 게시글 보기 수
	 * @param requestPageNumber ; 요청 페이지 번호
	 * @param whereColumn ; 검색 컬럼명
	 * @param word ; 검색어
	 * @param sortColumn ; 정렬 컬럼
	 * @param orderby ; 정렬방식 ASC, DESC	 
	 * @param GUBUN ;  공지사항:0, 이벤트:1 ; 
	 * @return
	 */
	public ReviewListDTO getReviewVOList(int pageCutCount, int requestPageNumber, String whereColumn, String word,
			String sortColumn, String orderby) {

		System.err.println("3. ▶▶▶▶ ReviewListService : getReviewVOList >> 조건 검색 들어옴");

		reviewListDTO.setWhereColumn(whereColumn);
		reviewListDTO.setWord(word);
		reviewListDTO.setSortColumn(sortColumn);
		reviewListDTO.setOrderby(orderby);		

		// 페이징 처리
		if (requestPageNumber < 0) {
			throw new IllegalArgumentException("page number < 0 : " + requestPageNumber);
		}	
		
		// DAO에게 DB의 전체 글 개수조회 요청
		// 4....
		int totalBoardVOCount = reviewDAO.selectReviewCount(reviewListDTO);

		if (totalBoardVOCount == 0) { // 글의 개수가 '0'이면			
			return new ReviewListDTO(); 
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

		reviewListDTO.setStartRow(firstRow);
		reviewListDTO.setEndRow(endRow);
		
		System.err.println("5. before ▶▶▶▶ List<ReviewVO> boardDTOList = reviewDAO.selectReviewSetList(reviewListDTO)");
		// 'DAO'에게 "DB Select" 요청
		// 6..
		List<ReviewVO> boardDTOList = reviewDAO.selectReviewSetList(reviewListDTO);		
		
		// BoardVOListModel 결과 모델을 생성
		ReviewListDTO boardVOListView = new ReviewListDTO(boardDTOList, whereColumn, word, sortColumn, orderby,
				pageCutCount, requestPageNumber, totalPageCount, firstRow, endRow);		

		return boardVOListView;
	}

	/**
	 * 후기 리스트 전체 페이지 갯수 계산
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
	
	/**
	 * 후기 상세보기, 조회수 증가
	 * @param Ncode
	 * @return reviewDAO.ReviewDetailView(Ncode)
	 */
	public ReviewVO getReviewVODetail(int Ncode) {
		System.out.println("2. ▶▶▶▶ NoticeDetailViewService : getNoticeVOList >> 들어옴");
		reviewDAO.updateHitCount(Ncode); // 글 조회수 증가
		return reviewDAO.ReviewDetailView(Ncode);
	}
	
	
}
