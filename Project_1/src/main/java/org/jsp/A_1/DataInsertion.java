package org.jsp.A_1;

public class DataInsertion {

public static void main(String[] args) {

    String[] names = {"Deeraj", "Rahul", "Priya", "Kiran", "Sneha", "Arjun", "Divya", "Rohit", "Pooja", "Vijay"};
    String[] phones = {"9876543210", "9876543211", "9876543212", "9876543213", "9876543214", "9876543215", "9876543216", "9876543217", "9876543218", "9876543219"};
    String[] emails = {"deeraj@gmail.com", "rahul@gmail.com", "priya@gmail.com", "kiran@gmail.com", "sneha@gmail.com", "arjun@gmail.com", "divya@gmail.com", "rohit@gmail.com", "pooja@gmail.com", "vijay@gmail.com"};
    String[] designations = {"Developer", "Tester", "Manager", "Developer", "HR", "Analyst", "Designer", "Tester", "Developer", "Manager"};
    double[] salaries = {35000, 28000, 60000, 40000, 30000, 45000, 32000, 29000, 38000, 65000};
    String[] passwords = {"Deeraj@123", "Rahul@123", "Priya@123", "Kiran@123", "Sneha@123", "Arjun@123", "Divya@123", "Rohit@123", "Pooja@123", "Vijay@123"};
    for (int i = 0; i < names.length; i++) {

        Employee employee = new Employee();

        employee.setName(names[i]);
        employee.setPhone(phones[i]);
        employee.setEmail(emails[i]);
        employee.setDesignation(designations[i]);
        employee.setSalary(salaries[i]);
        employee.setPassword(passwords[i]);

        EmployeeUtility.save(employee);

        System.out.println("Employee inserted successfully: " + names[i]);
    }
}

}
