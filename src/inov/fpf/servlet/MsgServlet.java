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

		// ͨ����ѯԱ���������������������п���
	
		int q = m.selectcount();
	boolean f =m.selectMnName(name);
	/*	boolean h=e.selectErrorName(name);
		if(h==false){
			List<MsgCheckContent> li = com.msgcontent();
			request.setAttribute("list", li);
			request.setAttribute("m",
					"<script>alert(\"���޴�Ա������鿴Ա�����������Ƿ�����\");</script>");
			System.out.println("���޴�Ա������鿴Ա�����������Ƿ�����");
			// request.setAttribute("msg","�ύʧ��");
			request.getRequestDispatcher("grade/d.jsp")
					.forward(request, response);
			return;
		}*/
		if(f==true){
			List<MsgCheckContent> li = com.msgcontent();
			request.setAttribute("list", li);
			request.setAttribute("m",
					"<script>alert(\"��������Ϊ��Ա������֣���Ϊ����Ա����֣�\");</script>");
			System.out.println("������˵ķ����������´��");
			// request.setAttribute("msg","�ύʧ��");
			//�жϾ���Ĵ�������������������ܵ�Ա�������ǳɱ����ģ���˵��δ����ݻ����ɱ����ķ֣�����ʾ���е�Ա��
			if(e.selectEmpMnCount()%t==0){
				List<Login>ll=e.empNameAndDept();
				//request.setAttribute("msg",name);
				request.setAttribute("ll",ll);
				request.setAttribute("mk","����");
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
				request.setAttribute("mk","����");
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
						"<script>alert(\"�����������࣬�����ύ�˷����������´�֣�\");</script>");
				System.out.println("������������");
				
				// request.setAttribute("msg","�ύʧ��");
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
							"<script>alert(\"�ύ�ɹ� \");</script>");
					System.out.println("�ύ�ɹ�");
					if (mngnum.selectMngCount()  == e.empsum()) {
						//System.out.println("lg������Ϊ��"+lg.size());
						request.setAttribute("l",
								"<script>alert(\"��������������� \");</script>");
//						lg.removeAll(lg);
//						System.out.println("remove lg������Ϊ��"+lg.size());
//						ss.removeAll(ss);
//						System.out.println("remove ss������Ϊ��"+ss.size());
//						tt.removeAll(tt);
						mngnum.deleteMngGrade();
						m.insertcount(1);
					}
					//�жϾ���Ĵ�������������������ܵ�Ա�������ǳɱ����ģ���˵��δ����ݻ����ɱ����ķ֣�����ʾ���е�Ա��
					if(e.selectEmpMnCount()%t==0){
						List<Login>ll=e.empNameAndDept();
						//request.setAttribute("msg",name);
						request.setAttribute("ll",ll);
						request.setAttribute("mk","����");
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
						request.setAttribute("mk","����");
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
							"<script>alert(\"�ύʧ�� \");</script>");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
				}
			}

		} else if (sum < 90 && sum >= 80) {
			//tt.add(sum);
			mngnum.MngInsert(2);

			if (mngnum.selectMngGood()  > t * 0.3) {
				//System.out.println("tt��������"+tt.size());
				List<MsgCheckContent> li = com.msgcontent();
				request.setAttribute("list", li);
				request.setAttribute("pname",name);
				request.setAttribute("dept",dept);
				request.setAttribute("name",mag);
				request.setAttribute("m",
						"<script>alert(\"�����������࣬�����ύ�˳ɼ��� \");</script>");
				System.out.println("�����������࣬�����ύ�˳ɼ���");
				//request.setAttribute("msg", "�ύʧ��");
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
							"<script>alert(\"�ύ�ɹ� \");</script>");
					System.out.println("�ύ�ɹ�");
					if (mngnum.selectMngCount()  == e.empsum()) {
						//System.out.println("lg������Ϊ��"+lg.size());
						request.setAttribute("l",
								"<script>alert(\"��������������� \");</script>");
						System.out.println("���������������");
//						lg.removeAll(lg);
//						System.out.println("remove lg������Ϊ��"+lg.size());
//						ss.removeAll(ss);
//						System.out.println("remove ss������Ϊ��"+ss.size());
//						tt.removeAll(tt);
//						System.out.println("remove tt������Ϊ��"+tt.size());
						mngnum.deleteMngGrade();
						m.insertcount(1);
					}
					if(e.selectEmpMnCount()%t==0){
						List<Login>ll=e.empNameAndDept();
						//request.setAttribute("msg",name);
						request.setAttribute("ll",ll);
						request.setAttribute("mk","����");
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
						request.setAttribute("mk","����");
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
							"<script>alert(\"�ύʧ�� \");</script>");
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
						"<script>alert(\"�ύ�ɹ� \");</script>");
				System.out.println("�ύ�ɹ�");
				if (mngnum.selectMngCount()== t) {
					//System.out.println("lg����Ϊ"+lg.size());
					request.setAttribute("l",
							"<script>alert(\"��������������� \");</script>");
					System.out.println("���������������");
					
//					lg.removeAll(lg);
//					System.out.println("lg�Ƴ�������Ϊ"+lg.size());
//					ss.removeAll(ss);
//					System.out.println("ss�Ƴ�������Ϊ"+ss.size());
//					tt.removeAll(tt);
//					System.out.println("tt�Ƴ�������Ϊ"+tt.size());
					mngnum.deleteMngGrade();
					m.insertcount(1);
				}
				if(e.selectEmpMnCount()%t==0){
					List<Login>ll=e.empNameAndDept();
					//request.setAttribute("msg",name);
					request.setAttribute("ll",ll);
					request.setAttribute("mk","����");
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
					request.setAttribute("mk","����");
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
						"<script>alert(\"�ύʧ�� \");</script>");
				request.getRequestDispatcher("grade/d.jsp")
						.forward(request, response);
			}
		}
	}
}
