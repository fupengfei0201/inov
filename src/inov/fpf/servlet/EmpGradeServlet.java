package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCContent;
import inov.fpf.model.dao.JDBCEmp;
import inov.fpf.model.dao.JDBCGradeNum;
import inov.fpf.model.dao.JDBCNum;
import inov.fpf.model.vo.Empcontent;
import inov.fpf.model.vo.Empgrade;
import inov.fpf.model.vo.Login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmpGradeServlet
 */
public class EmpGradeServlet extends HttpServlet {
	// 判断某一次提交的次数，与所有员工数量进行比较，大于员工数量时重新置0；
	private List<Integer> lg;
	private List<Integer> ss;
	// 对良好的人数进行控制
	private List<Integer> tt;

	/*
	 * private List<Integer>ls; private List<Integer>se; private
	 * List<Integer>te;
	 */

	private List<Integer> lx;
	private List<Integer> sf;
	private List<Integer> td;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpGradeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		lg = new ArrayList<Integer>();
		// ls=new ArrayList<Integer>();
		ss = new ArrayList<Integer>();
		tt = new ArrayList<Integer>();
		// se=new ArrayList<Integer>();
		// te=new ArrayList<Integer>();
		lx = new ArrayList<Integer>();
		sf = new ArrayList<Integer>();
		td = new ArrayList<Integer>();
		System.out.println("init()运行");
		super.init();

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
		// List<Empcontent>list=(ArrayList<Empcontent>)request.getAttribute("list");
		JDBCContent j = new JDBCContent();
		System.out.println("============================================");
		List<Empcontent> list1 = j.empcontents();
		List<Integer> l = new ArrayList<Integer>();
		HttpSession session = request.getSession();
		String ename = (String) session.getAttribute("name");
		// System.out.println(ename);
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		JDBCEmp e = new JDBCEmp();
		JDBCGradeNum gradenum=new JDBCGradeNum();
		String section=e.selectSection(ename);
		System.out.println(list1.size());
		int sum = 0;
		for (int x = 0; x < list1.size(); x++) {
			int i;
			String grade = request.getParameter("grade" + x);
			System.out.println(grade);
			i = Integer.parseInt(grade);
			l.add(i);
			sum = sum + i;
		}

		if (sum > 100 || sum < 0) {
			List<Empcontent> list = j.empcontents();
			request.setAttribute("list", list);
			request.setAttribute("pname", name);
			request.setAttribute("dept", dept);
			request.setAttribute("msg",
					"<script>alert(\"分数提交有误，不予提交！\");</script>");
			System.out.println("分数提交");
			request.getRequestDispatcher("grade/grade/d.jsp").forward(request,
					response);
			return;
		}
		
