package inov.fpf.model.vo;

import java.util.Date;

public class Teacher {
	private int empid;
public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
private String empname;
private String tname;
private int studyability;
private int planing;
private int discipline;
private int belonging;
private int teamwork;
private int enthusiasm;
private int responsibility;
private int efficiency;
private int quality;
private int tperformance;
private int tsum;
private String comments;
private Date scoredate;

public Teacher() {
	super();
}
public Teacher(int empid,String empname, String tname, int studyability, int planing,
		int discipline, int belonging, int teamwork, int enthusiasm,
		int responsibility, int efficiency, int quality, int tperformance,
		 int tsum,String comments) {
	super();
	this.empid=empid;
	this.empname = empname;
	this.tname = tname;
	this.studyability = studyability;
	this.planing = planing;
	this.discipline = discipline;
	this.belonging = belonging;
	this.teamwork = teamwork;
	this.enthusiasm = enthusiasm;
	this.responsibility = responsibility;
	this.efficiency = efficiency;
	this.quality = quality;
	this.tperformance = tperformance;

	this.tsum = tsum;
	this.comments = comments;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public int getStudyability() {
	return studyability;
}
public void setStudyability(int studyability) {
	this.studyability = studyability;
}
public int getPlaning() {
	return planing;
}
public void setPlaning(int planing) {
	this.planing = planing;
}
public int getDiscipline() {
	return discipline;
}
public void setDiscipline(int discipline) {
	this.discipline = discipline;
}
public int getBelonging() {
	return belonging;
}
public void setBelonging(int belonging) {
	this.belonging = belonging;
}
public int getTeamwork() {
	return teamwork;
}
public void setTeamwork(int teamwork) {
	this.teamwork = teamwork;
}
public int getEnthusiasm() {
	return enthusiasm;
}
public void setEnthusiasm(int enthusiasm) {
	this.enthusiasm = enthusiasm;
}
public int getResponsibility() {
	return responsibility;
}
public void setResponsibility(int responsibility) {
	this.responsibility = responsibility;
}
public int getEfficiency() {
	return efficiency;
}
public void setEfficiency(int efficiency) {
	this.efficiency = efficiency;
}
public int getQuality() {
	return quality;
}
public void setQuality(int quality) {
	this.quality = quality;
}
public int getTperformance() {
	return tperformance;
}
public void setTperformance(int tperformance) {
	this.tperformance = tperformance;
}
public int getTsum() {
	return tsum;
}
public void setTsum(int tsum) {
	this.tsum = tsum;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public Date getScoredate() {
	return scoredate;
}
public void setScoredate(Date scoredate) {
	this.scoredate = scoredate;
}
}
