package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCHR;
import inov.fpf.model.dao.JDBCMsg;
import inov.fpf.model.vo.MsgSelect;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MsgSelectServlet
 */
public class MsgSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgSelectServlet() {
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
//		request.setAttribute("yy",years);
//		request.setAttribute("mm",months);
		String time=years+"-"+months;
		System.out.println(time+"时间");
		JDBCMsg ms=new JDBCMsg();
		List<MsgSelect>list=ms.allMsgemp(time);
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("name");
		String levle=(String)session.getAttribute("title");
		request.setAttribute("pname",name);
		request.setAttribute("detp",levle);
		session.setAttribute("name",name);
		session.setAttribute("title",levle);
		session.setAttribute("T", "b");
		if(list.isEmpty()){
			session.setAttribute("list","0");
			request.setAttribute("x",
					"<script>alert(\"暂无员工得分\");</script>");
			request.getRequestDispatcher("grade/mngselgrade.jsp").forward(request, response);
			return;
		}
		else{
		session.setAttribute("list","1");
		request.setAttribute("list",list);
		request.setAttribute("time",time);
		request.getRequestDispatcher("grade/mngselgrade.jsp").forward(request, response);
		return;
		}
	}

}
