package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCContent;
import inov.fpf.model.vo.Empcontent;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GradeTwoServlet
 */
public class GradeTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeTwoServlet() {
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
		HttpSession session=request.getSession();
		String tilte=(String)session.getAttribute("title");
		String name=request.getParameter("name");
		String dept=request.getParameter("dept");
		String x="1";
		//System.out.println(name+"\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		JDBCContent j=new JDBCContent();
		if(tilte.equals("emp")){
			List<Empcontent>list=j.empcontents();
			request.setAttribute("list",list);
			request.setAttribute("pname",name);
			request.setAttribute("dept",dept);
			session.setAttribute("x",x);
			request.getRequestDispatcher("d.jsp").forward(request, response);
		}
	}

}
