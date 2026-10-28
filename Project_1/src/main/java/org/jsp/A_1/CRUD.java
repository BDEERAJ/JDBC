package org.jsp.A_1;

import java.util.Scanner;

public class CRUD {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("1. Add Employee");
            System.out.println("2. Find Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1: {
                    Employee employee = new Employee();


                    System.out.print("Enter name: ");
                    employee.setName(scanner.next());

                    System.out.print("Enter phone: ");
                    employee.setPhone(scanner.next());

                    System.out.print("Enter email: ");
                    employee.setEmail(scanner.next());

                    System.out.print("Enter designation: ");
                    employee.setDesignation(scanner.next());

                    System.out.print("Enter salary: ");
                    employee.setSalary(scanner.nextDouble());

                    System.out.print("Enter password: ");
                    employee.setPassword(scanner.next());

                    EmployeeUtility.save(employee);
                    System.out.println("Employee added successfully.");
                    break;
                }

                case 2: {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();

                    Employee employee = EmployeeUtility.get(id);

                    if (employee != null) {
                        System.out.println("ID: " + employee.getId());
                        System.out.println("Name: " + employee.getName());
                        System.out.println("Phone: " + employee.getPhone());
                        System.out.println("Email: " + employee.getEmail());
                        System.out.println("Designation: " + employee.getDesignation());
                        System.out.println("Salary: " + employee.getSalary());
                    } else {
                        System.err.println("Employee not found");
                    }
                    break;
                }

                case 3: {
                    System.out.print("Enter ID to update: ");
                    int id = scanner.nextInt();

                    Employee employee = EmployeeUtility.get(id);

                    if (employee != null) {
                        System.out.print("Enter new name: ");
                        employee.setName(scanner.next());

                        System.out.print("Enter new phone: ");
                        employee.setPhone(scanner.next());

                        System.out.print("Enter new email: ");
                        employee.setEmail(scanner.next());

                        System.out.print("Enter new designation: ");
                        employee.setDesignation(scanner.next());

                        System.out.print("Enter new salary: ");
                        employee.setSalary(scanner.nextDouble());

                        System.out.print("Enter new password: ");
                        employee.setPassword(scanner.next());

                        EmployeeUtility.update(employee);
                        System.out.println("Employee updated successfully.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Enter ID to delete: ");
                    int id = scanner.nextInt();

                    Employee employee = EmployeeUtility.get(id);

                    if (employee != null) {
                        EmployeeUtility.delete(id);
                        System.out.println("Employee deleted successfully.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                }

                case 5:
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
