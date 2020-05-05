package com.sample.school.vo;

import java.util.Date;

public class Student {

	private int no;
	private String StudentName;
	private int grade;
	private Department department;
	private Date StudentRegistrationDate;
	
	public Student() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getStudentRegistrationDate() {
		return StudentRegistrationDate;
	}

	public void setStudentRegistrationDate(Date studentRegistrationDate) {
		StudentRegistrationDate = studentRegistrationDate;
	}
	
	
	
}
