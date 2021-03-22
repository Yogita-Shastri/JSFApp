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
	
	public void getAllStudents() {
		studentList = repository.findAll();
	}
	
	public void save() {
		repository.save(student);
		student = new Student();
		studentList = repository.findAll();
	}
	
	public void edit(Student st) {
		student = st;
	}
	
	public void refresh() {
		student = new Student();
	}
	
	public List<Student> getStudentList() {
		return studentList;
	}
	
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
