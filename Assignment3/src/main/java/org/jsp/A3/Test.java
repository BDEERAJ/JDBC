package org.jsp.A3;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        UTILITY util = new UTILITY();
        EntityManager em = UTILITY.em;
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            QuestionData q = new QuestionData("Deeraj", "What is Java?");
            em.persist(q);
            AnswerData a1 = new AnswerData("Java is a programming language", q);
            AnswerData a2 = new AnswerData("Java is object-oriented", q);
            em.persist(a1);
            em.persist(a2);
            et.commit();
            QuestionData q1 = UTILITY.findQuestionDataById(q.getId());
            List<QuestionData> q2 = UTILITY.findQuestionDataByQuestionedBy("Deeraj");
            List<QuestionData> q3 = UTILITY.findQuestionDataByQuestion("What is Java?");
            QuestionData q4 = UTILITY.findQuestionDataByAnswerDataId(a1.getId());
            AnswerData a3 = UTILITY.findAnswerDataById(a1.getId());
            List<AnswerData> a4 = UTILITY.findAnswerDataByAnswer("Java is a programming language");
            List<AnswerData> a5 = UTILITY.findAnswerDataByQuestionDataId(q.getId());
            List<AnswerData> a6 = UTILITY.findAnswerDataByQuestion("What is Java?");
            List<AnswerData> a7 = UTILITY.findAnswerDataByQuestionedBy("Deeraj");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UTILITY.close();
        }
    }
}