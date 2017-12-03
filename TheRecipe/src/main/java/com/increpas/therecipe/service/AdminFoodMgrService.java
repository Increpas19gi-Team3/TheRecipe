package com.increpas.therecipe.service;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.increpas.therecipe.dao.AdminFoodMgrDAO;
import com.increpas.therecipe.dto.AdminFoodListDTO;
import com.increpas.therecipe.dto.AdminFoodRegDTO;
import com.increpas.therecipe.dto.UploadFileDTO;
import com.increpas.therecipe.vo.FoodMgrVO;
import com.increpas.therecipe.vo.FoodcodeVO;

/**
 * 관리자) 음식 관리 하기 위한 Service 
 * @author 손가연
 *
 */
@Service
public class AdminFoodMgrService {

	// slf4j 방식 로그
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	AdminFoodMgrDAO adminFoodMgrDAO;
	
	@Autowired
	AdminFoodListDTO adminFoodListDTO;
	
	
	/**
	 * 전체 등록 데이터 가져오기
	 * @return : List<FoodMgrVO>
	 */
	public List<FoodMgrVO> selectAdminFoodListAll(){
		return adminFoodMgrDAO.selectAdminFoodListAll();
	}
	
	
	/**
	 * 전체 등록 데이터 가져오기
	 * @return : List<FoodMgrVO>
	 */
	public List<FoodMgrVO> selectAdminFoodListSel(FoodcodeVO fcVO){
		return adminFoodMgrDAO.selectAdminFoodListSel(fcVO);
	}
	
	

