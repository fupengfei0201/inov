package inov.fpf.model.dao;

import inov.fpf.model.vo.ForemenGrade;
import inov.fpf.model.vo.Teacher;
import inov.fpf.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * ���ڹ��γ��������ݿ�Ĵ���
 * @author Administrator
 *
 */
public class JDBCForemen {
	private Connection con = null;
	private PreparedStatement psd = null;
	private ResultSet rs = null;
	//���γ���½ʱ�жϵ�¼��Ϣ�Ƿ���ȷ
	public boolean login(String tname, String password) {
		boolean t = false;

		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from foremen where floginname=? and fpassw=?";
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
	public int insertForcount(int x){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into fnum values(?)";
			psd=con.prepareStatement(sql);
			psd.setInt(1, x);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//��ʾ���γ���ֵĴ���
	public int selectForcount(){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="select count(numid)from fnum";
			psd=con.prepareStatement(sql);
			rs=psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(numid)");
				System.out.println(i+"------------------����");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//��Ӵ��
	public int  forinsert(ForemenGrade foremen){
		int i=0;
		
		try {
			con = JDBCUtil.getConnection();
			String sql="insert into foremengrade values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
			psd=con.prepareStatement(sql);
			psd.setInt(1,foremen.getEmpid());
			psd.setString(2,foremen.getEmpname());
			psd.setString(3,foremen.getTname());
			psd.setInt(4,foremen.getStudyability());
			psd.setInt(5,foremen.getPlaning());
			psd.setInt(6,foremen.getDiscipline());
			psd.setInt(7,foremen.getBelonging());
			psd.setInt(8,foremen.getTeamwork());
			psd.setInt(9,foremen.getEnthusiasm());
			psd.setInt(10,foremen.getResponsibility());
			psd.setInt(11,foremen.getEfficiency());
			psd.setInt(12,foremen.getQuality());
			psd.setInt(13,foremen.getTperformance());
			psd.setInt(14,foremen.getTsum());
			psd.setString(15,foremen.getComments());
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
	}
	//��ѯ���γ�����һ���ε�
	public String selForSection(String name){
		String str=null;
		try {
			con=JDBCUtil.getConnection();
			String sql="select sectionname from foremen where floginname=?";
			psd=con.prepareStatement(sql);
			psd.setString(1, name);
			rs=psd.executeQuery();
			while(rs.next()){
			str=rs.getString("sectionname");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str;
	}
	//ͬһ���в��ܸ�ͬһ���˴����η���
	public boolean selectName(String name) {
		boolean t = false;

		try {
			con = JDBCUtil.getConnection();
			String sql = "select empname from foremengrade where empname=? and empid=(select count(numid)from countnum)";
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
