package com.increpas.therecipe.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.increpas.therecipe.vo.EventVO;
import com.increpas.therecipe.vo.ReviewVO;

/**
 * 후기 리스트용 게시판용 DTO
 * @author 손가연, 손대성
 *
 */
@Repository
public class ReviewListDTO {

private List<ReviewVO> listVO;	// 게시글의 목록
	
	private String whereColumn;	// 검색 컬럼명
	private String word;		// 검색어
	private String sortColumn;	// 정렬 컬럼
	private String orderby;		// 정렬방식 ASC, DESC	

	private int pageCutCount;	// 게시글 보기 수 - 디폴트 10
	
	private int requestPage;			// 요청 페이지 번호
	private int totalPageCount;			// 전체 페이지 수
	private int startRow;				// 요청(클릭) 페이지 시작 글번호
	private int endRow;					// 요청(클릭) 페이지 마지막 글번호

	// DB의 저장된 전체글의 개수가 0일때 리턴할 게시글 모델
	public ReviewListDTO() {
		this(new ArrayList<ReviewVO>(), "", "", "", "", 10, 0, 0, 0, 0);
	}	
	
	public ReviewListDTO(List<ReviewVO> listVO, String whereColumn, String word, String sortColumn,
			String orderby, int pageCutCount, int requestPage, int totalPageCount, int startRow,
			int endRow) {
		
		super();
		this.listVO = listVO;
		this.whereColumn = whereColumn;
		this.word = word;
		this.sortColumn = sortColumn;
		this.orderby = orderby;		
		this.pageCutCount = pageCutCount;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startRow = startRow;
		this.endRow = endRow;
	}

		
	public List<ReviewVO> getReviewVOList() {
		return listVO;
	}
		
	
	//리스트 Empty 상태 : boolean 일때 get이 아닌 is로 메소드명 정의
	/**
	 * 리스트 Empty 상태 
	 * @return
	 */
	public boolean isHasBoardVO() {
		return ! listVO.isEmpty();
	}

	public List<ReviewVO> getListVO() {
		return listVO;
	}

	public void setListVO(List<ReviewVO> listVO) {
		this.listVO = listVO;
	}

	public String getWhereColumn() {
		return whereColumn;
	}

	public void setWhereColumn(String whereColumn) {
		this.whereColumn = whereColumn;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}	

	public int getPageCutCount() {
		return pageCutCount;
	}

	public void setPageCutCount(int pageCutCount) {
		this.pageCutCount = pageCutCount;
	}

	public int getRequestPage() {
		return requestPage;
	}

	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	@Override
	public String toString() {
		return "ReviewListDTO [listVO=" + listVO + ", whereColumn=" + whereColumn + ", word=" + word + ", sortColumn="
				+ sortColumn + ", orderby=" + orderby + ", pageCutCount=" + pageCutCount
				+ ", requestPage=" + requestPage + ", totalPageCount=" + totalPageCount + ", startRow=" + startRow
				+ ", endRow=" + endRow + "]";
	}	
}
