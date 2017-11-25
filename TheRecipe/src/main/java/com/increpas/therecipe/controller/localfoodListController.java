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
		
		@RequestMapping(value = "/localFoodList.do", method = RequestMethod.GET)
		public String allLocalFoodList(@Valid @ModelAttribute("icmd") FoodVO fvo, Model model){
			List<FoodVO> foodvo =  localService.selectAllList();

			model.addAttribute("foodList", foodvo);
			
			return "localfoodListView";
		}
		
		@RequestMapping(value = "/localKindList.do", method = RequestMethod.GET)
		public String koreaFoodList(@Valid @ModelAttribute("icmd") FoodVO fvo, Model model, HttpServletRequest request){
			int kind = 1;
			int local = Integer.parseInt(request.getParameter("local"));
			
			List<FoodVO> foodvo =  localService.selectKindList(kind, local);

			model.addAttribute("foodList", foodvo);
			
			return "localfoodListView";
		}
		
		@RequestMapping(value = "/localTitleList.do", method = RequestMethod.POST)
		public String FoodTitleList(@Valid @ModelAttribute("icmd") FoodVO fvo, Model model, HttpServletRequest request){
			int kind = 1;
			String title = request.getParameter("foodname");
			
			List<FoodVO> foodvo =  localService.selectTitleList(kind, title);

			model.addAttribute("foodList", foodvo);
			
			return "localfoodListView";
		}
}


