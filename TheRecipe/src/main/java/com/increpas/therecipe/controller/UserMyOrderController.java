package com.increpas.therecipe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.increpas.therecipe.service.UserMyOrderService;
import com.increpas.therecipe.vo.MyOrderVO;
import com.increpas.therecipe.vo.OrderVO;

/**
 * 주문관련 컨트롤러
 * 
 * @author 박호진
 *
 */

@Controller
public class UserMyOrderController {
	
	// slf4j 방식 로그
			Logger logger = LoggerFactory.getLogger(getClass());

			@Autowired
			UserMyOrderService userMyOrderService;
			
			/**
			 * 이미지명 데이터의 "_" 제거
			 * @param allImgname : foodvo.getF_thumname() - 저장된 이미지명  
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
			 * 썸네일 이미지 파싱
			 * @param usermyvo List<MyOrderVO>
			 * @return usermyvo
			 */
			public List<MyOrderVO> arrySplitImgname(List<MyOrderVO> mordervo){
				
				for(int i=0; i<mordervo.size(); i++){
					if(mordervo.get(i).getF_thumname()!=null){
						String[] tmp = splitImgname(mordervo.get(i).getF_thumname());
						mordervo.get(i).setF_thumname(tmp[0]);
					}
				}
				
				return mordervo;
			}
			
			/**
			 * 내 주문 등록
			 * @param odVo OrderVO odVo
			 * @param request HttpServletRequest request
			 * @param model Model model
			 * @param session HttpSession session
			 * @return 홈으로 이동
			 */
			@RequestMapping(value = "/orderWrite.do", method = RequestMethod.POST )
			public String orderWriteForm(@ModelAttribute("orderup") OrderVO odVo, HttpServletRequest request, Model model, HttpSession session) {
				
				String m_userid = (String) session.getAttribute("m_userid");
				String title= request.getParameter("title");
				String thumname= request.getParameter("thumname");
				odVo.setM_userid(m_userid);
//				odVo.setF_fdcode(request.getParameter("f_fdcode"));
//				odVo.setO_buyprice(Integer.parseInt(request.getParameter("o_buyprice")));
//				odVo.setO_amount(Integer.parseInt(request.getParameter("o_amount")));
				
			    userMyOrderService.insertOrder(odVo);
			    model.addAttribute("title", title);
				model.addAttribute("thumname", thumname);
				
				
				return "redirect:home.do";
			}
			
			/**
			 * 내 주문 보기
			 * @param request HttpServletRequest request
			 * @param model Model model
			 * @param session HttpSession session
			 * @return 내 주문 보기 페이지로 이동
			 */
			@RequestMapping(value = "myOrderList.do", method = RequestMethod.GET )
			public String orderListForm( HttpServletRequest request, Model model, HttpSession session) {
				
				String m_userid = (String) session.getAttribute("m_userid");
				
				List<MyOrderVO> list = userMyOrderService.selectMyOrder(m_userid);
				
				arrySplitImgname(list);
				
				model.addAttribute("list", list);

				
				return "myOrder";
			}
			/**
			 * 내 주문 상세보기
			 * @param model Model model
			 * @param request HttpServletRequest request
			 * @return 내 주문 상세보기 페이지로 이동
			 */
			@RequestMapping(value = "/myOrderDetail.do", method = RequestMethod.GET)
			public String myOrderDetail(Model model,HttpServletRequest request) {
				
				String o_orderid = request.getParameter("o_orderid");
				MyOrderVO moVo = userMyOrderService.selectMyOrderDetail(o_orderid);
				String[] F_thumname = splitImgname(moVo.getF_thumname());
				moVo.setF_thumname(F_thumname[0]);
				model.addAttribute("moVo", moVo);
				
				return "myOrder_detail";
			}
			
		
			
	

			
			
			
			

}
