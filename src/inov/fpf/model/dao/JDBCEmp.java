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
			String sql = "select * from emplogin where emploginname=? and empdate<(select ADD_MONTHS(sysdate, -12)from dual)";
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
	//��ѯĳһ����Ա������
	public int empcount(String section){
		int i=0;		
		try {
			con=JDBCUtil.getConnection();
			String sql="select count(empid)from emplogin where empdate>(select ADD_MONTHS(sysdate, -12)from dual) and sectionname=?";
			psd=con.prepareStatement(sql);
			psd.setString(1,section);
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
	//��ѯԱ������
	public int empsum(){
		int i=0;		
		try {
			con=JDBCUtil.getConnection();
			String sql="select count(empid)from emplogin where empdate>(select ADD_MONTHS(sysdate, -12)from dual)";
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
/*	public int empeecount(){
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
	}*/
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
			String sql="select emploginname,department from emplogin where empdate>(select ADD_MONTHS(sysdate, -12)from dual)";
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
	//������Ա����һ��Ҫ��ѯ���Լ����⻹Ҫȥ���Լ��ڱ���д���������ˣ�Ҳ����˵��Ա��������ֶ�ΪASSESSNAME=�Լ��Ķ���������ʾ
	public List<Login>empNameAndDeptOne(String name,String ename,String tname,String section){
		List<Login>list=new ArrayList<Login>();

		try {
			con=JDBCUtil.getConnection();
			String sql="select emploginname,department from emplogin  where  emploginname!=? and emploginname not in(select empname from empgradetwo where assessname=? and empcod=(select count(empid)from empnumtwo)) and emploginname not in(select empname from empgrade where assessname=? and empcod=(select count(empid)from empnum)) and emploginname not in(select empname from empgrade where empcod=(select count(empid)from empnum)) and empdate>(select ADD_MONTHS(sysdate, -12)from dual) and sectionname=?";
			psd=con.prepareStatement(sql);
			psd.setString(1,name);
			psd.setString(2,ename);
			psd.setString(3,tname);
			psd.setString(4,section);
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
	//������Ա����һ��Ҫ��ѯ���Լ����⻹Ҫȥ���Լ��ڱ���д���������ˣ�Ҳ����˵��Ա��������ֶ�ΪASSESSNAME=�Լ��Ķ���������ʾ
		public List<Login>empNameAndDeptThree(String name,String ename,String tname,String section){
			List<Login>list=new ArrayList<Login>();

			try {
				con=JDBCUtil.getConnection();
				String sql="select emploginname,department from emplogin  where  emploginname!=? and emploginname not in(select empname from empgradetwo where assessname=? and empcod=(select count(empid)from empnumtwo)) and emploginname not in(select empname from empgrade where assessname=? and empcod=(select count(empid)from empnum)) and emploginname not in(select empname from empgradetwo where empcod=(select count(empid)from empnumtwo)) and empdate>(select ADD_MONTHS(sysdate, -12)from dual) and sectionname=?";
				psd=con.prepareStatement(sql);
				psd.setString(1,name);
				psd.setString(2,ename);
				psd.setString(3,tname);
				psd.setString(4,section);
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
/*	//������Ա�������Ҫ��ѯ���Լ����⻹Ҫȥ���Լ��ڱ�һ�д���������ˣ�Ҳ����˵��Ա����һ���ֶ�ΪASSESSNAME=�Լ��Ķ���������ʾ
		public List<Login>empNameAndDeptTwo(String name,String ename,String tname){
			List<Login>list=new ArrayList<Login>();

			try {
				con=JDBCUtil.getConnection();
				String sql="select emploginname,department from emplogin  where emploginname!=? and emploginname not in(select empname from empgrade where assessname=? and empcod=(select count(empcod)from empgrade))and emploginname not in(select empname from empgradetwo where assessname=? and empcod=(select count(empcod)from empgradetwo))";
				psd=con.prepareStatement(sql);
				psd.setString(1,name);
				psd.setString(2,ename);
				psd.setString(3,tname);
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
			
		}*/
	//������Ա����һԱ����ѯ���Լ������Ա���������Ͳ���
	public List<Login>empNameAndDept(String name,String section){
		List<Login>list=new ArrayList<Login>();
		try {
			con=JDBCUtil.getConnection();
			String sql="select emploginname,department from emplogin where emploginname!=? and empdate>(select ADD_MONTHS(sysdate, -12)from dual) and sectionname=?";
			psd=con.prepareStatement(sql);
			psd.setString(1,name);
			psd.setString(2, section);
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
	public List<Login>empNameAndDeptMsg(String name){
		List<Login>list=new ArrayList<Login>();
		try {
			con=JDBCUtil.getConnection();
			String sql="select emploginname,department from emplogin where emploginname!=? and empdate>(select ADD_MONTHS(sysdate, -12)from dual)";
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
	//����Ա����һ����Ա�����������һ�ηֺ���ʾ��Ա����һ������
	
	public List<Login>empNameAndDeptTwo(String name,String ename,String tname,String section){
		List<Login>list=new ArrayList<Login>();
		try {
			con=JDBCUtil.getConnection();
			String sql="select emploginname,department from emplogin  where  emploginname!=? and emploginname not in(select empname from empgradetwo where assessname=? and empcod=(select max(empcod)from empgradetwo)) and emploginname not in(select empname from empgrade where assessname=? and empcod=(select max(empcod)from empgrade)) and emploginname not in(select empname from empgradetwo where empcod=(select count(empid)from empnumtwo)) and empdate>(select ADD_MONTHS(sysdate, -12)from dual) and sectionname=?";
			psd=con.prepareStatement(sql);
			psd.setString(1,name);
			psd.setString(2,ename);
			psd.setString(3,tname);
			psd.setString(4, section);
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
	
	public List<Login>empNameAndDeptF(String name,String ename,String tname,String section){
		List<Login>list=new ArrayList<Login>();

		try {
			con=JDBCUtil.getConnection();
			String sql="select emploginname,department from emplogin  where  emploginname!=? and emploginname not in(select empname from empgradetwo where assessname=? and empcod=(select max(empcod)from empgradetwo)) and emploginname not in(select empname from empgrade where assessname=? and empcod=(select max(empcod)from empgrade)) and emploginname not in(select empname from empgrade where empcod=(select count(empid)from empnum)) and empdate>(select ADD_MONTHS(sysdate, -12)from dual) and sectionname=?";
			psd=con.prepareStatement(sql);
			psd.setString(1,name);
			psd.setString(2,ename);
			psd.setString(3,tname);
			psd.setString(4,section);
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
		public List<Login>empNameTwo(String name,String ename){
			List<Login>list=new ArrayList<Login>();

			try {
				con=JDBCUtil.getConnection();
				String sql=" select distinct e.emploginname,e.department from emplogin e,empgradetwo emp where e.emploginname not in(select empname from empgradetwo where empcod=(select max(empcod)from empgradetwo))and e.emploginname not in(select empname from empgrade where assessname=?) and e.emploginname!=?";
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
		//��ʾ��Ա����δ�����������
		public List<Login>empNewName(String name,String section){
			List<Login>list=new ArrayList<Login>();

			try {
				con=JDBCUtil.getConnection();
				String sql=" select distinct e.emploginname,e.department from emplogin e,newemp emp where e.emploginname not in(select empname from newemp where empcod=(select max(empcod)from newemp)) and e.emploginname!=? and e.empdate>(select ADD_MONTHS(sysdate, -12)from dual) and sectionname=?";
				psd=con.prepareStatement(sql);
				psd.setString(1,name);
				psd.setString(2,section);
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
		public List<Login>empTeaName(String name){
			List<Login>list=new ArrayList<Login>();

			try {
				con=JDBCUtil.getConnection();
				String sql=" select distinct e.emploginname,e.department from emplogin e,teacher emp where e.emploginname not in(select empname from teacher where empid=(select max(empid)from teacher)) and teachername=? and empdate>(select ADD_MONTHS(sysdate, -12)from dual)";
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
		//��ѯʦ�����������������
		public int selectEmpTeaCount(String section){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql=" select count(nvl(empid,0))from teacher where sectionname=?";
				psd=con.prepareStatement(sql);
				psd.setString(1, section);
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
		//��ѯ���γ����������������
		public int selectEmpForCount(String section){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql=" select count(nvl(empid,0))from foremengrade where sectionname=?";
				psd=con.prepareStatement(sql);
				psd.setString(1, section);
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
		//��ѯ���γ��ڱ�����δ��ֵ���
		public List<Login>empForName(String name){
			List<Login>list=new ArrayList<Login>();

			try {
				con=JDBCUtil.getConnection();
				String sql=" select distinct e.emploginname,e.department from emplogin e,foremengrade emp where e.emploginname not in(select empname from foremengrade where empid=(select max(empid)from foremengrade)) and e.sectionname=? and e.empdate>(select ADD_MONTHS(sysdate, -12)from dual)";
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
		//��ʾ�������δ����ֵ���
		public List<Login>empMnName(){
			List<Login>list=new ArrayList<Login>();

			try {
				con=JDBCUtil.getConnection();
				String sql=" select distinct e.emploginname,e.department from emplogin e,msggrade emp where e.emploginname not in(select empname from msggrade where emp=(select max(emp)from msggrade)) and empdate>(select ADD_MONTHS(sysdate, -12)from dual)";
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
				String sql = "select empname from empgrade where empname=? and empcod=(select max(empcod)from empgrade)";
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
				String sql = "select empname from empgradetwo where empname=? and empcod=(select count(empid)from empnumtwo)";
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
				String sql = "select empname from newemp where empname=? and empcod=(select count(empid)from empnumnew)";
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
				String sql = "select emploginname from emplogin where emploginname=?";
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
		
		//ʦ����ѯ�����Ա
		public List<Login>teaNameAndDept(String name){
			List<Login>list=new ArrayList<Login>();

			try {
				con=JDBCUtil.getConnection();
				String sql="select emploginname,department from emplogin where teachername=? and empdate>(select ADD_MONTHS(sysdate, -12)from dual)";
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
		//���γ���ѯ�����Ա,ͨ�����κŹ��˳�ͬһ���ε���Ա�����д��
		public List<Login>forNameAndDept(String name){
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
		//��ѯ��Ա����һ���˴�ֵ�������Ҫ����3����
		public int selectOne(String name){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql="select count(assessname)from empgrade where assessname=? and empcod=(select max(empcod) from empgrade)";
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
		//��ѯ��Ա��������˴�ֲ�Ҫ��������
		public int selectTwo(String name){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql="select count(assessname)from empgradetwo where assessname=? and empcod=(select max(empcod) from empgradetwo)";
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
		//��ѯ��Ա�����˴�ֲ�Ҫ��������
		public int selectNew(String name){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql="select count(assessname)from newemp where assessname=? and empcod=(select max(empcod) from newemp)";
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
		//��ѯ��Ա����һ���˴�ֵ�������Ҫ����3����
		public int selectOneA(String name){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql="select count(assessname)from empgrade where assessname=? and empcod=(select count(empid) from empnum)";
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
		//��ѯ��Ա��������˴�ֲ�Ҫ��������
		public int selectTwoB(String name){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql="select count(assessname)from empgradetwo where assessname=? and empcod=(select count(empid) from empnumtwo)";
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
		//��ѯ��Ա�����˴�ֲ�Ҫ��������
		public int selectNewC(String name){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql="select count(assessname)from newemp where assessname=? and empcod=(select count(empid) from empnumnew)";
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
		//��ѯԱ���Ĺ��κ�
		public String selectSection(String name){
			String str=null;
			try {
				con=JDBCUtil.getConnection();
				String sql="select sectionname from emplogin where emploginname=?";
				psd=con.prepareStatement(sql);
				psd.setString(1,name);
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
		//��ѯԱ���Ĺ��κ�
		public String selectTeaSection(String name){
			String str=null;
			try {
				con=JDBCUtil.getConnection();
				String sql="select sectionname from teacherlogin where tloginname=?";
				psd=con.prepareStatement(sql);
				psd.setString(1,name);
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
}
