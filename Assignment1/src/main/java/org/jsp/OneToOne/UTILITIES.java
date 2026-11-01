package org.jsp.OneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UTILITIES {


private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("M17");
private static EntityManager em = emf.createEntityManager();

static User getUserById(int id) {
    return em.find(User.class, id);
}

static User getUserByName(String name) {
    try {
        Query q = em.createQuery("select u from User u where u.name = ?1");
        q.setParameter(1, name);
        return (User) q.getSingleResult();
    } catch (NoResultException e) {
        return null;
    }
}

static User getUserByPhone(long phone) {
    try {
        Query q = em.createQuery("select u from User u where u.phone = ?1");
        q.setParameter(1, phone);
        return (User) q.getSingleResult();
    } catch (NoResultException e) {
        return null;
    }
}

static User getUserByAddharId(int id) {
    try {
        Query q = em.createQuery("select u from User u where u.Addhar_id.id = ?1");
        q.setParameter(1, id);
        return (User) q.getSingleResult();
    } catch (NoResultException e) {
        return null;
    }
}

static User getUserByAddharNumber(long number) {
    try {
        Query q = em.createQuery("select u from User u where u.Addhar_id.AddharNo = ?1");
        q.setParameter(1, number);
        return (User) q.getSingleResult();
    } catch (NoResultException e) {
        return null;
    }
}

static User getUserByAddharNumberAndDOB(long number, String dob) {
    try {
        Query q = em.createQuery("select u from User u where u.Addhar_id.AddharNo = ?1 and u.Addhar_id.DOB = ?2");
        q.setParameter(1, number);
        q.setParameter(2, dob);
        return (User) q.getSingleResult();
    } catch (NoResultException e) {
        return null;
    }
}

static Addhar getAddharById(int id) {
    return em.find(Addhar.class, id);
}

static Addhar getAddharByNumber(long number) {
    try {
        Query q = em.createQuery("select a from Addhar a where a.AddharNo = ?1");
        q.setParameter(1, number);
        return (Addhar) q.getSingleResult();
    } catch (NoResultException e) {
        return null;
    }
}

static Addhar getAddharByNumberAndDOB(long number, String dob) {
    try {
        Query q = em.createQuery("select a from Addhar a where a.AddharNo = ?1 and a.DOB = ?2");
        q.setParameter(1, number);
        q.setParameter(2, dob);
        return (Addhar) q.getSingleResult();
    } catch (NoResultException e) {
        return null;
    }
}

static Addhar getAddharByUserId(int id) {
    try {
        Query q = em.createQuery("select a from Addhar a where a.user.id = ?1");
        q.setParameter(1, id);
        return (Addhar) q.getSingleResult();
    } catch (NoResultException e) {
        return null;
    }
}

static Addhar getAddharByUserPhone(long phone) {
    try {
        Query q = em.createQuery("select a from Addhar a where a.user.phone = ?1");
        q.setParameter(1, phone);
        return (Addhar) q.getSingleResult();
    } catch (NoResultException e) {
        return null;
    }
}

static Addhar getAddharByUserNameAndPhone(String name, long phone) {
    try {
        Query q = em.createQuery("select a from Addhar a where a.user.name = ?1 and a.user.phone = ?2");
        q.setParameter(1, name);
        q.setParameter(2, phone);
        return (Addhar) q.getSingleResult();
    } catch (NoResultException e) {
        return null;
    }
}
}
