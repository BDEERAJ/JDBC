package org.jsp.A_1;

import java.util.Scanner;

public class VerificationTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("1. Verify using Email and Password");
            System.out.println("2. Verify using Phone and Password");
            System.out.println("3. Verify using ID and Password");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            Employee employee = null;

            switch (choice) {

                case 1:
                    System.out.print("Enter email: ");
                    String email = scanner.next();

                    System.out.print("Enter password: ");
                    String emailPassword = scanner.next();

                    employee = Verfication.verifyByEmailAndPassword(
                            email, emailPassword);
                    break;

                case 2:
                    System.out.print("Enter phone: ");
                    String phone = scanner.next();

                    System.out.print("Enter password: ");
                    String phonePassword = scanner.next();

                    employee = Verfication.verifyByPhoneAndPassword(
                            phone, phonePassword);
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();

                    System.out.print("Enter password: ");
                    String idPassword = scanner.next();

                    employee = Verfication.verifyByIdAndPassword(
                            id, idPassword);
                    break;

                case 4:
                    System.out.println("Exiting verification...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            if (employee != null) {
                System.out.println("\nLogin successful!");
                System.out.println("ID: " + employee.getId());
                System.out.println("Name: " + employee.getName());
                System.out.println("Email: " + employee.getEmail());
                System.out.println("Phone: " + employee.getPhone());
                System.out.println("Designation: " + employee.getDesignation());
                System.out.println("Salary: " + employee.getSalary());
            } else {
                System.out.println("\nInvalid credentials!");
            }
        }
    }
}
