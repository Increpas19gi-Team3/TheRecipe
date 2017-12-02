package com.increpas.therecipe.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.increpas.therecipe.service.UserMyBasketService;
import com.increpas.therecipe.vo.UserMyBasketVO;

/**
 * 장바구니보기 주문조회 후기등록 관련 컨트롤러
 * 
 * @author 박호진
 *
 */

@Controller
public class UserMyBasketController {
	
	// slf4j 방식 로그
		Logger logger = LoggerFactory.getLogger(getClass());

		@Autowired
		UserMyBasketService userMyService;
		
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
		
		public List<UserMyBasketVO> arrySplitImgname(List<UserMyBasketVO> usermyvo){
			
			for(int i=0; i<usermyvo.size(); i++){
				if(usermyvo.get(i).getF_thumname()!=null){
					String[] tmp = splitImgname(usermyvo.get(i).getF_thumname());
				 	usermyvo.get(i).setF_thumname(tmp[0]);
				}
			}
			
			return usermyvo;
		}

		
		
		@RequestMapping(value = "/BasketForm.do", method = RequestMethod.GET)
		public String BasketForm( HttpSession session , Model model) {
			// 장바구니 리스트 조회(아이디)
			
			String m_userid = (String) session.getAttribute("m_userid");
			
			List<UserMyBasketVO> list = userMyService.selectBasket(m_userid);

			list = arrySplitImgname(list);
			
			
			
			model.addAttribute("basket", list);
			

			return "cart";
		}
		
		@RequestMapping(value = "/DeleteBasket.do", method = RequestMethod.POST)
		public String DeleteBasket( HttpSession session , Model model) {
			// 장바구니  삭제(아이디)
			
			String m_userid = (String) session.getAttribute("m_userid");
			
			
			model.addAttribute("basket", userMyService.selectBasket(m_userid));

			return "cart";
		}
		
		@RequestMapping(value = "/myorder.do", method = RequestMethod.POST)
		public String orderForm() {

			return "myOrder";
		}
		
		

}
