package org.jsp.A3;

import javax.persistence.*;

@Entity
public class AnswerData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionData questionData;

    public AnswerData() {

    }

    public AnswerData(String answer, QuestionData questionData) {
        this.answer = answer;
        this.questionData = questionData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionData getQuestionData() {
        return questionData;
    }

    public void setQuestionData(QuestionData questionData) {
        this.questionData = questionData;
    }

    @Override
    public String toString() {
        return "AnswerData [id=" + id + ", answer=" + answer + ", questionData=" + questionData + "]";
    }
}