package com.sample.school.vo;

import java.util.Date;

public class Subject {

	private int no;
	private String subjectName;
	private Department department;
	private Date subjectRegistrationDate;
	
	public Subject() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getSubjectRegistrationDate() {
		return subjectRegistrationDate;
	}

	public void setSubjectRegistrationDate(Date subjectRegistrationDate) {
		this.subjectRegistrationDate = subjectRegistrationDate;
	}
	
	
}
