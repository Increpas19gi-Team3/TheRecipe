package com.increpas.therecipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.LocalDAO;
import com.increpas.therecipe.vo.FoodVO;

@Service
public class LocalService {
	@Autowired
	LocalDAO lDao;
	
	public List<FoodVO> selectList(){
		
		return lDao.selectList();
	}

}
