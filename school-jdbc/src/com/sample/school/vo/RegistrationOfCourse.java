package com.sample.school.vo;

import java.util.Date;

public class RegistrationOfCourse {

	private int no;
	private Course course;
	private Student student;
	private String isCancled;
	private String isCompletion;
	private int score;
	private Date registrationOfCourseRegistrationDate;
	
	public RegistrationOfCourse() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getIsCancled() {
		return isCancled;
	}
	public void setIsCancled(String isCancled) {
		this.isCancled = isCancled;
	}
	public String getIsCompletion() {
		return isCompletion;
	}
	public void setIsCompletion(String isCompletion) {
		this.isCompletion = isCompletion;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getRegistrationOfCourseRegistrationDate() {
		return registrationOfCourseRegistrationDate;
	}

	public void setRegistrationOfCourseRegistrationDate(Date registrationOfCourseRegistrationDate) {
		this.registrationOfCourseRegistrationDate = registrationOfCourseRegistrationDate;
	}
	
	
	
}
