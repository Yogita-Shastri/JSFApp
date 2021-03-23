package com.cachetech.demo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.cachetech.demo.entity.Student;
import com.cachetech.demo.repository.StudentRepository;

@Named
@ViewScoped
public class StudentController implements Serializable {
	
	private Student student = new Student();
	
	private List<Student> studentList = new ArrayList<>();
	
	@Autowired
	private StudentRepository repository;
	
	//To get all students
	public void getAllStudents() {
		studentList = repository.findAll();
	}
	
	//To save student
	public void save() {
		repository.save(student);
		student = new Student();
		studentList = repository.findAll();
	}
	
	//Editing each student record
	public void edit(Student st) {
		student = st;
	}
	
	//To refresh 
	public void refresh() {
		student = new Student();
	}
	
	//getter method for studentList variable
	public List<Student> getStudentList() {
		return studentList;
	}
	
	//setter method for studentList variable
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	//getter method for student variable
	public Student getStudent() {
		return student;
	}

	//setter method for student variable
	public void setStudent(Student student) {
		this.student = student;
	}
}
