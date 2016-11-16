package inov.fpf.model.vo;

public class HR {
private String name;
private String passw;
public HR(String name, String passw) {
	super();
	this.name = name;
	this.passw = passw;
}
public HR() {
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

}
