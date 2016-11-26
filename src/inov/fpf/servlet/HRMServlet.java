package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCHR;
import inov.fpf.model.vo.HRGrade;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HRMServlet
 */
public class HRMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HRMServlet() {
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
		String years=request.getParameter("years");
		String months=request.getParameter("months");
				String time=years+"-"+months;
				System.out.println(time+"时间");
		JDBCHR jr=new JDBCHR();
		List<HRGrade>list=jr.allemp(time);
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("name");
		String levle=(String)session.getAttribute("title");
		request.setAttribute("pname",name);
		request.setAttribute("detp",levle);
		session.setAttribute("name",name);
		session.setAttribute("title",levle);
		if(list.isEmpty()){
			request.setAttribute("list", "0");
			request.setAttribute("x",
					"<script>alert(\"暂无员工得分\");</script>");
		
			request.getRequestDispatcher("d.jsp").forward(request, response);
		}
		else{
		request.setAttribute("list", list);
		request.setAttribute("time",time);
		request.getRequestDispatcher("d.jsp").forward(request, response);	}
	}

}
