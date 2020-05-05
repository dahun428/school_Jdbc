package com.sample.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sample.school.util.ConnectionUtil;
import com.sample.school.util.QueryUtil;
import com.sample.school.vo.Department;
import com.sample.school.vo.Student;

public class StudentDAO {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	public Student getStudentByStudentNo(int studentNo) throws Exception{
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("student.getStudentByStudentNo"));
		pstmt.setInt(1, studentNo);
		rs = pstmt.executeQuery();
		
		Student student = null;
		if(rs.next()) {
			student = resultSetToStudent(rs);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return student;
	}
	public List<Student> getAllStudentByDepartmentNo(int departmentNo) throws Exception {
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL(""));
		pstmt.setInt(1, departmentNo);
		rs = pstmt.executeQuery();
		List<Student> students = new ArrayList<Student>();
		
		while(rs.next()) {
			Student student = resultSetToStudent(rs);
			students.add(student);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return students;
	}
	
	private Student resultSetToStudent(ResultSet rs) throws Exception{
		Student student = new Student();
		student.setNo(rs.getInt("student_no"));
		student.setStudentName(rs.getString("student_name"));
		student.setGrade(rs.getInt("grade"));
		
		Department department = new Department();
		department.setNo(rs.getInt("department_no"));
		student.setDepartment(department);
		student.setStudentRegistrationDate(rs.getDate("registration_date"));
		
		return student;
	}
	
}
