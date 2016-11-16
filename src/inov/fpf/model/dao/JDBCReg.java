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
	public int regEmp(String name,String passw,String entry,String edu,String dept){
		int i=0;
	//SimpleDateFormat deDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into emplogin values(emp_sequence.nextval,?,?,to_date(?,'yyyy-MM-dd'),?,?)";
			psd=con.prepareStatement(sql);
			psd.setString(1,name);
			psd.setString(2,passw);
			psd.setString(3,entry);
			psd.setString(4,edu);
			psd.setString(5,dept);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
		
	}
	public int regTeacher(String name,String passw ){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into teacherlogin values(teacher_squence.nextval,?,?)";
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
	public int regMsg(String name,String passw ){
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
}
