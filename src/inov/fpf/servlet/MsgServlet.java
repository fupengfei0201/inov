package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCContent;
import inov.fpf.model.dao.JDBCEmp;
import inov.fpf.model.dao.JDBCGradeNum;
import inov.fpf.model.dao.JDBCMsg;
import inov.fpf.model.dao.JDBCNum;
import inov.fpf.model.vo.Login;
import inov.fpf.model.vo.MsgCheckContent;
import inov.fpf.model.vo.Msggrade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MsgServlet
 */
public class MsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MsgServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		session.setAttribute("T","a");
		String tilte=(String)session.getAttribute("title");
		String name = request.getParameter("name");
		// System.out.println("------------------------"+name);
		String dept = request.getParameter("dept");
		String mag = request.getParameter("mag");
		String station = request.getParameter("station");
		// System.out.println(station);
		String comm = request.getParameter("comm");
		JDBCContent com = new JDBCContent();
		JDBCMsg m = new JDBCMsg();
		JDBCEmp e = new JDBCEmp();
		JDBCNum n=new JDBCNum();
		JDBCGradeNum mngnum = new JDBCGradeNum();
		double t = e.empsum();

		// 通过查询员工的数量对优秀人数进行控制
	
		int q = m.selectcount();
	boolean f =m.selectMnName(name);
	/*	boolean h=e.selectErrorName(name);
		if(h==false){
			List<MsgCheckContent> li = com.msgcontent();
			request.setAttribute("list", li);
			request.setAttribute("m",
					"<script>alert(\"查无此员工，请查看员工姓名输入是否有误！\");</script>");
			System.out.println("查无此员工，请查看员工姓名输入是否有误！");
			// request.setAttribute("msg","提交失败");
			request.getRequestDispatcher("grade/d.jsp")
					.forward(request, response);
			return;
		}*/
		if(f==true){
			List<MsgCheckContent> li = com.msgcontent();
			request.setAttribute("list", li);
			request.setAttribute("m",
					"<script>alert(\"本次您已为此员工打过分，请为其他员工打分！\");</script>");
			System.out.println("打过此人的分数，请重新打分");
			// request.setAttribute("msg","提交失败");
			//判断经理的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
			if(e.selectEmpMnCount()%t==0){
				List<Login>ll=e.empNameAndDept();
				//request.setAttribute("msg",name);
				request.setAttribute("ll",ll);
				request.setAttribute("mk","经理");
				request.setAttribute("q",q);
				request.setAttribute("p",n.selectOneM());
				session.setAttribute("list","0");
				//session.setAttribute("T","a");
				request.getRequestDispatcher("empsel.jsp").forward(request, response);
				return;
			}
			else{
				List<Login>ll=e.empMnName();
				request.setAttribute("ll",ll);
				//request.setAttribute("msg",name);
				request.setAttribute("mk","经理");
				request.setAttribute("q",q);
				request.setAttribute("p",n.selectOneM());
				session .setAttribute("list","0");
				request.getRequestDispatcher("empsel.jsp").forward(request, response);
				return;
			}
		
		}
		List<MsgCheckContent> list1 = com.msgcontent();
		List<Integer> l = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 0; i < list1.size(); i++) {
			String grade = request.getParameter("grade" + i);
			int x = Integer.parseInt(grade);
			l.add(x);
			sum = sum + x;
		}
		
		
		if (sum >= 90) {
			//ss.add(sum);
			mngnum.MngInsert(1);
			if (mngnum.selectMngGrate()  > t * 0.3) {
				List<MsgCheckContent> li = com.msgcontent();
				request.setAttribute("list", li);
				request.setAttribute("pname",name);
				request.setAttribute("dept",dept);
				request.setAttribute("name",mag);
				request.setAttribute("m",
						"<script>alert(\"优秀人数过多，不予提交此分数，请重新打分！\");</script>");
				System.out.println("优秀人数过的");
				
				// request.setAttribute("msg","提交失败");
				request.getRequestDispatcher("grade/d.jsp")
						.forward(request, response);
			} else {
				Msggrade ms = new Msggrade(q, name, mag, dept, station,
						l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
						l.get(5), l.get(6), l.get(7), sum, comm);

				int s = m.msgInsert(ms);
				//lg.add(sum);
				mngnum.MngInsert(3);

				if (s == 1) {
					List<MsgCheckContent> li = com.msgcontent();
					request.setAttribute("list", li);
					request.setAttribute("msg",
							"<script>alert(\"提交成功 \");</script>");
					System.out.println("提交成功");
					if (mngnum.selectMngCount()  == e.empsum()) {
						//System.out.println("lg的数量为："+lg.size());
						request.setAttribute("l",
								"<script>alert(\"本次您已评分完毕 \");</script>");
//						lg.removeAll(lg);
//						System.out.println("remove lg的数量为："+lg.size());
//						ss.removeAll(ss);
//						System.out.println("remove ss的数量为："+ss.size());
//						tt.removeAll(tt);
						mngnum.deleteMngGrade();
						m.insertcount(1);
					}
					//判断经理的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
					if(e.selectEmpMnCount()%t==0){
						List<Login>ll=e.empNameAndDept();
						//request.setAttribute("msg",name);
						request.setAttribute("ll",ll);
						request.setAttribute("mk","经理");
						request.setAttribute("q",q);
						request.setAttribute("p",n.selectOneM());
						session.setAttribute("list","0");
						//session.setAttribute("T","a");
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
					}
					else{
						List<Login>ll=e.empMnName();
						request.setAttribute("ll",ll);
						//request.setAttribute("msg",name);
						request.setAttribute("mk","经理");
						request.setAttribute("q",q);
						request.setAttribute("p",n.selectOneM());
						session .setAttribute("list","0");
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
					}
				} else {
					List<MsgCheckContent> li = com.msgcontent();
					request.setAttribute("list", li);
					request.setAttribute("pname",name);
					request.setAttribute("dept",dept);
					request.setAttribute("name",mag);
					request.setAttribute("msg",
							"<script>alert(\"提交失败 \");</script>");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
				}
			}

		} else if (sum < 90 && sum >= 80) {
			//tt.add(sum);
			mngnum.MngInsert(2);

			if (mngnum.selectMngGood()  > t * 0.3) {
				//System.out.println("tt的数量："+tt.size());
				List<MsgCheckContent> li = com.msgcontent();
				request.setAttribute("list", li);
				request.setAttribute("pname",name);
				request.setAttribute("dept",dept);
				request.setAttribute("name",mag);
				request.setAttribute("m",
						"<script>alert(\"良好人数过多，不予提交此成绩！ \");</script>");
				System.out.println("良好人数过多，不予提交此成绩！");
				//request.setAttribute("msg", "提交失败");
				request.getRequestDispatcher("grade/d.jsp")
						.forward(request, response);
			} else {
				Msggrade ms = new Msggrade(q, name, mag, dept, station,
						l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
						l.get(5), l.get(6), l.get(7), sum, comm);

				int s = m.msgInsert(ms);
				//lg.add(sum);
				mngnum.MngInsert(3);
				if (s == 1) {
					List<MsgCheckContent> li = com.msgcontent();
					request.setAttribute("list", li);
					request.setAttribute("msg",
							"<script>alert(\"提交成功 \");</script>");
					System.out.println("提交成功");
					if (mngnum.selectMngCount()  == e.empsum()) {
						//System.out.println("lg的数量为："+lg.size());
						request.setAttribute("l",
								"<script>alert(\"本次您已评分完毕 \");</script>");
						System.out.println("本次您已评分完毕");
//						lg.removeAll(lg);
//						System.out.println("remove lg的数量为："+lg.size());
//						ss.removeAll(ss);
//						System.out.println("remove ss的数量为："+ss.size());
//						tt.removeAll(tt);
//						System.out.println("remove tt的数量为："+tt.size());
						mngnum.deleteMngGrade();
						m.insertcount(1);
					}
					if(e.selectEmpMnCount()%t==0){
						List<Login>ll=e.empNameAndDept();
						//request.setAttribute("msg",name);
						request.setAttribute("ll",ll);
						request.setAttribute("mk","经理");
						request.setAttribute("q",q);
						request.setAttribute("p",n.selectOneM());
						session.setAttribute("list","0");
						//session.setAttribute("T","a");
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
					}
					else{
						List<Login>ll=e.empMnName();
						request.setAttribute("ll",ll);
						//request.setAttribute("msg",name);
						request.setAttribute("mk","经理");
						request.setAttribute("q",q);
						request.setAttribute("p",n.selectOneM());
						session .setAttribute("list","0");
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
					}
				
				} else {
					List<MsgCheckContent> li = com.msgcontent();
					request.setAttribute("list", li);
					request.setAttribute("msg",
							"<script>alert(\"提交失败 \");</script>");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
				}
			}
		} else {
			Msggrade ms = new Msggrade(q, name, mag, dept, station, l.get(0),
					l.get(1), l.get(2), l.get(3), l.get(4), l.get(5), l.get(6),
					l.get(7), sum, comm);
			int s = m.msgInsert(ms);
			mngnum.MngInsert(3);
			if (s == 1) {
				List<MsgCheckContent> li = com.msgcontent();
				request.setAttribute("list", li);
				request.setAttribute("msg",
						"<script>alert(\"提交成功 \");</script>");
				System.out.println("提交成功");
				if (mngnum.selectMngCount()== t) {
					//System.out.println("lg数量为"+lg.size());
					request.setAttribute("l",
							"<script>alert(\"本次您已评分完毕 \");</script>");
					System.out.println("本次您已评分完毕");
					
//					lg.removeAll(lg);
//					System.out.println("lg移除后数量为"+lg.size());
//					ss.removeAll(ss);
//					System.out.println("ss移除后数量为"+ss.size());
//					tt.removeAll(tt);
//					System.out.println("tt移除后数量为"+tt.size());
					mngnum.deleteMngGrade();
					m.insertcount(1);
				}
				if(e.selectEmpMnCount()%t==0){
					List<Login>ll=e.empNameAndDept();
					//request.setAttribute("msg",name);
					request.setAttribute("ll",ll);
					request.setAttribute("mk","经理");
					request.setAttribute("q",q);
					request.setAttribute("p",n.selectOneM());
					session.setAttribute("list","0");
					//session.setAttribute("T","a");
					request.getRequestDispatcher("empsel.jsp").forward(request, response);
					return;
				}
				else{
					List<Login>ll=e.empMnName();
					request.setAttribute("ll",ll);
					//request.setAttribute("msg",name);
					request.setAttribute("mk","经理");
					request.setAttribute("q",q);
					request.setAttribute("p",n.selectOneM());
					session .setAttribute("list","0");
					request.getRequestDispatcher("empsel.jsp").forward(request, response);
					return;
				}
			
			} else {
				List<MsgCheckContent> li = com.msgcontent();
				request.setAttribute("list", li);
				request.setAttribute("pname",name);
				request.setAttribute("dept",dept);
				request.setAttribute("name",mag);
				request.setAttribute("msg",
						"<script>alert(\"提交失败 \");</script>");
				request.getRequestDispatcher("grade/d.jsp")
						.forward(request, response);
			}
		}
	}
}
