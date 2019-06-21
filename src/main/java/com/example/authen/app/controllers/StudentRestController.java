package com.example.authen.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.authen.app.model.Student;

@RestController
@RequestMapping("/student_controller_rest")
public class StudentRestController {
	
	@RequestMapping("/singleStudent")
	public Student singleStudent() {
		Student student = new Student("Mr.beans",23,3.35);
		return student;
		
	}
	
	@RequestMapping("/listStudent")
	public List<Student> listStudent() {
		Student student = new Student("Mr.beans",23,3.35);
		Student student2 = new Student("Mr. Chalee",25,3.01);
		
		List<Student> dataList = new ArrayList<>();
		dataList.add(student);
		dataList.add(student2);
		
		return dataList;
		
	}
}

