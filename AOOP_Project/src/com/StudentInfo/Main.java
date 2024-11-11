package com.StudentInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField studentIDField, firstNameField, lastNameField, ageField, genderField,
                       departmentField, emailField, phoneNumberField, addressField, gpaField;
    private JTextArea displayArea;
    private StudentDAO studentDAO;

    public Main() {
        studentDAO = new StudentDAO(); // Initialize the DAO

        // Set up the JFrame
        setTitle("Student Information Management System");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the form panel
        JPanel formPanel = new JPanel(new GridLayout(11, 2, 10, 10));

        // Create form fields
        formPanel.add(new JLabel("Student ID:"));
        studentIDField = new JTextField();
        formPanel.add(studentIDField);

        formPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        formPanel.add(firstNameField);

        formPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        formPanel.add(lastNameField);

        formPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        formPanel.add(ageField);

        formPanel.add(new JLabel("Gender:"));
        genderField = new JTextField();
        formPanel.add(genderField);

        formPanel.add(new JLabel("Department:"));
        departmentField = new JTextField();
        formPanel.add(departmentField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        formPanel.add(phoneNumberField);

        formPanel.add(new JLabel("Address:"));
        addressField = new JTextField();
        formPanel.add(addressField);

        formPanel.add(new JLabel("GPA:"));
        gpaField = new JTextField();
        formPanel.add(gpaField);

        // Add buttons
        JButton addButton = new JButton("Add Student");
        formPanel.add(addButton);

        JButton viewButton = new JButton("View All Students");
        formPanel.add(viewButton);

        // Add the form panel to the top of the frame
        add(formPanel, BorderLayout.NORTH);

        // Create display area to show student information
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Add student action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        // View all students action
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStudents();
            }
        });
    }

    // Method to add a student
    private void addStudent() {
        String studentID = studentIDField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        int age;
        try {
            age = Integer.parseInt(ageField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid age.");
            return;
        }
        String gender = genderField.getText();
        String department = departmentField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        String address = addressField.getText();
        double gpa;
        try {
            gpa = Double.parseDouble(gpaField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid GPA.");
            return;
        }

        // Add student to the DAO
        studentDAO.addStudent(studentID, firstName, lastName, age, gender, department, email, phoneNumber, address, gpa);
        JOptionPane.showMessageDialog(this, "Student added successfully!");

        // Clear input fields
        studentIDField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        ageField.setText("");
        genderField.setText("");
        departmentField.setText("");
        emailField.setText("");
        phoneNumberField.setText("");
        addressField.setText("");
        gpaField.setText("");
    }

    // Method to display all students
    private void displayStudents() {
        List<Student> students = studentDAO.getAllStudents(); // Fetch from DAO
        displayArea.setText(""); // Clear previous content
        if (students.isEmpty()) {
            displayArea.setText("No students available.");
        } else {
            for (Student student : students) {
                displayArea.append(student.toString() + "\n");
            }
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main frame = new Main();
            frame.setVisible(true);
        });
    }
}
