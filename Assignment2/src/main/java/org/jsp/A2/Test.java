package org.jsp.A2;

import javax.persistence.*;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        UTILITY util = new UTILITY();

        EntityManager em = UTILITY.em;
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            PanCard pc = new PanCard("ABCDE1234F", "2004-05-10");
            Person p = new Person("Deeraj", 9876543210L, pc);
            em.persist(p);
            et.commit();
            Person p1 = UTILITY.findPersonById(p.getId());
            List<Person> p2 = UTILITY.findPersonByName("Deeraj");
            Person p3 = UTILITY.findPersonByPhone(9876543210L);
            PanCard pc1 = UTILITY.findPanCardById(pc.getId());
            PanCard pc2 = UTILITY.findPanCardByNumber("ABCDE1234F");
            PanCard pc3 = UTILITY.findPanCardByNumberAndDOB("ABCDE1234F", "2004-05-10");
            PanCard pc4 = UTILITY.findPanCardByPersonId(p.getId());
            PanCard pc5 = UTILITY.findPanCardByPersonPhone(9876543210L);
            Person p4 = UTILITY.findPersonByPanCardId(pc.getId());
            Person p5 = UTILITY.findPersonByPanCardNumber("ABCDE1234F");
            Person p6 = UTILITY.findPersonByPanCardNumberAndDOB("ABCDE1234F", "2004-05-10");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UTILITY.close();
        }
    }
}