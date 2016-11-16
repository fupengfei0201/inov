package inov.fpf.model.dao;

import inov.fpf.model.vo.Msggrade;
import inov.fpf.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCMsg {
	private Connection con = null;
	private PreparedStatement psd = null;
	private ResultSet rs = null;
	public boolean login(String tname, String password) {
		boolean t = false;

		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from msglogin where mloginname=? and mpassw=?";
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
	
	//插入打分
	public int msgInsert(Msggrade msggrade){
		int i=0;
		
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into msggrade values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
			psd=con.prepareStatement(sql);
			psd.setInt(1,msggrade.getEmpid());
			psd.setString(2,msggrade.getEmpname());
			psd.setString(3,msggrade.getMsgname());
			psd.setString(4,msggrade.getStation());
			psd.setString(5,msggrade.getJobdescriotion());
			psd.setInt(6,msggrade.getSkills());
			psd.setInt(7,msggrade.getUnderstanding());
			psd.setInt(8,msggrade.getCommunication() ); 
			psd.setInt(9,msggrade.getInitiative() );
			psd.setInt(10,msggrade.getCooperation() );
			psd.setInt(11,msggrade.getCreativeness() );
			psd.setInt(12,msggrade.getDiscipline() );
			psd.setInt(13, msggrade.getEmpperformance());
			psd.setInt(14,msggrade.getMsum() );
			psd.setString(15,msggrade.getComments());
			i=psd.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	//打完所有员工后标志经理的数据库就插入一条信息
	public int insertcount(int x){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into mnnum values(?)";
			
			psd=con.prepareStatement(sql);
			psd.setInt(1, x);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//显示经理打分的次数
	public int selectcount(){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="select count(numid)from mnnum";
			psd=con.prepareStatement(sql);
			rs=psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(numid)");
				System.out.println(i+"------------------数量");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//经理在同一次中不能给同一个人打两次分数
		public boolean selectMnName(String name) {
			boolean t = false;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select empname from msggrade where empname=? and emp=(select count(numid)from mnnum)";
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
