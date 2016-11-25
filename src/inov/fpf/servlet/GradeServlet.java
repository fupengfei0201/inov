package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCContent;
import inov.fpf.model.vo.Empcontent;
import inov.fpf.model.vo.MsgCheckContent;
import inov.fpf.model.vo.TCheckPoints;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.border.TitledBorder;
import javax.websocket.Session;

/**
 * Servlet implementation class GradeServlet
 */
public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String tilte=(String)session.getAttribute("title");
		String name=request.getParameter("name");
		String dept=request.getParameter("dept");
		System.out.println(name+"\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		JDBCContent j=new JDBCContent();
		//跳转到经理打分页面
		if(tilte.equals("manag")){
		
		List<MsgCheckContent>m=j.msgcontent();
		request.setAttribute("list",m);
		request.setAttribute("pname",name);
		request.setAttribute("dept",dept);
		request.getRequestDispatcher("d.jsp").forward(request, response);
	
		}
		//跳转到师傅打分页面
		if(tilte.equals("tea")){
			List<TCheckPoints>ls=j.tCheckPoints();
			System.out.println(ls.size());
			request.setAttribute("ls",ls);
			request.setAttribute("pname",name);
			request.setAttribute("dept",dept);
			request.getRequestDispatcher("d.jsp").forward(request, response);
		}
		if(tilte.equals("emp")){
			String x="0";
			List<Empcontent>list=j.empcontents();
			request.setAttribute("list",list);
			request.setAttribute("pname",name);
			request.setAttribute("dept",dept);
			session.setAttribute("x",x);
			request.getRequestDispatcher("d.jsp").forward(request, response);
		}
	}

}
