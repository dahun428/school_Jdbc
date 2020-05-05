package com.sample.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sample.school.util.ConnectionUtil;
import com.sample.school.util.QueryUtil;
import com.sample.school.vo.Course;
import com.sample.school.vo.Department;
import com.sample.school.vo.Professor;
import com.sample.school.vo.RegistrationOfCourse;
import com.sample.school.vo.Student;

public class RegistrationOfCourseDAO {

	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	
	public void addNewRegistrationOfCourse(RegistrationOfCourse registrationOfCourse) throws Exception {
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("registrationOfCourse.addNewRegistrationOfCourse"));
		pstmt.setInt(1, registrationOfCourse.getCourse().getNo());
		pstmt.setInt(2, registrationOfCourse.getStudent().getNo());
		pstmt.executeQuery();
		
		pstmt.close();
		connection.close();
		
	}
	public RegistrationOfCourse getStudentByCourseNo(int courseNo, int studentNo) throws Exception {
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("registrationOfCourse.getStudentByCourseNo"));
		pstmt.setInt(1, courseNo);
		pstmt.setInt(2, studentNo);
		rs = pstmt.executeQuery();
		
		RegistrationOfCourse regi = null;
		
		if(rs.next()) {
			regi = new RegistrationOfCourse();
			regi.setNo(rs.getInt("registration_no"));
			
			Course course = new Course();
			course.setNo(rs.getInt("course_no"));
			regi.setCourse(course);
			
			Student student = new Student();
			student.setNo(rs.getInt("student_no"));
			regi.setStudent(student);
			
			regi.setIsCancled(rs.getString("isCancled"));
			regi.setIsCompletion(rs.getString("isCompleted"));
			regi.setScore(rs.getInt("score"));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return regi;
	}
	public List<RegistrationOfCourse> getAllRegistrationOfCourseByStudentNo(int studentNo) throws Exception {
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("registrationOfCourse.getAllRegistrationOfCourseByStudentNo"));
		pstmt.setInt(1, studentNo);
		rs = pstmt.executeQuery();
		
		List<RegistrationOfCourse> registrations = new ArrayList<RegistrationOfCourse>();
		
		while(rs.next()) {
			RegistrationOfCourse regi = resultSetToRegistration(rs);
			
			registrations.add(regi);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return registrations;
	}
	
	public List<RegistrationOfCourse> getAllRegistrationOfCourseByCourseNo(int courseNo) throws Exception {
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("registrationOfCourse.getAllRegistrationOfCourseByCourseNo"));
		pstmt.setInt(1, courseNo);
		rs = pstmt.executeQuery();
		
		List<RegistrationOfCourse> registrations = new ArrayList<RegistrationOfCourse>();
		
		while(rs.next()) {
			RegistrationOfCourse regi = resultSetToRegistration(rs);
			
			registrations.add(regi);
		}
		rs.close();
		pstmt.close();
		connection.close();
		return registrations;
	}
	public List<RegistrationOfCourse> getAllRegistrationOfCourseByCourseName(String courseName) throws Exception{
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("registrationOfCourse.getAllRegistrationOfCourseByCourseName"));
		pstmt.setString(1, courseName);
		rs = pstmt.executeQuery();
		
		List<RegistrationOfCourse> registrations = new ArrayList<RegistrationOfCourse>();
		
		while(rs.next()) {
			RegistrationOfCourse regi = resultSetToRegistration(rs);
			
			registrations.add(regi);
		}
		rs.close();
		pstmt.close();
		connection.close();
		return registrations;
	}
	
	public List<RegistrationOfCourse> getAllRegistrationOfCourseByProfessorNo(int professorNo) throws Exception {
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("registrationOfCourse.getAllRegistrationOfCourseByProfessorNo"));
		pstmt.setInt(1, professorNo);
		rs = pstmt.executeQuery();
		
		List<RegistrationOfCourse> registrations = new ArrayList<RegistrationOfCourse>();
		
		while(rs.next()) {
			RegistrationOfCourse regi = resultSetToRegistration(rs);
			
			registrations.add(regi);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return registrations;
	}
	
	public void updateRegistrationOfCourse(RegistrationOfCourse registrationOfCourse) throws Exception {
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("registrationOfCourse.updateRegistrationOfCourseByNo"));
		pstmt.setInt(1, registrationOfCourse.getCourse().getNo());
		pstmt.setInt(2, registrationOfCourse.getStudent().getNo());
		pstmt.setString(3, registrationOfCourse.getIsCancled().toLowerCase());
		pstmt.setString(4, registrationOfCourse.getIsCompletion().toLowerCase());
		pstmt.setInt(5, registrationOfCourse.getScore());
		pstmt.setInt(6, registrationOfCourse.getNo());
		pstmt.executeQuery();
		
		pstmt.close();
		connection.close();
		
	}
	private RegistrationOfCourse resultSetToRegistration(ResultSet rs) throws Exception {
		RegistrationOfCourse registration = new RegistrationOfCourse();
		registration.setNo(rs.getInt("registration_no"));
		Course course = new Course();
		course.setNo(rs.getInt("course_no"));
		course.setCourseName(rs.getString("course_name"));
		Professor professor = new Professor();
		professor.setNo(rs.getInt("professor_no"));
		professor.setProfessorName(rs.getString("professor_name"));
		course.setProfessor(professor);
		Department department = new Department();
		department.setNo(rs.getInt("department_no"));
		department.setDepartmentName(rs.getString("department_name"));
		course.setDepartment(department);

		registration.setCourse(course);

		Student student = new Student();
		student.setNo(rs.getInt("student_no"));
		student.setStudentName(rs.getString("student_name"));
		
		registration.setStudent(student);
		registration.setIsCancled(rs.getString("isCancled"));
		registration.setIsCompletion(rs.getString("isCompleted"));
		registration.setScore(rs.getInt("score"));
		registration.setRegistrationOfCourseRegistrationDate(rs.getDate("registrationDate"));
		
		return registration;
	}
}
