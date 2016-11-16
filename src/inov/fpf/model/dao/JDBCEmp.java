package inov.fpf.model.dao;

import inov.fpf.model.vo.Empgrade;
import inov.fpf.model.vo.Login;
import inov.fpf.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class JDBCEmp {
	private Connection con = null;
	private PreparedStatement psd = null;
	private ResultSet rs = null;
	//�ж�Ա����½
	public boolean login(String tname, String password) {
		boolean t = false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from emplogin where emploginname=? and emppassw=?";
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
	//��ѯ����Ա��
	public boolean empentry(String name){
		boolean t=false;
	
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from emplogin where emploginname=? and empdate<to_date('2010-01-01','YYYY-MM-DD')";
			psd = con.prepareStatement(sql);
			psd.setString(1, name);
			
			rs = psd.executeQuery();
			t = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
	//������Ա������
			public int empNewInsert(Empgrade empgrade){
				int i=0;
				try {
					con=JDBCUtil.getConnection();
					String sql="insert into newemp values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
					psd=con.prepareStatement(sql);
					psd.setInt(1,empgrade.getEmpid());
					psd.setString(2,empgrade.getEmpname());
					psd.setString(3,empgrade.getDepartment());
					psd.setString(4,empgrade.getAssessname());
					psd.setInt(5,empgrade.getWorkquality());
					psd.setInt(6,empgrade.getWorknowledge() );
					psd.setInt(7,empgrade.getWorkeffciency() );
					psd.setInt(8,empgrade.getAttitude() );
					psd.setInt(9,empgrade.getLearning() );
					psd.setInt(10,empgrade.getPlanning() );
					psd.setInt(11,empgrade.getResponsibility() );
					psd.setInt(12,empgrade.getCommunication() );
					psd.setInt(13,empgrade.getCooperation() );
					psd.setInt(14,empgrade.getEmpsum() );
					i=psd.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JDBCUtil.closeupdate(con, psd, rs);
				return i;
				
			}
	//������Ա��������
	public int empTwoInsert(Empgrade empgrade){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into empgradetwo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
			psd=con.prepareStatement(sql);
			psd.setInt(1,empgrade.getEmpid());
			psd.setString(2,empgrade.getEmpname());
			psd.setString(3,empgrade.getDepartment());
			psd.setString(4,empgrade.getAssessname());
			psd.setInt(5,empgrade.getWorkquality());
			psd.setInt(6,empgrade.getWorknowledge() );
			psd.setInt(7,empgrade.getWorkeffciency() );
			psd.setInt(8,empgrade.getAttitude() );
			psd.setInt(9,empgrade.getLearning() );
			psd.setInt(10,empgrade.getPlanning() );
			psd.setInt(11,empgrade.getResponsibility() );
			psd.setInt(12,empgrade.getCommunication() );
			psd.setInt(13,empgrade.getCooperation() );
			psd.setInt(14,empgrade.getEmpsum() );
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return i;
		
	}
	//������Ա��һ����
		public int empInsert(Empgrade empgrade){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql="insert into empgrade values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
				psd=con.prepareStatement(sql);
				psd.setInt(1,empgrade.getEmpid());
				psd.setString(2,empgrade.getEmpname());
				psd.setString(3,empgrade.getDepartment());
				psd.setString(4,empgrade.getAssessname());
				psd.setInt(5,empgrade.getWorkquality());
				psd.setInt(6,empgrade.getWorknowledge() );
				psd.setInt(7,empgrade.getWorkeffciency() );
				psd.setInt(8,empgrade.getAttitude() );
				psd.setInt(9,empgrade.getLearning() );
				psd.setInt(10,empgrade.getPlanning() );
				psd.setInt(11,empgrade.getResponsibility() );
				psd.setInt(12,empgrade.getCommunication() );
				psd.setInt(13,empgrade.getCooperation() );
				psd.setInt(14,empgrade.getEmpsum() );
				i=psd.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
			
		}
	//��ѯԱ������
	public int empcount(){
		int i=0;
		
		try {
			con=JDBCUtil.getConnection();
			String sql="select count(empid)from emplogin";
			psd=con.prepareStatement(sql);
			rs=psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(empid)");
				System.out.println(i+"---------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//Ա���ı��
	public int empeecount(){
		int i=0;
		
		try {
			con=JDBCUtil.getConnection();
			String sql="select count(empid)from empnum";
			psd=con.prepareStatement(sql);
			rs=psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(empid)");
				System.out.println(i+"---------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//ÿ��������Ա���ķ���һ�Σ����ݿ��б�־ʦ����ֵ����ݿ�Ͳ���һ����Ϣ
	public int insertcount(int x){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="insert into countnum values(?)";
			psd=con.prepareStatement(sql);
			psd.setInt(1, x);
			i=psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//ʦ����ֵĴ���
	public int selectcount(){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="select count(numid)from countnum";
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
	//�����ʦ����ѯ����Ա��
	public List<Login>empNameAndDept(){
		List<Login>list=new ArrayList<Login>();

		try {
			con=JDBCUtil.getConnection();
			String sql="select emploginname,department from emplogin";
			psd=con.prepareStatement(sql);
			
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
	//������Ա�������Ҫ��ѯ���Լ����⻹Ҫȥ���Լ��ڱ�һ�д���������ˣ�Ҳ����˵��Ա����һ���ֶ�ΪASSESSNAME=�Լ��Ķ���������ʾ
	public List<Login>empNameAndDeptTwo(String name,String ename){
		List<Login>list=new ArrayList<Login>();

		try {
			con=JDBCUtil.getConnection();
			String sql="select emp.emploginname,emp.department from emplogin emp,empgrade e where emp.emploginname!=? and e.assessname!=? and emp.emploginname=(select empname from empgrade where empcod=(select max(empcod)from empgrade))";
			psd=con.prepareStatement(sql);
			psd.setString(1,name);
			psd.setString(2,ename);
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
	//������Ա����һԱ����ѯ���Լ������Ա���������Ͳ���
	public List<Login>empNameAndDept(String name){
		List<Login>list=new ArrayList<Login>();

		try {
			con=JDBCUtil.getConnection();
			String sql="select emploginname,department from emplogin where emploginname!=? ";
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
	//��Ա��һ���ѯ��ֺ�Ա���ڴ�ֱ������
	public int selectEmpOnecount(){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql=" select count(nvl(empcod,0))from empgrade";
			psd=con.prepareStatement(sql);
			rs=psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(nvl(empcod,0))");
				System.out.println(i+"------------------����");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//��ѯ��Ա�������ֵ�Ա������
	public int selectEmpTwocount(){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql=" select count(nvl(empcod,0))from empgradetwo";
			psd=con.prepareStatement(sql);
			rs=psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(nvl(empcod,0))");
				System.out.println(i+"------------------����");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//��ѯ��Ա���д�ֵ�����
	public int selectEmpNewCount(){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql=" select count(nvl(empcod,0))from newemp";
			psd=con.prepareStatement(sql);
			rs=psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(nvl(empcod,0))");
				System.out.println(i+"------------------����");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//��ʾ��Ա��һ����δ�����Ա
	public List<Login>empName(String name){
		List<Login>list=new ArrayList<Login>();

		try {
			con=JDBCUtil.getConnection();
			String sql=" select distinct e.emploginname,e.department from emplogin e,empgrade emp where e.emploginname not in(select empname from empgrade where empcod=(select max(empcod)from empgrade)) and e.emploginname!=?";
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
	//��ʾ��Ա��������δ�����Ա
		public List<Login>empNameTwo(String name){
			List<Login>list=new ArrayList<Login>();

			try {
				con=JDBCUtil.getConnection();
				String sql=" select distinct e.emploginname,e.department from emplogin e,empgradetwo emp where e.emploginname not in(select empname from empgradetwo where empcod=(select max(empcod)from empgradetwo)) and e.emploginname!=?";
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
		//��ʾ��Ա����δ�����������
		public List<Login>empNewName(String name){
			List<Login>list=new ArrayList<Login>();

			try {
				con=JDBCUtil.getConnection();
				String sql=" select distinct e.emploginname,e.department from emplogin e,newemp emp where e.emploginname not in(select empname from newemp where empcod=(select max(empcod)from newemp)) and e.emploginname!=?";
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
		//��ʾʦ������δ����ֵ���
		public List<Login>empTeaName(){
			List<Login>list=new ArrayList<Login>();

			try {
				con=JDBCUtil.getConnection();
				String sql=" select distinct e.emploginname,e.department from emplogin e,teacher emp where e.emploginname not in(select empname from teacher where empid=(select max(empid)from teacher))";
				psd=con.prepareStatement(sql);
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
		//��ѯʦ�����������������
		public int selectEmpTeaCount(){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql=" select count(nvl(empid,0))from teacher";
				psd=con.prepareStatement(sql);
				rs=psd.executeQuery();
				while(rs.next()){
					i=rs.getInt("count(nvl(empid,0))");
					System.out.println(i+"------------------����");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//��ѯ������������������
		public int selectEmpMnCount(){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql=" select count(nvl(emp,0))from msggrade";
				psd=con.prepareStatement(sql);
				rs=psd.executeQuery();
				while(rs.next()){
					i=rs.getInt("count(nvl(emp,0))");
					System.out.println(i+"------------------����");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//��ʾʦ������δ����ֵ���
		public List<Login>empMnName(){
			List<Login>list=new ArrayList<Login>();

			try {
				con=JDBCUtil.getConnection();
				String sql=" select distinct e.emploginname,e.department from emplogin e,msggrade emp where e.emploginname not in(select empname from msggrade where emp=(select max(emp)from msggrade))";
				psd=con.prepareStatement(sql);
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
		//---------------------------------------------------------------------------------
		//��������Ա�����־��Ա��������ݿ�Ͳ���һ����Ϣ
				public int insertEmpNewcount(int x){
					int i=0;
					try {
						con=JDBCUtil.getConnection();
						String sql="insert into empnumnew values(?)";
						
						psd=con.prepareStatement(sql);
						psd.setInt(1, x);
						i=psd.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return i;
				}
				//��ʾ��Ա����Ĵ�ֵĴ���
				public int selectNewcount(){
					int i=0;
					try {
						con=JDBCUtil.getConnection();
						String sql="select count(empid)from empnumnew";
						psd=con.prepareStatement(sql);
						rs=psd.executeQuery();
						while(rs.next()){
							i=rs.getInt("count(empid)");
							System.out.println(i+"------------------����");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return i;
				}
		//��������Ա�����־��Ա����������ݿ�Ͳ���һ����Ϣ
		public int insertEmpTwocount(int x){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql="insert into empnumtwo values(?)";
				
				psd=con.prepareStatement(sql);
				psd.setInt(1, x);
				i=psd.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//��ʾ��Ա������Ĵ�ֵĴ���
		public int selectTwocount(){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql="select count(empid)from empnumtwo";
				psd=con.prepareStatement(sql);
				rs=psd.executeQuery();
				while(rs.next()){
					i=rs.getInt("count(empid)");
					System.out.println(i+"------------------����");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//��������Ա�����־��Ա��һ������ݿ�Ͳ���һ����Ϣ
		public int insertEmpOnecount(int x){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql="insert into empnum values(?)";
				psd=con.prepareStatement(sql);
				psd.setInt(1, x);
				i=psd.executeUpdate();
				System.out.println("i��ֵΪ"+i+"=====================");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//��ʾ��Ա����һ�Ĵ�ֵĴ���
		public int selectOnecount(){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql="select count(empid)from empnum";
				psd=con.prepareStatement(sql);
				rs=psd.executeQuery();
				while(rs.next()){
					i=rs.getInt("count(empid)");
					System.out.println(i+"------------------����");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
	//Ϊ��ֹ����ͬһ���˴����η֣���Ա����һ��
	
		public boolean selectEmpOneName(String name) {
			boolean t = false;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select empname from empgrade where empname=? and empcod=(select count(numid)from empnum)";
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
		//��ֹ��Ա��������ظ��ύ
		public boolean selectEmpTwoName(String name) {
			boolean t = false;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select empname from empgradetwo where empname=? and empcod=(select count(numid)from empnumtwo)";
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
		//��ֹ��Ա��������ͬһ�����ظ���Ա�����
		public boolean selectEmpNewName(String name) {
			boolean t = false;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select empname from newemp where empname=? and empcod=(select count(numid)from empnumnew)";
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
		//��ֹ�ύ��Ա���ڹ�˾�в����ڣ������������������
		public boolean selectErrorName(String name) {
			boolean t = false;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select empname from emplogin where empname=?";
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
