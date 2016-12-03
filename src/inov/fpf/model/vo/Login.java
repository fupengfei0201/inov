package inov.fpf.model.vo;

public class Login {
private int id;
private String name;
private String passw;
private String title;
private String dept;
private String session;
public String getSession() {
	return session;
}
public void setSession(String session) {
	this.session = session;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
}
