
package com.increpas.therecipe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.increpas.therecipe.service.LocalService;
import com.increpas.therecipe.util.NullToBlank;
import com.increpas.therecipe.vo.FoodListVO;
import com.increpas.therecipe.vo.FoodcodeVO;
import com.increpas.therecipe.vo.ReviewVO;


/**
 * 
 * 지역 관련 컨트롤러
 * @author 김지현
 *
 */
@Controller
public class localfoodListController {
		Logger logger = LoggerFactory.getLogger(getClass());
		
		@Autowired
		LocalService localService;

		/**
		 * 이미지명 데이터의 "_" 제거
		 * @param allImgname : foodvo.getF_imgname() - 저장된 이미지명  
		 * @return 구분자를 split한 배열
		 */
		public String[] splitImgname(String allImgname){
			//String[] imgname = allImgname.split("\\|");
			String[] imgname = null;
			
			if(allImgname != null){
				imgname = allImgname.split("_");
			}
			return imgname;
		}

		/**
		 * DB에 저장된 이미지명 set
		 * @param foodvo : FoodVO
		 * @return FoodVO
		 */
		public List<FoodListVO> arrySplitImgname(List<FoodListVO> foodvo){
			
			for(int i=0; i<foodvo.size(); i++){
				if(foodvo.get(i).getF_imgname()!=null){
					String[] tmp = splitImgname(foodvo.get(i).getF_imgname());
				 	foodvo.get(i).setF_imgname(tmp[0]);
				}
			}
			
			return foodvo;
		}

		/**
		 * 분류별 리스트 출력
		 * @param fvo : 뷰에서 받은 FoodVO
		 * @param model : Model
		 * @return 뷰파일명
		 */
		@RequestMapping(value = "/totalFoodList.do", method = RequestMethod.GET)
		public String allLocalFoodList(@Valid @ModelAttribute("icmd") FoodListVO fvo, Model model, HttpServletRequest request){
			int beginPage=1, endPage=0;
			int startNum=0, endNum=0;
			int level = 0, large = 0, medium = 0, small=0;
			String strL="0", strM="0", strS="0";
			String tmp=null; 
			List<FoodListVO> foodvo ;
			List<FoodcodeVO> foodcdvo, ctgoryvo, itemvo;
						
			if(!NullToBlank.doChange(request.getParameter("level")).equals(""))
				level = Integer.parseInt(request.getParameter("level"));
			if(!NullToBlank.doChange(request.getParameter("large")).equals("")){
				large = Integer.parseInt(request.getParameter("large"));
				strL = request.getParameter("large");
			}
			if(!NullToBlank.doChange(request.getParameter("medium")).equals("")){
				medium = Integer.parseInt(request.getParameter("medium"));
				strM = request.getParameter("medium");
			}				
			if(!NullToBlank.doChange(request.getParameter("small")).equals("")){
				small = Integer.parseInt(request.getParameter("small"));
				strS = request.getParameter("small");
			}
			
			tmp =  NullToBlank.doChange(request.getParameter("pageSize"));
			int pageSize= tmp.equals("") ? 8 : Integer.parseInt(request.getParameter("pageSize"));
						
			tmp = NullToBlank.doChange(request.getParameter("currPage"));
			int currPage = tmp.equals("") ? 1 : Integer.parseInt(request.getParameter("currPage"));

			int totalCount = localService.selectLargeCount(large,medium,small); //총 음식 리스트 갯수
			
			// 끝 페이지 계산
			if(totalCount%pageSize==0)
				endPage = totalCount/pageSize;
			else
				endPage = (totalCount/pageSize)+1;
			
			//현재 페이지의 startNum, endNum 계산
			startNum = (currPage*pageSize) - (pageSize-1);
			endNum = currPage*pageSize;
			
			
			foodvo =  localService.selectAllList(large,medium,small,startNum,endNum);
			foodvo = arrySplitImgname(foodvo);
			
			if(level == 1){
				foodcdvo = localService.searchFoodCode(strL,strM,strS);
			}
			else if(level == 2){
				ctgoryvo = localService.searchFoodCode(strL,strM,strS);
				foodcdvo = localService.searchFoodCode(strL,strM,"-1");
				model.addAttribute("ctgoryvo",ctgoryvo);
				
			}else{
				ctgoryvo = localService.searchFoodCode(strL,strM,"0");
				itemvo = localService.searchFoodCode(strL,strM,strS);		
				foodcdvo = localService.searchFoodCode(strL,strM,"-1");
				model.addAttribute("ctgoryvo",ctgoryvo);
				model.addAttribute("itemvo",itemvo);
			}
			
			model.addAttribute("large", large);
			model.addAttribute("level", level);
			model.addAttribute("foodList", foodvo);
			model.addAttribute("foodcode",foodcdvo);
			model.addAttribute("beginPage",beginPage);			
			model.addAttribute("endPage",endPage);		
			model.addAttribute("currPage",currPage);		
			
			
			return "localfoodListView";
		}
		
