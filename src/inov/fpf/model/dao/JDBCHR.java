package inov.fpf.model.dao;

import inov.fpf.model.vo.HRGrade;
import inov.fpf.util.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCHR {
	private Connection con = null;
	private PreparedStatement psd = null;
	private ResultSet rs = null;
	public boolean login(String tname, String password) {
		boolean t = false;

		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from HR where hrname=? and hrpassw=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, tname);
			psd.setString(2, password);
			rs = psd.executeQuery();
			t = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return t;
	}
	public List<HRGrade> allemp(){
		List list =new ArrayList<HRGrade>();
		con = JDBCUtil.getConnection();
		String sql="select m.msgname,m.msum,t.tname,t.tsum,emp.assessname,emp.empsum,emp.(select avg(empsum)from empgrade group by empcod)from teacher t,msggrade m,empgrade emp where emp.cod=m.emp and m.emp=t.empid";
		return list;
	}
}
