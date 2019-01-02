package com.itc.bo;

public class StudentBO {
private int sno;
private String sname;
private String mailId;
private String marks1,marks2,marks3;

public StudentBO() {
}
public StudentBO(int sno, String sname, String mailId, String marks1, String marks2, String marks3) {
	this.sno = sno;
	this.sname = sname;
	this.mailId = mailId;
	this.marks1 = marks1;
	this.marks2 = marks2;
	this.marks3 = marks3;
}
public int getSno() {
	return sno;
}
public String getSname() {
	return sname;
}
public String getMailId() {
	return mailId;
}
public String getMarks1() {
	return marks1;
}
public String getMarks2() {
	return marks2;
}
public String getMarks3() {
	return marks3;
}
public void setSno(int sno) {
	this.sno = sno;
}
public void setSname(String sname) {
	this.sname = sname;
}
public void setMailId(String mailId) {
	this.mailId = mailId;
}
public void setMarks1(String marks1) {
	this.marks1 = marks1;
}
public void setMarks2(String marks2) {
	this.marks2 = marks2;
}
public void setMarks3(String marks3) {
	this.marks3 = marks3;
}
@Override
public String toString() {
	return "StudentBO [sno=" + sno + ", sname=" + sname + ", mailId=" + mailId + ", marks1=" + marks1 + ", marks2="
			+ marks2 + ", marks3=" + marks3 + "]";
}

}
