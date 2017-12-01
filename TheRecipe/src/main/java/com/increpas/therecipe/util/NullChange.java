package com.increpas.therecipe.util;

/**
 * Null 값 처리하는 클래스
 * @author 손가연
 * 
 */
public class NullChange {

	/**
	 * Null 데이터가 들어오면 "" 값으로 돌려보내기
	 * @param data
	 * @return  data == null → "" / 
	 * 			data != null → data
	 */
	public static String doBlank(String data){
		
		if(data == null) return "";
		else return data;
	}
	
	/**
	 * Null 데이터가 들어오면 "0" 값으로 돌려보내기
	 * @param data
	 * @return  data == null → "0" / 
	 * 			data != null → data
	 */
	public static String doStringZero(String data){
		
		if(data == null) return "0";
		else return data;
	}
	
	/**
	 * Null 데이터가 들어오면 0 값으로 돌려보내기
	 * @param data
	 * @return  data == null → 0 / 
	 * 			data != null → Integer.parseInt(data)
	 */
	public static int doIntegerZero(String data){
		
		if(data == null) return 0;
		else return Integer.parseInt(data);
	}
	
	/**
	 * Null 데이터가 들어오면 number 값으로 돌려보내기
	 * @param data
	 * @return  data == null → number / 
	 * 			data != null → data
	 */
	public static String doStringNumber(String data, String number){
		if(data == null) return number;
		else return data;
	}
	

	/**
	 * Null 데이터가 들어오면 number 값으로 돌려보내기
	 * @param data
	 * @return  data == null → number / 
	 * 			data != null → Integer.parseInt(data)
	 */
	public static int doIntegerNumber(String data, int number){
		
		if(data == null) return number;
		else return Integer.parseInt(data);
	}
}
