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
import com.sample.school.vo.Subject;

public class CourseDAO {

	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void addNewCourse(Course course) throws Exception {
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("course.addNewCourse"));
		pstmt.setString(1, course.getCourseName());
		pstmt.setInt(2, course.getDepartment().getNo());
		pstmt.setInt(3, course.getSubject().getNo());
		pstmt.setInt(4, course.getProfessor().getNo());
		pstmt.executeQuery();
		
		pstmt.close();
		connection.close();
		
	}
	public Course getCourseByCourseNo(int courseNo) throws Exception {
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("course.getCourseByCourseNo"));
		pstmt.setInt(1, courseNo);
		rs = pstmt.executeQuery();
		
		Course course = null;
		if(rs.next()) {
			course = resultSetToCourse(rs);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return course;
	}
	
	public List<Course> getAllCourseByCourseName(String courseName) throws Exception {
		List<Course> courses = new ArrayList<Course>();
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("course.getAllCourseByCourseName"));
		pstmt.setString(1, courseName);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Course course = resultSetToCourse(rs);
			courses.add(course);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return courses;
	}
	
	public void updateCourseByCourseNo(Course course) throws Exception{
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("course.updateCourseByCourseNo"));
		pstmt.setString(1, course.getCourseName());
		pstmt.setInt(2, course.getDepartment().getNo());
		pstmt.setInt(3, course.getSubject().getNo());
		pstmt.setInt(4, course.getProfessor().getNo());
		pstmt.setInt(5, course.getNumberOfPeople());
		pstmt.setString(6, course.getIsFullOfCourse().toUpperCase());
		pstmt.setInt(7, course.getNo());
		pstmt.executeQuery();
		
		pstmt.close();
		connection.close();
	}
	
	private Course resultSetToCourse(ResultSet rs) throws Exception{
		
		Course course = new Course();
		course.setNo(rs.getInt("course_no"));
		course.setCourseName(rs.getString("course_name"));
		
		Department department = new Department();
		department.setNo(rs.getInt("department_no"));
		department.setDepartmentName(rs.getString("department_name"));
		course.setDepartment(department);
		
		Subject subject = new Subject();
		subject.setNo(rs.getInt("subject_no"));
		subject.setSubjectName(rs.getString("subject_name"));
		course.setSubject(subject);
		
		Professor professor = new Professor();
		professor.setNo(rs.getInt("professor_no"));
		professor.setProfessorName(rs.getString("professor_name"));
		course.setProfessor(professor);
		
		course.setNumberOfPeople(rs.getInt("numberofpeople"));
		course.setIsFullOfCourse(rs.getString("isfullofCourse"));
		course.setCourseRegistrationDate(rs.getDate("registration_date"));
		
		return course;
	}
	
	
}
