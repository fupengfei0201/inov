package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCReg;
import inov.fpf.model.dao.JDBCTeacher;
import inov.fpf.model.vo.Teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpRegServlet
 */
public class EmpRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpRegServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String passw=request.getParameter("pwd");
		String time=request.getParameter("time");
		String teachername=request.getParameter("tea");
		String section=request.getParameter("dname");
		JDBCTeacher teacher=new JDBCTeacher();
		if(teachername.equals("")||(teacher.selectTeacher(teachername))==false){
			request.setAttribute("msg", "<script>alert(\"师傅姓名有误！\");</script>");
			System.out.println("师傅姓名有误");
			request.getRequestDispatcher("register/empregister.jsp").forward(request, response);
			return;
		}
		if(time.equals("")){
			request.setAttribute("msg", "<script>alert(\"请输入入职时间！\");</script>");
			System.out.println("入职时间为空");
			request.getRequestDispatcher("register/empregister.jsp").forward(request, response);
			return;
		}
		String edu=request.getParameter("edu");
		String dept=request.getParameter("dept");
		String passw1=request.getParameter("pwd1");
		if(!passw.equals(passw1)){
		
			System.out.println("注册失败，两次密码不一致");
			request.getRequestDispatcher("register/empregister.jsp").forward(request, response);
			return;
		}
		if(name==null||passw==null||edu==null||dept==null||section==null){
			System.out.println("有未填项");
			request.getRequestDispatcher("register/empregister.jsp").forward(request, response);
			return;
		}
		JDBCReg reg=new JDBCReg();
		boolean t=reg.emplogin(name);
		if(t==false){
		int i=reg.regEmp(name, passw,time,edu,dept,teachername,section);
		if(i==1){
			
			request.setAttribute("msg", "<script>alert(\"注册成功！\");</script>");
			System.out.println("注册成功");
			request.getRequestDispatcher("c.jsp").forward(request, response);
		}
		else{
			 request.setAttribute("msg","<script>alert(\"注册失败,请重新注册\");</script>");
			request.getRequestDispatcher("register/empregister.jsp").forward(request, response);
		}
		}
		else{
			request.setAttribute("msg","<script>alert(\"此用户名正在使用中，请勿注册\");</script>");
			request.getRequestDispatcher("register/empregister.jsp").forward(request, response);
		}
	}

}
