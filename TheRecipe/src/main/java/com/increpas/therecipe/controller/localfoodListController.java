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
		 * 전체 리스트 출력
		 * @param fvo : 뷰에서 받은 FoodVO
		 * @param model : Model
		 * @return 뷰파일명
		 */
		@RequestMapping(value = "/localFoodList.do", method = RequestMethod.GET)
		public String allLocalFoodList(@Valid @ModelAttribute("icmd") FoodVO fvo, Model model){
			List<FoodVO> foodvo =  localService.selectAllList();
			foodvo = arrySplitImgname(foodvo);
			
			List<FoodcodeVO> foodcdvo = localService.searchFoodCode("1","0","0");
			model.addAttribute("foodList", foodvo);
			model.addAttribute("foodcode",foodcdvo);
			
			return "localfoodListView";
		}
		
		/**
		 * 종류별 리스트 출력
		 * @param fvo : 뷰에서 받은 FoodVO 
		 * @param model : Model
		 * @param request : HttpServletRequest
		 * @return 뷰파일명
		 */
		@RequestMapping(value = "/localKindList.do", method = RequestMethod.GET)
		public String kindFoodList(@Valid @ModelAttribute("icmd") FoodVO fvo, Model model, HttpServletRequest request){
			int kind = 1;
			int local = Integer.parseInt(request.getParameter("local"));
			
			List<FoodVO> foodvo =  localService.selectKindList(kind, local);
			foodvo = arrySplitImgname(foodvo);
			
			List<FoodcodeVO> foodcdvo = localService.searchFoodCode("1",request.getParameter("local"),"1");
			
			model.addAttribute("foodList", foodvo);
			model.addAttribute("foodcode",foodcdvo);
			
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
			int kind = 1;
			String title = request.getParameter("foodname");
			
			List<FoodVO> foodvo =  localService.selectTitleList(kind, title);
			foodvo = arrySplitImgname(foodvo);
			
			model.addAttribute("foodList", foodvo);
			
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


