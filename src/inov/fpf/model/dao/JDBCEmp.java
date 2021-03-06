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
	//判断员工登陆
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
	//查询新老员工
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
	//增加新员工表打分
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
	//增加老员工二表打分
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
	//增加老员工一表打分
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
	//查询某一工段员工数量
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
	//查询员工数量
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
	//员工的标记
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
	//每打完所有员工的分数一次，数据库中标志师傅打分的数据库就插入一条信息
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
	//师傅打分的次数
	public int selectcount(){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql="select count(numid)from countnum";
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
	//经理和师傅查询所有员工
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
	//对于老员工表一需要查询除自己以外还要去除自己在表二中打过分数的人，也就是说老员工表二中字段为ASSESSNAME=自己的都不可以显示
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
	//对于老员工表一需要查询除自己以外还要去除自己在表二中打过分数的人，也就是说老员工表二中字段为ASSESSNAME=自己的都不可以显示
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
/*	//对于老员工表二需要查询除自己以外还要去除自己在表一中打过分数的人，也就是说老员工表一中字段为ASSESSNAME=自己的都不可以显示
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
	//对于老员工表一员工查询除自己以外的员工的姓名和部门
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
	//当老员工表一和老员工表二都打完一次分后，显示老员工表一的内容
	
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
	
	
	
	
	
	//老员工一表查询打分后员工在打分表的数量
	public int selectEmpOnecount(){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql=" select count(nvl(empcod,0))from empgrade";
			psd=con.prepareStatement(sql);
			rs=psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(nvl(empcod,0))");
				System.out.println(i+"------------------数量");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//查询老员工二表打分的员工数量
	public int selectEmpTwocount(){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql=" select count(nvl(empcod,0))from empgradetwo";
			psd=con.prepareStatement(sql);
			rs=psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(nvl(empcod,0))");
				System.out.println(i+"------------------数量");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//查询新员工中打分的数量
	public int selectEmpNewCount(String section){
		int i=0;
		try {
			con=JDBCUtil.getConnection();
			String sql=" select count(nvl(n.empcod,0))from newemp n,emplogin emp where emp.sectionname=? and n.empname=emp.emploginname";
			psd=con.prepareStatement(sql);
			psd.setString(1,section);
			rs=psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(nvl(n.empcod,0))");
				System.out.println(i+"------------------数量");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//显示老员工一表中未打分人员
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
	//显示老员工二表中未打分人员
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
		//显示新员工中未打过分数的人
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
		//显示师傅表中未打过分的人
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
		//查询师傅打过分人数的总数
		public int selectEmpTeaCount(String section){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql=" select count(nvl(t.empid,0))from teacher t,emplogin emp where emp.sectionname=? and t.empname=emp.emploginname";
				psd=con.prepareStatement(sql);
				psd.setString(1, section);
				rs=psd.executeQuery();
				while(rs.next()){
					i=rs.getInt("count(nvl(t.empid,0))");
					System.out.println(i+"------------------数量");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//查询工段长打过分人数的总数
		public int selectEmpForCount(String section){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql=" select count(nvl(f.empid,0))from foremengrade f,emplogin emp where emp.sectionname=? and emp.emploginname=f.empname";
				psd=con.prepareStatement(sql);
				psd.setString(1, section);
				rs=psd.executeQuery();
				while(rs.next()){
					i=rs.getInt("count(nvl(f.empid,0))");
					System.out.println(i+"------------------数量");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//查询工段长在本次中未打分的人
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
		//查询经理打过分人数的总数
		public int selectEmpMnCount(){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql=" select count(nvl(emp,0))from msggrade";
				psd=con.prepareStatement(sql);
				rs=psd.executeQuery();
				while(rs.next()){
					i=rs.getInt("count(nvl(emp,0))");
					System.out.println(i+"------------------数量");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//显示经理表中未打过分的人
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
		//打完所有员工后标志新员工表的数据库就插入一条信息
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
				//显示新员工表的打分的次数
				public int selectNewcount(){
					int i=0;
					try {
						con=JDBCUtil.getConnection();
						String sql="select count(empid)from empnumnew";
						psd=con.prepareStatement(sql);
						rs=psd.executeQuery();
						while(rs.next()){
							i=rs.getInt("count(empid)");
							System.out.println(i+"------------------数量");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return i;
				}
		//打完所有员工后标志老员工二表的数据库就插入一条信息
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
		//显示老员工表二的打分的次数
		public int selectTwocount(){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql="select count(empid)from empnumtwo";
				psd=con.prepareStatement(sql);
				rs=psd.executeQuery();
				while(rs.next()){
					i=rs.getInt("count(empid)");
					System.out.println(i+"------------------数量");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//打完所有员工后标志老员工一表的数据库就插入一条信息
		public int insertEmpOnecount(int x){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql="insert into empnum values(?)";
				psd=con.prepareStatement(sql);
				psd.setInt(1, x);
				i=psd.executeUpdate();
				System.out.println("i的值为"+i+"=====================");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//显示老员工表一的打分的次数
		public int selectOnecount(){
			int i=0;
			try {
				con=JDBCUtil.getConnection();
				String sql="select count(empid)from empnum";
				psd=con.prepareStatement(sql);
				rs=psd.executeQuery();
				while(rs.next()){
					i=rs.getInt("count(empid)");
					System.out.println(i+"------------------数量");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
	//为防止输入同一个人打两次分，老员工表一中
	
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
		//防止老员工表二中重复提交
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
		//防止新员工表中在同一次中重复给员工打分
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
		//防止提交的员工在公司中不存在，或者是人名输入错误
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
		
		//师傅查询打分人员
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
		//工段长查询打分人员,通过工段号过滤出同一工段的人员，进行打分
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
		//查询老员工表一个人打分的人数不要超过3个人
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
					System.out.println(i+"------------------数量");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//查询老员工表二个人打分不要超过三人
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
					System.out.println(i+"------------------数量");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//查询新员工个人打分不要超过三人
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
					System.out.println(i+"------------------数量");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//查询老员工表一个人打分的人数不要超过3个人
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
					System.out.println(i+"------------------数量");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//查询老员工表二个人打分不要超过三人
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
					System.out.println(i+"------------------数量");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//查询新员工个人打分不要超过三人
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
					System.out.println(i+"------------------数量");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//查询员工的工段号
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
		//查询员工的工段号
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
