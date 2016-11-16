package inov.fpf.model.vo;

import java.util.Date;

public class Empgrade {
private int empid; 
public int getEmpid() {
	return empid;
}

public void setEmpid(int empid) {
	this.empid = empid;
}
private String empname;
private String department;
private String assessname;
private int workquality;
private int worknowledge;
private int workeffciency;
private int attitude;
private int learning;
private int planning;
private int responsibility;
private int communication;
private int cooperation;
private int empsum;
private Date scoretime;

public Empgrade(int empid,String empname, String department,
		String assessname, int workquality, int worknowledge,
		int workeffciency, int attitude, int learning, int planning,
		int responsibility, int communication, int cooperation, int empsum) {
	super();
	this.empid=empid;
	this.empname = empname;
	this.department = department;
	this.assessname = assessname;
	this.workquality = workquality;
	this.worknowledge = worknowledge;
	this.workeffciency = workeffciency;
	this.attitude = attitude;
	this.learning = learning;
	this.planning = planning;
	this.responsibility = responsibility;
	this.communication = communication;
	this.cooperation = cooperation;
	this.empsum = empsum;

}

public Empgrade() {
	super();
}

public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getAssessname() {
	return assessname;
}
public void setAssessname(String assessname) {
	this.assessname = assessname;
}
public int getWorkquality() {
	return workquality;
}
public void setWorkquality(int workquality) {
	this.workquality = workquality;
}
public int getWorknowledge() {
	return worknowledge;
}
public void setWorknowledge(int worknowledge) {
	this.worknowledge = worknowledge;
}
public int getWorkeffciency() {
	return workeffciency;
}
public void setWorkeffciency(int workeffciency) {
	this.workeffciency = workeffciency;
}
public int getAttitude() {
	return attitude;
}
public void setAttitude(int attitude) {
	this.attitude = attitude;
}
public int getLearning() {
	return learning;
}
public void setLearning(int learning) {
	this.learning = learning;
}
public int getPlanning() {
	return planning;
}
public void setPlanning(int planning) {
	this.planning = planning;
}
public int getResponsibility() {
	return responsibility;
}
public void setResponsibility(int responsibility) {
	this.responsibility = responsibility;
}
public int getCommunication() {
	return communication;
}
public void setCommunication(int communication) {
	this.communication = communication;
}
public int getCooperation() {
	return cooperation;
}
public void setCooperation(int cooperation) {
	this.cooperation = cooperation;
}
public int getEmpsum() {
	return empsum;
}
public void setEmpsum(int empsum) {
	this.empsum = empsum;
}
public Date getScoretime() {
	return scoretime;
}
public void setScoretime(Date scoretime) {
	this.scoretime = scoretime;
}
}
