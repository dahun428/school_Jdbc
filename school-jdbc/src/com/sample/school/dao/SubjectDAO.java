package com.sample.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sample.school.util.ConnectionUtil;
import com.sample.school.util.QueryUtil;
import com.sample.school.vo.Department;
import com.sample.school.vo.Subject;

public class SubjectDAO {

	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void addNewSubject(Subject subject) throws Exception{
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("subject.addNewSubject"));
		pstmt.setString(1, subject.getSubjectName());
		pstmt.setInt(2, subject.getDepartment().getNo());
		pstmt.executeQuery();
		
		pstmt.close();
		connection.close();
	}
	public Subject getSubjectBySubjectName(String subjectName) throws Exception {
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("subject.getSubjectBySubjectName"));
		pstmt.setString(1, subjectName);
		rs = pstmt.executeQuery();
		Subject subject = null;
		
		if(rs.next()) {
			subject = resultSetToSubejct(rs);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return subject;
		
	}
	
	public Subject getSubjectBySubjectNo(int subjectNo) throws Exception {
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("subject.getSubjectBySubjectNo"));
		pstmt.setInt(1, subjectNo);
		rs = pstmt.executeQuery();
		Subject subject = null;
		
		if(rs.next()) {
			subject = resultSetToSubejct(rs);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return subject;
	}	
	public List<Subject> getAllSubjectBySubjectName(String subjectName)throws Exception{
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("subject.getAllSubjectBySubjectName"));
		pstmt.setString(1, subjectName);
		rs = pstmt.executeQuery();
		List<Subject> subjects = new ArrayList<Subject>();

		while(rs.next()) {
			Subject subject = resultSetToSubejct(rs);
			subjects.add(subject);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return subjects;
	}
	private Subject resultSetToSubejct(ResultSet rs) throws Exception{
		
		Subject subject = new Subject();
		subject.setNo(rs.getInt("subject_no"));
		subject.setSubjectName(rs.getString("subject_name"));
		Department department = new Department();
		department.setNo(rs.getInt("department_no"));
		department.setDepartmentName(rs.getString("department_name"));
		
		subject.setDepartment(department);
		subject.setSubjectRegistrationDate(rs.getDate("registration_date"));
		
		return subject;
	}
	
	
}
