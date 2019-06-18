package org.zerock.service;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DBTests {
	
	@Test
	public void testConnection() throws Exception{
		String driver = "com.mysql.cj.jdbc.Driver";  
		String url = "jdbc:mysql://192.168.41.10:3306/book_ex?useSSL=false&serverTimezone=Asia/Seoul";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url,"zerock","zerock");
		
		System.out.println(con);
		
		con.close();
		
		

		
	}
	
	

}
