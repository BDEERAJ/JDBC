package org.jsp.OneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Addhar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private long AddharNo;
private String DOB;
@OneToOne(mappedBy = "Addhar_id")
private User user;
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAddharNo() {
		return AddharNo;
	}
	public void setAddharNo(long addharNo) {
		AddharNo = addharNo;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
