package org.jsp.MTMUni;

import java.util.Arrays;
import java.util.List;
import javax.persistence.*;

public class Test {


public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("M17");
    EntityManager em = emf.createEntityManager();
    EntityTransaction t = em.getTransaction();

    t.begin();

    Batch b1 = new Batch();
    b1.setTrainer("Mayank");
    b1.setSubject("JDBC");
    b1.setBatch_code("M17");

    Batch b2 = new Batch();
    b2.setTrainer("Manoj");
    b2.setSubject("SQL");
    b2.setBatch_code("M18");

    Students s1 = new Students();
    s1.setMarks(91);
    s1.setName("Ania");
    s1.setPhone(9700200200L);

    Students s2 = new Students();
    s2.setMarks(97);
    s2.setName("Anush");
    s2.setPhone(97000200L);

    Students s3 = new Students();
    s3.setMarks(90);
    s3.setName("Aditya");
    s3.setPhone(900200L);

    Students s4 = new Students();
    s4.setMarks(80);
    s4.setName("Adityan");
    s4.setPhone(908899898L);

    Students s5 = new Students();
    s5.setMarks(60);
    s5.setName("Deeraj");
    s5.setPhone(9002008989L);

    List<Students> list1 = Arrays.asList(s1, s2, s3, s4, s5);
    List<Students> list2 = Arrays.asList(s4, s5);

    b1.setStuds(list2);
    b2.setStuds(list1);

    List<Batch> blist = Arrays.asList(b1, b2);

    for (Batch b : blist) {
        em.persist(b);
    }

    t.commit();

    Batch batch1 = em.find(Batch.class, b1.getId());

    Query q1 = em.createQuery("select b from Batch b where b.subject = ?1");
    q1.setParameter(1, "JDBC");
    List<Batch> batch2 = q1.getResultList();

    Query q2 = em.createQuery("select b from Batch b where b.Batch_code = ?1");
    q2.setParameter(1, "M17");
    Batch batch3 = (Batch) q2.getSingleResult();

    Query q3 = em.createQuery("select b from Batch b where b.trainer = ?1");
    q3.setParameter(1, "Mayank");
    List<Batch> batch4 = q3.getResultList();

    // 5. Find Student by id
    Students student1 = em.find(Students.class, s1.getId());

    Query q4 = em.createQuery("select s from Students s where s.name = ?1");
    q4.setParameter(1, "Deeraj");
    List<Students> student2 = q4.getResultList();

    Query q5 = em.createQuery("select s from Students s where s.marks >= ?1");
    q5.setParameter(1, 60.0);
    List<Students> student3 = q5.getResultList();

    Query q6 = em.createQuery("select s from Students s where s.marks between ?1 and ?2");
    q6.setParameter(1, 60.0);
    q6.setParameter(2, 90.0);
    List<Students> student4 = q6.getResultList();

    Query q7 = em.createQuery("select s from Batch b join b.studs s where b.id = ?1");
    q7.setParameter(1, b1.getId());
    List<Students> student5 = q7.getResultList();

    Query q8 = em.createQuery("select s from Batch b join b.studs s where b.Batch_code = ?1");
    q8.setParameter(1, "M18");
    List<Students> student6 = q8.getResultList();
    System.out.println(batch1);
    System.out.println(batch2);
    System.out.println(batch3);
    System.out.println(batch4);
    System.out.println(student1);
    System.out.println(student2);
    System.out.println(student3);
    System.out.println(student4);
    System.out.println(student5);
    System.out.println(student6);
    em.close();
    emf.close();
}


}
