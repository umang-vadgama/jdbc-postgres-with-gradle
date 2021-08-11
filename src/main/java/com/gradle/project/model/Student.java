package com.gradle.project.model;

public class Student {

	
	String firstName;
	
	String lastName;
	int studet_id;
	
	public Student(String f_name, String l_name){
		this.firstName = f_name;
		this.lastName = l_name;
	}
	
	public Student(int id, String f_name, String l_name) {
		
		this.studet_id=id;
		this.firstName= f_name;
		this.lastName= l_name;
	}
	
	
	public int getStudet_id() {
		return studet_id;
	}

	public void setStudet_id(int studet_id) {
		this.studet_id = studet_id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
