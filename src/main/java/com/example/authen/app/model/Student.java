package com.example.authen.app.model;

public class Student {
	private String name;
	private int age;
	private Double gpa;
	
	
	public Student() {};
	
	public Student(String name, int age, Double gpa) {
		this.name = name;
		this.age = age;
		this.gpa = gpa;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Double getGpa() {
		return gpa;
	}
	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}
	
	
}
