package inov.fpf.model.dao;

import inov.fpf.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCNum {
	private Connection con = null;
	private PreparedStatement psd = null;
	private ResultSet rs = null;
	//插入数---------------------------------------------
	public int oneM(int x){
		int i=0;
		
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into oneM values(?)";
			psd=con.prepareStatement(sql);
			psd.setInt(1, x);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	public int oneT(int x){
		int i=0;
		
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into oneT values(?)";
			psd=con.prepareStatement(sql);
			psd.setInt(1, x);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	public int oneEmpA(int x){
		int i=0;
		
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into oneempA values(?)";
			psd=con.prepareStatement(sql);
			psd.setInt(1, x);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	public int oneEmpB(int x){
		int i=0;
		
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into oneempB values(?)";
			psd=con.prepareStatement(sql);
			psd.setInt(1, x);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	public int oneEmpC(int x){
		int i=0;
		
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into oneempC values(?)";
			psd=con.prepareStatement(sql);
			psd.setInt(1, x);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	//查询数----------------------
	public int selectOneM() {
		int i=0;

		try {
			con = JDBCUtil.getConnection();
			String sql = "select count(idm) from oneM";
			psd = con.prepareStatement(sql);
			rs = psd.executeQuery();
		while(rs.next()){
			i=rs.getInt("count(idm)");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
	public int selectOneT() {
		int i=0;

		try {
			con = JDBCUtil.getConnection();
			String sql = "select count(idt) from oneT";
			psd = con.prepareStatement(sql);
			rs = psd.executeQuery();
		while(rs.next()){
			i=rs.getInt("count(idt)");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
	public int selectOneEmpA() {
		int i=0;

		try {
			con = JDBCUtil.getConnection();
			String sql = "select count(ida) from oneempA";
			psd = con.prepareStatement(sql);
			rs = psd.executeQuery();
		while(rs.next()){
			i=rs.getInt("count(ida)");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
	public int selectOneEmpB() {
		int i=0;

		try {
			con = JDBCUtil.getConnection();
			String sql = "select count(idb) from oneempB";
			psd = con.prepareStatement(sql);
			rs = psd.executeQuery();
		while(rs.next()){
			i=rs.getInt("count(idb)");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
	public int selectOneEmpC() {
		int i=0;

		try {
			con = JDBCUtil.getConnection();
			String sql = "select count(idc) from oneempC";
			psd = con.prepareStatement(sql);
			rs = psd.executeQuery();
		while(rs.next()){
			i=rs.getInt("count(idc)");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
	//删除信息
	public int deleteOneM(){
		int i=0;
		try {
			con = JDBCUtil.getConnection();
			String sql = "delete from oneM";
			psd = con.prepareStatement(sql);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
	public int deleteOneT(){
		int i=0;
		try {
			con = JDBCUtil.getConnection();
			String sql = "delete from oneT";
			psd = con.prepareStatement(sql);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
	public int deleteOneEmpA(){
		int i=0;
		try {
			con = JDBCUtil.getConnection();
			String sql = "delete from oneempA";
			psd = con.prepareStatement(sql);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
	public int deleteOneEmpB(){
		int i=0;
		try {
			con = JDBCUtil.getConnection();
			String sql = "delete from oneempB";
			psd = con.prepareStatement(sql);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
	public int deleteOneEmpC(){
		int i=0;
		try {
			con = JDBCUtil.getConnection();
			String sql = "delete from oneEmpC";
			psd = con.prepareStatement(sql);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
}
