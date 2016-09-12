package com.wlj.sort;

import java.util.Arrays;

public class BubbleUp {
	
	public void sort(){
		int count = 0;
		int[] sort = new int[]{623,25,32,10,26,99,11};
		int lenth = sort.length;
		int temp = -1;
		for(int i=0; i<lenth-1; i++){
			for(int j=i+1; j<lenth; j++){
				count ++;
				if(sort[j] < sort[i]){
					temp = sort[i];
					sort[i] = sort[j];
					sort[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(sort));
		System.out.println("比较次数：" + count);
		
	}
	
	private void test(){
		System.out.println("test ... bubble up !");
	}
	
	private void test(int in){
		System.out.println("test ... bubble up !" + in);
	}
	
	private void test(int in, String str){
		System.out.println("test ... bubble up !" + in + "," + str);
	}
	
	private void test(int in, char str){
		System.out.println("test ... bubble up !" + in + "," + str);
	}
	
	private void test(int in, String str1, String str2){
		System.out.println("test ... bubble up !" + in + "," + str1 + "," + str2);
	}
	
	public static void main(String[] args) {
//		BubbleUp up = new BubbleUp();
//		up.sort();
		char aa = 'a';
		Character a = 's';
		System.out.println(char.class.getName());
		System.out.println(Character.class.getName());
	}

}
