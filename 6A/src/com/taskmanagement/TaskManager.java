package com.taskmanagement;
	import java.util.ArrayList;
	import java.util.Scanner;

	public class TaskManager {
	    private ArrayList<Task> tasks = new ArrayList<>();
	    private Scanner scanner = new Scanner(System.in);

	    // Add a task
	    public void addTask() {
	        System.out.print("Enter task description: ");
	        String description = scanner.nextLine();
	        tasks.add(new Task(description));
	        System.out.println("Task added successfully.");
	    }

	    // Update a task's description
	    public void updateTask() {
	        displayTasks();
	        System.out.print("Enter the task number to update: ");
	        int index = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        if (index >= 0 && index < tasks.size()) {
	            System.out.print("Enter the new task description: ");
	            String description = scanner.nextLine();
	            tasks.get(index).setDescription(description);
	            System.out.println("Task updated successfully.");
	        } else {
	            System.out.println("Invalid task number.");
	        }
	    }

	    // Remove a task by its position
	    public void removeTask() {
	        displayTasks();
	        System.out.print("Enter the task number to remove: ");
	        int index = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        if (index >= 0 && index < tasks.size()) {
	            tasks.remove(index);
	            System.out.println("Task removed successfully.");
	        } else {
	            System.out.println("Invalid task number.");
	        }
	    }

	    // Display all tasks in the list
	    public void displayTasks() {
	        if (tasks.isEmpty()) {
	            System.out.println("No tasks available.");
	        } else {
	            System.out.println("Task List:");
	            for (int i = 0; i < tasks.size(); i++) {
	                System.out.println((i) + ". " + tasks.get(i));
	            }
	        }
	    }

	    // Menu to manage tasks
	    public void showMenu() {
	        while (true) {
	            System.out.println("\nTask Management Menu:");
	            System.out.println("1. Add Task");
	            System.out.println("2. Update Task");
	            System.out.println("3. Remove Task");
	            System.out.println("4. Display Tasks");
	            System.out.println("5. Exit");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    addTask();
	                    break;
	                case 2:
	                    updateTask();
	                    break;
	                case 3:
	                    removeTask();
	                    break;
	                case 4:
	                    displayTasks();
	                    break;
	                case 5:
	                    System.out.println("Exiting Task Manager. Goodbye!");
	                    return;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	        }
	    }

	    public static void main(String[] args) {
	        TaskManager manager = new TaskManager();
	        manager.showMenu();
	    }
	}



