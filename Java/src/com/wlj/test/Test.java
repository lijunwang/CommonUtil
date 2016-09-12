package com.wlj.test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Test {
	public static void main(String[] args) {
		String Meter = "\u7c73";// "รื";
		String te = "\u7c73";
		System.out.println(te + "," + Meter);
		DecimalFormat fnum = new DecimalFormat("##0.0");
		System.out.println(fnum.format(23));
	}
	
	private static boolean isSameType(String type1, String type2){
		ArrayList<String> list = new ArrayList<String>();
		list.add(short.class.getName());
		list.add(Short.class.getName());
		list.add("SSSS");
		
		list.add(int.class.getName());
		list.add(Integer.class.getName());
		list.add("IIII");
		
		list.add(float.class.getName());
		list.add(Float.class.getName());
		list.add("FFFF");
		
		list.add(double.class.getName());
		list.add(Double.class.getName());
		list.add("DDDD");
		
		list.add(long.class.getName());
		list.add(Long.class.getName());
		list.add("LLLL");
		
		list.add(byte.class.getName());
		list.add(Byte.class.getName());
		list.add("BBBB");
		
		if(type1 == null || type2 == null){
			System.out.println("should not compare null ... ");
			return false;
		}else if(Math.abs(list.indexOf(type1) - list.indexOf(type2)) == 1){
			System.out.println("hello you are the special one ... ");
			return true;
		}else if(type1.equals(type2)){
			return true;
		}else{
			return false;
		}
	}
	
}
