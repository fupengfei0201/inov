package inov.fpf.model.dao;

import inov.fpf.model.vo.Login;
import inov.fpf.model.vo.Monitor;
import inov.fpf.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public int empMonInsert(Monitor mon){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into monitorgrade values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
			psd=con.prepareStatement(sql);
			psd.setInt(1,mon.getEmpid());
			psd.setString(2,mon.getEmpname());
			psd.setString(3,mon.getDepartment());
			psd.setString(4,mon.getAssessname());
			psd.setInt(5,mon.getWorkquality());
			psd.setInt(6,mon.getWorknowledge() );
			psd.setInt(7,mon.getWorkeffciency() );
			psd.setInt(8,mon.getAttitude() );
			psd.setInt(9,mon.getLearning() );
			psd.setInt(10,mon.getPlanning() );
			psd.setInt(11,mon.getResponsibility() );
			psd.setInt(12,mon.getCommunication() );
			psd.setInt(13,mon.getCooperation() );
			psd.setInt(14,mon.getEmpsum() );
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
		
	}
	//��ѯ����ֵ�����
	public int selectMonC(String section){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql=" select count(nvl(m.empcod,0))from monitorgrade m,emplogin emp where emp.sectionname=? and emp.emploginname=m.empname";
			psd=con.prepareStatement(sql);
			psd.setString(1,section);
			rs=psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(nvl(m.empcod,0))");
				System.out.println(i+"------------------����");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//��ѯ���������˶�û�д���ֵķ���
	public List<Login>monNameAndDept(String name){
		List<Login>list=new ArrayList<Login>();

		try {
			con=JDBCUtil.getConnection();
			String sql="select emploginname,department from emplogin where sectionname=? and empdate>(select ADD_MONTHS(sysdate, -12)from dual)";
			psd=con.prepareStatement(sql);
			psd.setString(1,name);
			rs=psd.executeQuery();
			while(rs.next()){
				Login login=new Login();
				login.setName(rs.getString("emploginname"));
				login.setDept(rs.getString("department"));
				list.add(login);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	//��ʾ���鳤����δ����ֵ���
	public List<Login>empMonName(String name){
		List<Login>list=new ArrayList<Login>();

		try {
			con=JDBCUtil.getConnection();
			String sql=" select distinct e.emploginname,e.department from emplogin e,monitorgrade emp where e.emploginname not in(select empname from monitorgrade where empcod=(select max(empcod)from monitorgrade)) and e.sectionname=? and e.empdate>(select ADD_MONTHS(sysdate, -12)from dual)";
			psd=con.prepareStatement(sql);
			psd.setString(1,name);
			rs=psd.executeQuery();
			while(rs.next()){
				Login login=new Login();
				login.setName(rs.getString("emploginname"));
				login.setDept(rs.getString("department"));
				list.add(login);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	//��ѯ���鳤����һ���ε�
	public String selMonSection(String name){
		String str=null;
		try {
			con=JDBCUtil.getConnection();
			String sql="select sectionname from monitor where monloginname=?";
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
	//��ѯ���鳤���˴�ֲ�Ҫ����ָ������
	public int selectMon(String name){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="select count(assessname)from monitorgrade where assessname=? and empcod=(select max(empcod) from monitorgrade)";
			psd=con.prepareStatement(sql);
			psd.setString(1,name);
			rs=psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(assessname)");
				System.out.println(i+"------------------����");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//��ʾ���鳤�Ĵ�ֵĴ���
	public int selecMoncount(){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="select count(numid)from monnum";
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
	//������鳤��ִ���
	public int insertMoncount(int x){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into monnum values(?)";
			psd=con.prepareStatement(sql);
			psd.setInt(1, x);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//��ѯͬһ���εİ��鳤������
	public int selectMonCount(String section){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="select count(monloginname)from monitor where sectionname=?";
			psd=con.prepareStatement(sql);
			psd.setString(1, section);
			rs=psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(monloginname)");
				System.out.println(i+"------------------����");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	
	}
	//��ֹ�ظ�ΪԱ�����
	public boolean selectEmpMonName(String name) {
		boolean t = false;

		try {
			con = JDBCUtil.getConnection();
			String sql = "select empname from monitorgrade where empname=? and empcod=(select count(empid)from monnum)";
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
