package org.jsp.MTMUni;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Batch {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String subject;
private String Batch_code;
private String trainer;
//@JoinTable()//It takes 3 args 1.Name of that 3rd reference table , 2.joincolumns=({@JoinColumn = "this ttable col_name"}) , 3.InverseColumns=({@joinColumn="its name"})
@ManyToMany(cascade = CascadeType.ALL)
private List<Students> studs;
public List<Students> getStuds() {
	return studs;
}
public void setStuds(List<Students> studs) {
	this.studs = studs;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getBatch_code() {
	return Batch_code;
}
public void setBatch_code(String batch_code) {
	Batch_code = batch_code;
}
public String getTrainer() {
	return trainer;
}
public void setTrainer(String trainer) {
	this.trainer = trainer;
}
@Override
public String toString() {
    return "Batch [id=" + id + ", subject=" + subject + ", Batch_code=" + Batch_code + ", trainer=" + trainer + ", studs=" + studs + "]";
}

}
