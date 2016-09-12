package com.wlj.serialization;

import java.io.Serializable;

public class Student implements Serializable{
	private String name;
	private int age;
	public Student(){
		this.name = "WangLiJun";
		this.age = 24;
	}
	
	public Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String ageName(){
		return this.name;
	}
	
	public int ageAge(){
		return this.age;
	}

	public String toString() {
		return String.format("name is %s, age is %d",  name, age);
	};
	
	public static void main(String[] args) {
		Student s1 = new Student();
		System.out.println(s1);
	}
}
