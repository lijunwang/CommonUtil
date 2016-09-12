package com.wlj.tools;

public class Density {
	
	public double getDensityDpi(int width, int height, double size){
		return Math.sqrt(width * width + height * height) / size;
	}
	
	public static void main(String[] args) {
		Density d = new Density();
//		double result = d.getDensityDpi(480, 800, 4.5);
		double result = d.getDensityDpi(1080, 1920, 5);
		System.out.println(result);
	}
}
