package inov.fpf.model.dao;

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
	
}
