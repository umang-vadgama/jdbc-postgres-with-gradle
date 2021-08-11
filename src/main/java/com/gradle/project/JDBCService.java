package com.gradle.project;



import com.gradle.project.helper.GetFromDB;
import com.gradle.project.model.Student;

import java.util.List;

public class JDBCService {

    public static void main(String[] args) {
        GetFromDB db = new GetFromDB();

        List<Student> students = db.getAllStudents();



        for (Student student : students) {

            System.out.printf("\n%3d | %-10s | %-10s", student.getStudet_id(), student.getFirstName(),
                    student.getLastName());
        }
    }
}
