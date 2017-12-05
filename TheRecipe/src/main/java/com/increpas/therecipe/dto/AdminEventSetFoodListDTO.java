package com.increpas.therecipe.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.vo.EventSetFoodVO;

/**
 *  게시판용 DTO
 * @author 손가연
 *
 */
@Repository
public class AdminEventSetFoodListDTO {

	private List<EventSetFoodVO> listVO;	// 게시글의 목록

	private String whereColumn;	// 검색 컬럼명
	private String word;		// 검색어
	private String sortColumn;	// 정렬 컬럼
	private String orderby;		// 정렬방식 ASC, DESC
	
	private int pageCutCount;	// 게시글 보기 수 - 디폴트 10
	
	private int requestPage;			// 요청 페이지 번호
	private int totalPageCount;			// 전체 페이지 수
	private int startRow;				// 요청(클릭) 페이지 시작 글번호
	private int endRow;					// 요청(클릭) 페이지 마지막 글번호
	
	
	private int fc_1st;			/* 지역:1 / TV:2	NUMBER NOT NULL */
	private int fc_2nd; 		/* 지역				NUMBER NOT NULL */
	private int fc_3rd; 		/* 구성				NUMBER NOT NULL */  
	

	private String selEventCode; // 요청 선택한 이벤트 코드

	// DB의 저장된 전체글의 개수가 0일때 리턴할 게시글 모델
	public AdminEventSetFoodListDTO() {
		this(new ArrayList<EventSetFoodVO>(), "", "", "", 
				"", 10, 0, 0, 0, 0,
				0, 0, 0,
				"ALL");
	}
	
	public AdminEventSetFoodListDTO(List<EventSetFoodVO> listVO, String whereColumn, String word, String sortColumn,
			String orderby, int pageCutCount, int requestPage, int totalPageCount, int startRow, int endRow,
			int fc_1st, int fc_2nd, int fc_3rd,
			String selEventCode) {
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
		
		this.fc_1st = fc_1st;
		this.fc_2nd = fc_2nd;
		this.fc_3rd = fc_3rd;		
		
		this.selEventCode = selEventCode;
	}

	
	//리스트 Empty 상태 : boolean 일때 get이 아닌 is로 메소드명 정의
	/**
	 * 리스트 Empty 상태 
	 * @return
	 */
	public boolean isHasFoodMgrVO() {
		return ! listVO.isEmpty();
	}

	public List<EventSetFoodVO> getListVO() {
		return listVO;
	}

	public void setListVO(List<EventSetFoodVO> listVO) {
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

	public int getFc_1st() {
		return fc_1st;
	}

	public void setFc_1st(int fc_1st) {
		this.fc_1st = fc_1st;
	}

	public int getFc_2nd() {
		return fc_2nd;
	}

	public void setFc_2nd(int fc_2nd) {
		this.fc_2nd = fc_2nd;
	}

	public int getFc_3rd() {
		return fc_3rd;
	}

	public void setFc_3rd(int fc_3rd) {
		this.fc_3rd = fc_3rd;
	}

	public String getSelEventCode() {
		return selEventCode;
	}

	public void setSelEventCode(String selEventCode) {
		this.selEventCode = selEventCode;
	}

	@Override
	public String toString() {
		return "AdminEventSetFoodListDTO [listVO=" + listVO + ", whereColumn=" + whereColumn + ", word=" + word
				+ ", sortColumn=" + sortColumn + ", orderby=" + orderby + ", pageCutCount=" + pageCutCount
				+ ", requestPage=" + requestPage + ", totalPageCount=" + totalPageCount + ", startRow=" + startRow
				+ ", endRow=" + endRow + ", fc_1st=" + fc_1st + ", fc_2nd=" + fc_2nd + ", fc_3rd=" + fc_3rd
				+ ", selEventCode=" + selEventCode + "]";
	}

}
