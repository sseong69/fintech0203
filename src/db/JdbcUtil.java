package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	
	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			Context intiCtx = new InitialContext();
			Context envCtx = (Context)intiCtx.lookup("java:comp/env");
			//데이터베이스 연결정보
			DataSource ds = (DataSource)envCtx.lookup("jdbc/dogTest");
			
			//Connection Pool(컨넥션 풀)에서 Free한 Connection이 연결된다.
			con = ds.getConnection();
			
			//자동으로 Commit을 안한다는 선언
			con.setAutoCommit(false);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

	
	public static void close(Connection con) {
		try {
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			stmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con) {
		try {
			con.commit();
			System.out.println("Commit Success");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
			System.out.println("RollBack Success");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
