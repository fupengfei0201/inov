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
			request.setAttribute("msg", "<script>alert(\"ʦ����������\");</script>");
			System.out.println("ʦ����������");
			request.getRequestDispatcher("register/empregister.jsp").forward(request, response);
			return;
		}
		if(time.equals("")){
			request.setAttribute("msg", "<script>alert(\"��������ְʱ�䣡\");</script>");
			System.out.println("��ְʱ��Ϊ��");
			request.getRequestDispatcher("register/empregister.jsp").forward(request, response);
			return;
		}
		String edu=request.getParameter("edu");
		String dept=request.getParameter("dept");
		String passw1=request.getParameter("pwd1");
		if(!passw.equals(passw1)){
		
			System.out.println("ע��ʧ�ܣ��������벻һ��");
			request.getRequestDispatcher("register/empregister.jsp").forward(request, response);
			return;
		}
		if(name==null||passw==null||edu==null||dept==null||section==null){
			System.out.println("��δ����");
			request.getRequestDispatcher("register/empregister.jsp").forward(request, response);
			return;
		}
		JDBCReg reg=new JDBCReg();
		boolean t=reg.emplogin(name);
		if(t==false){
		int i=reg.regEmp(name, passw,time,edu,dept,teachername,section);
		if(i==1){
			
			request.setAttribute("msg", "<script>alert(\"ע��ɹ���\");</script>");
			System.out.println("ע��ɹ�");
			request.getRequestDispatcher("c.jsp").forward(request, response);
		}
		else{
			 request.setAttribute("msg","<script>alert(\"ע��ʧ��,������ע��\");</script>");
			request.getRequestDispatcher("register/empregister.jsp").forward(request, response);
		}
		}
		else{
			request.setAttribute("msg","<script>alert(\"���û�������ʹ���У�����ע��\");</script>");
			request.getRequestDispatcher("register/empregister.jsp").forward(request, response);
		}
	}

}
