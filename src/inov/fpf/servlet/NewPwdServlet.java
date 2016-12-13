package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCNewPwd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NewPwdServlet
 */
public class NewPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPwdServlet() {
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
		HttpSession session = request.getSession();
		String name=(String) session.getAttribute("name");
		String pwd = request.getParameter("pwd");
		String title=(String) session.getAttribute("title");
		System.out.println(name);
		System.out.println(pwd);
		System.out.println(title);
		JDBCNewPwd p=new JDBCNewPwd();
		if(title.equals("emp")){
			p.EmpnewPwd(pwd, name);
			request.getRequestDispatcher("findpwd3.jsp").forward(request,response);
			return;
		}
		if(title.equals("tea")){
			p.TeachernewPwd(pwd, name);
			request.getRequestDispatcher("findpwd3.jsp").forward(request,response);
			return;
		}
		if(title.equals("mng")){
			p.MngnewPwd(pwd, name);
			request.getRequestDispatcher("findpwd3.jsp").forward(request,response);
			return;
		}
		if(title.equals("hr")){
			p.HRnewPwd(pwd, name);
			request.getRequestDispatcher("findpwd3.jsp").forward(request,response);
			return;
		}
		if(title.equals("for")){
			p.ForemennewPwd(pwd, name);
			request.getRequestDispatcher("findpwd3.jsp").forward(request,response);
		}
		if(title.equals("mon")){
			p.MngnewPwd(pwd, name);
			request.getRequestDispatcher("findpwd3.jsp").forward(request,response);
			return;
		}
		else{
			request.setAttribute("msg","<script>alert(\"ÐÞ¸ÄÊ§°Ü£¡ \");</script>");
			request.getRequestDispatcher("findpwd2.jsp").forward(request, response);
			return;
		}
	}

}
