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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String tilte=(String)session.getAttribute("title");
		JDBCContent j=new JDBCContent();
		//跳转到经理打分页面
		if(tilte.equals("manag")){
		
		List<MsgCheckContent>m=j.msgcontent();
		request.setAttribute("list",m);
		request.getRequestDispatcher("d.jsp").forward(request, response);
		}
		//跳转到师傅打分页面
		if(tilte.equals("tea")){
			List<TCheckPoints>ls=j.tCheckPoints();
			System.out.println(ls.size());
			request.setAttribute("ls",ls);
			request.getRequestDispatcher("d.jsp").forward(request, response);
		}
		if(tilte.equals("emp")){
			List<Empcontent>list=j.empcontents();
			request.setAttribute("list",list);
			request.getRequestDispatcher("d.jsp").forward(request, response);
		}
	}

}