	/**
	 * 전체 등록 데이터 가져오기 - 페이징, 검색
	 * @return : List<AdminFoodListDTO>
	 */
	public List<AdminFoodListDTO> selectSetAdminFoodList(FoodcodeVO fcVO){
		return adminFoodMgrDAO.selectSetAdminFoodList(fcVO);
	}
	
	
	
	
	
	
	public AdminFoodListDTO getFoodMgrVOList(int pageCutCount, int requestPageNumber, 
			String whereColumn, String word, 
			String sortColumn, String orderby,
			int fc_1st, int fc_2nd, int fc_3rd){
		
		System.err.println("▶▶▶▶ ListService : getBoardVOList >> 조건 검색 들어옴");
		
		adminFoodListDTO.setWhereColumn(whereColumn);
		adminFoodListDTO.setWord(word);
		adminFoodListDTO.setSortColumn(sortColumn);
		adminFoodListDTO.setOrderby(orderby);
		adminFoodListDTO.setFc_1st(fc_1st);
		adminFoodListDTO.setFc_2nd(fc_2nd);
		adminFoodListDTO.setFc_3rd(fc_3rd);
		
		// 페이징 처리
		if (requestPageNumber < 0) {
			throw new IllegalArgumentException("page number < 0 : "
					+ requestPageNumber);
		}
		
		// DAO에게 DB의 전체 글 개수조회 요청
		int totalBoardVOCount = adminFoodMgrDAO.listCount(adminFoodListDTO);
		System.out.println("---------------------- 전체 글 갯수 " + totalBoardVOCount);
		
		if (totalBoardVOCount == 0) {//글의 개수가 0이면
			//모델 : BoardVOListModel : 게시글 목록화면 VO 
			return new AdminFoodListDTO(); // AC에게 되돌려줄 모델(게시글 목록 화면) 리턴
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
		
		adminFoodListDTO.setStartRow(firstRow);
		adminFoodListDTO.setEndRow(endRow);
		
		// DAO에게 DB Select 요청
		List<FoodMgrVO> boardDTOList = adminFoodMgrDAO.selectSetAdminFoodList(adminFoodListDTO);
		System.out.println("---------------------- DB에서 값 가져오기 성공 ");
		
		//BoardVOListModel 결과 모델을 생성
		AdminFoodListDTO foodMgrVOList = new AdminFoodListDTO(boardDTOList, 
				whereColumn, word, sortColumn, orderby, pageCutCount,
				requestPageNumber, totalPageCount, firstRow, endRow, 
				fc_1st, fc_2nd, fc_3rd);
				
		
		return foodMgrVOList;
		
	}
	/**/
	
	
	/**
	 * 전체 페이지 계산(게시글 보기 설정값으로 계산)
	 * @param pageCutCount
	 * @param totalBoardVOCount
	 * @return
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
	 * 선택한 음식정보 상세보기
	 * @param String f_fdcode
	 * @return FoodMgrVO
	 */
	public FoodMgrVO selFoodView(String f_fdcode){
		return adminFoodMgrDAO.selFoodView(f_fdcode);
	}
	
	
	
	public AdminFoodRegDTO saveImagesSetting(AdminFoodRegDTO adminFoodRegDTO, Model model){
		
		MultipartFile f_imgname_1 = adminFoodRegDTO.getF_imgname_1();
		MultipartFile f_imgname_2 = adminFoodRegDTO.getF_imgname_2();
		MultipartFile f_imgname_3 = adminFoodRegDTO.getF_imgname_3();
		MultipartFile f_imgname_4 = adminFoodRegDTO.getF_imgname_4();
		MultipartFile f_imgname_5 = adminFoodRegDTO.getF_imgname_5();
		
		System.out.println(">>>>>>>>>>> f_imgname_1="+f_imgname_1.getOriginalFilename()+
				", f_imgname_2="+f_imgname_2.getOriginalFilename()+
				", f_imgname_3="+f_imgname_3.getOriginalFilename()+
				", f_imgname_4="+f_imgname_4.getOriginalFilename()+
				", f_imgname_5="+f_imgname_5.getOriginalFilename());		
		
		
		
		String imageNames = "";
		
		// 이미지 1번 업로드
		if (!f_imgname_1.isEmpty()) {
			imageNames += saveImages(f_imgname_1, model); //이미지 명 누적합
		}
		
		
		// 이미지 2번 업로드
		if (!f_imgname_2.isEmpty()) {
			imageNames += "_"+saveImages(f_imgname_2, model); //이미지 명 누적합			
		}
		
		
		// 이미지 3번 업로드
		if (!f_imgname_3.isEmpty()) {
			imageNames += "_"+saveImages(f_imgname_3, model); //이미지 명 누적합
		}
		
		
		// 이미지 4번 업로드
		if (!f_imgname_4.isEmpty()) {
			imageNames += "_"+saveImages(f_imgname_4, model); //이미지 명 누적합
			
		}
		
		
		// 이미지 5번 업로드
		if (!f_imgname_5.isEmpty()) {
			imageNames += "_"+saveImages(f_imgname_5, model); //이미지 명 누적합
		}
		
		// 여기에 썸네일 이미지도 적용 해야함
		/*
		 https://okky.kr/article/367729
		  http://jsonobject.tistory.com/226
		  http://jaesu.tistory.com/entry/image-thumbnail-%EB%A7%8C%EB%93%A4%EA%B8%B0
		  
		 */
		
		//DB에 입력할 이미지 적용
		adminFoodRegDTO.setF_imgname(imageNames);
		System.out.println("getF_imgname : " + adminFoodRegDTO.getF_imgname());
		
		return adminFoodRegDTO;
	}
	
	
	
	public String saveImages(MultipartFile f_imgname, Model model){
		
		String imageNames = "";
		String path = "C:/images/";
		
		String originalFilename = f_imgname.getOriginalFilename();
		String systemFilename = UUID.randomUUID() + "_" + originalFilename;
		
		// 업로드파일객체를 지정한 파일에 복사
		try {
			f_imgname.transferTo(new File(path, systemFilename));
			System.out.println(systemFilename + " 업로드완료.");
			UploadFileDTO fileDTO = new UploadFileDTO();
			fileDTO.setOriginalFilename(originalFilename);
			fileDTO.setSystemFilename(systemFilename);
			fileDTO.setFileSize(f_imgname.getSize());
			model.addAttribute(f_imgname+"_fileDTO", fileDTO);
			
			imageNames += systemFilename; //이미지 명 누적합
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return imageNames;
	}
	
}