		double t = e.empcount(section);
		int sx = e.selectOnecount();
		//int two = e.selectTwocount();
		int news = e.selectNewcount();
		JDBCNum n = new JDBCNum();
		System.out.println(t);
		System.out.println(lg.size());
		boolean f = e.selectEmpOneName(name);
		if (session.getAttribute("r").equals("oldone")) {
		
			/*
			 * //boolean h=e.selectErrorName(name); if(h==false){
			 * List<Empcontent> list = j.empcontents();
			 * request.setAttribute("list", list); request.setAttribute("msg",
			 * "<script>alert(\"查无此员工，请查看输入的姓名是否有误！\");</script>");
			 * System.out.println("查无此员工，请查看输入的姓名是否有误！");
			 * request.getRequestDispatcher("grade/d.jsp").forward(request, response);
			 * return; }
			 */
			if (f == true) {
				request.setAttribute("m",
						"<script>alert(\"在本次评分中此员工已打过分，请给其他员工打分！\");</script>");
				System.out.println("重复提交了员工得分");
				if (e.selectOnecount() == e.selectTwocount()) {
					// 显示除自己以外的表二中自己未打分的的所有人全部显示

					List<Login> ll = e.empNameAndDeptOne(ename, ename, ename,section);
					// 显示所有老员工，对表二进行打分
					List<Login> lw = e.empNameAndDeptThree(ename, ename, ename,section);
					if (n.selectOneEmpA() == n.selectOneEmpB()) {
						request.setAttribute("p", n.selectOneEmpA());
					} else if (n.selectOneEmpA() < n.selectOneEmpB()) {
						request.setAttribute("p", n.selectOneEmpA());
					} else {
						request.setAttribute("p", n.selectOneEmpB());
					}
					int q = e.selectOnecount();
					if ((e.selectOneA(ename) + e.selectTwoB(ename)) < 3) {
						request.setAttribute("ll", ll);
						request.setAttribute("lw", lw);

					} else {
						request.setAttribute("ll", "1");
						request.setAttribute("lw", "1");
						request.setAttribute("m",
								"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
					}
					request.setAttribute("mk", "老员工");
					request.setAttribute("q", q);
					request.getRequestDispatcher("empsel.jsp").forward(request,
							response);
					return;

				} else if (e.selectOnecount() > e.selectTwocount()) {

					// 显示所有老员工，对表二进行打分
					List<Login> lw = e.empNameAndDeptTwo(ename, ename, ename,section);

					int q = e.selectTwocount();
					if (n.selectOneEmpA() == n.selectOneEmpB()) {
						request.setAttribute("p", n.selectOneEmpA());
					} else if (n.selectOneEmpA() < n.selectOneEmpB()) {
						request.setAttribute("p", n.selectOneEmpA());
					} else {
						request.setAttribute("p", n.selectOneEmpB());
					}
					if ((e.selectOne(ename) + e.selectTwoB(ename)) < 3) {

						request.setAttribute("lw", lw);

						request.setAttribute("ll", "1");
					} else {
						request.setAttribute("ll", "1");
						request.setAttribute("lw", "1");
						request.setAttribute("m",
								"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
					}
					request.setAttribute("q", q);
					request.setAttribute("mk", "老员工");
					request.getRequestDispatcher("empsel.jsp").forward(request,
							response);
					return;

				} else {

					// 显示除自己以外的表二中自己未打分的的所有人全部显示
					List<Login> ll = e.empNameAndDeptF(ename, ename, ename,section);
					int q = e.selectOnecount();
					if (n.selectOneEmpA() == n.selectOneEmpB()) {
						request.setAttribute("p", n.selectOneEmpA());
					} else if (n.selectOneEmpA() < n.selectOneEmpB()) {
						request.setAttribute("p", n.selectOneEmpA());
					} else {
						request.setAttribute("p", n.selectOneEmpB());
					}
					if ((e.selectOneA(ename) + e.selectTwo(ename)) < 3) {
						request.setAttribute("ll", ll);

						request.setAttribute("lw", "1");
					} else {
						request.setAttribute("ll", "1");
						request.setAttribute("lw", "1");
						request.setAttribute("m",
								"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
					}
					request.setAttribute("mk", "老员工");
					request.setAttribute("q", q);
					request.getRequestDispatcher("empsel.jsp").forward(request,
							response);
					return;

				}
			}

			if (sum >= 90) {
			//	ss.add(sum);
				gradenum.EmpOneInsert(1);
				System.out.println("ss的长度为" + ss.size());
				if ((gradenum.selectEmpOneGrate()) > (t * 0.3)) {
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					request.setAttribute("pname", name);
					request.setAttribute("dept", dept);
					request.setAttribute("msg",
							"<script>alert(\"优秀人数超出，不予提交！\");</script>");
					System.out.println("优秀人数过多");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				} else {
					Empgrade empgrade = new Empgrade(sx, name, dept, ename,
							l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
							l.get(5), l.get(6), l.get(7), l.get(8), sum);
				//	lg.add(sum);
			gradenum.EmpOneInsert(3);
					int s = e.empInsert(empgrade);
					System.out.println("s的值为" + s
							+ "//////////////////////////////");
					if (s == 1) {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						System.out.println("----------------------");
						//System.out.println("lg.size()的值为" + lg.size());
						System.out.println("t的值为" + t);
						request.setAttribute("msg",
								"<script>alert(\"提交成功 \");</script>");
						if ((gradenum.selectEmpOneCount()) == e.empsum()) {
							//lg.removeAll(lg);
							//ss.removeAll(ss);
							//tt.removeAll(tt);
							e.insertEmpOnecount(1);
							//System.out.println("走到lg.size==t" + lg.size()
							//		+ "==" + t);
							gradenum.deleteEmpOneGrade();
							n.oneEmpA(1);
							if (e.selectOnecount() == e.selectTwocount()) {
								request.setAttribute("l",
										"<script>alert(\"本次您已评分完毕\")<script>");

							}
						}

						session.setAttribute("r", "oldone");
						if (e.selectOnecount() == e.selectTwocount()) {
							// 显示除自己以外的表二中自己未打分的的所有人全部显示

							List<Login> ll = e.empNameAndDeptOne(ename, ename,
									ename,section);
							// 显示所有老员工，对表二进行打分
							List<Login> lw = e.empNameAndDeptThree(ename,
									ename, ename,section);
							if (n.selectOneEmpA() == n.selectOneEmpB()) {
								request.setAttribute("p", n.selectOneEmpA());
							} else if (n.selectOneEmpA() < n.selectOneEmpB()) {
								request.setAttribute("p", n.selectOneEmpA());
							} else {
								request.setAttribute("p", n.selectOneEmpB());
							}
							int q = e.selectOnecount();
							if ((e.selectOneA(ename) + e.selectTwoB(ename)) < 3) {
								request.setAttribute("ll", ll);
								request.setAttribute("lw", lw);

							} else {
								request.setAttribute("ll", "1");
								request.setAttribute("lw", "1");
								request.setAttribute("m",
										"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
							}
							request.setAttribute("mk", "老员工");
							request.setAttribute("q", q);
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;

						} else if (e.selectOnecount() > e.selectTwocount()) {

							// 显示所有老员工，对表二进行打分
							List<Login> lw = e.empNameAndDeptTwo(ename, ename,
									ename,section);

							int q = e.selectTwocount();
							if (n.selectOneEmpA() == n.selectOneEmpB()) {
								request.setAttribute("p", n.selectOneEmpA());
							} else if (n.selectOneEmpA() < n.selectOneEmpB()) {
								request.setAttribute("p", n.selectOneEmpA());
							} else {
								request.setAttribute("p", n.selectOneEmpB());
							}
							if ((e.selectOne(ename) + e.selectTwoB(ename)) < 3) {

								request.setAttribute("lw", lw);

								request.setAttribute("ll", "1");
							} else {
								request.setAttribute("ll", "1");
								request.setAttribute("lw", "1");
								request.setAttribute("m",
										"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
							}
							request.setAttribute("q", q);
							request.setAttribute("mk", "老员工");
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;

						} else {

							// 显示除自己以外的表二中自己未打分的的所有人全部显示
							List<Login> ll = e.empNameAndDeptF(ename, ename,
									ename,section);
							int q = e.selectOnecount();
							if (n.selectOneEmpA() == n.selectOneEmpB()) {
								request.setAttribute("p", n.selectOneEmpA());
							} else if (n.selectOneEmpA() < n.selectOneEmpB()) {
								request.setAttribute("p", n.selectOneEmpA());
							} else {
								request.setAttribute("p", n.selectOneEmpB());
							}
							if ((e.selectOneA(ename) + e.selectTwo(ename)) < 3) {
								request.setAttribute("ll", ll);

								request.setAttribute("lw", "1");
							} else {
								request.setAttribute("ll", "1");
								request.setAttribute("lw", "1");
								request.setAttribute("m",
										"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
							}
							request.setAttribute("mk", "老员工");
							request.setAttribute("q", q);
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;

						}
					} else {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						request.setAttribute("pname", name);
						request.setAttribute("dept", dept);
						request.setAttribute("msg",
								"<script>alert(\"提交失败 \");</script>");
						request.getRequestDispatcher("grade/d.jsp").forward(request,
								response);
						return;
					}
				}

			} else if (sum >= 80 && sum < 90) {
				//tt.add(sum);
				gradenum.EmpOneInsert(2);
				if ((gradenum.selectEmpOneGood()) > (t * 0.3)) {
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					request.setAttribute("msg",
							"<script>alert(\"良好人数超出，不予提交！\");</script>");
					System.out.println("良好人数过多");
					request.setAttribute("pname", name);
					request.setAttribute("dept", dept);
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				} else {

					Empgrade empgrade = new Empgrade(sx, name, dept, ename,
							l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
							l.get(5), l.get(6), l.get(7), l.get(8), sum);
					//lg.add(sum);
					gradenum.EmpOneInsert(3);
					int s = e.empInsert(empgrade);
					System.out.println("s的值为" + s
							+ "//////////////////////////////");
					request.setAttribute("msg",
							"<script>alert(\"提交成功 \");</script>");
					if (s == 1) {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						System.out.println("----------------------");
						//System.out.println("lg.size()的值为" + lg.size());
						System.out.println("t的值为" + t);
						if ((gradenum.selectEmpOneCount()) == e.empsum()) {

							//lg.removeAll(lg);
							//ss.removeAll(ss);
						//	tt.removeAll(tt);
							e.insertEmpOnecount(1);
							n.oneEmpA(1);
							gradenum.deleteEmpOneGrade();
						//	System.out.println("走到lg.size==t" + lg.size()
							//		+ "==" + t);
							if (e.selectOnecount() == e.selectTwocount()) {
								request.setAttribute("l",
										"<script>alert(\"本次您已评分完毕\")<script>");
							}
						}

						session.setAttribute("r", "oldone");
						if (e.selectOnecount() == e.selectTwocount()) {
							// 显示除自己以外的表二中自己未打分的的所有人全部显示

							List<Login> ll = e.empNameAndDeptOne(ename, ename,
									ename,section);
							// 显示所有老员工，对表二进行打分
							List<Login> lw = e.empNameAndDeptThree(ename,
									ename, ename,section);
							if (n.selectOneEmpA() == n.selectOneEmpB()) {
								request.setAttribute("p", n.selectOneEmpA());
							} else if (n.selectOneEmpA() < n.selectOneEmpB()) {
								request.setAttribute("p", n.selectOneEmpA());
							} else {
								request.setAttribute("p", n.selectOneEmpB());
							}
							int q = e.selectOnecount();
							if ((e.selectOneA(ename) + e.selectTwoB(ename)) < 3) {
								request.setAttribute("ll", ll);
								request.setAttribute("lw", lw);

							} else {
								request.setAttribute("ll", "1");
								request.setAttribute("lw", "1");
								request.setAttribute("m",
										"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
							}
							request.setAttribute("mk", "老员工");
							request.setAttribute("q", q);
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;

						} else if (e.selectOnecount() > e.selectTwocount()) {

							// 显示所有老员工，对表二进行打分
							List<Login> lw = e.empNameAndDeptTwo(ename, ename,
									ename,section);

							int q = e.selectTwocount();
							if (n.selectOneEmpA() == n.selectOneEmpB()) {
								request.setAttribute("p", n.selectOneEmpA());
							} else if (n.selectOneEmpA() < n.selectOneEmpB()) {
								request.setAttribute("p", n.selectOneEmpA());
							} else {
								request.setAttribute("p", n.selectOneEmpB());
							}
							if ((e.selectOne(ename) + e.selectTwoB(ename)) < 3) {

								request.setAttribute("lw", lw);

								request.setAttribute("ll", "1");
							} else {
								request.setAttribute("ll", "1");
								request.setAttribute("lw", "1");
								request.setAttribute("m",
										"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
							}
							request.setAttribute("q", q);
							request.setAttribute("mk", "老员工");
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;

						} else {

							// 显示除自己以外的表二中自己未打分的的所有人全部显示
							List<Login> ll = e.empNameAndDeptF(ename, ename,
									ename,section);
							int q = e.selectOnecount();
							if (n.selectOneEmpA() == n.selectOneEmpB()) {
								request.setAttribute("p", n.selectOneEmpA());
							} else if (n.selectOneEmpA() < n.selectOneEmpB()) {
								request.setAttribute("p", n.selectOneEmpA());
							} else {
								request.setAttribute("p", n.selectOneEmpB());
							}
							if ((e.selectOneA(ename) + e.selectTwo(ename)) < 3) {
								request.setAttribute("ll", ll);

								request.setAttribute("lw", "1");
							} else {
								request.setAttribute("ll", "1");
								request.setAttribute("lw", "1");
								request.setAttribute("m",
										"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
							}
							request.setAttribute("mk", "老员工");
							request.setAttribute("q", q);
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;

						}

					} else {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						request.setAttribute("pname", name);
						request.setAttribute("dept", dept);
						request.setAttribute("msg",
								"<script>alert(\"提交失败 \");</script>");
						request.getRequestDispatcher("grade/d.jsp").forward(request,
								response);
						return;
					}

				}

			} else {
				Empgrade empgrade = new Empgrade(sx, name, dept, ename,
						l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
						l.get(5), l.get(6), l.get(7), l.get(8), sum);
			
				int s = e.empInsert(empgrade);
				//lg.add(sum);
				gradenum.EmpOneInsert(3);
				System.out.println("s的值为" + s
						+ "//////////////////////////////");
				if (s == 1) {
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					System.out.println("----------------------");
					System.out.println("lg.size()的值为" + lg.size());
					System.out.println("t的值为" + t);
					request.setAttribute("msg",
							"<script>alert(\"提交成功 \");</script>");
					if (gradenum.selectEmpOneCount() == e.empsum()) {

//						lg.removeAll(lg);
//						ss.removeAll(ss);
//						tt.removeAll(tt);
						e.insertEmpOnecount(1);
						n.oneEmpA(1);
						gradenum.deleteEmpOneGrade();
//						System.out.println("走到lg.size==t" + lg.size() + "=="
//								+ t);
						if (e.selectOnecount() == e.selectTwocount()) {
							request.setAttribute("l",
									"<script>alert(\"本次您已评分完毕\")<script>");
						}
					}

					session.setAttribute("r", "oldone");
					if (e.selectOnecount() == e.selectTwocount()) {
						// 显示除自己以外的表二中自己未打分的的所有人全部显示

						List<Login> ll = e.empNameAndDeptOne(ename, ename,
								ename,section);
						// 显示所有老员工，对表二进行打分
						List<Login> lw = e.empNameAndDeptThree(ename, ename,
								ename,section);
						if (n.selectOneEmpA() == n.selectOneEmpB()) {
							request.setAttribute("p", n.selectOneEmpA());
						} else if (n.selectOneEmpA() < n.selectOneEmpB()) {
							request.setAttribute("p", n.selectOneEmpA());
						} else {
							request.setAttribute("p", n.selectOneEmpB());
						}
						int q = e.selectOnecount();
						if ((e.selectOneA(ename) + e.selectTwoB(ename)) < 3) {
							request.setAttribute("ll", ll);
							request.setAttribute("lw", lw);

						} else {
							request.setAttribute("ll", "1");
							request.setAttribute("lw", "1");
							request.setAttribute("m",
									"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
						}
						request.setAttribute("mk", "老员工");
						request.setAttribute("q", q);
						request.getRequestDispatcher("empsel.jsp").forward(
								request, response);
						return;

					} else if (e.selectOnecount() > e.selectTwocount()) {

						// 显示所有老员工，对表二进行打分
						List<Login> lw = e.empNameAndDeptTwo(ename, ename,
								ename,section);

						int q = e.selectTwocount();
						if (n.selectOneEmpA() == n.selectOneEmpB()) {
							request.setAttribute("p", n.selectOneEmpA());
						} else if (n.selectOneEmpA() < n.selectOneEmpB()) {
							request.setAttribute("p", n.selectOneEmpA());
						} else {
							request.setAttribute("p", n.selectOneEmpB());
						}
						if ((e.selectOne(ename) + e.selectTwoB(ename)) < 3) {

							request.setAttribute("lw", lw);

							request.setAttribute("ll", "1");
						} else {
							request.setAttribute("ll", "1");
							request.setAttribute("lw", "1");
							request.setAttribute("m",
									"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
						}
						request.setAttribute("q", q);
						request.setAttribute("mk", "老员工");
						request.getRequestDispatcher("empsel.jsp").forward(
								request, response);
						return;

					} else {

						// 显示除自己以外的表二中自己未打分的的所有人全部显示
						List<Login> ll = e.empNameAndDeptF(ename, ename, ename,section);
						int q = e.selectOnecount();
						if (n.selectOneEmpA() == n.selectOneEmpB()) {
							request.setAttribute("p", n.selectOneEmpA());
						} else if (n.selectOneEmpA() < n.selectOneEmpB()) {
							request.setAttribute("p", n.selectOneEmpA());
						} else {
							request.setAttribute("p", n.selectOneEmpB());
						}
						if ((e.selectOneA(ename) + e.selectTwo(ename)) < 3) {
							request.setAttribute("ll", ll);

							request.setAttribute("lw", "1");
						} else {
							request.setAttribute("ll", "1");
							request.setAttribute("lw", "1");
							request.setAttribute("m",
									"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
						}
						request.setAttribute("mk", "老员工");
						request.setAttribute("q", q);
						request.getRequestDispatcher("empsel.jsp").forward(
								request, response);
						return;

					}
				} else {
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					request.setAttribute("pname", name);
					request.setAttribute("dept", dept);
					request.setAttribute("msg",
							"<script>alert(\"提交失败 \");</script>");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				}
			}
		}
		
			if (f == true) {
				request.setAttribute("m",
						"<script>alert(\"本次此员工已经提交过分数，请为其他员工打分！\");</script>");
				System.out.println("重复提交分数");
				if ((e.selectEmpNewCount(section) % e.empcount(section)) == 0) {
					List<Login> ll = e.empNameAndDept(ename,section);

					request.setAttribute("ll", ll);
					// request.setAttribute("r","new");
					session.setAttribute("r", "new");
					int q = e.selectNewcount();
					request.setAttribute("mk", "新员工");
					request.setAttribute("q", q);
					request.setAttribute("p", n.selectOneEmpC());
					request.setAttribute("lw", "1");
					request.getRequestDispatcher("empsel.jsp").forward(request,
							response);
					return;
				} else {
					int q = e.selectNewcount();
					if (e.selectNew(ename) < 3) {
						List<Login> ll = e.empNewName(ename,section);
						request.setAttribute("ll", ll);
						// request.setAttribute("r","new");

						request.setAttribute("lw", "1");
					}

					else {
						request.setAttribute("ll", "1");
						request.setAttribute("lw", "1");
						request.setAttribute("m",
								"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
					}
					request.setAttribute("mk", "新员工");
					request.setAttribute("q", q);
					request.setAttribute("p", n.selectOneEmpC());
					session.setAttribute("r", "new");
					request.getRequestDispatcher("empsel.jsp").forward(request,
							response);
					return;
				}

			}
			if (sum >= 90) {
				//sf.add(sum);
				//System.out.println("sf的数量为" + sf.size());
				gradenum.EmpNewInsert(1);
				if (gradenum.selectEmpNewGrate() > t * 0.3) {
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					request.setAttribute("pname", name);
					request.setAttribute("dept", dept);
					request.setAttribute("msg",
							"<script>alert(\"优秀人数超出，不予提交！\");</script>");
					System.out.println("优秀人数过多");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				} else {
					Empgrade empgrade = new Empgrade(news, name, dept, ename,
							l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
							l.get(5), l.get(6), l.get(7), l.get(8), sum);
					//lx.add(sum);
					gradenum.EmpNewInsert(3);
					int s = e.empNewInsert(empgrade);
					if (s == 1) {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						System.out.println("----------------------");
						request.setAttribute("msg",
								"<script>alert(\"提交成功 \");</script>");
						if (gradenum.selectEmpNewCount() == e.empsum()) {
							request.setAttribute("l",
									"<script>alert(\"本次您已评分完毕\")<script>");
//							lx.removeAll(lx);
//							sf.removeAll(sf);
//							td.removeAll(td);
							gradenum.deleteEmpNewGrade();
							e.insertEmpNewcount(1);
							n.oneEmpC(1);
						}

						if ((e.selectEmpNewCount(section) % e.empcount(section)) == 0) {
							List<Login> ll = e.empNameAndDept(ename,section);

							request.setAttribute("ll", ll);
							// request.setAttribute("r","new");
							session.setAttribute("r", "new");
							int q = e.selectNewcount();
							request.setAttribute("mk", "新员工");
							request.setAttribute("q", q);
							request.setAttribute("lw", "1");
							request.setAttribute("p", n.selectOneEmpC());
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;
						} else {
							int q = e.selectNewcount();
							if (e.selectNew(ename) < 3) {
								List<Login> ll = e.empNewName(ename,section);
								request.setAttribute("ll", ll);
								// request.setAttribute("r","new");

								request.setAttribute("lw", "1");

							} else {
								request.setAttribute("ll", "1");
								request.setAttribute("lw", "1");
								request.setAttribute("m",
										"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
							}
							request.setAttribute("mk", "新员工");
							request.setAttribute("q", q);
							request.setAttribute("p", n.selectOneEmpC());
							session.setAttribute("r", "new");

							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;
						}

					} else {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						request.setAttribute("pname", name);
						request.setAttribute("dept", dept);
						request.setAttribute("msg",
								"<script>alert(\"提交失败 \");</script>");
						request.getRequestDispatcher("grade/d.jsp").forward(request,
								response);
						return;
					}
				}

			} else if (sum >= 80 && sum < 90) {
				//td.add(sum);
				gradenum.EmpNewInsert(2);
				if (gradenum.selectEmpNewGood() > t * 0.3) {
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					request.setAttribute("pname", name);
					request.setAttribute("dept", dept);
					request.setAttribute("msg",
							"<script>alert(\"良好人数超出，不予提交！\");</script>");
					System.out.println("良好人数过多");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				} else {

					Empgrade empgrade = new Empgrade(news, name, dept, ename,
							l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
							l.get(5), l.get(6), l.get(7), l.get(8), sum);
					//lx.add(sum);
					gradenum.EmpNewInsert(3);
					int s = e.empNewInsert(empgrade);
					if (s == 1) {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						System.out.println("----------------------");
						request.setAttribute("msg",
								"<script>alert(\"提交成功 \");</script>");
						if (gradenum.selectEmpNewCount()>= e.empsum()) {
							request.setAttribute("l",
									"<script>alert(\"本次您已评分完毕\")<script>");
//							lx.removeAll(lx);
//							sf.removeAll(sf);
//							td.removeAll(td);
							gradenum.deleteEmpNewGrade();
							e.insertEmpNewcount(1);
							n.oneEmpC(1);
						}

						if ((e.selectEmpNewCount(section) % e.empcount(section)) == 0) {
							List<Login> ll = e.empNameAndDept(ename,section);
							request.setAttribute("ll", ll);
							// request.setAttribute("r","new");
							int q = e.selectNewcount();
							request.setAttribute("mk", "新员工");
							request.setAttribute("q", q);
							session.setAttribute("r", "new");
							request.setAttribute("lw", "1");
							request.setAttribute("p", n.selectOneEmpC());
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;
						} else {
							int q = e.selectNewcount();
							if (e.selectNew(ename) < 3) {
								List<Login> ll = e.empNewName(ename,section);
								request.setAttribute("ll", ll);
								// request.setAttribute("r","new");

								request.setAttribute("lw", "1");

							} else {
								request.setAttribute("ll", "1");
								request.setAttribute("lw", "1");
								request.setAttribute("m",
										"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
							}
							request.setAttribute("mk", "新员工");
							request.setAttribute("q", q);
							session.setAttribute("r", "new");
							request.setAttribute("p", n.selectOneEmpC());
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;
						}

					} else {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						request.setAttribute("pname", name);
						request.setAttribute("dept", dept);
						request.setAttribute("msg",
								"<script>alert(\"提交失败 \");</script>");
						request.getRequestDispatcher("grade/d.jsp").forward(request,
								response);
						return;
					}

				}

			} else {
				Empgrade empgrade = new Empgrade(news, name, dept, ename,
						l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
						l.get(5), l.get(6), l.get(7), l.get(8), sum);
				int s = e.empNewInsert(empgrade);

				if (s == 1) {
					//lx.add(sum);
					gradenum.EmpNewInsert(3);
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					System.out.println("----------------------");
					request.setAttribute("msg",
							"<script>alert(\"提交成功 \");</script>");
					if (gradenum.selectEmpNewCount() == e.empsum()) {
						request.setAttribute("l",
								"<script>alert(\"本次您已评分完毕\")<script>");
//						lx.removeAll(lx);
//						sf.removeAll(sf);
//						td.removeAll(td);
						gradenum.deleteEmpNewGrade();
						e.insertEmpNewcount(1);
						n.oneEmpC(1);
					}

					if ((e.selectEmpNewCount(section) % e.empcount(section)) == 0) {
						List<Login> ll = e.empNameAndDept(ename,section);
						request.setAttribute("ll", ll);
						// request.setAttribute("r","new");
						int q = e.selectNewcount();
						request.setAttribute("mk", "新员工");
						request.setAttribute("q", q);
						session.setAttribute("r", "new");
						request.setAttribute("lw", "1");
						request.setAttribute("p", n.selectOneEmpC());
						request.getRequestDispatcher("empsel.jsp").forward(
								request, response);
						return;
					} else {
						int q = e.selectNewcount();
						if (e.selectNew(ename) < 3) {
							List<Login> ll = e.empNewName(ename,section);
							request.setAttribute("ll", ll);
							// request.setAttribute("r","new");

							session.setAttribute("r", "new");
							request.setAttribute("lw", "1");
						} else {
							request.setAttribute("ll", "1");
							request.setAttribute("lw", "1");
							request.setAttribute("m",
									"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
						}
						request.setAttribute("mk", "新员工");
						request.setAttribute("q", q);
						request.setAttribute("p", n.selectOneEmpC());
						request.getRequestDispatcher("empsel.jsp").forward(
								request, response);
						return;
					}

				} else {
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					request.setAttribute("msg",
							"<script>alert(\"提交失败 \");</script>");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				}
			}
		}
	}

