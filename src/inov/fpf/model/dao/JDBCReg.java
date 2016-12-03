package inov.fpf.model.dao;

import inov.fpf.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCReg {
	private Connection con = null;
	private PreparedStatement psd = null;
	private ResultSet rs = null;
	public int regEmp(String name,String passw,String entry,String edu,String dept,String teachername,String section){
		int i=0;
	//SimpleDateFormat deDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into emplogin values(emp_sequence.nextval,?,?,to_date(?,'yyyy-MM-dd'),?,?,?,?)";
			psd=con.prepareStatement(sql);
			psd.setString(1,name);
			psd.setString(2,passw);
			psd.setString(3,entry);
			psd.setString(4,edu);
			psd.setString(5,dept);
			psd.setString(6,teachername);
			psd.setString(7, section);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
		
	}
	public int regTeacher(String name,String passw,String section){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into teacherlogin values(teacher_squence.nextval,?,?,?)";
			psd=con.prepareStatement(sql);
			psd.setString(1,name);
			psd.setString(2,passw);
			psd.setString(3,section);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
	public int regMsg(String name,String passw){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into msglogin values(msg_sequence.nextval,?,?)";
			psd=con.prepareStatement(sql);
			psd.setString(1,name);
			psd.setString(2,passw);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
	public int regHr(String name,String passw ){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into HR values(hr_sequence.nextval,?,?)";
			psd=con.prepareStatement(sql);
			psd.setString(1,name);
			psd.setString(2,passw);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
	//¹¤¶Î³¤×¢²á
	public int regSection(String name,String passw,String section){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into foremen values(foremen_squence.nextval,?,?,?)";
			psd=con.prepareStatement(sql);
			psd.setString(1,name);
			psd.setString(2,passw);
			psd.setString(3,section);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
	//°à×é³¤×¢²á
	public int regMonitor(String name,String passw,String section){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into monitor values(mon_squence.nextval,?,?,?)";
			psd=con.prepareStatement(sql);
			psd.setString(1,name);
			psd.setString(2,passw);
			psd.setString(3,section);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
	//ÅÐ¶ÏÊÇ·ñ×¢²á¹ý
	public boolean emplogin(String tname) {
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from emplogin where emploginname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, tname);
			rs = psd.executeQuery();
			t = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return t;
	}
	public boolean tealogin(String tname) {
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from teacherlogin where tloginname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, tname);
			rs = psd.executeQuery();
			t = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return t;
	}
	public boolean msglogin(String tname) {
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from msglogin where mloginname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, tname);
			rs = psd.executeQuery();
			t = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return t;
	}
	public boolean Hrlogin(String tname) {
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from HR where hrname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, tname);
			rs = psd.executeQuery();
			t = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return t;
	}
	public boolean Sectionlogin(String tname) {
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from foremen where floginname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, tname);
			rs = psd.executeQuery();
			t = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return t;
	}
	//ÅÐ¶Ï°à×é³¤ÊÇ·ñ×¢²á¹ý
	public boolean monitorlogin(String tname) {
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from monitor where monloginname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, tname);
			rs = psd.executeQuery();
			t = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return t;
	}
	//ÅÐ¶ÏÊÇ·ñ´æÔÚ¹¤¶ÎºÅ
	public boolean Section(String section) {
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from section where sectionname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, section);
			rs = psd.executeQuery();
			t = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return t;
	}
}
