package org.jsp.A_1;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EmployeeUtility {


public static void save(Employee employee) {
    Session session = SF_Helper.getSession();
    Transaction transaction = session.getTransaction();
    transaction.begin();
    session.save(employee);
    transaction.commit();
    session.close();
}

public static Employee get(int id) {
    Session session = SF_Helper.getSession();
    Employee employee = session.get(Employee.class, id);
    session.close();
    return employee;
}

public static void delete(int id) {
    Session session = SF_Helper.getSession();
    Transaction transaction = session.getTransaction();
    transaction.begin();
    Employee employee = session.get(Employee.class, id);
    if (employee != null) {
        session.delete(employee);
    }
    transaction.commit();
    session.close();
}

public static void update(Employee employee) {
    Session session = SF_Helper.getSession();
    Transaction transaction = session.getTransaction();
    transaction.begin();
    session.update(employee);
    transaction.commit();
    session.close();
}

public static List<Employee> getAll() {
    Session session = SF_Helper.getSession();
    Query<Employee> query = session.createQuery("select e FROM Employee e ", Employee.class);
    List<Employee> employeeList = query.getResultList();
    session.close();
    return employeeList;
}

public static List<Employee> findByName(String name) {
    Session session = SF_Helper.getSession();
    Transaction transaction = session.getTransaction();
    transaction.begin();
    Query<Employee> query = session.createQuery(
        "FROM Employee WHERE name = ?1", Employee.class);
    query.setParameter(1, name);
    List<Employee> employeeList = query.getResultList();
    transaction.commit();
    session.close();
    return employeeList;
}

public static List<Employee> findByDesignation(String designation) {
    Session session = SF_Helper.getSession();
    Transaction transaction = session.getTransaction();
    transaction.begin();
    Query<Employee> query = session.createQuery(
        "FROM Employee WHERE designation = ?1", Employee.class);
    query.setParameter(1, designation);
    List<Employee> employeeList = query.getResultList();
    transaction.commit();
    session.close();
    return employeeList;
}

public static List<Employee> findBySalary(double salary) {
    Session session = SF_Helper.getSession();
    Transaction transaction = session.getTransaction();
    transaction.begin();
    Query<Employee> query = session.createQuery(
        "FROM Employee WHERE salary = ?1", Employee.class);
    query.setParameter(1, salary);
    List<Employee> employeeList = query.getResultList();
    transaction.commit();
    session.close();
    return employeeList;
}

public static List<Employee> findBetweenSalary(double minimumSalary, double maximumSalary) {
    Session session = SF_Helper.getSession();
    Transaction transaction = session.getTransaction();
    transaction.begin();
    Query<Employee> query = session.createQuery(
        "FROM Employee WHERE salary BETWEEN ?1 AND ?2", Employee.class);
    query.setParameter(1, minimumSalary);
    query.setParameter(2, maximumSalary);
    List<Employee> employeeList = query.getResultList();
    transaction.commit();
    session.close();
    return employeeList;
}
}
