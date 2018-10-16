package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {

	private String studentID;
	private String first;     // first name
	private String last;      // last name
	private String email;     // email address
	
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String string) {
		this.studentID = string;
	}
	
}
