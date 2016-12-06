package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCContent;
import inov.fpf.model.dao.JDBCEmp;
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
	// �ж�ĳһ���ύ�Ĵ�����������Ա���������бȽϣ�����Ա������ʱ������0��
	private List<Integer> lg;
	private List<Integer> ss;
	// �����õ��������п���
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
		System.out.println("init()����");
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
					"<script>alert(\"�����ύ���󣬲����ύ��\");</script>");
			System.out.println("�����ύ");
			request.getRequestDispatcher("grade/grade/d.jsp").forward(request,
					response);
			return;
		}
		JDBCEmp e = new JDBCEmp();
		double t = e.empcount();
		int sx = e.selectOnecount();
		int two = e.selectTwocount();
		int news = e.selectNewcount();
		JDBCNum n = new JDBCNum();
		System.out.println(t);
		System.out.println(lg.size());
		if (session.getAttribute("r").equals("oldone")) {
			boolean f = e.selectEmpOneName(name);
			/*
			 * //boolean h=e.selectErrorName(name); if(h==false){
			 * List<Empcontent> list = j.empcontents();
			 * request.setAttribute("list", list); request.setAttribute("msg",
			 * "<script>alert(\"���޴�Ա������鿴����������Ƿ�����\");</script>");
			 * System.out.println("���޴�Ա������鿴����������Ƿ�����");
			 * request.getRequestDispatcher("grade/d.jsp").forward(request, response);
			 * return; }
			 */
			if (f == true) {
				request.setAttribute("m",
						"<script>alert(\"�ڱ��������д�Ա���Ѵ���֣��������Ա����֣�\");</script>");
				System.out.println("�ظ��ύ��Ա���÷�");
				if (e.selectOnecount() == e.selectTwocount()) {
					// ��ʾ���Լ�����ı�����Լ�δ��ֵĵ�������ȫ����ʾ

					List<Login> ll = e.empNameAndDeptOne(ename, ename, ename);
					// ��ʾ������Ա�����Ա�����д��
					List<Login> lw = e.empNameAndDeptThree(ename, ename, ename);
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
								"<script>alert(\"�������Ѵ����ϣ����´��ٴ�\");</script>");
					}
					request.setAttribute("mk", "��Ա��");
					request.setAttribute("q", q);
					request.getRequestDispatcher("empsel.jsp").forward(request,
							response);
					return;

				} else if (e.selectOnecount() > e.selectTwocount()) {

					// ��ʾ������Ա�����Ա�����д��
					List<Login> lw = e.empNameAndDeptTwo(ename, ename, ename);

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
								"<script>alert(\"�������Ѵ����ϣ����´��ٴ�\");</script>");
					}
					request.setAttribute("q", q);
					request.setAttribute("mk", "��Ա��");
					request.getRequestDispatcher("empsel.jsp").forward(request,
							response);
					return;

				} else {

					// ��ʾ���Լ�����ı�����Լ�δ��ֵĵ�������ȫ����ʾ
					List<Login> ll = e.empNameAndDeptF(ename, ename, ename);
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
								"<script>alert(\"�������Ѵ����ϣ����´��ٴ�\");</script>");
					}
					request.setAttribute("mk", "��Ա��");
					request.setAttribute("q", q);
					request.getRequestDispatcher("empsel.jsp").forward(request,
							response);
					return;

				}
			}

			if (sum >= 90) {
				ss.add(sum);
				System.out.println("ss�ĳ���Ϊ" + ss.size());
				if ((ss.size()) > (t * 0.3)) {
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					request.setAttribute("pname", name);
					request.setAttribute("dept", dept);
					request.setAttribute("msg",
							"<script>alert(\"�������������������ύ��\");</script>");
					System.out.println("������������");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				} else {
					Empgrade empgrade = new Empgrade(sx, name, dept, ename,
							l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
							l.get(5), l.get(6), l.get(7), l.get(8), sum);
					lg.add(sum);
					JDBCEmp emp = new JDBCEmp();
					int s = emp.empInsert(empgrade);
					System.out.println("s��ֵΪ" + s
							+ "//////////////////////////////");
					if (s == 1) {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						System.out.println("----------------------");
						System.out.println("lg.size()��ֵΪ" + lg.size());
						System.out.println("t��ֵΪ" + t);
						request.setAttribute("msg",
								"<script>alert(\"�ύ�ɹ� \");</script>");
						if ((lg.size()) == t) {
							lg.removeAll(lg);
							ss.removeAll(ss);
							tt.removeAll(tt);
							e.insertEmpOnecount(1);
							System.out.println("�ߵ�lg.size==t" + lg.size()
									+ "==" + t);
							n.oneEmpA(1);
							if (e.selectOnecount() == e.selectTwocount()) {
								request.setAttribute("l",
										"<script>alert(\"���������������\")<script>");

							}
						}

						session.setAttribute("r", "oldone");
						if (e.selectOnecount() == e.selectTwocount()) {
							// ��ʾ���Լ�����ı�����Լ�δ��ֵĵ�������ȫ����ʾ

							List<Login> ll = e.empNameAndDeptOne(ename, ename,
									ename);
							// ��ʾ������Ա�����Ա�����д��
							List<Login> lw = e.empNameAndDeptThree(ename,
									ename, ename);
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
										"<script>alert(\"�������Ѵ����ϣ����´��ٴ�\");</script>");
							}
							request.setAttribute("mk", "��Ա��");
							request.setAttribute("q", q);
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;

						} else if (e.selectOnecount() > e.selectTwocount()) {

							// ��ʾ������Ա�����Ա�����д��
							List<Login> lw = e.empNameAndDeptTwo(ename, ename,
									ename);

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
										"<script>alert(\"�������Ѵ����ϣ����´��ٴ�\");</script>");
							}
							request.setAttribute("q", q);
							request.setAttribute("mk", "��Ա��");
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;

						} else {

							// ��ʾ���Լ�����ı�����Լ�δ��ֵĵ�������ȫ����ʾ
							List<Login> ll = e.empNameAndDeptF(ename, ename,
									ename);
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
										"<script>alert(\"�������Ѵ����ϣ����´��ٴ�\");</script>");
							}
							request.setAttribute("mk", "��Ա��");
							request.setAttribute("q", q);
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;

						}
						/*
						 * //�����Ա������һ���д����������Ա���ı�����˵�����������1.��δ����ݣ�2��������Ա������ɱ��ķ�
						 * if((e.selectEmpOnecount()%e.empcount())==0){
						 * //�ٲ�ѯ��Ա����ֱ��
						 * �������Ա�����ֱ������Ա���ı�����˵�����������1.��δ����ݣ�2��������Ա������ɱ��ķ�
						 * if((e.selectEmpTwocount
						 * ()%e.empcount())==0&&e.selectEmpOnecount
						 * ()==e.selectEmpTwocount()){ //����ʾ��Ա����һ������Ա����һ���д��
						 * List<Login>ll=e.empNameAndDept(ename); int
						 * q=e.selectOnecount(); request.setAttribute("ll",ll);
						 * //request.setAttribute("r","oldone");
						 * session.setAttribute("r","oldone");
						 * request.setAttribute("mk","��Ա��һ");
						 * request.setAttribute("q",q);
						 * request.getRequestDispatcher
						 * ("empsel.jsp").forward(request, response); } else
						 * if((e.selectEmpTwocount()%e.empcount())==0&&e.
						 * selectEmpOnecount()!=e.selectEmpTwocount()){
						 * //��ʾ������Ա�����Ա�����д��
						 * List<Login>ll=e.empNameAndDeptTwo(ename,ename); int
						 * q=e.selectTwocount(); request.setAttribute("ll",ll);
						 * //request.setAttribute("r","oldtwo");
						 * session.setAttribute("r","oldtwo");
						 * request.setAttribute("mk","��Ա����");
						 * request.setAttribute("q",q);
						 * request.getRequestDispatcher
						 * ("empsel.jsp").forward(request, response); return; }
						 * //�����ʣ��δ��ֵ���Ա��������д�� else{
						 * List<Login>ll=e.empNameTwo(ename,ename); int
						 * q=e.selectTwocount(); request.setAttribute("ll",ll);
						 * //request.setAttribute("r","oldtwo");
						 * session.setAttribute("r","oldtwo");
						 * request.setAttribute("mk","��Ա����");
						 * request.setAttribute("q",q);
						 * request.getRequestDispatcher
						 * ("empsel.jsp").forward(request, response); return; }
						 * }
						 */

						// �������Ա����һδ�����Ա���д��
						/*
						 * else{ List<Login>ll=e.empName(ename); int
						 * q=e.selectOnecount(); request.setAttribute("ll",ll);
						 * //request.setAttribute("r","oldone");
						 * session.setAttribute("r","oldone");
						 * request.setAttribute("mk","��Ա��һ");
						 * request.setAttribute("q",q);
						 * request.getRequestDispatcher
						 * ("empsel.jsp").forward(request, response); return; }
						 */

					} else {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						request.setAttribute("pname", name);
						request.setAttribute("dept", dept);
						request.setAttribute("msg",
								"<script>alert(\"�ύʧ�� \");</script>");
						request.getRequestDispatcher("grade/d.jsp").forward(request,
								response);
						return;
					}
				}

			} else if (sum >= 80 && sum < 90) {
				tt.add(sum);
				if ((tt.size()) > (t * 0.3)) {
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					request.setAttribute("msg",
							"<script>alert(\"�������������������ύ��\");</script>");
					System.out.println("������������");
					request.setAttribute("pname", name);
					request.setAttribute("dept", dept);
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				} else {

					Empgrade empgrade = new Empgrade(sx, name, dept, ename,
							l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
							l.get(5), l.get(6), l.get(7), l.get(8), sum);
					lg.add(sum);
					JDBCEmp emp = new JDBCEmp();
					int s = emp.empInsert(empgrade);
					System.out.println("s��ֵΪ" + s
							+ "//////////////////////////////");
					request.setAttribute("msg",
							"<script>alert(\"�ύ�ɹ� \");</script>");
					if (s == 1) {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						System.out.println("----------------------");
						System.out.println("lg.size()��ֵΪ" + lg.size());
						System.out.println("t��ֵΪ" + t);
						if ((lg.size()) == t) {

							lg.removeAll(lg);
							ss.removeAll(ss);
							tt.removeAll(tt);
							e.insertEmpOnecount(1);
							n.oneEmpA(1);
							System.out.println("�ߵ�lg.size==t" + lg.size()
									+ "==" + t);
							if (e.selectOnecount() == e.selectTwocount()) {
								request.setAttribute("l",
										"<script>alert(\"���������������\")<script>");
							}
						}

						session.setAttribute("r", "oldone");
						if (e.selectOnecount() == e.selectTwocount()) {
							// ��ʾ���Լ�����ı�����Լ�δ��ֵĵ�������ȫ����ʾ

							List<Login> ll = e.empNameAndDeptOne(ename, ename,
									ename);
							// ��ʾ������Ա�����Ա�����д��
							List<Login> lw = e.empNameAndDeptThree(ename,
									ename, ename);
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
										"<script>alert(\"�������Ѵ����ϣ����´��ٴ�\");</script>");
							}
							request.setAttribute("mk", "��Ա��");
							request.setAttribute("q", q);
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;

						} else if (e.selectOnecount() > e.selectTwocount()) {

							// ��ʾ������Ա�����Ա�����д��
							List<Login> lw = e.empNameAndDeptTwo(ename, ename,
									ename);

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
										"<script>alert(\"�������Ѵ����ϣ����´��ٴ�\");</script>");
							}
							request.setAttribute("q", q);
							request.setAttribute("mk", "��Ա��");
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;

						} else {

							// ��ʾ���Լ�����ı�����Լ�δ��ֵĵ�������ȫ����ʾ
							List<Login> ll = e.empNameAndDeptF(ename, ename,
									ename);
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
										"<script>alert(\"�������Ѵ����ϣ����´��ٴ�\");</script>");
							}
							request.setAttribute("mk", "��Ա��");
							request.setAttribute("q", q);
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;

						}
						/*
						 * //�����Ա������һ���д����������Ա���ı�����˵�����������1.��δ����ݣ�2��������Ա������ɱ��ķ�
						 * if((e.selectEmpOnecount()%e.empcount())==0){
						 * //�ٲ�ѯ��Ա����ֱ��
						 * �������Ա�����ֱ������Ա���ı�����˵�����������1.��δ����ݣ�2��������Ա������ɱ��ķ�
						 * if((e.selectEmpTwocount
						 * ()%e.empcount())==0&&e.selectEmpOnecount
						 * ()==e.selectEmpTwocount()){ //����ʾ��Ա����һ������Ա����һ���д��
						 * List<Login>ll=e.empNameAndDept(ename); int
						 * q=e.selectOnecount(); request.setAttribute("ll",ll);
						 * //request.setAttribute("r","oldone");
						 * session.setAttribute("r","oldone");
						 * request.setAttribute("mk","��Ա��һ");
						 * request.setAttribute("q",q);
						 * request.getRequestDispatcher
						 * ("empsel.jsp").forward(request, response); } else
						 * if((e.selectEmpTwocount()%e.empcount())==0&&e.
						 * selectEmpOnecount()!=e.selectEmpTwocount()){
						 * //��ʾ������Ա�����Ա�����д��
						 * List<Login>ll=e.empNameAndDeptTwo(ename,ename); int
						 * q=e.selectTwocount(); request.setAttribute("ll",ll);
						 * //request.setAttribute("r","oldtwo");
						 * session.setAttribute("r","oldtwo");
						 * request.setAttribute("mk","��Ա����");
						 * request.setAttribute("q",q);
						 * request.getRequestDispatcher
						 * ("empsel.jsp").forward(request, response); return; }
						 * //�����ʣ��δ��ֵ���Ա��������д�� else{
						 * List<Login>ll=e.empNameTwo(ename,ename); int
						 * q=e.selectTwocount(); request.setAttribute("ll",ll);
						 * //request.setAttribute("r","oldtwo");
						 * session.setAttribute("r","oldtwo");
						 * request.setAttribute("mk","��Ա����");
						 * request.setAttribute("q",q);
						 * request.getRequestDispatcher
						 * ("empsel.jsp").forward(request, response); } }
						 * 
						 * //�������Ա����һδ�����Ա���д�� else{
						 * List<Login>ll=e.empName(ename); int
						 * q=e.selectOnecount(); request.setAttribute("ll",ll);
						 * //request.setAttribute("r","oldone");
						 * session.setAttribute("r","oldone");
						 * request.setAttribute("mk","��Ա��һ");
						 * request.setAttribute("q",q);
						 * request.getRequestDispatcher
						 * ("empsel.jsp").forward(request, response); return; }
						 */

					} else {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						request.setAttribute("pname", name);
						request.setAttribute("dept", dept);
						request.setAttribute("msg",
								"<script>alert(\"�ύʧ�� \");</script>");
						request.getRequestDispatcher("grade/d.jsp").forward(request,
								response);
						return;
					}

				}

			} else {
				Empgrade empgrade = new Empgrade(sx, name, dept, ename,
						l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
						l.get(5), l.get(6), l.get(7), l.get(8), sum);
				JDBCEmp emp = new JDBCEmp();
				int s = emp.empInsert(empgrade);
				lg.add(sum);
				System.out.println("s��ֵΪ" + s
						+ "//////////////////////////////");
				if (s == 1) {
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					System.out.println("----------------------");
					System.out.println("lg.size()��ֵΪ" + lg.size());
					System.out.println("t��ֵΪ" + t);
					request.setAttribute("msg",
							"<script>alert(\"�ύ�ɹ� \");</script>");
					if (lg.size() == t) {

						lg.removeAll(lg);
						ss.removeAll(ss);
						tt.removeAll(tt);
						e.insertEmpOnecount(1);
						n.oneEmpA(1);
						System.out.println("�ߵ�lg.size==t" + lg.size() + "=="
								+ t);
						if (e.selectOnecount() == e.selectTwocount()) {
							request.setAttribute("l",
									"<script>alert(\"���������������\")<script>");
						}
					}

					session.setAttribute("r", "oldone");
					if (e.selectOnecount() == e.selectTwocount()) {
						// ��ʾ���Լ�����ı�����Լ�δ��ֵĵ�������ȫ����ʾ

						List<Login> ll = e.empNameAndDeptOne(ename, ename,
								ename);
						// ��ʾ������Ա�����Ա�����д��
						List<Login> lw = e.empNameAndDeptThree(ename, ename,
								ename);
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
									"<script>alert(\"�������Ѵ����ϣ����´��ٴ�\");</script>");
						}
						request.setAttribute("mk", "��Ա��");
						request.setAttribute("q", q);
						request.getRequestDispatcher("empsel.jsp").forward(
								request, response);
						return;

					} else if (e.selectOnecount() > e.selectTwocount()) {

						// ��ʾ������Ա�����Ա�����д��
						List<Login> lw = e.empNameAndDeptTwo(ename, ename,
								ename);

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
									"<script>alert(\"�������Ѵ����ϣ����´��ٴ�\");</script>");
						}
						request.setAttribute("q", q);
						request.setAttribute("mk", "��Ա��");
						request.getRequestDispatcher("empsel.jsp").forward(
								request, response);
						return;

					} else {

						// ��ʾ���Լ�����ı�����Լ�δ��ֵĵ�������ȫ����ʾ
						List<Login> ll = e.empNameAndDeptF(ename, ename, ename);
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
									"<script>alert(\"�������Ѵ����ϣ����´��ٴ�\");</script>");
						}
						request.setAttribute("mk", "��Ա��");
						request.setAttribute("q", q);
						request.getRequestDispatcher("empsel.jsp").forward(
								request, response);
						return;

					}
					/*
					 * //�����Ա������һ���д����������Ա���ı�����˵�����������1.��δ����ݣ�2��������Ա������ɱ��ķ�
					 * if((e.selectEmpOnecount()%e.empcount())==0){
					 * //�ٲ�ѯ��Ա����ֱ����
					 * �����Ա�����ֱ������Ա���ı�����˵�����������1.��δ����ݣ�2��������Ա������ɱ��ķ�
					 * if((e.selectEmpTwocount
					 * ()%e.empcount())==0&&e.selectEmpOnecount
					 * ()==e.selectEmpTwocount()){ //����ʾ��Ա����һ������Ա����һ���д��
					 * List<Login>ll=e.empNameAndDept(ename); int
					 * q=e.selectOnecount(); request.setAttribute("ll",ll);
					 * //request.setAttribute("r","oldone");
					 * session.setAttribute("r","oldone");
					 * request.setAttribute("mk","��Ա��һ");
					 * request.setAttribute("q",q);
					 * request.getRequestDispatcher(
					 * "empsel.jsp").forward(request, response); return; } else
					 * if
					 * ((e.selectEmpTwocount()%e.empcount())==0&&e.selectEmpOnecount
					 * ()!=e.selectEmpTwocount()){ //��ʾ������Ա�����Ա�����д��
					 * List<Login>ll=e.empNameAndDeptTwo(ename,ename); int
					 * q=e.selectTwocount(); request.setAttribute("ll",ll);
					 * //request.setAttribute("r","oldtwo");
					 * session.setAttribute("r","oldtwo");
					 * request.setAttribute("mk","��Ա����");
					 * request.setAttribute("q",q);
					 * request.getRequestDispatcher(
					 * "empsel.jsp").forward(request, response); return; }
					 * //�����ʣ��δ��ֵ���Ա��������д�� else{
					 * List<Login>ll=e.empNameTwo(ename,ename); int
					 * q=e.selectTwocount(); request.setAttribute("ll",ll);
					 * //request.setAttribute("r","oldtwo");
					 * session.setAttribute("r","oldtwo");
					 * request.setAttribute("mk","��Ա����");
					 * request.setAttribute("q",q);
					 * request.getRequestDispatcher(
					 * "empsel.jsp").forward(request, response); return; } }
					 * 
					 * //�������Ա����һδ�����Ա���д�� else{ List<Login>ll=e.empName(ename);
					 * int q=e.selectOnecount(); request.setAttribute("ll",ll);
					 * //request.setAttribute("r","oldone");
					 * session.setAttribute("r","oldone");
					 * request.setAttribute("mk","��Ա��һ");
					 * request.setAttribute("q",q);
					 * request.getRequestDispatcher(
					 * "empsel.jsp").forward(request, response); return; }
					 */

				} else {
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					request.setAttribute("pname", name);
					request.setAttribute("dept", dept);
					request.setAttribute("msg",
							"<script>alert(\"�ύʧ�� \");</script>");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				}
			}
		}
		/*
		 * if(session.getAttribute("r").equals("oldtwo")){ boolean f
		 * =e.selectEmpTwoName(name); boolean h=e.selectErrorName(name);
		 * if(h==false){ List<Empcontent> list = j.empcontents();
		 * request.setAttribute("list", list); request.setAttribute("msg",
		 * "<script>alert(\"���޴�Ա������鿴����������Ƿ�����\");</script>");
		 * System.out.println("���޴�Ա������鿴����������Ƿ�����");
		 * request.getRequestDispatcher("grade/d.jsp").forward(request, response);
		 * return; } if(f==true){ List<Empcontent> list = j.empcontents();
		 * request.setAttribute("list", list); request.setAttribute("msg",
		 * "<script>alert(\"���δ�Ա���Ѿ��ύ����������Ϊ����Ա����֣�\");</script>");
		 * System.out.println("�ظ��ύ����");
		 * request.getRequestDispatcher("grade/d.jsp").forward(request, response);
		 * return; } if (sum >= 90) { se.add(sum); if (se.size() > t * 0.3) {
		 * List<Empcontent> list = j.empcontents(); request.setAttribute("list",
		 * list); request.setAttribute("msg",
		 * "<script>alert(\"�������������������ύ��\");</script>");
		 * System.out.println("������������");
		 * request.getRequestDispatcher("grade/d.jsp").forward(request, response);
		 * return; } else{ Empgrade empgrade = new Empgrade(two, name,dept,
		 * ename, l.get(0), l.get(1), l.get(2), l.get(3), l.get(4), l.get(5),
		 * l.get(6), l.get(7), l.get(8), sum); ls.add(sum); JDBCEmp emp = new
		 * JDBCEmp(); int s = emp.empTwoInsert(empgrade); if (s == 1) {
		 * List<Empcontent> list = j.empcontents(); request.setAttribute("list",
		 * list); System.out.println("----------------------");
		 * 
		 * if(ls.size()==t){
		 * request.setAttribute("l","<script>alert(\"���������������\")<script>");
		 * ls.removeAll(ls); se.removeAll(se); te.removeAll(te);
		 * e.insertEmpTwocount(1); }
		 * request.setAttribute("msg","<script>alert(\"�ύ�ɹ� \");</script>");
		 * session.setAttribute("r","oldone");
		 * if(e.selectOnecount()==e.selectTwocount()){
		 * //��ʾ���Լ�����ı�����Լ�δ��ֵĵ�������ȫ����ʾ List<Login>ll=e.empNameAndDeptOne(name,
		 * name); //��ʾ������Ա�����Ա�����д��
		 * List<Login>lw=e.empNameAndDeptTwo(name,name); int
		 * q=e.selectOnecount(); request.setAttribute("ll",ll);
		 * request.setAttribute("lw",lw); request.setAttribute("mk","��Ա��");
		 * request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response);
		 * 
		 * } else if(e.selectOnecount()>e.selectTwocount()){ //��ʾ������Ա�����Ա�����д��
		 * List<Login>lw=e.empNameAndDeptTwo(name,name); int
		 * q=e.selectTwocount(); request.setAttribute("q",q);
		 * request.setAttribute("lw",lw); request.setAttribute("mk","��Ա��");
		 * 
		 * } else{ //��ʾ���Լ�����ı�����Լ�δ��ֵĵ�������ȫ����ʾ
		 * List<Login>ll=e.empNameAndDeptOne(name, name); int
		 * q=e.selectOnecount(); request.setAttribute("ll",ll);
		 * request.setAttribute("mk","��Ա��"); request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response);
		 * 
		 * }
		 * 
		 * //�����Ա������һ���д����������Ա���ı�����˵�����������1.��δ����ݣ�2��������Ա������ɱ��ķ�
		 * if((e.selectEmpOnecount()%e.empcount())==0){
		 * //�ٲ�ѯ��Ա����ֱ���������Ա�����ֱ������Ա���ı�����˵�����������1.��δ����ݣ�2��������Ա������ɱ��ķ�
		 * if((e.selectEmpTwocount
		 * ()%e.empcount())==0&&e.selectEmpOnecount()==e.selectEmpTwocount()){
		 * //����ʾ��Ա����һ������Ա����һ���д�� List<Login>ll=e.empNameAndDept(ename); int
		 * q=e.selectOnecount(); request.setAttribute("ll",ll);
		 * //request.setAttribute("r","oldone");
		 * session.setAttribute("r","oldone");
		 * request.setAttribute("mk","��Ա��һ"); request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response); return; } else
		 * if((e.selectEmpTwocount()%e.empcount())==0&&
		 * e.selectEmpOnecount()!=e.selectEmpTwocount()){ //��ʾ������Ա�����Ա�����д��
		 * List<Login>ll=e.empNameAndDeptTwo(ename,ename); int
		 * q=e.selectTwocount(); request.setAttribute("ll",ll);
		 * //request.setAttribute("r","oldtwo");
		 * session.setAttribute("r","oldtwo");
		 * request.setAttribute("mk","��Ա����"); request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response); return; } //�����ʣ��δ��ֵ���Ա��������д�� else{
		 * List<Login>ll=e.empNameTwo(ename,ename); int q=e.selectTwocount();
		 * request.setAttribute("ll",ll); //request.setAttribute("r","oldtwo");
		 * session.setAttribute("r","oldtwo");
		 * request.setAttribute("mk","��Ա����"); request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response); return; } }
		 * 
		 * //�������Ա����һδ�����Ա���д�� else{ List<Login>ll=e.empName(ename); int
		 * q=e.selectOnecount(); request.setAttribute("ll",ll);
		 * //request.setAttribute("r","oldone");
		 * session.setAttribute("r","oldone");
		 * request.setAttribute("mk","��Ա��һ"); request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response); return; }
		 * 
		 * 
		 * 
		 * } else { List<Empcontent> list = j.empcontents();
		 * request.setAttribute("list", list); request.setAttribute("msg",
		 * "<script>alert(\"�ύʧ�� \");</script>");
		 * request.getRequestDispatcher("grade/d.jsp").forward(request,response);
		 * return; } }
		 * 
		 * } else if(sum>=80&&sum<90){ te.add(sum); if (te.size() > t * 0.3){
		 * List<Empcontent> list = j.empcontents(); request.setAttribute("list",
		 * list); request.setAttribute("msg",
		 * "<script>alert(\"�������������������ύ��\");</script>");
		 * System.out.println("������������");
		 * request.getRequestDispatcher("grade/d.jsp").forward(request, response);
		 * return; } else{
		 * 
		 * Empgrade empgrade = new Empgrade(two, name,dept, ename, l.get(0),
		 * l.get(1), l.get(2), l.get(3), l.get(4), l.get(5), l.get(6), l.get(7),
		 * l.get(8), sum); ls.add(sum); JDBCEmp emp = new JDBCEmp(); int s =
		 * emp.empTwoInsert(empgrade); if (s == 1) { List<Empcontent> list =
		 * j.empcontents(); request.setAttribute("list", list);
		 * System.out.println("----------------------");
		 * 
		 * if(ls.size()==t){
		 * request.setAttribute("l","<script>alert(\"���������������\")<script>");
		 * ls.removeAll(ls); se.removeAll(se); te.removeAll(te);
		 * e.insertEmpTwocount(1); }
		 * request.setAttribute("msg","<script>alert(\"�ύ�ɹ� \");</script>");
		 * session.setAttribute("r","oldone");
		 * if(e.selectOnecount()==e.selectTwocount()){
		 * //��ʾ���Լ�����ı�����Լ�δ��ֵĵ�������ȫ����ʾ List<Login>ll=e.empNameAndDeptOne(name,
		 * name); //��ʾ������Ա�����Ա�����д��
		 * List<Login>lw=e.empNameAndDeptTwo(name,name); int
		 * q=e.selectOnecount(); request.setAttribute("ll",ll);
		 * request.setAttribute("lw",lw); request.setAttribute("mk","��Ա��");
		 * request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response);
		 * 
		 * } else if(e.selectOnecount()>e.selectTwocount()){ //��ʾ������Ա�����Ա�����д��
		 * List<Login>lw=e.empNameAndDeptTwo(name,name); int
		 * q=e.selectTwocount(); request.setAttribute("q",q);
		 * request.setAttribute("lw",lw); request.setAttribute("mk","��Ա��");
		 * 
		 * } else{ //��ʾ���Լ�����ı�����Լ�δ��ֵĵ�������ȫ����ʾ
		 * List<Login>ll=e.empNameAndDeptOne(name, name); int
		 * q=e.selectOnecount(); request.setAttribute("ll",ll);
		 * request.setAttribute("mk","��Ա��"); request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response);
		 * 
		 * } //�����Ա������һ���д����������Ա���ı�����˵�����������1.��δ����ݣ�2��������Ա������ɱ��ķ�
		 * if((e.selectEmpOnecount()%e.empcount())==0){
		 * //�ٲ�ѯ��Ա����ֱ���������Ա�����ֱ������Ա���ı�����˵�����������1.��δ����ݣ�2��������Ա������ɱ��ķ�
		 * if((e.selectEmpTwocount
		 * ()%e.empcount())==0&&e.selectEmpOnecount()==e.selectEmpTwocount()){
		 * //����ʾ��Ա����һ������Ա����һ���д�� List<Login>ll=e.empNameAndDept(ename); int
		 * q=e.selectOnecount(); request.setAttribute("ll",ll);
		 * //request.setAttribute("r","oldone");
		 * session.setAttribute("r","oldone");
		 * request.setAttribute("mk","��Ա��һ"); request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response); return; } else
		 * if((e.selectEmpTwocount()%e.empcount())==0&&
		 * e.selectEmpOnecount()!=e.selectEmpTwocount()){ //��ʾ������Ա�����Ա�����д��
		 * List<Login>ll=e.empNameAndDeptTwo(ename,ename); int
		 * q=e.selectTwocount(); request.setAttribute("ll",ll);
		 * //request.setAttribute("r","oldtwo");
		 * session.setAttribute("r","oldtwo");
		 * request.setAttribute("mk","��Ա����"); request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response); return; } //�����ʣ��δ��ֵ���Ա��������д�� else{
		 * List<Login>ll=e.empNameTwo(ename,ename); int q=e.selectTwocount();
		 * request.setAttribute("ll",ll); //request.setAttribute("r","oldtwo");
		 * session.setAttribute("r","oldtwo");
		 * request.setAttribute("mk","��Ա����"); request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response); return; } }
		 * 
		 * //�������Ա����һδ�����Ա���д�� else{ List<Login>ll=e.empName(ename); int
		 * q=e.selectOnecount(); request.setAttribute("ll",ll);
		 * //request.setAttribute("r","oldone");
		 * session.setAttribute("r","oldone");
		 * request.setAttribute("mk","��Ա��һ"); request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response); return; }
		 * 
		 * 
		 * 
		 * } else { List<Empcontent> list = j.empcontents();
		 * request.setAttribute("list", list); request.setAttribute("msg",
		 * "<script>alert(\"�ύʧ�� \");</script>");
		 * request.getRequestDispatcher("grade/d.jsp").forward(request,response);
		 * return; }
		 * 
		 * }
		 * 
		 * } else{ Empgrade empgrade = new Empgrade(two, name,dept, ename,
		 * l.get(0), l.get(1), l.get(2), l.get(3), l.get(4), l.get(5), l.get(6),
		 * l.get(7), l.get(8), sum); JDBCEmp emp = new JDBCEmp(); int s =
		 * emp.empTwoInsert(empgrade); ls.add(sum); if (s == 1) {
		 * List<Empcontent> list = j.empcontents(); request.setAttribute("list",
		 * list); System.out.println("----------------------");
		 * 
		 * if(ls.size()==t){
		 * request.setAttribute("l","<script>alert(\"���������������\")<script>");
		 * ls.removeAll(ls); se.removeAll(se); te.removeAll(te);
		 * e.insertEmpTwocount(1); }
		 * request.setAttribute("msg","<script>alert(\"�ύ�ɹ� \");</script>");
		 * session.setAttribute("r","oldone");
		 * if(e.selectOnecount()==e.selectTwocount()){
		 * //��ʾ���Լ�����ı�����Լ�δ��ֵĵ�������ȫ����ʾ List<Login>ll=e.empNameAndDeptOne(name,
		 * name); //��ʾ������Ա�����Ա�����д��
		 * List<Login>lw=e.empNameAndDeptTwo(name,name); int
		 * q=e.selectOnecount(); request.setAttribute("ll",ll);
		 * request.setAttribute("lw",lw); request.setAttribute("mk","��Ա��");
		 * request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response);
		 * 
		 * } else if(e.selectOnecount()>e.selectTwocount()){ //��ʾ������Ա�����Ա�����д��
		 * List<Login>lw=e.empNameAndDeptTwo(name,name); int
		 * q=e.selectTwocount(); request.setAttribute("q",q);
		 * request.setAttribute("lw",lw); request.setAttribute("mk","��Ա��");
		 * 
		 * } else{ //��ʾ���Լ�����ı�����Լ�δ��ֵĵ�������ȫ����ʾ
		 * List<Login>ll=e.empNameAndDeptOne(name, name); int
		 * q=e.selectOnecount(); request.setAttribute("ll",ll);
		 * request.setAttribute("mk","��Ա��"); request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response);
		 * 
		 * }
		 * 
		 * //�����Ա������һ���д����������Ա���ı�����˵�����������1.��δ����ݣ�2��������Ա������ɱ��ķ�
		 * if((e.selectEmpOnecount()%e.empcount())==0){
		 * //�ٲ�ѯ��Ա����ֱ���������Ա�����ֱ������Ա���ı�����˵�����������1.��δ����ݣ�2��������Ա������ɱ��ķ�
		 * if((e.selectEmpTwocount
		 * ()%e.empcount())==0&&e.selectEmpOnecount()==e.selectEmpTwocount()){
		 * //����ʾ��Ա����һ������Ա����һ���д�� List<Login>ll=e.empNameAndDept(ename); int
		 * q=e.selectOnecount(); request.setAttribute("ll",ll);
		 * //request.setAttribute("r","oldone");
		 * session.setAttribute("r","oldone");
		 * request.setAttribute("mk","��Ա��һ"); request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response); return; } else
		 * if((e.selectEmpTwocount()%e.empcount())==0&&
		 * e.selectEmpOnecount()!=e.selectEmpTwocount()){ //��ʾ������Ա�����Ա�����д��
		 * List<Login>ll=e.empNameAndDeptTwo(ename,ename); int
		 * q=e.selectTwocount(); request.setAttribute("ll",ll);
		 * //request.setAttribute("r","oldtwo");
		 * session.setAttribute("r","oldtwo");
		 * request.setAttribute("mk","��Ա����"); request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response); return; } //�����ʣ��δ��ֵ���Ա��������д�� else{
		 * List<Login>ll=e.empNameTwo(ename,ename); int q=e.selectTwocount();
		 * request.setAttribute("ll",ll); //request.setAttribute("r","oldtwo");
		 * session.setAttribute("r","oldtwo");
		 * request.setAttribute("mk","��Ա����"); request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response); return; } }
		 * 
		 * //�������Ա����һδ�����Ա���д�� else{ List<Login>ll=e.empName(ename); int
		 * q=e.selectOnecount(); request.setAttribute("ll",ll);
		 * //request.setAttribute("r","oldone");
		 * session.setAttribute("r","oldone");
		 * request.setAttribute("mk","��Ա��һ"); request.setAttribute("q",q);
		 * request.getRequestDispatcher("empsel.jsp").forward(request,
		 * response); return; }
		 * 
		 * 
		 * 
		 * } else { List<Empcontent> list = j.empcontents();
		 * request.setAttribute("list", list); request.setAttribute("msg",
		 * "<script>alert(\"�ύʧ�� \");</script>");
		 * request.getRequestDispatcher("grade/d.jsp").forward(request,response);
		 * return; } } }
		 */
		if (session.getAttribute("r").equals("new")) {
			boolean f = e.selectEmpNewName(name);
			/*
			 * boolean h=e.selectErrorName(name); if(h==false){ List<Empcontent>
			 * list = j.empcontents(); request.setAttribute("list", list);
			 * request.setAttribute("msg",
			 * "<script>alert(\"���޴�Ա������鿴����������Ƿ�����\");</script>");
			 * System.out.println("���޴�Ա������鿴����������Ƿ�����");
			 * request.getRequestDispatcher("grade/d.jsp").forward(request, response);
			 * return; }
			 */
			if (f == true) {
				request.setAttribute("m",
						"<script>alert(\"���δ�Ա���Ѿ��ύ����������Ϊ����Ա����֣�\");</script>");
				System.out.println("�ظ��ύ����");
				if ((e.selectEmpNewCount() % e.empcount()) == 0) {
					List<Login> ll = e.empNameAndDept(ename);

					request.setAttribute("ll", ll);
					// request.setAttribute("r","new");
					session.setAttribute("r", "new");
					int q = e.selectNewcount();
					request.setAttribute("mk", "��Ա��");
					request.setAttribute("q", q);
					request.setAttribute("p", n.selectOneEmpC());
					request.setAttribute("lw", "1");
					request.getRequestDispatcher("empsel.jsp").forward(request,
							response);
					return;
				} else {
					int q = e.selectNewcount();
					if (e.selectNew(ename) < 3) {
						List<Login> ll = e.empNewName(ename);
						request.setAttribute("ll", ll);
						// request.setAttribute("r","new");

						request.setAttribute("lw", "1");
					}

					else {
						request.setAttribute("ll", "1");
						request.setAttribute("lw", "1");
						request.setAttribute("m",
								"<script>alert(\"�������Ѵ����ϣ����´��ٴ�\");</script>");
					}
					request.setAttribute("mk", "��Ա��");
					request.setAttribute("q", q);
					request.setAttribute("p", n.selectOneEmpC());
					session.setAttribute("r", "new");
					request.getRequestDispatcher("empsel.jsp").forward(request,
							response);
					return;
				}

			}
			if (sum >= 90) {
				sf.add(sum);
				System.out.println("sf������Ϊ" + sf.size());
				if (sf.size() > t * 0.3) {
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					request.setAttribute("pname", name);
					request.setAttribute("dept", dept);
					request.setAttribute("msg",
							"<script>alert(\"�������������������ύ��\");</script>");
					System.out.println("������������");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				} else {
					Empgrade empgrade = new Empgrade(news, name, dept, ename,
							l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
							l.get(5), l.get(6), l.get(7), l.get(8), sum);
					lx.add(sum);
					JDBCEmp emp = new JDBCEmp();
					int s = emp.empNewInsert(empgrade);
					if (s == 1) {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						System.out.println("----------------------");
						request.setAttribute("msg",
								"<script>alert(\"�ύ�ɹ� \");</script>");
						if (lx.size() == t) {
							request.setAttribute("l",
									"<script>alert(\"���������������\")<script>");
							lx.removeAll(lx);
							sf.removeAll(sf);
							td.removeAll(td);
							e.insertEmpNewcount(1);
							n.oneEmpC(1);
						}

						if ((e.selectEmpNewCount() % e.empcount()) == 0) {
							List<Login> ll = e.empNameAndDept(ename);

							request.setAttribute("ll", ll);
							// request.setAttribute("r","new");
							session.setAttribute("r", "new");
							int q = e.selectNewcount();
							request.setAttribute("mk", "��Ա��");
							request.setAttribute("q", q);
							request.setAttribute("lw", "1");
							request.setAttribute("p", n.selectOneEmpC());
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
							return;
						} else {
							int q = e.selectNewcount();
							if (e.selectNew(ename) < 3) {
								List<Login> ll = e.empNewName(ename);
								request.setAttribute("ll", ll);
								// request.setAttribute("r","new");

								request.setAttribute("lw", "1");

							} else {
								request.setAttribute("ll", "1");
								request.setAttribute("lw", "1");
								request.setAttribute("m",
										"<script>alert(\"�������Ѵ����ϣ����´��ٴ�\");</script>");
							}
							request.setAttribute("mk", "��Ա��");
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
								"<script>alert(\"�ύʧ�� \");</script>");
						request.getRequestDispatcher("grade/d.jsp").forward(request,
								response);
						return;
					}
				}

			} else if (sum >= 80 && sum < 90) {
				td.add(sum);
				if (td.size() > t * 0.3) {
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					request.setAttribute("pname", name);
					request.setAttribute("dept", dept);
					request.setAttribute("msg",
							"<script>alert(\"�������������������ύ��\");</script>");
					System.out.println("������������");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				} else {

					Empgrade empgrade = new Empgrade(news, name, dept, ename,
							l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
							l.get(5), l.get(6), l.get(7), l.get(8), sum);
					lx.add(sum);
					JDBCEmp emp = new JDBCEmp();
					int s = emp.empNewInsert(empgrade);
					if (s == 1) {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						System.out.println("----------------------");
						request.setAttribute("msg",
								"<script>alert(\"�ύ�ɹ� \");</script>");
						if (lx.size() >= t) {
							request.setAttribute("l",
									"<script>alert(\"���������������\")<script>");
							lx.removeAll(lx);
							sf.removeAll(sf);
							td.removeAll(td);
							e.insertEmpNewcount(1);
							n.oneEmpC(1);
						}

						if ((e.selectEmpNewCount() % e.empcount()) == 0) {
							List<Login> ll = e.empNameAndDept(ename);
							request.setAttribute("ll", ll);
							// request.setAttribute("r","new");
							int q = e.selectNewcount();
							request.setAttribute("mk", "��Ա��");
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
								List<Login> ll = e.empNewName(ename);
								request.setAttribute("ll", ll);
								// request.setAttribute("r","new");

								request.setAttribute("lw", "1");

							} else {
								request.setAttribute("ll", "1");
								request.setAttribute("lw", "1");
								request.setAttribute("m",
										"<script>alert(\"�������Ѵ����ϣ����´��ٴ�\");</script>");
							}
							request.setAttribute("mk", "��Ա��");
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
								"<script>alert(\"�ύʧ�� \");</script>");
						request.getRequestDispatcher("grade/d.jsp").forward(request,
								response);
						return;
					}

				}

			} else {
				Empgrade empgrade = new Empgrade(news, name, dept, ename,
						l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
						l.get(5), l.get(6), l.get(7), l.get(8), sum);
				JDBCEmp emp = new JDBCEmp();
				int s = emp.empNewInsert(empgrade);

				if (s == 1) {
					lx.add(sum);
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					System.out.println("----------------------");
					request.setAttribute("msg",
							"<script>alert(\"�ύ�ɹ� \");</script>");
					if (lx.size() == t) {
						request.setAttribute("l",
								"<script>alert(\"���������������\")<script>");
						lx.removeAll(lx);
						sf.removeAll(sf);
						td.removeAll(td);
						e.insertEmpNewcount(1);
						n.oneEmpC(1);
					}

					if ((e.selectEmpNewCount() % e.empcount()) == 0) {
						List<Login> ll = e.empNameAndDept(ename);
						request.setAttribute("ll", ll);
						// request.setAttribute("r","new");
						int q = e.selectNewcount();
						request.setAttribute("mk", "��Ա��");
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
							List<Login> ll = e.empNewName(ename);
							request.setAttribute("ll", ll);
							// request.setAttribute("r","new");

							session.setAttribute("r", "new");
							request.setAttribute("lw", "1");
						} else {
							request.setAttribute("ll", "1");
							request.setAttribute("lw", "1");
							request.setAttribute("m",
									"<script>alert(\"�������Ѵ����ϣ����´��ٴ�\");</script>");
						}
						request.setAttribute("mk", "��Ա��");
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
							"<script>alert(\"�ύʧ�� \");</script>");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				}
			}
		}
	}
}
