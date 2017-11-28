package com.increpas.therecipe.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.increpas.therecipe.vo.EventVO;

/**
 * 공지사항 & 이벤트 게시판용 DTO
 * @author 손가연
 *
 */
@Repository
public class EventListDTO {

private List<EventVO> listVO;	// 게시글의 목록
	
	private String whereColumn;	// 검색 컬럼명
	private String word;		// 검색어
	private String sortColumn;	// 정렬 컬럼
	private String orderby;		// 정렬방식 ASC, DESC
	private String GUBUN;		// 전체글 검색, 블록글 검색
	

	private int pageCutCount;	// 게시글 보기 수 - 디폴트 10
	
	private int requestPage;			// 요청 페이지 번호
	private int totalPageCount;			// 전체 페이지 수
	private int startRow;				// 요청(클릭) 페이지 시작 글번호
	private int endRow;					// 요청(클릭) 페이지 마지막 글번호

	// DB의 저장된 전체글의 개수가 0일때 리턴할 게시글 모델
	public EventListDTO() {
		this(new ArrayList<EventVO>(), "", "", "", "", "", 10, 0, 0, 0, 0);
	}
	
	public EventListDTO(List<EventVO> listVO, String whereColumn, String word, String sortColumn,
			String orderby, String GUBUN, int pageCutCount, int requestPage, int totalPageCount, int startRow,
			int endRow) {
		super();
		this.listVO = listVO;
		this.whereColumn = whereColumn;
		this.word = word;
		this.sortColumn = sortColumn;
		this.orderby = orderby;
		this.GUBUN = GUBUN;
		this.pageCutCount = pageCutCount;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startRow = startRow;
		this.endRow = endRow;
	}

		
	public List<EventVO> getEventVOList() {
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

	public List<EventVO> getListVO() {
		return listVO;
	}

	public void setListVO(List<EventVO> listVO) {
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

	public String getGUBUN() {
		return GUBUN;
	}

	public void setGUBUN(String GUBUN) {
		this.GUBUN = GUBUN;
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
		return "EventListDTO [listVO=" + listVO + ", whereColumn=" + whereColumn + ", word=" + word + ", sortColumn="
				+ sortColumn + ", orderby=" + orderby + ", GUBUN=" + GUBUN + ", pageCutCount=" + pageCutCount
				+ ", requestPage=" + requestPage + ", totalPageCount=" + totalPageCount + ", startRow=" + startRow
				+ ", endRow=" + endRow + "]";
	}
	
	
}
