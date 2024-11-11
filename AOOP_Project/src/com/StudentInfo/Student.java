package com.StudentInfo;

public class Student {
    private String studentID;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String department;
    private String email;
    private String phoneNumber;
    private String address;
    private double gpa;

    public Student(String studentID, String firstName, String lastName, int age, String gender, String department,
                   String email, String phoneNumber, String address, double gpa) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gpa = gpa;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "StudentID: " + studentID + ", Name: " + firstName + " " + lastName + ", Age: " + age +
               ", Gender: " + gender + ", Department: " + department + ", Email: " + email +
               ", Phone: " + phoneNumber + ", Address: " + address + ", GPA: " + gpa;
    }
}
