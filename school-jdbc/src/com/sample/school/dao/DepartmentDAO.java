package com.sample.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sample.school.util.ConnectionUtil;
import com.sample.school.util.QueryUtil;
import com.sample.school.vo.Department;

public class DepartmentDAO {

	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Department getDepartmentByNo(int departmentNo) throws Exception {
		
		connection = ConnectionUtil.getConnection();
		pstmt = connection.prepareStatement(QueryUtil.getSQL("department.getDepartmentByNo"));
		pstmt.setInt(1, departmentNo);
		rs = pstmt.executeQuery();
		
		Department department = null;
		if(rs.next()) {
			department = new Department();
			department.setNo(rs.getInt("department_no"));
			department.setDepartmentName(rs.getString("department_name"));
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return department;
	}
	
	
	
	
	
}
