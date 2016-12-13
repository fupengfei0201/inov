package inov.fpf.model.dao;

import inov.fpf.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCGradeNum {
	private Connection con = null;
	private PreparedStatement psd = null;
	private ResultSet rs = null;
	//≤Â»Î ˝---------------------------------------------
		public int TeaInsert(int x){
			int i=0;
			
			try {
				con=JDBCUtil.getConnection();
				String sql="insert into teanum values(?)";
				psd=con.prepareStatement(sql);
				psd.setInt(1, x);
				i=psd.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return i;
		}
		public int selectTeaGrate() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(teaid) from teanum where teaid=1";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(teaid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int selectTeaGood() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(teaid) from teanum where teaid=2";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(teaid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int selectTeaCount() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(teaid) from teanum where teaid=3";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(teaid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
	
		public int deleteTeaGrade(){
			int i=0;
			try {
				con = JDBCUtil.getConnection();
				String sql = "delete from teanum";
				psd = con.prepareStatement(sql);
				i=psd.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int MonInsert(int x){
			int i=0;
			
			try {
				con=JDBCUtil.getConnection();
				String sql="insert into monn values(?)";
				psd=con.prepareStatement(sql);
				psd.setInt(1, x);
				i=psd.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return i;
		}
		public int selectMonGrate() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(monid) from monn where monid=1";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(monid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int selectMonGood() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(monid) from monn where monid=2";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(monid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int selectMonCount() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(monid) from monn where monid=3";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(monid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
	
		public int deleteMonGrade(){
			int i=0;
			try {
				con = JDBCUtil.getConnection();
				String sql = "delete from monn";
				psd = con.prepareStatement(sql);
				i=psd.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int EmpOneInsert(int x){
			int i=0;
			
			try {
				con=JDBCUtil.getConnection();
				String sql="insert into emponenum values(?)";
				psd=con.prepareStatement(sql);
				psd.setInt(1, x);
				i=psd.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return i;
		}
		public int selectEmpOneGrate() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(empid) from emponenum where empid=1";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(empid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int selectEmpOneGood() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(empid) from emponenum where empid=2";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(empid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int selectEmpOneCount() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(empid) from emponenum where empid=3";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(empid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
	
		public int deleteEmpOneGrade(){
			int i=0;
			try {
				con = JDBCUtil.getConnection();
				String sql = "delete from emponenum";
				psd = con.prepareStatement(sql);
				i=psd.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int EmpNewInsert(int x){
			int i=0;
			
			try {
				con=JDBCUtil.getConnection();
				String sql="insert into empnewnum values(?)";
				psd=con.prepareStatement(sql);
				psd.setInt(1, x);
				i=psd.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return i;
		}
		public int selectEmpNewGrate() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(empid) from empnewnum where empid=1";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(empid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int selectEmpNewGood() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(empid) from empnewnum where empid=2";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(empid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int selectEmpNewCount() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(empid) from empnewnum where empid=3";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(empid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
	
		public int deleteEmpNewGrade(){
			int i=0;
			try {
				con = JDBCUtil.getConnection();
				String sql = "delete from empnewnum";
				psd = con.prepareStatement(sql);
				i=psd.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int EmpTwoInsert(int x){
			int i=0;
			
			try {
				con=JDBCUtil.getConnection();
				String sql="insert into emptwonum values(?)";
				psd=con.prepareStatement(sql);
				psd.setInt(1, x);
				i=psd.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return i;
		}
		public int selectEmpTwoGrate() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(empid) from emptwonum where empid=1";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(empid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int selectEmpTwoGood() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(empid) from emptwonum where empid=2";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(empid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int selectEmpTwoCount() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(empid) from emptwonum where empid=3";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(empid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
	
		public int deleteEmpTwoGrade(){
			int i=0;
			try {
				con = JDBCUtil.getConnection();
				String sql = "delete from emptwonum";
				psd = con.prepareStatement(sql);
				i=psd.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int ForemenInsert(int x){
			int i=0;
			
			try {
				con=JDBCUtil.getConnection();
				String sql="insert into fmnum values(?)";
				psd=con.prepareStatement(sql);
				psd.setInt(1, x);
				i=psd.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return i;
		}
		
		public int selectForemenGrate() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(fmid) from fmnum where fmid=1";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(fmid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		
		public int selectForemenGood() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(fmid) from fmnum where fmid=2";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(fmid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		
		public int selectForemenCount() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(fmid) from fmnum where fmid=3";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(fmid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}

		public int deleteForemenGrade(){
			int i=0;
			try {
				con = JDBCUtil.getConnection();
				String sql = "delete from fmnum";
				psd = con.prepareStatement(sql);
				i=psd.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int MngInsert(int x){
			int i=0;
			
			try {
				con=JDBCUtil.getConnection();
				String sql="insert into mngnum values(?)";
				psd=con.prepareStatement(sql);
				psd.setInt(1, x);
				i=psd.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return i;
		}
		public int selectMngGrate() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(mngid) from mngnum where mngid=1";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(mngid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int selectMngGood() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(mngid) from mngnum where mngid=2";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(mngid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}
		public int selectMngCount() {
			int i=0;

			try {
				con = JDBCUtil.getConnection();
				String sql = "select count(mngid) from mngnum where mngid=3";
				psd = con.prepareStatement(sql);
				rs = psd.executeQuery();
			while(rs.next()){
				i=rs.getInt("count(mngid)");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}

		public int deleteMngGrade(){
			int i=0;
			try {
				con = JDBCUtil.getConnection();
				String sql = "delete from mngnum";
				psd = con.prepareStatement(sql);
				i=psd.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeupdate(con, psd, rs);
			return i;
		}

}
