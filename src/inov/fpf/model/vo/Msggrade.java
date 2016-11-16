package inov.fpf.model.vo;

import java.util.Date;

public class Msggrade {
private int empid;
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
private String empname;
private String msgname;
private String station;
private String jobdescriotion;
private int skills;
private int understanding;
private int communication;
private int initiative;
private int cooperation;
private int creativeness;
private int discipline;
private int empperformance;
private int msum;
private String comments;
private Date gradetime;

public Msggrade() {
	super();
}
public Msggrade(int empid,String empname, String msgname, String station,
		String jobdescriotion, int skills, int understanding,
		int communication, int initiative, int cooperation, int creativeness,
		int discipline, int empperformance, int msum, String comments) {
	super();
	this.empid=empid;
	this.empname = empname;
	this.msgname = msgname;
	this.station = station;
	this.jobdescriotion = jobdescriotion;
	this.skills = skills;
	this.understanding = understanding;
	this.communication = communication;
	this.initiative = initiative;
	this.cooperation = cooperation;
	this.creativeness = creativeness;
	this.discipline = discipline;
	this.empperformance = empperformance;
	this.msum = msum;
	this.comments = comments;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public String getMsgname() {
	return msgname;
}
public void setMsgname(String msgname) {
	this.msgname = msgname;
}
public String getStation() {
	return station;
}
public void setStation(String station) {
	this.station = station;
}
public String getJobdescriotion() {
	return jobdescriotion;
}
public void setJobdescriotion(String jobdescriotion) {
	this.jobdescriotion = jobdescriotion;
}
public int getSkills() {
	return skills;
}
public void setSkills(int skills) {
	this.skills = skills;
}
public int getUnderstanding() {
	return understanding;
}
public void setUnderstanding(int understanding) {
	this.understanding = understanding;
}
public int getCommunication() {
	return communication;
}
public void setCommunication(int communication) {
	this.communication = communication;
}
public int getInitiative() {
	return initiative;
}
public void setInitiative(int initiative) {
	this.initiative = initiative;
}
public int getCooperation() {
	return cooperation;
}
public void setCooperation(int cooperation) {
	this.cooperation = cooperation;
}
public int getCreativeness() {
	return creativeness;
}
public void setCreativeness(int creativeness) {
	this.creativeness = creativeness;
}
public int getDiscipline() {
	return discipline;
}
public void setDiscipline(int discipline) {
	this.discipline = discipline;
}
public int getEmpperformance() {
	return empperformance;
}
public void setEmpperformance(int empperformance) {
	this.empperformance = empperformance;
}
public int getMsum() {
	return msum;
}
public void setMsum(int msum) {
	this.msum = msum;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public Date getGradetime() {
	return gradetime;
}
public void setGradetime(Date gradetime) {
	this.gradetime = gradetime;
}
}
