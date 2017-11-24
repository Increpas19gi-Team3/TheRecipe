package com.increpas.therecipe.controller;

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

@Controller
public class localfoodListController {
		Logger logger = LoggerFactory.getLogger(getClass());
		
		@Autowired
		LocalService localService;
		
		@RequestMapping(value = "/foodList.do", method = RequestMethod.GET)
		public String foodList(@Valid @ModelAttribute("icmd") FoodVO fvo, Model model){
			
			model.addAttribute("food", localService.selectList());
			
			return "";
		}
}
