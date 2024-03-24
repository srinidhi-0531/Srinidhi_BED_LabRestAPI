package com.gl.Debate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Student {

	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String first_name;
	
	private String last_name;
	
	private String course;
	
	private String country;

	public Student() {
		// default constructor
		
	}
			
	public Student(int id, String first_name, String last_name, String course, String country) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.course = course;
		this.country = country;
	}

	public Student(String first_name, String last_name, String course, String country) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.course = course;
		this.country = country;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", course=" + course
				+ ", country=" + country + "]";
	}




	
}