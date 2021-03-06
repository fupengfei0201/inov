package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCContent;
import inov.fpf.model.dao.JDBCEmp;
import inov.fpf.model.dao.JDBCGradeNum;
import inov.fpf.model.dao.JDBCNum;
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
		//System.out.println("运行Servlet");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String teachername = request.getParameter("detp");
		String comm = request.getParameter("comm");
		JDBCEmp emp = new JDBCEmp();
		JDBCGradeNum gradenum=new JDBCGradeNum();
		String section=emp.selectSection(name);
		System.out.println(name);
		System.out.println(teachername);
		JDBCContent j = new JDBCContent();
		List<TCheckPoints> list1 = j.tCheckPoints();
		List<Integer> l = new ArrayList<Integer>();
		JDBCTeacher t = new JDBCTeacher();
		JDBCNum n=new JDBCNum();
		int sum = 0;
		for (int i = 0; i < list1.size(); i++) {
			
			String grade = request.getParameter("grade" + i);
			System.out.println(grade);
			int x = Integer.parseInt(grade.trim());
			l.add(x);
			sum = sum + x;
		}
		if(sum>100||sum<0){
			List<TCheckPoints> li = j.tCheckPoints();
			request.setAttribute("ls", li);
			request.setAttribute("pname",name);
			request.setAttribute("detp",teachername);
			request.setAttribute("m",
					"<script>alert(\"分数提交有误，不予提交\");</script>");
			System.out.println("分数提交有误");
			//request.setAttribute("msg", "提交失败");
			request.getRequestDispatcher("grade/d.jsp")
					.forward(request, response);
			return;
		}
		boolean f=t.selectName(name);
		double a = emp.empcount(section);
	//	double b=emp.empsum();
		if(f==true){
			request.setAttribute("m",
					"<script>alert(\"已为此员工打过分，请勿再打分 \");</script>");
			System.out.println("已为此员工打过分，请勿再打分");
			//request.setAttribute("msg", "提交失败");
			// 判断师傅的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
			if ((emp.selectEmpTeaCount(section) % a) == 0) {
				List<Login> ll = emp.teaNameAndDept(teachername);
				request.setAttribute("ll", ll);
				//request.setAttribute("msg", "tea");
				request.setAttribute("mk","师傅");
				request.setAttribute("p",n.selectOneT());
				request.setAttribute("q",emp.selectcount());
				request.getRequestDispatcher("empsel.jsp").forward(
						request, response);
				return;
			} else {
				List<Login> ll = emp.empTeaName(teachername);
				request.setAttribute("ll", ll);
				//request.setAttribute("msg", "tea");
				request.setAttribute("mk","师傅");
				request.setAttribute("p",n.selectOneT());
				request.setAttribute("q",emp.selectcount());
				request.getRequestDispatcher("empsel.jsp").forward(
						request, response);
				return;
			}
		}
		System.out.println("aa");
		System.out.println("a的值为："+a);
		int q = emp.selectcount();
		if (sum >= 90) {
			//ss.add(sum);
			gradenum.TeaInsert(1);
			System.out.println("ss的数量为" + ss.size() + "    a的数量为" + a);
			if (gradenum.selectTeaGrate() > (a * 0.3)){
				System.out.println("判断优秀数量超出");
				List<TCheckPoints> li = j.tCheckPoints();
				request.setAttribute("ls", li);
				request.setAttribute("pname",name);
				request.setAttribute("detp",teachername);
				request.setAttribute("m",
						"<script>alert(\"优秀人数超出不予提交，请重新打分 \");</script>");
				System.out.println("优秀人数过多");
				//request.setAttribute("msg", "提交失败");
				request.getRequestDispatcher("grade/d.jsp")
						.forward(request, response);
				return;
			} else {
				Teacher teacher = new Teacher(q, name, teachername, l.get(0),
						l.get(1), l.get(2), l.get(3), l.get(4), l.get(5),
						l.get(6), l.get(7), l.get(8), l.get(9), sum, comm);
				int s = t.tinsert(teacher);
				//lg.add(sum);
				gradenum.TeaInsert(3);
				if (s == 1) {
					List<TCheckPoints> li = j.tCheckPoints();
					request.setAttribute("ls", li);
					request.setAttribute("msg",
							"<script>alert(\"提交成功 \");</script>");
					if (gradenum.selectTeaCount() ==emp.empsum()) {
						//System.out.println(lg.size()+ "=" +emp.empsum());
						//lg.removeAll(lg);
						//System.out.println(lg.size()+ "removeAll()");
						//ss.removeAll(ss);
						//tt.removeAll(tt);
						gradenum.deleteTeaGrade();
						emp.insertcount(1);
						n.oneT(1);
						request.setAttribute("l",
								"<script>alert(\"本次打分完毕！\");</script>");
						}

						// 判断师傅的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
						if ((emp.selectEmpTeaCount(section) % emp.empcount(section)) == 0) {
							List<Login> ll = emp.teaNameAndDept(teachername);
							request.setAttribute("ll", ll);
							//request.setAttribute("msg", "tea");
							request.setAttribute("mk","师傅");
							request.setAttribute("p",n.selectOneT());
							request.setAttribute("q",emp.selectcount());
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;
						} else {
							List<Login> ll = emp.empTeaName(teachername);
							request.setAttribute("ll", ll);
							//request.setAttribute("msg", "tea");
							request.setAttribute("mk","师傅");
							request.setAttribute("p",n.selectOneT());
							request.setAttribute("q",emp.selectcount());
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;
						}
					} 

				else {
					List<TCheckPoints> li = j.tCheckPoints();
					request.setAttribute("ls", li);
					request.setAttribute("pname",name);
					request.setAttribute("detp",teachername);
					request.setAttribute("msg",
							"<script>alert(\"提交失败 \");</script>");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				}
			}

		} else if (sum < 90 && sum >= 80) {
			//tt.add(sum);
			gradenum.TeaInsert(2);
			//System.out.println("tt的数量为" + tt.size());
			if (gradenum.selectTeaGood() > (a * 0.3)) {
				System.out.println("判断等级");
				List<TCheckPoints> li = j.tCheckPoints();
				request.setAttribute("ls", li);
				request.setAttribute("pname",name);
				request.setAttribute("detp",teachername);
				request.setAttribute("l",
						"<script>alert(\"良好人数超出，不予提交，请重新打分！ \");</script>");
				//System.out.println("良好人数过多,不予提交此成绩，请重新打分");
				//request.setAttribute("msg", "提交失败");
				request.getRequestDispatcher("grade/d.jsp")
						.forward(request, response);
			} else {
				Teacher teacher = new Teacher(q, name,teachername, l.get(0),
						l.get(1), l.get(2), l.get(3), l.get(4), l.get(5),
						l.get(6), l.get(7), l.get(8), l.get(9), sum, comm);
				
				//lg.add(sum);
				gradenum.TeaInsert(3);
				int s = t.tinsert(teacher);
				if (s == 1) {
					List<TCheckPoints> li = j.tCheckPoints();
					request.setAttribute("ls", li);
					request.setAttribute("msg",
							"<script>alert(\"提交成功 \");</script>");
					if (gradenum.selectTeaCount() == emp.empsum()) {
						System.out.println(lg.size() + "=" +emp.empsum());
						request.setAttribute("l",
								"<script>alert(\"本次打分完毕！\");</script>");
						//lg.removeAll(lg);
						//System.out.println(lg.size() + "removeAll()");
						//ss.removeAll(ss);
						//tt.removeAll(tt);
						gradenum.deleteTeaGrade();
						emp.insertcount(1);
						n.oneT(1);

					}
					
					// 判断师傅的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
					if ((emp.selectEmpTeaCount(section) % emp.empcount(section)) == 0) {
						List<Login> ll = emp.teaNameAndDept(teachername);
						request.setAttribute("ll", ll);
						//request.setAttribute("msg", "tea");
						request.setAttribute("mk","师傅");
						request.setAttribute("q",emp.selectcount());
						request.setAttribute("p",n.selectOneT());
						request.getRequestDispatcher("empsel.jsp").forward(
								request, response);
						return;
					} else {
						List<Login> ll = emp.empTeaName(teachername);
						request.setAttribute("ll", ll);
						request.setAttribute("mk","师傅");
						request.setAttribute("q",emp.selectcount());
						request.setAttribute("p",n.selectOneT());
						request.getRequestDispatcher("empsel.jsp").forward(
								request, response);
						return;
					}
				}
				else {
					List<TCheckPoints> li = j.tCheckPoints();
					request.setAttribute("ls", li);
					request.setAttribute("pname",name);
					request.setAttribute("detp",teachername);
					request.setAttribute("msg",
							"<script>alert(\"提交失败 \");</script>");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
				}
			}

		} else {
			Teacher teacher = new Teacher(q, name, teachername, l.get(0),
					l.get(1), l.get(2), l.get(3), l.get(4), l.get(5), l.get(6),
					l.get(7), l.get(8), l.get(9), sum, comm);			
			//lg.add(sum);
			gradenum.TeaInsert(3);
			int s = t.tinsert(teacher);
			request.setAttribute("msg", "<script>alert(\"提交成功 \");</script>");
			if (s == 1) {
				List<TCheckPoints> li = j.tCheckPoints();
				request.setAttribute("ls", li);
				if (gradenum.selectTeaCount() == emp.empsum()) {
					System.out.println(lg.size() + "=" +emp.empsum());
					request.setAttribute("l",
							"<script>alert(\"本次打分完毕！\");</script>");
					//lg.removeAll(lg);
				//	System.out.println(lg.size() + "removeAll()");
					//ss.removeAll(ss);
					//tt.removeAll(tt);
					gradenum.deleteTeaGrade();
					emp.insertcount(1);
					n.oneT(1);
				}

				// 判断师傅的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
				if ((emp.selectEmpTeaCount(section) %a) == 0) {
					List<Login> ll = emp.teaNameAndDept(teachername);
					request.setAttribute("ll", ll);
					//request.setAttribute("msg", "tea");
					request.setAttribute("mk","师傅");
					request.setAttribute("q",emp.selectcount());
					request.setAttribute("p",n.selectOneT());
					request.getRequestDispatcher("empsel.jsp").forward(request,
							response);
					return;
				} else {
					List<Login> ll = emp.empTeaName(teachername);
					request.setAttribute("ll", ll);
					//request.setAttribute("msg", "tea");
					request.setAttribute("mk","师傅");
					request.setAttribute("q",emp.selectcount());
					request.setAttribute("p",n.selectOneT());
					request.getRequestDispatcher("empsel.jsp").forward(request,
							response);
					return;
				}
			}
			else {
				List<TCheckPoints> li = j.tCheckPoints();
				request.setAttribute("ls", li);
				request.setAttribute("pname",name);
				request.setAttribute("detp",teachername);
				request.setAttribute("msg",
						"<script>alert(\"提交失败 \");</script>");
				request.getRequestDispatcher("grade/d.jsp")
								.forward(request, response);
				return;
			}
		}
}

	
}
