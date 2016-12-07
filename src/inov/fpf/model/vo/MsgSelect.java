package inov.fpf.model.vo;

public class MsgSelect {
	private int cod;
	private String name;
	private String deptname;
	private double deptgrade;
	private String teachername;
	private double teachergrade;
	private String monname;
	private  double mongrade;
	private double sum;
	private String comment;
	
	public MsgSelect(int cod, String name, String deptname, double deptgrade,
			String teachername, double teachergrade, String monname,
			double mongrade, double sum, String comment) {
		super();
		this.cod = cod;
		this.name = name;
		this.deptname = deptname;
		this.deptgrade = deptgrade;
		this.teachername = teachername;
		this.teachergrade = teachergrade;
		this.monname = monname;
		this.mongrade = mongrade;
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

	public String getMonname() {
		return monname;
	}

	public void setMonname(String monname) {
		this.monname = monname;
	}

	public double getMongrade() {
		return mongrade;
	}

	public void setMongrade(double mongrade) {
		this.mongrade = mongrade;
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

	public MsgSelect() {
		super();
	}
	
}
