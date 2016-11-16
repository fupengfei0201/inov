package inov.fpf.model.dao;

import inov.fpf.model.vo.Empcontent;
import inov.fpf.model.vo.MsgCheckContent;
import inov.fpf.model.vo.TCheckPoints;
import inov.fpf.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCContent {
	private Connection con = null;
	private PreparedStatement psd = null;
	private ResultSet rs = null;
	//员工考核内容
	public List<Empcontent>empcontents(){
		List<Empcontent> list=new ArrayList<Empcontent>();
		try {
			con = JDBCUtil.getConnection();
			String sql="select * from empcontent";
			psd=con.prepareStatement(sql);
			rs=psd.executeQuery();
			while(rs.next()){
				Empcontent empcontent=new Empcontent();
		empcontent.setAssessment(rs.getString(1));
		empcontent.setEmpcontent(rs.getString(2));
		empcontent.setMarks(rs.getInt(3));
			list.add(empcontent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return list;
	}
	//师傅考核内容
	public List<TCheckPoints>tCheckPoints(){
		List<TCheckPoints>list=new ArrayList<TCheckPoints>();
	
		
		try {
			con=JDBCUtil.getConnection();
			String sql="select * from tcheckpoints";
			psd=con.prepareStatement(sql);
			rs=psd.executeQuery();
			while(rs.next()){
				TCheckPoints tPoints=new TCheckPoints();
				tPoints.setItem(rs.getString(1));
				tPoints.setElements(rs.getString(2));
				tPoints.setPoints(rs.getString(3));
				tPoints.setMarks(rs.getInt(4));
				list.add(tPoints);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return list;
	}
	//经理考核内容
	public List<MsgCheckContent>msgcontent(){
		List<MsgCheckContent>list=new ArrayList<MsgCheckContent>();
		
		try {
			con=JDBCUtil.getConnection();
			String sql="select * from msgcheckcontent";
			psd=con.prepareStatement(sql);
			rs=psd.executeQuery();
			while(rs.next()){
			MsgCheckContent msgCheckContent=new MsgCheckContent();
			msgCheckContent.setItme(rs.getString(1));
			msgCheckContent.setElements(rs.getString(2));
			msgCheckContent.setDefinition(rs.getString(3));
			msgCheckContent.setPoints(rs.getString(4));
			msgCheckContent.setMarks(rs.getInt(5));
			list.add(msgCheckContent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.closeupdate(con, psd, rs);
		return list;
		
	}
	
}
