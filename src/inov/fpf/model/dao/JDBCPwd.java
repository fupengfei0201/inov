package inov.fpf.model.dao;

import inov.fpf.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPwd {
	private Connection con = null;
	private PreparedStatement psd = null;
	private ResultSet rs = null;
	//查询员工表
	public boolean checkEmp(String tname){
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from emplogin where emploginname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, tname);
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
	public boolean checkTeacher(String tname){
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from teacherlogin where tloginname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, tname);
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
	public boolean checkMng(String tname){
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from msglogin where mloginname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, tname);
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
	public boolean checkHR(String tname){
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from HR where hrname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, tname);
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
	public boolean checkForemen(String tname){
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from foremen where floginname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, tname);
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
	public boolean checkMonitor(String tname){
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from monitor where monloginname=?";
			psd = con.prepareStatement(sql);
			psd.setString(1, tname);
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
