package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCReg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HRMRigServlet
 */
public class HRMRigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HRMRigServlet() {
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
		JDBCReg reg=new JDBCReg();
		System.out.println("��ת����ע���̨");
		int i=reg.regHr(name,passw);
		if(i==1){
			request.setAttribute("ע��ɹ�","msg");
			System.out.println("ע��ɹ�");
			request.getRequestDispatcher("register/hrmregister.jsp").forward(request, response);
		}
		else{
			request.setAttribute("ע��ʧ��,������ע��","msg");
			request.getRequestDispatcher("register/hrmregister.jsp").forward(request, response);
		}
		
	}

}
