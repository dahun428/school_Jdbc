package com.sample.school.vo;

import java.sql.Date;

public class Course {

	private int no;
	private String courseName;
	private Department department;
	private Subject subject;
	private Professor professor;
	private int NumberOfPeople;
	private String isFullOfCourse;
	private Date courseRegistrationDate;
	
	public Course() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getNumberOfPeople() {
		return NumberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		NumberOfPeople = numberOfPeople;
	}
	public void setIsFullOfCourse(String isFullOfCourse) {
		this.isFullOfCourse = isFullOfCourse;
	}
	public String getIsFullOfCourse() {
		return isFullOfCourse;
	}
	public Date getCourseRegistrationDate() {
		return courseRegistrationDate;
	}

	public void setCourseRegistrationDate(Date courseRegistrationDate) {
		this.courseRegistrationDate = courseRegistrationDate;
	}
	
	
	
	
}
