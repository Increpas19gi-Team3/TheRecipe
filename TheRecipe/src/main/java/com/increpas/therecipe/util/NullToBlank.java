package com.increpas.therecipe.util;

/**
 * Null 값 처리하는 클래스
 * @author 손가연
 * 
 */
public class NullToBlank {

	/**
	 * Null 데이터가 들어오면 "" 값으로 돌려보내기
	 * @param data
	 * @return  data == null → "" / 
	 * 			data != null → data
	 */
	public static String doChange(String data){
		
		if(data == null) return "";
		else return data;
	}
	
}
