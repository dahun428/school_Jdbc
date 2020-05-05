package com.sample.school.vo;

import java.util.Date;

public class Professor {

	private int no;
	private String professorName;
	private String position;
	private Department department;
	private Date professorRegistrationDate;
	
	public Professor() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getProfessorRegistrationDate() {
		return professorRegistrationDate;
	}

	public void setProfessorRegistrationDate(Date professorRegistrationDate) {
		this.professorRegistrationDate = professorRegistrationDate;
	}
	
	
}
