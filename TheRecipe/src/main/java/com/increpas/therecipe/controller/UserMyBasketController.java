package com.increpas.therecipe.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.increpas.therecipe.service.UserMyBasketService;
import com.increpas.therecipe.vo.UserMyBasketVO;

/**
 * 장바구니보기  관련 컨트롤러
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
			
	      for (int i = 0; i < list.size(); i++) {
				if(list.get(i).getDiscount_value()==null) {
					list.get(i).setDiscount_value("0");
				}
			}
			
			list = arrySplitImgname(list);

			model.addAttribute("basket", list);
			
			return "cart";
		}
		
	
		@RequestMapping(value = "/DeleteBasket.do", method = RequestMethod.GET)
		public String DeleteBasket(@RequestParam("f_fdcode") String f_fdcode , HttpSession session , Model model) {
			// 장바구니  삭제(아이디)
			
			String m_userid = (String) session.getAttribute("m_userid");
			System.out.println(f_fdcode);
			
			
			 userMyService.deleteBasket(m_userid,f_fdcode);

			return "redirect:BasketForm.do";
		}
		
		@RequestMapping(value = "/orderWriteForm.do", method = { RequestMethod.GET, RequestMethod.POST })
		public String orderWriteForm(HttpServletRequest request,  Model model) {
			
			String f_fdcode =  request.getParameter("f_fdcode");
			int o_buyprice = Integer.parseInt(request.getParameter("o_buyprice"));
			int o_amount = Integer.parseInt(request.getParameter("buy_cnt"));
			String title= request.getParameter("title");
			String thumname= request.getParameter("thumname");
			 model.addAttribute("f_fdcode", f_fdcode);
			 model.addAttribute("o_buyprice", o_buyprice);
			 model.addAttribute("o_amount", o_amount);
			 model.addAttribute("title", title);
			 model.addAttribute("thumname", thumname);
			
			
			return "orderWriteForm";
		}
		

}
