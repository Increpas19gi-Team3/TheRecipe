package com.increpas.therecipe.util;

/**
 * Blank 값 처리하는 클래스
 * @author 손가연
 * 
 */
public class BlankChange {

	/**
	 * "" 데이터가 들어오면 "0" 값으로 돌려보내기
	 * @param data
	 * @return  data == "" → "0" / 
	 * 			data != "" → data
	 */
	public static String doStringZero(String data){
		
		if(data.equals("")) return "0";
		else return data;
	}
	
	/**
	 * "" 데이터가 들어오면 0 값으로 돌려보내기
	 * @param data
	 * @return  data == "" → 0 / 
	 * 			data != "" → Integer.parseInt(data)
	 */
	public static int doIntegerZero(String data){
		
		if(data.equals("")) return 0;
		else return Integer.parseInt(data);
	}
}
