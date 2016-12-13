package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCEmp;
import inov.fpf.model.dao.JDBCForemen;
import inov.fpf.model.dao.JDBCHR;
import inov.fpf.model.dao.JDBCMonitor;
import inov.fpf.model.dao.JDBCMsg;
import inov.fpf.model.dao.JDBCNum;
import inov.fpf.model.dao.JDBCTeacher;
import inov.fpf.model.vo.Login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SelServlet
 */
public class SelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JDBCNum n = new JDBCNum();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		super.destroy();
		n.deleteOneM();
		n.deleteOneT();
		n.deleteOneEmpA();
		n.deleteOneEmpB();
		n.deleteOneEmpC();
		n.deleteF();
		n.deleteOneMon();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		n.oneM(1);
		n.oneT(1);
		n.oneEmpA(1);
		n.oneEmpB(1);
		n.oneEmpC(1);
		n.oneF(1);
		n.oneMon(1);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String password = request.getParameter("upassw");
		HttpSession session = request.getSession();
		JDBCEmp p = new JDBCEmp();
		//int r = p.empcount();
		JDBCMsg msg = new JDBCMsg();
		JDBCTeacher teacher = new JDBCTeacher();
		JDBCForemen foremen = new JDBCForemen();
		JDBCMonitor monitor=new JDBCMonitor();
		JDBCHR jr = new JDBCHR();
		if (msg.login(name, password) == true) {
			session.setAttribute("name", name);
			session.setAttribute("title", "manag");
			request.getRequestDispatcher("introduce.jsp").forward(request,
					response);
		}

		else if (teacher.login(name, password) == true) {
			session.setAttribute("name", name);
			session.setAttribute("title", "tea");
			request.getRequestDispatcher("introduce.jsp").forward(request,
					response);
		}

		else if (p.login(name, password) == true) {
			session.setAttribute("name", name);
			session.setAttribute("title", "emp");
			request.getRequestDispatcher("introduce.jsp").forward(request,
					response);
			return;
		}

		else if (jr.login(name, password) == true) {
			session.setAttribute("name", name);
			session.setAttribute("title", "hrm");
			request.getRequestDispatcher("introduce.jsp").forward(request,
					response);
			return;
		} else if (foremen.login(name, password)==true) {
			session.setAttribute("name", name);
			session.setAttribute("title", "cheif");
			request.getRequestDispatcher("introduce.jsp").forward(request,
					response);
		} 
		else if(monitor.login(name, password)==true){
			session.setAttribute("name", name);
			session.setAttribute("title", "leader");
			request.getRequestDispatcher("introduce.jsp").forward(request,
					response);
		}
		else {
			request.setAttribute("msg",
					"<script>alert(\"用户名或密码错误 \");</script>");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}

	}

}
