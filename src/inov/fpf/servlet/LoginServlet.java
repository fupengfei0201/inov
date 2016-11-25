package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCContent;
import inov.fpf.model.dao.JDBCEmp;
import inov.fpf.model.dao.JDBCMsg;
import inov.fpf.model.dao.JDBCTeacher;
import inov.fpf.model.vo.Empcontent;
import inov.fpf.model.vo.Login;
import inov.fpf.model.vo.MsgCheckContent;
import inov.fpf.model.vo.TCheckPoints;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("name");
		String password=request.getParameter("upassw");
		String levle=(String)session.getAttribute("title");
		System.out.println(name);
		System.out.println(levle);
		//boolean t;
		JDBCEmp p=new JDBCEmp();
		int r=p.empcount();
		//Login l=new Login();
		if(levle.equals("hrm")){
			request.setAttribute("list","0");
			request.getRequestDispatcher("d.jsp").forward(request, response);		
		}
		if(levle.equals("manag")){
			JDBCMsg msg=new JDBCMsg();
			int q=msg.selectcount();
				//判断经理的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
				if(p.selectEmpMnCount()%r==0){
					List<Login>ll=p.empNameAndDept(name);
					//request.setAttribute("msg",name);
					request.setAttribute("ll",ll);
					request.setAttribute("mk","经理");
					request.setAttribute("q",q);
					request.getRequestDispatcher("empsel.jsp").forward(request, response);	
				}
				else{
					List<Login>ll=p.empMnName();
					request.setAttribute("ll",ll);
					//request.setAttribute("msg",name);
					request.setAttribute("mk","经理");
					request.setAttribute("q",q);
					request.getRequestDispatcher("empsel.jsp").forward(request, response);
				}
		}
		if(levle.equals("tea")){
			JDBCTeacher teacher=new JDBCTeacher();
			int q=p.selectcount();
				//判断师傅的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
				if(p.selectEmpTeaCount()%r==0){
					List<Login>ll=p.empNameAndDept(name);
					request.setAttribute("ll",ll);
					//request.setAttribute("msg",levle);
					request.setAttribute("mk","师傅");
					request.setAttribute("q",q);
					request.getRequestDispatcher("empsel.jsp").forward(request, response);
				}
				else{
					List<Login>ll=p.empTeaName();
					request.setAttribute("ll",ll);
					//request.setAttribute("msg",levle);
					request.setAttribute("mk","师傅");
					request.setAttribute("q",q);
					request.getRequestDispatcher("empsel.jsp").forward(request, response);
				}
		}
		if(levle.equals("emp")){	
				//老员工评分
				if(p.empentry(name)){
					session.setAttribute("r","oldone");
					if(p.selectOnecount()==p.selectTwocount()){
						//显示除自己以外的表二中自己未打分的的所有人全部显示
						List<Login>ll=p.empNameAndDeptOne(name, name,name);
						//显示所有老员工，对表二进行打分
						List<Login>lw=p.empNameAndDeptThree(name,name,name);
						int q=p.selectOnecount();
						request.setAttribute("ll",ll);
						request.setAttribute("lw",lw);
						request.setAttribute("mk","老员工");
						request.setAttribute("q",q);
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
						
					}
					else if(p.selectOnecount()>p.selectTwocount()){
						//显示所有老员工，对表二进行打分
						List<Login>lw=p.empNameAndDeptTwo(name,name,name);
					
						int q=p.selectTwocount();
						request.setAttribute("q",q);
						request.setAttribute("lw",lw);
						request.setAttribute("mk","老员工");
						request.setAttribute("ll","1");
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
						
					}
					else{
						//显示除自己以外的表二中自己未打分的的所有人全部显示
						List<Login>ll=p.empNameAndDeptF(name,name,name);
						int q=p.selectOnecount();
						request.setAttribute("ll",ll);
						request.setAttribute("mk","老员工");
						request.setAttribute("q",q);
						request.setAttribute("lw","1");
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
						
					}
					/*//如果老员工评分一表中打分数量是总员工的倍数，说明两种情况：1.从未打过份，2，给所有员工打过成倍的分
					if(p.selectEmpOnecount()%r==0){
						//再查询老员工打分表二，如果老员工评分表二是总员工的倍数，说明两种情况：1.从未打过份，2，给所有员工打过成倍的分
						if(p.selectEmpTwocount()%r==0&&p.selectEmpOnecount()==p.selectEmpTwocount()){
							//先显示老员工表一，对老员工表一进行打分
						List<Login>ll=p.empNameAndDept(name);
						int q=p.selectOnecount();
						request.setAttribute("ll",ll);
						//request.setAttribute("r","oldone");
						session.setAttribute("r","oldone");
						request.setAttribute("mk","老员工一");
						request.setAttribute("q",q);
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						}
						else if(p.selectEmpTwocount()%r==0&&p.selectEmpOnecount()!=p.selectEmpTwocount()){
							
							//显示所有老员工，对表二进行打分
							List<Login>ll=p.empNameAndDeptTwo(name,name);
							int q=p.selectTwocount();
							request.setAttribute("ll",ll);
							//request.setAttribute("r","oldtwo");
							session.setAttribute("r","oldtwo");
							request.setAttribute("mk","老员工二");
							request.setAttribute("q",q);
							request.getRequestDispatcher("empsel.jsp").forward(request, response);
						}
				
						//否则对剩余未打分的老员工二表进行打分
						else{
							List<Login>ll=p.empNameTwo(name,name);
							int q=p.selectTwocount();
							request.setAttribute("ll",ll);
							//request.setAttribute("r","oldtwo");
							session.setAttribute("r","oldtwo");
							request.setAttribute("mk","老员工二");
							request.setAttribute("q",q);
							request.getRequestDispatcher("empsel.jsp").forward(request, response);
						}
					}
	
					//否则对老员工表一未打分人员进行打分
				else{
						List<Login>ll=p.empName(name);
						int q=p.selectOnecount();
						request.setAttribute("ll",ll);
						//request.setAttribute("r","oldtwo");
						session.setAttribute("r","oldone");
						request.setAttribute("mk","老员工一");
						request.setAttribute("q",q);
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
					}*/
				
			}
				//新员工评分，写入新员工评分表
				else{
					if((p.selectEmpNewCount()%r)==0){
						List<Login>ll=p.empNameAndDept(name);
						int q=p.selectNewcount();
						request.setAttribute("ll",ll);
						//request.setAttribute("r","new");
						session.setAttribute("r","new");
						request.setAttribute("mk","新员工");
						request.setAttribute("q",q);
						request.setAttribute("lw","1");
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
					}
					else{
						List<Login>ll=p.empNewName(name);
						int q=p.selectNewcount();
						request.setAttribute("ll",ll);
						//request.setAttribute("r","new");
						session.setAttribute("r","new");
						request.setAttribute("mk","新员工");
						request.setAttribute("q",q);
						request.setAttribute("lw","1");
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
					}
				}
		}
	}
	
}
