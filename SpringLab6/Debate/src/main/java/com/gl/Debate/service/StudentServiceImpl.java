package com.gl.Debate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.Debate.model.Student;
import com.gl.Debate.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		List<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	public Student findById(int theId) {
		// TODO Auto-generated method stub
		return studentRepository.findById(theId).get();
	}

	@Override
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		studentRepository.save(theStudent);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(theId);
		
	}




}