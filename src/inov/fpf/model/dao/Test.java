package inov.fpf.model.dao;

public class Test {

	public static void main(String[] args) {
	/*	JDBCMsg msg=new JDBCMsg();
		boolean t=msg.login("inov", "admin");
		System.out.println("============"+t);*/
		JDBCEmp emp=new JDBCEmp();
		int x=emp.insertEmpOnecount(1);
		System.out.println("xµÄÖµÎª"+x+"------------------------");
	}

}
