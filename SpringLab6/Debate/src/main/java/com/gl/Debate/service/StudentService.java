package com.gl.Debate.service;

import java.util.List;

import com.gl.Debate.model.Student;

public interface StudentService {
	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student theStudent);

	public void deleteById(int theId);

	//public List<Student> searchBy(String name);


}