		/**
		 * 검색어(음식명)로 리스트 출력
		 * @param fvo : 뷰에서 받은 FoodVO 
		 * @param model : Model
		 * @param request : HttpServletRequest
		 * @return 뷰파일명
		 */
		@RequestMapping(value = "/localTitleList.do", method = RequestMethod.POST)
		public String FoodTitleList(@Valid @ModelAttribute("icmd") FoodListVO fvo, Model model, HttpServletRequest request){
			String title = request.getParameter("foodname");
			int first = Integer.parseInt(request.getParameter("first"));
			int second = Integer.parseInt(request.getParameter("second"));
			int third = Integer.parseInt(request.getParameter("third"));
			int level = 0;
			int beginPage=1, endPage=0;
			int startNum=0, endNum=0;
			String tmp=null; 
			List<FoodcodeVO> ctgoryvo = null;
			List<FoodcodeVO> itemvo = null;
			List<FoodcodeVO> foodcdvo = null;
			
			if(first!=0 && second==0 && third==0){
				level = 1;
				foodcdvo = localService.searchFoodCode(request.getParameter("first"),"0","0");
			}
			else if(second!=0 && third==0){
				level = 2;
				ctgoryvo = localService.searchFoodCode(request.getParameter("first"),request.getParameter("second"),"0");
				foodcdvo = localService.searchFoodCode(request.getParameter("first"),request.getParameter("second"),"-1");
				model.addAttribute("ctgoryvo",ctgoryvo);
				
			}
			else{
				level = 3;
				ctgoryvo = localService.searchFoodCode("1",request.getParameter("second"),"0");
				itemvo = localService.searchFoodCode("1",request.getParameter("second"),request.getParameter("third"));
				foodcdvo = localService.searchFoodCode("1",request.getParameter("second"),"-1");
				
				model.addAttribute("ctgoryvo",ctgoryvo);
				model.addAttribute("itemvo",itemvo);
			}
			
			tmp =  NullToBlank.doChange(request.getParameter("pageSize"));
			int pageSize= tmp.equals("") ? 8 : Integer.parseInt(request.getParameter("pageSize"));
						
			tmp = NullToBlank.doChange(request.getParameter("currPage"));
			int currPage = tmp.equals("") ? 1 : Integer.parseInt(request.getParameter("currPage"));

			int totalCount = localService.selectTitleCount(first, second, third, title); //총 음식 리스트 갯수
		
			// 끝 페이지 계산
			if(totalCount%pageSize==0)
				endPage = totalCount/pageSize;
			else
				endPage = (totalCount/pageSize)+1;
			
			//현재 페이지의 startNum, endNum 계산
			startNum = (currPage*pageSize) - (pageSize-1);
			endNum = currPage*pageSize;
			
			List<FoodListVO> foodvo =  localService.selectTitleList(first, second, third, title, startNum, endNum);
			foodvo = arrySplitImgname(foodvo);
			
			model.addAttribute("foodList", foodvo);
			model.addAttribute("foodcode",foodcdvo);
			model.addAttribute("level", level);
			model.addAttribute("large", first);
			model.addAttribute("beginPage",beginPage);			
			model.addAttribute("endPage",endPage);		
			model.addAttribute("currPage",currPage);
			
			return "localfoodListView";
		}

		/**
		 * 음식 상세페이지
		 * @param fvo : 뷰에서 받은 FoodVO 
		 * @param model : Model
		 * @param request : HttpServletRequest
		 * @return 뷰파일명
		 */
		@RequestMapping(value = "/foodDetailView.do", method = RequestMethod.GET)
		public String FoodDeatilList(@Valid @ModelAttribute("icmd") FoodListVO fvo, Model model, HttpServletRequest request){
			int large = Integer.parseInt(request.getParameter("large"));
	
			String code = request.getParameter("fcode");
			
			FoodListVO foodvo =  localService.selectFood(large, code);
			List<ReviewVO> reviewvo = localService.selectReview(code);
			
			model.addAttribute("foodList", foodvo);
			model.addAttribute("imgname", splitImgname(foodvo.getF_imgname()));
			model.addAttribute("thumname", splitImgname(foodvo.getF_thumname()));
			model.addAttribute("reviewList", reviewvo);
			
			return "foodDetailView";
		}
			
		/**
		 * 장바구니 상품 등록
		 * @param fvo : 뷰에서 받은 FoodVO 
		 * @param model : Model
		 * @param request : HttpServletRequest
		 * @return 뷰파일명
		 */
		@RequestMapping(value = "/shoppingBasket.do", method = RequestMethod.POST)
		public String ShoppingBasket(@Valid @ModelAttribute("icmd") FoodListVO fvo, Model model, HttpServletRequest request){
			int large = Integer.parseInt(request.getParameter("large"));
			int result = 0;
			String userID = request.getParameter("userID");
			String fdcode = request.getParameter("fdcode");
			int amount = Integer.parseInt(request.getParameter("amount"));
			
			int count = localService.selectExist(userID,fdcode);
			
			if(count>0){
				result =  localService.updateBasket(userID, fdcode, amount);
			}else{
				result =  localService.insertBasket(userID, fdcode, amount);
			}
			
			FoodListVO foodvo =  localService.selectFood(large, fdcode);
			
			model.addAttribute("result", result);
			model.addAttribute("foodList", foodvo);
			model.addAttribute("imgname", splitImgname(foodvo.getF_imgname()));
			
			return "foodDetailView";
		}
		
		
		
}


