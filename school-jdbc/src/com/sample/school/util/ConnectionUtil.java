package com.sample.school.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	/**
	 * Ŭ���� �ε��� JDBC ����̹��� JVM ����̹� ������Ʈ���� ���
	 */
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * �����ͺ��̽��� ����� ���ο� Connection ��ȯ
	 * @return �����ͺ��̽� ����, SQL ���ۿ� �ʿ��� Connection ��ü
	 * @throws SQLException �����ͺ��̽� url, ������������ �ùٸ��� ���� ��� �߻��ȴ�.
	 */
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password ="zxcv1234";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}
	
	
}