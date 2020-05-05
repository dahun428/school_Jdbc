package com.sample.school.util;

import java.io.FileInputStream;
import java.util.Properties;

public class QueryUtil {

	//query.properties�� ���ǵ� ������ key,value�� ������ �����ϴ� ��ü
	private static Properties prop = new Properties();
	static {
		try {
			prop.load(new FileInputStream("src/com/sample/school/dao/query.properties"));
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ������ �̸��� �������� ��ȯ
	 * @param name query.properties�� ���ǵ� sql �̸�
	 * @return sql ����, ��ȿ�� �̸��� �ƴ� ��� null �� ��ȯ��
	 */
	
	public static String getSQL(String name) {
		return prop.getProperty(name);
	}
	
}