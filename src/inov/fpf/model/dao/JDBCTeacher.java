package inov.fpf.model.dao;

import inov.fpf.model.vo.Teacher;
import inov.fpf.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTeacher {
	private Connection con = null;
	private PreparedStatement psd = null;
	private ResultSet rs = null;
	public boolean login(String tname, String password) {
		boolean t = false;

		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from teacherlogin where tloginname=? and tpassw=?";
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
	public int  tinsert(Teacher teacher){
		int i=0;
		
		try {
			con = JDBCUtil.getConnection();
			String sql="insert into teacher values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
			psd=con.prepareStatement(sql);
			psd.setInt(1,teacher.getEmpid());
			psd.setString(2,teacher.getEmpname());
			psd.setString(3,teacher.getTname());
			psd.setInt(4,teacher.getStudyability());
			psd.setInt(5,teacher.getPlaning());
			psd.setInt(6,teacher.getDiscipline());
			psd.setInt(7,teacher.getBelonging());
			psd.setInt(8,teacher.getTeamwork());
			psd.setInt(9,teacher.getEnthusiasm());
			psd.setInt(10,teacher.getResponsibility());
			psd.setInt(11,teacher.getEfficiency());
			psd.setInt(12,teacher.getQuality());
			psd.setInt(13,teacher.getTperformance());
			psd.setInt(14,teacher.getTsum());
			psd.setString(15,teacher.getComments());
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
	//同一次中不能给同一个人打两次分数
	public boolean selectName(String name) {
		boolean t = false;

		try {
			con = JDBCUtil.getConnection();
			String sql = "select empname from teacher where empname=? and empid=(select count(numid)from countnum)";
			psd = con.prepareStatement(sql);
			psd.setString(1, name);
		
			rs = psd.executeQuery();
			t = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return t;
	}
}
