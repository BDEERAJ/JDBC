package org.jsp.A_1;

import java.util.List;
import java.util.Scanner;

public class FindEmployeeByOtherDetails {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Find Employee By Name");
        System.out.println("2. Find Employee By Designation");
        System.out.println("3. Find Employee By Salary");
        System.out.println("4. Find Employees By Salary Range");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        List<Employee> employeeList = null;
        while(choice!=-1){
        switch (choice) {

            case 1:
                System.out.print("Enter employee name: ");
                String name = scanner.next();
                employeeList = EmployeeUtility.findByName(name);
                break;

            case 2:
                System.out.print("Enter designation: ");
                String designation = scanner.next();
                employeeList = EmployeeUtility.findByDesignation(designation);
                break;

            case 3:
                System.out.print("Enter salary: ");
                double salary = scanner.nextDouble();
                employeeList = EmployeeUtility.findBySalary(salary);
                break;

            case 4:
                System.out.print("Enter minimum salary: ");
                double minimumSalary = scanner.nextDouble();

                System.out.print("Enter maximum salary: ");
                double maximumSalary = scanner.nextDouble();

                employeeList = EmployeeUtility.findBetweenSalary(
                        minimumSalary, maximumSalary);
                break;

            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        if (employeeList.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employeeList) {
                System.out.println("\n----- EMPLOYEE DETAILS -----");
                System.out.println("ID          : " + employee.getId());
                System.out.println("Name        : " + employee.getName());
                System.out.println("Phone       : " + employee.getPhone());
                System.out.println("Email       : " + employee.getEmail());
                System.out.println("Designation : " + employee.getDesignation());
                System.out.println("Salary      : " + employee.getSalary());
            }
        }
        System.out.println("1. Find Employee By Name");
        System.out.println("2. Find Employee By Designation");
        System.out.println("3. Find Employee By Salary");
        System.out.println("4. Find Employees By Salary Range");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        }
        scanner.close();
    }
}
