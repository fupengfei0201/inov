package inov.fpf.model.dao;

import inov.fpf.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCMonitor {
	private Connection con = null;
	private PreparedStatement psd = null;
	private ResultSet rs = null;
	//���γ���½ʱ�жϵ�¼��Ϣ�Ƿ���ȷ
	public boolean login(String tname, String password) {
		boolean t = false;

		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from monitor where monloginname=? and monpassw=?";
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
	
	
}
