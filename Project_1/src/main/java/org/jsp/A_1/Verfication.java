package org.jsp.A_1;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Verfication {

public static Employee verifyByEmailAndPassword(String email, String password) {
    Session s = SF_Helper.getSession();
    try {
        Query<Employee> q = s.createQuery("select e FROM Employee e  WHERE email = ?1 AND password = ?2", Employee.class);
        q.setParameter(1, email);
        q.setParameter(2, password);
        return q.getSingleResult();
    } catch (Exception e) {
        return null;
    } finally {
        s.close();
    }
}

public static Employee verifyByPhoneAndPassword(String phone, String password) {
    Session s = SF_Helper.getSession();
    try {
        Query<Employee> q = s.createQuery("select e FROM Employee e  WHERE phone = ?1 AND password = ?2", Employee.class);
        q.setParameter(1, phone);
        q.setParameter(2, password);
        return q.getSingleResult();
    } catch (Exception e) {
        return null;
    } finally {
        s.close();
    }
}

public static Employee verifyByIdAndPassword(int id, String password) {
    Session s = SF_Helper.getSession();
    try {
        Query<Employee> q = s.createQuery("select e FROM Employee e  WHERE id = ?1 AND password = ?2", Employee.class);
        q.setParameter(1, id);
        q.setParameter(2, password);
        return q.getSingleResult();
    } catch (Exception e) {
        return null;
    } finally {
        s.close();
    }
}
}
