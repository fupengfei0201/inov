package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCPwd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FindPwdServlet
 */
public class FindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		System.out.println(name);
		HttpSession session = request.getSession();
		JDBCPwd p = new JDBCPwd();
		if(p.checkEmp(name)==true){
			session.setAttribute("name", name);
			session.setAttribute("title", "emp");
			System.out.println("emp");
			request.getRequestDispatcher("findpwd2.jsp").forward(request,response);
		}
		else if(p.checkTeacher(name)==true){
			session.setAttribute("name", name);
			session.setAttribute("title", "tea");
			System.out.println("tea");
			request.getRequestDispatcher("findpwd2.jsp").forward(request,response);
		}
		else if(p.checkMng(name)==true){
			session.setAttribute("name", name);
			session.setAttribute("title", "mng");
			System.out.println("mng");
			request.getRequestDispatcher("findpwd2.jsp").forward(request,response);
		}
		else if(p.checkHR(name)==true){
			session.setAttribute("name", name);
			session.setAttribute("title", "hr");
			System.out.println("hr");
			request.getRequestDispatcher("findpwd2.jsp").forward(request,response);
		}
		else if(p.checkForemen(name)==true){
			session.setAttribute("name", name);
			session.setAttribute("title", "for");
			System.out.println("for");
			request.getRequestDispatcher("findpwd2.jsp").forward(request,response);
		}
		else if(p.checkMonitor(name)==true){
			session.setAttribute("name", name);
			session.setAttribute("title", "mon");
			System.out.println("mon");
			request.getRequestDispatcher("findpwd2.jsp").forward(request,response);
		}
		else{
			request.setAttribute("msg","<script>alert(\"无此员工信息，请重新输入！ \");</script>");
			request.getRequestDispatcher("findpwd.jsp").forward(request, response);
		}
	}

}
