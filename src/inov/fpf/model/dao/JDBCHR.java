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
			String sql="select rownum, m.empname,m.msgname,m.msum,t.tname,t.tsum,f.tname,f.tsum,n.assessname,n.empsum,round((m.msum+t.tsum+f.tsum+n.empsum)/4,2),m.comments from msggrade m,teacher t,foremengrade f,monitorgrade n where m.emp=T.EMPID and t.empid=f.empid and f.empid=n.empcod and m.empname=t.empname and t.empname=f.empname and f.empname=n.empname and to_char(m.gradetime,'yyyy-mm')=?and to_char(t.scoredate,'yyyy-mm')=? and to_char(f.scoredate,'yyyy-mm')=? and to_char(n.scoretime,'yyyy-mm')=?";
			psd=con.prepareStatement(sql);
			psd.setString(1, time);
			psd.setString(2, time);
			psd.setString(3,time);
			psd.setString(4, time);
			rs=psd.executeQuery();
			while(rs.next()){
				HRGrade hr=new HRGrade();
			hr.setCod(rs.getInt(1));
			hr.setName(rs.getString(2));
			hr.setDeptname(rs.getString(3));
			hr.setDeptgrade(rs.getDouble(4));
			hr.setTeachername(rs.getString(5));
			hr.setTeachergrade(rs.getDouble(6));
			hr.setForemenname(rs.getString(7));
			hr.setForemengrade(rs.getDouble(8));
			hr.setMonname(rs.getString(9));
			hr.setMongrade(rs.getDouble(10));
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
//未打分人员
	public List<HRGrade> allempnot(String time){
		List list =new ArrayList<HRGrade>();
		try {
			con = JDBCUtil.getConnection();
			String sql="select rownum,z1.emploginname,nvl(z2.msgname,' '),nvl(z2.msum,0),z1.teachername,nvl(z3.tsum,0),(select floginname from foremen where sectionname=z1.sectionname),nvl(z4.tsum,0),nvl(z5.assessname,' '),nvl(z5.empsum,0) from emplogin z1 left join msggrade z2 on z1.emploginname = z2.empname left join teacher z3  on Z1.EMPLOGINNAME = z3.empname left join foremengrade z4 on z1.emploginname = z4.empname left join monitorgrade z5 on z1.emploginname = z5.empname where z1.emploginname not in(select empname from msggrade where to_char(gradetime,'yyyy-MM')=?) or z1.emploginname not in(select empname from teacher where to_char(scoredate,'yyyy-MM')=?)or z1.emploginname not in(select empname from foremengrade where to_char(scoredate,'yyyy-MM')=?)or z1.emploginname not in(select empname from monitorgrade where to_char(scoretime,'yyyy-MM')=?)";
			psd=con.prepareStatement(sql);
			psd.setString(1,time);
			psd.setString(2,time);
			psd.setString(3,time);
			psd.setString(4,time);
			rs=psd.executeQuery();
			while(rs.next()){
			HRGrade hr=new HRGrade();
			hr.setCod(rs.getInt(1));
			hr.setName(rs.getString(2));
			hr.setDeptname(rs.getString(3));
			hr.setDeptgrade(rs.getDouble(4));
			hr.setTeachername(rs.getString(5));
			hr.setTeachergrade(rs.getDouble(6));
			hr.setForemenname(rs.getString(7));
			hr.setForemengrade(rs.getDouble(8));
			hr.setMonname(rs.getString(9));
			hr.setMongrade(rs.getDouble(10));
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
