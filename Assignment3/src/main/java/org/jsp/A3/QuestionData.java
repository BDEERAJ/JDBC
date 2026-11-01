package org.jsp.A3;

import javax.persistence.*;

@Entity
public class QuestionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String questionedBy;
    private String question;

    public QuestionData() {

    }

    public QuestionData(String questionedBy, String question) {
        this.questionedBy = questionedBy;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionedBy() {
        return questionedBy;
    }

    public void setQuestionedBy(String questionedBy) {
        this.questionedBy = questionedBy;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "QuestionData [id=" + id + ", questionedBy=" + questionedBy + ", question=" + question + "]";
    }
}