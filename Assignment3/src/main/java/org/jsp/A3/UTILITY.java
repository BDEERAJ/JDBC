package org.jsp.A3;

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

    public static QuestionData findQuestionDataById(int id) {
        return em.find(QuestionData.class, id);
    }

    public static List<QuestionData> findQuestionDataByQuestionedBy(String questionedBy) {
        Query q = em.createQuery("select q from QuestionData q where q.questionedBy = ?1");
        q.setParameter(1, questionedBy);
        return q.getResultList();
    }

    public static List<QuestionData> findQuestionDataByQuestion(String question) {
        Query q = em.createQuery("select q from QuestionData q where q.question = ?1");
        q.setParameter(1, question);
        return q.getResultList();
    }

    public static QuestionData findQuestionDataByAnswerDataId(int id) {
        Query q = em.createQuery("select a.questionData from AnswerData a where a.id = ?1");
        q.setParameter(1, id);
        return (QuestionData) q.getSingleResult();
    }

    public static AnswerData findAnswerDataById(int id) {
        return em.find(AnswerData.class, id);
    }

    public static List<AnswerData> findAnswerDataByAnswer(String answer) {
        Query q = em.createQuery("select a from AnswerData a where a.answer = ?1");
        q.setParameter(1, answer);
        return q.getResultList();
    }

    public static List<AnswerData> findAnswerDataByQuestionDataId(int id) {
        Query q = em.createQuery("select a from AnswerData a where a.questionData.id = ?1");
        q.setParameter(1, id);
        return q.getResultList();
    }

    public static List<AnswerData> findAnswerDataByQuestion(String question) {
        Query q = em.createQuery("select a from AnswerData a where a.questionData.question = ?1");
        q.setParameter(1, question);
        return q.getResultList();
    }

    public static List<AnswerData> findAnswerDataByQuestionedBy(String questionedBy) {
        Query q = em.createQuery("select a from AnswerData a where a.questionData.questionedBy = ?1");
        q.setParameter(1, questionedBy);
        return q.getResultList();
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