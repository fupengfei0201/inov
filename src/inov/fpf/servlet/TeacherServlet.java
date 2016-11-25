package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCContent;
import inov.fpf.model.dao.JDBCEmp;
import inov.fpf.model.dao.JDBCTeacher;
import inov.fpf.model.vo.Login;
import inov.fpf.model.vo.TCheckPoints;
import inov.fpf.model.vo.Teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TeacherServlet
 */
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 判断某一次提交的次数，与所有员工数量进行比较，大于员工数量时重新置0；
	private List<Integer> lg;
	private List<Integer> ss;
	// 对良好的人数进行控制
	private List<Integer> tt;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		lg = new ArrayList<Integer>();
		ss = new ArrayList<Integer>();

		tt = new ArrayList<Integer>();

		System.out.println("init()运行");
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
		// TODO Auto-generated method stub
		System.out.println("运行Servlet");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String teachername = request.getParameter("detp");
		String comm = request.getParameter("comm");
		System.out.println(name);
		System.out.println(teachername);
		JDBCContent j = new JDBCContent();
		List<TCheckPoints> list1 = j.tCheckPoints();
		List<Integer> l = new ArrayList<Integer>();
		JDBCTeacher t = new JDBCTeacher();
		JDBCEmp emp = new JDBCEmp();
		/*boolean f=t.selectName(name);
		boolean h=emp.selectErrorName(name);
		if(h==false){
			List<TCheckPoints> li = j.tCheckPoints();
			request.setAttribute("ls", li);
			request.setAttribute("m",
					"<script>alert(\"查无此员工请查看员工姓名输入是否有误\");</script>");
			System.out.println("查无此员工请查看员工姓名输入是否有误！");
			//request.setAttribute("msg", "提交失败");
			request.getRequestDispatcher("d.jsp")
					.forward(request, response);	
			return;
		}
		if(f==true){
			List<TCheckPoints> li = j.tCheckPoints();
			request.setAttribute("ls", li);
			request.setAttribute("m",
					"<script>alert(\"此员工在本次打分中您已提交过分数，请给其他员工打分！\");</script>");
			System.out.println("你本次已打过此人的分数，请重新打分！");
			//request.setAttribute("msg", "提交失败");
			request.getRequestDispatcher("d.jsp")
					.forward(request, response);	
			return;
		}*/
		int sum = 0;
		for (int i = 0; i < list1.size(); i++) {
			
			String grade = request.getParameter("grade" + i);
			System.out.println(grade);
			int x = Integer.parseInt(grade.trim());
			l.add(x);
			sum = sum + x;

		}
		System.out.println("aa");
		double a = emp.empcount();
		System.out.println("a的值为："+a);
		int q = emp.selectcount();
		if (sum >= 90) {
			ss.add(sum);
			System.out.println("ss的数量为" + ss.size() + "    a的数量为" + a);

			if (ss.size() > (a * 0.3)) {
				System.out.println("判断优秀数量超出");
				List<TCheckPoints> li = j.tCheckPoints();
				request.setAttribute("ls", li);
				request.setAttribute("pname",name);
				request.setAttribute("detp",teachername);
			
				request.setAttribute("m",
						"<script>alert(\"优秀人数超出不予提交，请重新打分 \");</script>");
				System.out.println("优秀人数过多");
				//request.setAttribute("msg", "提交失败");
				request.getRequestDispatcher("d.jsp")
						.forward(request, response);
			} else {
				Teacher teacher = new Teacher(q, name, teachername, l.get(0),
						l.get(1), l.get(2), l.get(3), l.get(4), l.get(5),
						l.get(6), l.get(7), l.get(8), l.get(9), sum, comm);
				
				
				int s = t.tinsert(teacher);
				lg.add(sum);
				if (s == 1) {
					List<TCheckPoints> li = j.tCheckPoints();
					request.setAttribute("ls", li);
					if (lg.size() == a) {
						System.out.println(lg.size() + "=" + a);
						request.setAttribute("l",
								"<script>alert(\"本次打分完毕！\");</script>");
						lg.removeAll(lg);
						System.out.println(lg.size() + "removeAll()");
						ss.removeAll(ss);
						tt.removeAll(tt);
						
						emp.insertcount(1);
						request.setAttribute("msg",
								"<script>alert(\"提交成功 \");</script>");
						}

						// 判断师傅的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
						if ((emp.selectEmpTeaCount() % a) == 0) {
							List<Login> ll = emp.empNameAndDept();
							request.setAttribute("ll", ll);
							//request.setAttribute("msg", "tea");
							request.setAttribute("mk","师傅");
							request.setAttribute("q",emp.selectcount());
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
						} else {
							List<Login> ll = emp.empTeaName();
							request.setAttribute("ll", ll);
							//request.setAttribute("msg", "tea");
							request.setAttribute("mk","师傅");
							request.setAttribute("q",emp.selectcount());
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
						}
					} 

				else {
					List<TCheckPoints> li = j.tCheckPoints();
					request.setAttribute("ls", li);
					request.setAttribute("pname",name);
					request.setAttribute("detp",teachername);
					request.setAttribute("msg",
							"<script>alert(\"提交失败 \");</script>");
					request.getRequestDispatcher("d.jsp").forward(request,
							response);
				}
			}

		} else if (sum < 90 && sum >= 80) {

			tt.add(sum);

			System.out.println("tt的数量为" + tt.size());
			if (tt.size() > (a * 0.3)) {
				System.out.println("判断等级");
				List<TCheckPoints> li = j.tCheckPoints();
				request.setAttribute("ls", li);
				request.setAttribute("pname",name);
				request.setAttribute("detp",teachername);
				request.setAttribute("l",
						"<script>alert(\"良好人数超出，不予提交，请重新打分！ \");</script>");
				System.out.println("良好人数过多,不予提交此成绩，请重新打分");
				//request.setAttribute("msg", "提交失败");
				request.getRequestDispatcher("d.jsp")
						.forward(request, response);
			} else {
				Teacher teacher = new Teacher(q, name, teachername, l.get(0),
						l.get(1), l.get(2), l.get(3), l.get(4), l.get(5),
						l.get(6), l.get(7), l.get(8), l.get(9), sum, comm);
				
				lg.add(sum);
				int s = t.tinsert(teacher);
				if (s == 1) {
					List<TCheckPoints> li = j.tCheckPoints();
					request.setAttribute("ls", li);
					if (lg.size() == a) {
						System.out.println(lg.size() + "=" + a);
						request.setAttribute("l",
								"<script>alert(\"本次打分完毕！\");</script>");
						lg.removeAll(lg);
						System.out.println(lg.size() + "removeAll()");
						ss.removeAll(ss);
						tt.removeAll(tt);
						emp.insertcount(1);

					}
					request.setAttribute("msg",
							"<script>alert(\"提交成功 \");</script>");
					// 判断师傅的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
					if ((emp.selectEmpTeaCount() % a) == 0) {
						List<Login> ll = emp.empNameAndDept();
						request.setAttribute("ll", ll);
						//request.setAttribute("msg", "tea");
						request.setAttribute("mk","师傅");
						request.setAttribute("q",emp.selectcount());
						request.getRequestDispatcher("empsel.jsp").forward(
								request, response);
					} else {
						List<Login> ll = emp.empTeaName();
						request.setAttribute("ll", ll);
						//request.setAttribute("msg", "tea");
						request.setAttribute("mk","师傅");
						request.setAttribute("q",emp.selectcount());
						request.getRequestDispatcher("empsel.jsp").forward(
								request, response);
					}
				}

				else {
					List<TCheckPoints> li = j.tCheckPoints();
					request.setAttribute("ls", li);
					request.setAttribute("pname",name);
					request.setAttribute("detp",teachername);
					request.setAttribute("msg",
							"<script>alert(\"提交失败 \");</script>");
					request.getRequestDispatcher("d.jsp").forward(request,
							response);
				}
			}

		} else {
			Teacher teacher = new Teacher(q, name, teachername, l.get(0),
					l.get(1), l.get(2), l.get(3), l.get(4), l.get(5), l.get(6),
					l.get(7), l.get(8), l.get(9), sum, comm);
			
			lg.add(sum);
			int s = t.tinsert(teacher);
			request.setAttribute("msg", "<script>alert(\"提交成功 \");</script>");
			if (s == 1) {
				List<TCheckPoints> li = j.tCheckPoints();
				request.setAttribute("ls", li);
				if (lg.size() == a) {
					System.out.println(lg.size() + "=" + a);
					request.setAttribute("l",
							"<script>alert(\"本次打分完毕！\");</script>");
					lg.removeAll(lg);
					System.out.println(lg.size() + "removeAll()");
					ss.removeAll(ss);
					tt.removeAll(tt);
					emp.insertcount(1);
				}

				// 判断师傅的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
				if ((emp.selectEmpTeaCount() %a) == 0) {
					List<Login> ll = emp.empNameAndDept();
					request.setAttribute("ll", ll);
					//request.setAttribute("msg", "tea");
					request.setAttribute("mk","师傅");
					request.setAttribute("q",emp.selectcount());
					request.getRequestDispatcher("empsel.jsp").forward(request,
							response);
				} else {
					List<Login> ll = emp.empTeaName();
					request.setAttribute("ll", ll);
					//request.setAttribute("msg", "tea");
					request.setAttribute("mk","师傅");
					request.setAttribute("q",emp.selectcount());
					request.getRequestDispatcher("empsel.jsp").forward(request,
							response);
				}
			}

			else {
				List<TCheckPoints> li = j.tCheckPoints();
				request.setAttribute("ls", li);
				request.setAttribute("pname",name);
				request.setAttribute("detp",teachername);
				request.setAttribute("msg",
						"<script>alert(\"提交失败 \");</script>");
				request.getRequestDispatcher("d.jsp")
						.forward(request, response);
			}
		}
}
}
