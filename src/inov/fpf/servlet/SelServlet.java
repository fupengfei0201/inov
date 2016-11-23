package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCEmp;
import inov.fpf.model.dao.JDBCMsg;
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelServlet() {
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
		String name=request.getParameter("uname");
		String password=request.getParameter("upassw");
		String levle=request.getParameter("title");
		boolean t;
		HttpSession session=request.getSession();
		JDBCEmp p=new JDBCEmp();
		int r=p.empcount();
		if(levle.equals("manag")){
			JDBCMsg msg=new JDBCMsg();
			 t=msg.login(name, password);
			if(t==true){
				session.setAttribute("name",name);
				session.setAttribute("title",levle);
				request.getRequestDispatcher("introduce.jsp").forward(request, response);			
			}
			else{
				request.setAttribute("msg","<script>alert(\"用户名或密码错误 \");</script>");
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
		}
		if(levle.equals("tea")){
			JDBCTeacher teacher=new JDBCTeacher();
			t=teacher.login(name, password);
			if(t==true){
				session.setAttribute("name",name);
				session.setAttribute("title",levle);
				request.getRequestDispatcher("introduce.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msg","<script>alert(\"用户名或密码错误 \");</script>");
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
		}
		if(levle.equals("emp")){
			
			t=p.login(name, password);
			if(t==true){
				session.setAttribute("name",name);
				session.setAttribute("title",levle);
				request.getRequestDispatcher("introduce.jsp").forward(request, response);
				return;		
				}
			else{
				request.setAttribute("msg","<script>alert(\"用户名或密码错误 \");</script>");
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
		}
	}

}
