package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MakeConnection {
	private static MakeConnection mc;
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://엔드포인트주소:3306/mydb";
	private final String USER = "DB아이디";
	private final String PASSWORD = "DB패스워드";
	Connection conn = null;

	private MakeConnection() {
	}
	
	public static MakeConnection getInstance() {
		if(mc == null)
			mc = new MakeConnection();
		return mc;
	}
	
	public Connection getConnection() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
			
		}
		return conn;
	}
}
