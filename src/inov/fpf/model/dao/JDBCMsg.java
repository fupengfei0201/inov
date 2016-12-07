package inov.fpf.model.dao;

import inov.fpf.model.vo.MsgSelect;
import inov.fpf.model.vo.Msggrade;
import inov.fpf.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		//经理查询打分情况
		public List<MsgSelect> allMsgemp(String time){
			List list =new ArrayList<MsgSelect>();
			try {
				con = JDBCUtil.getConnection();
				String sql="select rownum, t.empname,t.tname,t.tsum,f.tname,f.tsum,n.assessname,n.empsum,round((t.tsum+f.tsum+n.empsum)/3,2),t.comments from teacher t,foremengrade f,monitorgrade n where  t.empid=f.empid and f.empid=n.empcod and t.empname=f.empname and f.empname=n.empname and to_char(t.scoredate,'yyyy-mm')=? and to_char(f.scoredate,'yyyy-mm')=? and to_char(n.scoretime,'yyyy-mm')=?";
				psd=con.prepareStatement(sql);
				psd.setString(1, time);
				psd.setString(2, time);
				psd.setString(3,time);
				rs=psd.executeQuery();
				while(rs.next()){
					MsgSelect msg=new MsgSelect();
				msg.setCod(rs.getInt(1));
				msg.setName(rs.getString(2));
				msg.setDeptname(rs.getString(3));
				msg.setDeptgrade(rs.getDouble(4));
				msg.setTeachername(rs.getString(5));
				msg.setTeachergrade(rs.getDouble(6));
				msg.setMonname(rs.getString(7));
				msg.setMongrade(rs.getDouble(8));
				msg.setSum(rs.getDouble(9));
				msg.setComment(rs.getString(10));
				list.add(msg);	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return list;
		}
	
}
