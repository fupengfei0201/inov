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
	// �ж�ĳһ���ύ�Ĵ�����������Ա���������бȽϣ�����Ա������ʱ������0��
	private List<Integer> lg;
	private List<Integer> ss;
	// �����õ��������п���
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

		System.out.println("init()����");
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
		System.out.println("����Servlet");
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
					"<script>alert(\"���޴�Ա����鿴Ա�����������Ƿ�����\");</script>");
			System.out.println("���޴�Ա����鿴Ա�����������Ƿ�����");
			//request.setAttribute("msg", "�ύʧ��");
			request.getRequestDispatcher("d.jsp")
					.forward(request, response);	
			return;
		}
		if(f==true){
			List<TCheckPoints> li = j.tCheckPoints();
			request.setAttribute("ls", li);
			request.setAttribute("m",
					"<script>alert(\"��Ա���ڱ��δ���������ύ���������������Ա����֣�\");</script>");
			System.out.println("�㱾���Ѵ�����˵ķ����������´�֣�");
			//request.setAttribute("msg", "�ύʧ��");
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
		System.out.println("a��ֵΪ��"+a);
		int q = emp.selectcount();
		if (sum >= 90) {
			ss.add(sum);
			System.out.println("ss������Ϊ" + ss.size() + "    a������Ϊ" + a);

			if (ss.size() > (a * 0.3)) {
				System.out.println("�ж�������������");
				List<TCheckPoints> li = j.tCheckPoints();
				request.setAttribute("ls", li);
				request.setAttribute("pname",name);
				request.setAttribute("detp",teachername);
			
				request.setAttribute("m",
						"<script>alert(\"�����������������ύ�������´�� \");</script>");
				System.out.println("������������");
				//request.setAttribute("msg", "�ύʧ��");
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
								"<script>alert(\"���δ����ϣ�\");</script>");
						lg.removeAll(lg);
						System.out.println(lg.size() + "removeAll()");
						ss.removeAll(ss);
						tt.removeAll(tt);
						
						emp.insertcount(1);
						request.setAttribute("msg",
								"<script>alert(\"�ύ�ɹ� \");</script>");
						}

						// �ж�ʦ���Ĵ�������������������ܵ�Ա�������ǳɱ����ģ���˵��δ����ݻ����ɱ����ķ֣�����ʾ���е�Ա��
						if ((emp.selectEmpTeaCount() % a) == 0) {
							List<Login> ll = emp.empNameAndDept();
							request.setAttribute("ll", ll);
							//request.setAttribute("msg", "tea");
							request.setAttribute("mk","ʦ��");
							request.setAttribute("q",emp.selectcount());
							request.getRequestDispatcher("empsel.jsp").forward(
									request, response);
						} else {
							List<Login> ll = emp.empTeaName();
							request.setAttribute("ll", ll);
							//request.setAttribute("msg", "tea");
							request.setAttribute("mk","ʦ��");
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
							"<script>alert(\"�ύʧ�� \");</script>");
					request.getRequestDispatcher("d.jsp").forward(request,
							response);
				}
			}

		} else if (sum < 90 && sum >= 80) {

			tt.add(sum);

			System.out.println("tt������Ϊ" + tt.size());
			if (tt.size() > (a * 0.3)) {
				System.out.println("�жϵȼ�");
				List<TCheckPoints> li = j.tCheckPoints();
				request.setAttribute("ls", li);
				request.setAttribute("pname",name);
				request.setAttribute("detp",teachername);
				request.setAttribute("l",
						"<script>alert(\"�������������������ύ�������´�֣� \");</script>");
				System.out.println("������������,�����ύ�˳ɼ��������´��");
				//request.setAttribute("msg", "�ύʧ��");
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
								"<script>alert(\"���δ����ϣ�\");</script>");
						lg.removeAll(lg);
						System.out.println(lg.size() + "removeAll()");
						ss.removeAll(ss);
						tt.removeAll(tt);
						emp.insertcount(1);

					}
					request.setAttribute("msg",
							"<script>alert(\"�ύ�ɹ� \");</script>");
					// �ж�ʦ���Ĵ�������������������ܵ�Ա�������ǳɱ����ģ���˵��δ����ݻ����ɱ����ķ֣�����ʾ���е�Ա��
					if ((emp.selectEmpTeaCount() % a) == 0) {
						List<Login> ll = emp.empNameAndDept();
						request.setAttribute("ll", ll);
						//request.setAttribute("msg", "tea");
						request.setAttribute("mk","ʦ��");
						request.setAttribute("q",emp.selectcount());
						request.getRequestDispatcher("empsel.jsp").forward(
								request, response);
					} else {
						List<Login> ll = emp.empTeaName();
						request.setAttribute("ll", ll);
						//request.setAttribute("msg", "tea");
						request.setAttribute("mk","ʦ��");
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
							"<script>alert(\"�ύʧ�� \");</script>");
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
			request.setAttribute("msg", "<script>alert(\"�ύ�ɹ� \");</script>");
			if (s == 1) {
				List<TCheckPoints> li = j.tCheckPoints();
				request.setAttribute("ls", li);
				if (lg.size() == a) {
					System.out.println(lg.size() + "=" + a);
					request.setAttribute("l",
							"<script>alert(\"���δ����ϣ�\");</script>");
					lg.removeAll(lg);
					System.out.println(lg.size() + "removeAll()");
					ss.removeAll(ss);
					tt.removeAll(tt);
					emp.insertcount(1);
				}

				// �ж�ʦ���Ĵ�������������������ܵ�Ա�������ǳɱ����ģ���˵��δ����ݻ����ɱ����ķ֣�����ʾ���е�Ա��
				if ((emp.selectEmpTeaCount() %a) == 0) {
					List<Login> ll = emp.empNameAndDept();
					request.setAttribute("ll", ll);
					//request.setAttribute("msg", "tea");
					request.setAttribute("mk","ʦ��");
					request.setAttribute("q",emp.selectcount());
					request.getRequestDispatcher("empsel.jsp").forward(request,
							response);
				} else {
					List<Login> ll = emp.empTeaName();
					request.setAttribute("ll", ll);
					//request.setAttribute("msg", "tea");
					request.setAttribute("mk","ʦ��");
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
						"<script>alert(\"�ύʧ�� \");</script>");
				request.getRequestDispatcher("d.jsp")
						.forward(request, response);
			}
		}
}
}
