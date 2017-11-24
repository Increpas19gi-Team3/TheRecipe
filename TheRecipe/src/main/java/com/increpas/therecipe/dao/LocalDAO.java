package com.increpas.therecipe.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.increpas.therecipe.vo.FoodVO;

@Repository
public class LocalDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public List<FoodVO> selectList(){
		
		return sqlSessionTemplate.selectList("local_ns.selectAllList"); 
		
	}
}
