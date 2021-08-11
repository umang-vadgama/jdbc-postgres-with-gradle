package com.gradle.project.dbconnection;

import java.sql.*;

public class DBConnection {

	
	private Connection connection;
	PreparedStatement ps;
	
	public void createConnection() {
		
		String  host = "jdbc:postgresql://localhost:5432/student";
	
		String uName = "postgres";
		String passcode= "123";
		
		try {
			connection = DriverManager.getConnection(host, uName, passcode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public int studentNameToDB(String sql,String first_name,String last_name) {
		
		
		try {
			ps= connection.prepareStatement(sql);
			ps.setString(1,first_name );
			ps.setString(2, last_name);
			
			System.out.println(sql);
			int status = ps.executeUpdate();
			
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
			
			return -1;
		}
	}
	
	public ResultSet getAllStudents(String sql) {
		try {
			ps=connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	public int updateStudentToDB(String sql,String new_fname,String new_lname,int id) {
		
		try {
			ps=connection.prepareStatement(sql);
			ps.setString(1, new_fname);
			ps.setString(2,new_lname);
			ps.setInt(3, id);
			
			int s_id = ps.executeUpdate();
			
			return s_id;
			
		}catch(Exception e) {
			System.out.println("ERROR\n"+e.getMessage());
			
			return -1;
		}
	}
	
	public int deletingStudent(String sql,int id) {
		int status=-1;
		
		try {
			ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			
			
			return status;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return status;
		}
		
		
		
	}
	
	public void closeConnection() {
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
