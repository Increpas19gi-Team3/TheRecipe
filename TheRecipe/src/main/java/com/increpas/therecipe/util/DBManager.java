package com.increpas.therecipe.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	
	/**
	 * DB 연결
	 * @return Connection
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			// jdbc/myoracle
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			// ds
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}


	/**
	 * Select 사용 시, close
	 * @param conn : Connection
	 * @param stmt : Statement
	 * @param rs : ResultSet
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * DML(insert, update, delete) 사용 시, close
	 * @param conn : Connection
	 * @param stmt : Statement
	 */
	public static void close(Connection conn, Statement stmt) {
		try {
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Select 사용 시, close
	 * @param conn : Connection
	 * @param prepStmt : PreparedStatement
	 * @param rs : ResultSet
	 */
	public static void close(Connection conn, PreparedStatement prepStmt, ResultSet rs) {
		try {
			rs.close();
			prepStmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * DML(insert, update, delete) 사용 시, close
	 * @param conn : Connection
	 * @param prepStmt : PreparedStatement
	 */
	public static void close(Connection conn, PreparedStatement prepStmt) {
		try {
			if(prepStmt!=null) prepStmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
