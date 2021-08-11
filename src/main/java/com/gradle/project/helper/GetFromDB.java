package com.gradle.project.helper;




import com.gradle.project.dbconnection.DBConnection;
import com.gradle.project.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetFromDB {

	DBConnection conn;
	ResultSet rSet;
	List<Student> students;

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub

		String sql = "select * from public.student_name";
		conn = new DBConnection();
		conn.createConnection();

		students = new ArrayList<Student>();
		rSet = conn.getAllStudents(sql);

		try {
			while (rSet.next()) {
				students.add(new Student(rSet.getInt(1), rSet.getString(2), rSet.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return students;

	}

	public void getStudentResult(int student_id) {

		//String sql = "select exam_results.sub_code, exam_results.marks  from student_name join public.exam_results on student_name.student_id = exam_results.stu_id where student_name.student_id= "
		//		+ student_id + ";";
		
		String sql="select *  from student_name join public.exam_results on student_name.student_id = exam_results.stu_id where student_name.student_id= "+student_id+";";
		
	
		conn = new DBConnection();
		conn.createConnection();
		rSet = conn.getAllStudents(sql);

		try {
			
		/*	if(rSet.next()==false) {
				System.out.println("----- Result not found -----");
			}
		*/	
			while (rSet.next()) {
				//System.out.println(rSet.getInt(1) + "|" + rSet.getInt(2));
				System.out.println(rSet.getInt(1)+"|"+rSet.getString(2)+"|"+rSet.getString(3)+"|"+rSet.getInt(4)+"|"+rSet.getInt(5)+"|"+rSet.getInt(6)+"|"+rSet.getInt(7)+"|"+rSet.getInt(8)+"|"+rSet.getInt(9)+"\n");
			}
			
		} catch (Exception e) {
			System.out.println("ERROR..");
		}

		conn.closeConnection();

	}
}
