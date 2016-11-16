package inov.fpf.model.vo;

import java.util.Date;

public class Employee {
private String empname;
private String department;
private int empgrade;
private int tgrade;
private int mgrade;
private Date gradetime;
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
public int getEmpgrade() {
	return empgrade;
}
public void setEmpgrade(int empgrade) {
	this.empgrade = empgrade;
}
public int getTgrade() {
	return tgrade;
}
public void setTgrade(int tgrade) {
	this.tgrade = tgrade;
}
public int getMgrade() {
	return mgrade;
}
public void setMgrade(int mgrade) {
	this.mgrade = mgrade;
}
public Date getGradetime() {
	return gradetime;
}
public void setGradetime(Date gradetime) {
	this.gradetime = gradetime;
}
}
