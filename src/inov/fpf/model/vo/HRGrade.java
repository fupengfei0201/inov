package inov.fpf.model.vo;

public class HRGrade {
private int cod;
private String name;
private String deptname;
private double deptgrade;
private String teachername;
private double teachergrade;
private double onegrade;
private double twograde;
private double threegrade;
private double empavg;
private double sum;
private String comment;
public HRGrade() {
	super();
}
public HRGrade(int cod, String name, String deptname, double deptgrade,
		String teachername, double teachergrade, double onegrade,
		double twograde, double threegrade, double empavg, double sum,
		String comment) {
	super();
	this.cod = cod;
	this.name = name;
	this.deptname = deptname;
	this.deptgrade = deptgrade;
	this.teachername = teachername;
	this.teachergrade = teachergrade;
	this.onegrade = onegrade;
	this.twograde = twograde;
	this.threegrade = threegrade;
	this.empavg = empavg;
	this.sum = sum;
	this.comment = comment;
}
public int getCod() {
	return cod;
}
public void setCod(int cod) {
	this.cod = cod;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDeptname() {
	return deptname;
}
public void setDeptname(String deptname) {
	this.deptname = deptname;
}
public double getDeptgrade() {
	return deptgrade;
}
public void setDeptgrade(double deptgrade) {
	this.deptgrade = deptgrade;
}
public String getTeachername() {
	return teachername;
}
public void setTeachername(String teachername) {
	this.teachername = teachername;
}
public double getTeachergrade() {
	return teachergrade;
}
public void setTeachergrade(double teachergrade) {
	this.teachergrade = teachergrade;
}
public double getOnegrade() {
	return onegrade;
}
public void setOnegrade(double onegrade) {
	this.onegrade = onegrade;
}
public double getTwograde() {
	return twograde;
}
public void setTwograde(double twograde) {
	this.twograde = twograde;
}
public double getThreegrade() {
	return threegrade;
}
public void setThreegrade(double threegrade) {
	this.threegrade = threegrade;
}
public double getEmpavg() {
	return empavg;
}
public void setEmpavg(double empavg) {
	this.empavg = empavg;
}
public double getSum() {
	return sum;
}
public void setSum(double sum) {
	this.sum = sum;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}


}
