package org.jsp.A2;

import javax.persistence.*;
import java.util.List;

public class UTILITY {

    static EntityManagerFactory emf;
    static EntityManager em;
    static EntityTransaction et;

    public UTILITY() {
        emf = Persistence.createEntityManagerFactory("M17");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    public static Person findPersonById(int id) {
        return em.find(Person.class, id);
    }

    public static List<Person> findPersonByName(String name) {
        Query q = em.createQuery("select p from Person p where p.name = ?1");
        q.setParameter(1, name);
        return q.getResultList();
    }

    public static Person findPersonByPhone(long phone) {
        Query q = em.createQuery("select p from Person p where p.phone = ?1");
        q.setParameter(1, phone);
        return (Person) q.getSingleResult();
    }

    public static PanCard findPanCardById(int id) {
        return em.find(PanCard.class, id);
    }

    public static PanCard findPanCardByNumber(String panNumber) {
        Query q = em.createQuery("select p from PanCard p where p.panNumber = ?1");
        q.setParameter(1, panNumber);
        return (PanCard) q.getSingleResult();
    }

    public static PanCard findPanCardByNumberAndDOB(String panNumber, String dob) {
        Query q = em.createQuery("select p from PanCard p where p.panNumber = ?1 and p.dob = ?2");
        q.setParameter(1, panNumber);
        q.setParameter(2, dob);
        return (PanCard) q.getSingleResult();
    }

    public static PanCard findPanCardByPersonId(int id) {
        Query q = em.createQuery("select p.pancard from Person p where p.id = ?1");
        q.setParameter(1, id);
        return (PanCard) q.getSingleResult();
    }

    public static PanCard findPanCardByPersonPhone(long phone) {
        Query q = em.createQuery("select p.pancard from Person p where p.phone = ?1");
        q.setParameter(1, phone);
        return (PanCard) q.getSingleResult();
    }

    public static Person findPersonByPanCardId(int id) {
        Query q = em.createQuery("select p from Person p where p.pancard.id = ?1");
        q.setParameter(1, id);
        return (Person) q.getSingleResult();
    }

    public static Person findPersonByPanCardNumber(String panNumber) {
        Query q = em.createQuery("select p from Person p where p.pancard.panNumber = ?1");
        q.setParameter(1, panNumber);
        return (Person) q.getSingleResult();
    }

    public static Person findPersonByPanCardNumberAndDOB(String panNumber, String dob) {
        Query q = em.createQuery("select p from Person p where p.pancard.panNumber = ?1 and p.pancard.dob = ?2");
        q.setParameter(1, panNumber);
        q.setParameter(2, dob);
        return (Person) q.getSingleResult();
    }

    public static void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }

        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}