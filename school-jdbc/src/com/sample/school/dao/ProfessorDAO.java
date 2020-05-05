package com.sample.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sample.school.util.ConnectionUtil;
import com.sample.school.util.QueryUtil;
import com.sample.school.vo.Department;
import com.sample.school.vo.Professor;

public class ProfessorDAO {

	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Professor getProfessorByProfessorNo(int professorNo) throws Exception{
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("professor.getProfessorByProfessorNo"));
		pstmt.setInt(1, professorNo);
		rs = pstmt.executeQuery();
		
		Professor professor = null;
		
		if(rs.next()) {
			professor = resultSetToProfessor(rs);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return professor;
	}
	public Professor getProfessorByProfessorName(String ProfessorName) throws Exception{
		Professor professor = null;
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("professor.getProfessorByProfessorName"));
		rs = pstmt.executeQuery();
		if(rs.next()) {
			professor = resultSetToProfessor(rs);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return professor;
	}
	private Professor resultSetToProfessor(ResultSet rs) throws Exception{
		Professor professor = new Professor();
		professor.setNo(rs.getInt("professor_no"));
		professor.setProfessorName(rs.getString("professor_name"));
		
		Department department = new Department();
		department.setNo(rs.getInt("department_no"));
		
		professor.setDepartment(department);
		professor.setPosition(rs.getString("professor_position"));
		professor.setProfessorRegistrationDate(rs.getDate("registration_date"));

		return professor;
	}
	
}
