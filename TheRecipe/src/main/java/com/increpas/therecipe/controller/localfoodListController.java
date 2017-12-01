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
import com.increpas.therecipe.vo.FoodVO;
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
		public List<FoodVO> arrySplitImgname(List<FoodVO> foodvo){
			
			for(int i=0; i<foodvo.size(); i++){
				if(foodvo.get(i).getF_imgname()!=null){
					String[] tmp = splitImgname(foodvo.get(i).getF_imgname());
				 	foodvo.get(i).setF_imgname(tmp[0]);
				}
			}
			
			return foodvo;
		}

		/**
		 * 대분류별 리스트 출력
		 * @param fvo : 뷰에서 받은 FoodVO
		 * @param model : Model
		 * @return 뷰파일명
		 */
		@RequestMapping(value = "/totalFoodList.do", method = RequestMethod.GET)
		public String allLocalFoodList(@Valid @ModelAttribute("icmd") FoodVO fvo, Model model, HttpServletRequest request){
			int level = 1;
			int large = Integer.parseInt(request.getParameter("large"));
			
			List<FoodVO> foodvo =  localService.selectAllList(large);
			foodvo = arrySplitImgname(foodvo);
			
			List<FoodcodeVO> foodcdvo = localService.searchFoodCode(request.getParameter("large"),"0","0");
			model.addAttribute("large", large);
			model.addAttribute("level", level);
			model.addAttribute("foodList", foodvo);
			model.addAttribute("foodcode",foodcdvo);
			
			return "localfoodListView";
		}
		
		/**
		 * 중분류별 리스트 출력
		 * @param fvo : 뷰에서 받은 FoodVO 
		 * @param model : Model
		 * @param request : HttpServletRequest
		 * @return 뷰파일명
		 */
		@RequestMapping(value = "/localKindList.do", method = RequestMethod.GET)
		public String kindFoodList(@Valid @ModelAttribute("icmd") FoodVO fvo, Model model, HttpServletRequest request){
			int level = 2;
			int large = Integer.parseInt(request.getParameter("large"));
			int medium = Integer.parseInt(request.getParameter("medium"));
			
			List<FoodVO> foodvo =  localService.selectKindList(large, medium);

			foodvo = arrySplitImgname(foodvo);
			
			List<FoodcodeVO> ctgoryvo = localService.searchFoodCode(request.getParameter("large"),request.getParameter("medium"),"0");
			List<FoodcodeVO> foodcdvo = localService.searchFoodCode(request.getParameter("large"),request.getParameter("medium"),"-1");

			model.addAttribute("large", large);
			model.addAttribute("foodList", foodvo);
			model.addAttribute("ctgoryvo",ctgoryvo);
			model.addAttribute("foodcode",foodcdvo);
			model.addAttribute("level",level);
			
			return "localfoodListView";
		}
		
		/**
		 * 소분류별 리스트 출력
		 * @param fvo : 뷰에서 받은 FoodVO 
		 * @param model : Model
		 * @param request : HttpServletRequest
		 * @return 뷰파일명
		 */
		@RequestMapping(value = "/localKindItemList.do", method = RequestMethod.GET)
		public String ItemFoodList(@Valid @ModelAttribute("icmd") FoodVO fvo, Model model, HttpServletRequest request){
			int level = 3;

			int large = Integer.parseInt(request.getParameter("large"));
			int medium = Integer.parseInt(request.getParameter("medium"));
			int small = Integer.parseInt(request.getParameter("small"));
			
			List<FoodVO> foodvo =  localService.selectItemList(large, medium, small);

			foodvo = arrySplitImgname(foodvo);
			
			List<FoodcodeVO> ctgoryvo = localService.searchFoodCode(request.getParameter("large"),request.getParameter("medium"),"0");
			List<FoodcodeVO> itemvo = localService.searchFoodCode(request.getParameter("large"),request.getParameter("medium"),request.getParameter("small"));			
			List<FoodcodeVO> foodcdvo = localService.searchFoodCode(request.getParameter("large"),request.getParameter("medium"),"-1");

			model.addAttribute("large", large);
			model.addAttribute("foodList", foodvo);
			model.addAttribute("ctgoryvo",ctgoryvo);
			model.addAttribute("itemvo",itemvo);
			model.addAttribute("foodcode",foodcdvo);
			model.addAttribute("level",level);
			
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
		public String FoodTitleList(@Valid @ModelAttribute("icmd") FoodVO fvo, Model model, HttpServletRequest request){
			String title = request.getParameter("foodname");
			int first = Integer.parseInt(request.getParameter("first"));
			int second = Integer.parseInt(request.getParameter("second"));
			int third = Integer.parseInt(request.getParameter("third"));
			int level = 0;
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
			
			List<FoodVO> foodvo =  localService.selectTitleList(first, second, third, title);
			foodvo = arrySplitImgname(foodvo);
			
			model.addAttribute("foodList", foodvo);
			model.addAttribute("foodcode",foodcdvo);
			model.addAttribute("level", level);
			model.addAttribute("large", first);
			
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
		public String FoodDeatilList(@Valid @ModelAttribute("icmd") FoodVO fvo, Model model, HttpServletRequest request){
			int kind = 1;
			String code = request.getParameter("fcode");
			
			FoodVO foodvo =  localService.selectFood(kind, code);
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
		public String ShoppingBasket(@Valid @ModelAttribute("icmd") FoodVO fvo, Model model, HttpServletRequest request){
			int kind = 1;
			String userID = request.getParameter("userID");
			String fdcode = request.getParameter("fdcode");
			int buyPrice = Integer.parseInt(request.getParameter("buyPrice"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			
			int result =  localService.insertBasket(userID, fdcode, buyPrice, amount);
			FoodVO foodvo =  localService.selectFood(kind, fdcode);
			
			model.addAttribute("result", result);
			model.addAttribute("foodList", foodvo);
			model.addAttribute("imgname", splitImgname(foodvo.getF_imgname()));
			
			return "foodDetailView";
		}
		
		
		
}


