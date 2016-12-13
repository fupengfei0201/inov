package inov.fpf.model.dao;

import inov.fpf.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCNewPwd {
	private Connection con = null;
	private PreparedStatement psd = null;
	private ResultSet rs = null;
	//查询员工表
	public boolean EmpnewPwd(String pwd,String tname){
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "update emplogin set emppassw =? where emploginname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, pwd);
			psd.setString(2, tname);	
			rs = psd.executeQuery();
			t = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return t;
		
	}
	//查询师傅表
	public boolean TeachernewPwd(String pwd,String tname){
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "update teacherlogin set tpassw =? where tloginname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, pwd);
			psd.setString(2, tname);
			rs = psd.executeQuery();
			t = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return t;
		
	}
	//查询经理表
	public boolean MngnewPwd(String pwd,String tname){
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "update msglogin set mpassw =? where mloginname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, pwd);
			psd.setString(2, tname);
			rs = psd.executeQuery();
			t = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return t;
		
	}
	//查询人力资源表
	public boolean HRnewPwd(String pwd,String tname){
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "update HR set hrpassw =? where hrname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, pwd);
			psd.setString(2, tname);
			rs = psd.executeQuery();
			t = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return t;
		
	}
	//查询工段长表
	public boolean ForemennewPwd(String pwd,String tname){
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "update foremen set fpassw =? where floginname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, pwd);
			psd.setString(2, tname);
			rs = psd.executeQuery();
			t = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return t;
		
	}
	//查询班组长表
	public boolean MonitornewPwd(String pwd,String tname){
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "update monitor set monpassw =? where monloginname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, pwd);
			psd.setString(2, tname);
			rs = psd.executeQuery();
			t = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return t;
		
	}
	
}
