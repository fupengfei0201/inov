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

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

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
	
	public List<HRGrade> allemp(String time){
		List list =new ArrayList<HRGrade>();
		
		try {
			con = JDBCUtil.getConnection();
			String sql="select rownum, m.empname,m.msgname,m.msum,t.tname,t.tsum,a.empsum,b.empsum,c.empsum,round((a.empsum+b.empsum+c.empsum)/3,2),round((m.msum+t.tsum+((a.empsum+b.empsum+c.empsum)/3))/3,2),m.comments from msggrade m,teacher t,empgrade a,empgradetwo b,newemp c where m.emp=T.EMPID and t.empid=A.EMPCOD and a.empcod=b.empcod and b.empcod=c.empcod and m.empname=t.empname and t.empname=a.empname and a.empname=b.empname and b.empname=c.empname and to_char(m.gradetime,'yyyy-mm')=?and to_char(t.scoredate,'yyyy-mm')=? and to_char(a.scoretime,'yyyy-mm')=? and to_char(b.scoretime,'yyyy-mm')=? and to_char(c.scoretime,'yyyy-mm')=?";
			psd=con.prepareStatement(sql);
			psd.setString(1, time);
			psd.setString(2, time);
			psd.setString(3,time);
			psd.setString(4, time);
			psd.setString(5,time);
			rs=psd.executeQuery();
			while(rs.next()){
				HRGrade hr=new HRGrade();
			hr.setCod(rs.getInt(1));
			hr.setName(rs.getString(2));
			hr.setDeptname(rs.getString(3));
			hr.setDeptgrade(rs.getDouble(4));
			hr.setTeachername(rs.getString(5));
			hr.setTeachergrade(rs.getDouble(6));
			hr.setOnegrade(rs.getDouble(7));
			hr.setTwograde(rs.getDouble(8));
			hr.setThreegrade(rs.getDouble(9));
			hr.setEmpavg(rs.getDouble(10));
			hr.setSum(rs.getDouble(11));
			hr.setComment(rs.getString(12));
			list.add(hr);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return list;
	}

	
}
