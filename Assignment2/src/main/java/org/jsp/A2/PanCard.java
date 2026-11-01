package org.jsp.A2;

import javax.persistence.*;

@Entity
public class PanCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String panNumber;
    private String dob;

    public PanCard() {

    }

    public PanCard(String panNumber, String dob) {
        this.panNumber = panNumber;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    @Override
    public String toString() {
        return "PanCard [id=" + id + ", panNumber=" + panNumber + ", dob=" + dob + "]";
    }
}