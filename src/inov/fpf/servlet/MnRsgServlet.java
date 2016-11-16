package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCReg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MnServlet
 */
public class MnRsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MnRsgServlet() {
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
		JDBCReg reg=new JDBCReg();
		int i=reg.regMsg(name, passw);
		if(i==1){
			request.setAttribute("×¢²á³É¹¦","msg");
			System.out.println("×¢²á³É¹¦");
			request.getRequestDispatcher("register/mngregister.jsp").forward(request, response);
		}
		else{
			request.setAttribute("×¢²áÊ§°Ü,ÇëÖØÐÂ×¢²á","msg");
			request.getRequestDispatcher("register/mngregister.jsp").forward(request, response);
		}
		
	}

}
