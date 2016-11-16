package inov.fpf.model.vo;

public class HRGrade {
private String name;
private String deptname;
private int deptgrade;
private String teachername;
private int teachergrade;
private int onegrade;
private int twograde;
private int threegrade;

public HRGrade(String name, String deptname, int deptgrade, String teachername,
		int teachergrade,  int onegrade, 
		int twograde, int threegrade) {
	super();
	this.name = name;
	this.deptname = deptname;
	this.deptgrade = deptgrade;
	this.teachername = teachername;
	this.teachergrade = teachergrade;

	this.onegrade = onegrade;

	this.twograde = twograde;

	this.threegrade = threegrade;
}

public HRGrade() {
	super();
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
public int getDeptgrade() {
	return deptgrade;
}
public void setDeptgrade(int deptgrade) {
	this.deptgrade = deptgrade;
}
public String getTeachername() {
	return teachername;
}
public void setTeachername(String teachername) {
	this.teachername = teachername;
}
public int getTeachergrade() {
	return teachergrade;
}
public void setTeachergrade(int teachergrade) {
	this.teachergrade = teachergrade;
}
public int getOnegrade() {
	return onegrade;
}
public void setOnegrade(int onegrade) {
	this.onegrade = onegrade;
}

public int getTwograde() {
	return twograde;
}
public void setTwograde(int twograde) {
	this.twograde = twograde;
}

public int getThreegrade() {
	return threegrade;
}
public void setThreegrade(int threegrade) {
	this.threegrade = threegrade;
}
}
