package inov.fpf.model.vo;




public class Reg {
private String name;
private String passw;
private String entry;
private String edu;
private String dept;
public String getEdu() {
	return edu;
}

public void setEdu(String edu) {
	this.edu = edu;
}

public String getDept() {
	return dept;
}

public void setDept(String dept) {
	this.dept = dept;
}

public Reg(String name, String passw, String entry) {
	super();
	this.name = name;
	this.passw = passw;
	this.entry = entry;
}

public Reg(String name, String passw, String entry, String edu, String dept) {
	super();
	this.name = name;
	this.passw = passw;
	this.entry = entry;
	this.edu = edu;
	this.dept = dept;
}

public Reg() {
	super();
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassw() {
	return passw;
}
public void setPassw(String passw) {
	this.passw = passw;
}
public String getEntry() {
	return entry;
}
public void setEntry(String entry) {
	this.entry = entry;
}

}
