package com.StudentInfo;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private List<Student> students;

    public StudentDAO() {
        students = new ArrayList<>();
    }

    public void addStudent(String studentID, String firstName, String lastName, int age, String gender,
                           String department, String email, String phoneNumber, String address, double gpa) {
        students.add(new Student(studentID, firstName, lastName, age, gender, department, email, phoneNumber, address, gpa));
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
