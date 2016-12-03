package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCReg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MonitorRegServlet
 */
public class MonitorRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonitorRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String passw=request.getParameter("pwd");
		String passw1=request.getParameter("pwd1");
		String section=request.getParameter("dname");
		if(!passw.equals(passw1)){
			
			System.out.println("注册失败，两次密码不一致");
			request.getRequestDispatcher("register/tleaderregister.jsp").forward(request, response);
			return;
	}
		if(name==null||passw==null||section==null){
			System.out.println("用户名或密码为空");
			request.getRequestDispatcher("register/tleaderregister.jsp").forward(request, response);
			return;
		}
		JDBCReg reg=new JDBCReg();
		if(reg.Section(section)==false){
			 request.setAttribute("msg","<script>alert(\"您输入的工段名称不存在\");</script>");
			System.out.println("工段名称不存在");
			request.getRequestDispatcher("register/tleaderregister.jsp").forward(request, response);
			return;
		}
		boolean t=reg.monitorlogin(name);
		if(t==false){
		int i=reg.regMonitor(name, passw,section);
		if(i==1){
			 request.setAttribute("msg","<script>alert(\"注册成功\");</script>");
			System.out.println("注册成功");
			request.getRequestDispatcher("register/tleaderregister.jsp").forward(request, response);
		}
		else{
			 request.setAttribute("msg","<script>alert(\"注册失败,请重新注册\");</script>");
			request.getRequestDispatcher("register/tleaderregister.jsp").forward(request, response);
		}
		}
		else{
			request.setAttribute("msg","<script>alert(\"此用户名正在使用中，请勿注册\");</script>");
			request.getRequestDispatcher("register/tleaderregister.jsp").forward(request, response);
		}
	}

}
