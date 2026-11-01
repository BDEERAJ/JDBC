package org.jsp.A2;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private long phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pan_card_id")
    private PanCard pancard;

    public Person() {
    }

    public Person(String name, long phone, PanCard pancard) {
        this.name = name;
        this.phone = phone;
        this.pancard = pancard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public PanCard getPancard() {
        return pancard;
    }

    public void setPancard(PanCard pancard) {
        this.pancard = pancard;
    }
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", phone=" + phone + ", pancard=" + pancard + "]";
    }
}