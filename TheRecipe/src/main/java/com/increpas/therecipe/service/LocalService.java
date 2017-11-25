package com.increpas.therecipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increpas.therecipe.dao.LocalDAO;
import com.increpas.therecipe.vo.FoodVO;

/**
 * 
 * 지역 관련 service
 * @author 김지현
 *
 */

@Service
public class LocalService {
	@Autowired
	LocalDAO lDao;
	
	public List<FoodVO> selectAllList(){
		
		return lDao.selectList();
	}
	
	public List<FoodVO> selectKindList(int kind, int local){
		
		return lDao.selectLocalKindList(kind, local);
	}
	
	public List<FoodVO> selectTitleList(int kind, String title){
		
		return lDao.selectTitleList(kind, title);
	}
}
