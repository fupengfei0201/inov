package inov.fpf.servlet;


import inov.fpf.model.dao.JDBCEmp;
import inov.fpf.model.dao.JDBCForemen;
import inov.fpf.model.dao.JDBCMonitor;
import inov.fpf.model.dao.JDBCMsg;
import inov.fpf.model.dao.JDBCNum;
import inov.fpf.model.vo.Login;

import java.io.IOException;
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
		//String password=request.getParameter("upassw");
		String levle=(String)session.getAttribute("title");
		System.out.println(name);
		System.out.println(levle);
		//boolean t;
		JDBCEmp p=new JDBCEmp();

		
		JDBCNum n=new JDBCNum();
		//Login l=new Login();
		if(levle.equals("hrm")){
			session.setAttribute("list","0");
			request.getRequestDispatcher("grade/d.jsp").forward(request, response);		
		}
		if(levle.equals("cheif")){
			JDBCForemen foremen=new JDBCForemen();
			String section=foremen.selForSection(name);
			System.out.println(section);
			int q=foremen.selectForcount();
			int r=p.empcount(section);
			//判断工段长的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
			if(p.selectEmpForCount(section)%r==0){
				List<Login>ll=p.forNameAndDept(section);
				request.setAttribute("ll",ll);
				//request.setAttribute("msg",levle);
				request.setAttribute("mk","工段长");
				request.setAttribute("q",q);
				request.setAttribute("p",n.selectF());
				request.getRequestDispatcher("empsel.jsp").forward(request, response);
				return;
			}
			else{
				List<Login>ll=p.empForName(section);
				request.setAttribute("ll",ll);
				//request.setAttribute("msg",levle);
				request.setAttribute("mk","工段长");
				request.setAttribute("q",q);
				request.setAttribute("p",n.selectF());
				request.getRequestDispatcher("empsel.jsp").forward(request, response);
				return;
			}
			
		}
		if(levle.equals("leader")){
			JDBCMonitor mon=new JDBCMonitor();
			String section=mon.selMonSection(name);
			int r=p.empcount(section);
			if((mon.selectMonC(section)%r)==0){
				List<Login>ll=mon.monNameAndDept(section);
				int q=mon.selecMoncount();
				request.setAttribute("ll",ll);
				//request.setAttribute("r","new");
				request.setAttribute("mk","班组长");
				request.setAttribute("q",q);
				request.setAttribute("p",n.selectOneMon());
				request.getRequestDispatcher("empsel.jsp").forward(request, response);
			}
			else{
				if(mon.selectMon(name)<((p.empcount(section)/mon.selectMonCount(section))+1)){
				List<Login>ll=mon.empMonName(section);
				int q=mon.selecMoncount();
				request.setAttribute("ll",ll);
				//request.setAttribute("r","new");
				request.setAttribute("mk","班组长");
				request.setAttribute("q",q);
				request.setAttribute("p",n.selectOneMon());
			
				}else{
					int q=mon.selecMoncount();
					request.setAttribute("ll","1");
					request.setAttribute("m",
							"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
					request.setAttribute("mk","班组长");
					request.setAttribute("q",q);
					request.setAttribute("p",n.selectOneMon());
				}
				request.getRequestDispatcher("empsel.jsp").forward(request, response);	
				return;
			}
		}
		if(levle.equals("manag")){
			JDBCMsg msg=new JDBCMsg();
			int q=msg.selectcount();
			int r=p.empsum();
				//判断经理的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
				if(p.selectEmpMnCount()%r==0){
					List<Login>ll=p.empNameAndDept();
					//request.setAttribute("msg",name);
					request.setAttribute("ll",ll);
					request.setAttribute("mk","经理");
					request.setAttribute("q",q);
					request.setAttribute("p",n.selectOneM());
					session.setAttribute("list","0");
					//session.setAttribute("T","a");
					request.getRequestDispatcher("empsel.jsp").forward(request, response);
					return;
				}
				else{
					List<Login>ll=p.empMnName();
					request.setAttribute("ll",ll);
					//request.setAttribute("msg",name);
					request.setAttribute("mk","经理");
					request.setAttribute("q",q);
					request.setAttribute("p",n.selectOneM());
					session .setAttribute("list","0");
					request.getRequestDispatcher("empsel.jsp").forward(request, response);
					return;
				}
		}
		if(levle.equals("tea")){
			//JDBCTeacher teacher=new JDBCTeacher();
			int q=p.selectcount();
			String section=p.selectTeaSection(name);
			int r=p.empcount(section);
				//判断师傅的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
				if(p.selectEmpTeaCount(section)%r==0){
					List<Login>ll=p.teaNameAndDept(name);
					request.setAttribute("ll",ll);
					//request.setAttribute("msg",levle);
					request.setAttribute("mk","师傅");
					request.setAttribute("q",q);
					request.setAttribute("p",n.selectOneT());
					request.getRequestDispatcher("empsel.jsp").forward(request, response);
				}
				else{
					List<Login>ll=p.empTeaName(name);
					request.setAttribute("ll",ll);
					//request.setAttribute("msg",levle);
					request.setAttribute("mk","师傅");
					request.setAttribute("q",q);
					request.setAttribute("p",n.selectOneT());
					request.getRequestDispatcher("empsel.jsp").forward(request, response);
				}
		}
		if(levle.equals("emp")){	
				//老员工评分
				if(p.empentry(name)){
					session.setAttribute("r","oldone");
					String section=p.selectSection(name);
					if(p.selectOnecount()==p.selectTwocount()){
						//显示除自己以外的表二中自己未打分的的所有人全部显示
						List<Login>ll=p.empNameAndDeptOne(name, name,name,section);
						//显示所有老员工，对表二进行打分
						List<Login>lw=p.empNameAndDeptThree(name,name,name,section);
						if(n.selectOneEmpA()==n.selectOneEmpB()){
							request.setAttribute("p",n.selectOneEmpA());
						}
						else if(n.selectOneEmpA()<n.selectOneEmpB()){
							request.setAttribute("p",n.selectOneEmpA());
						}
						else{
							request.setAttribute("p",n.selectOneEmpB());
						}
						int q=p.selectOnecount();
						if((p.selectOneA(name)+p.selectTwoB(name))<3){
						request.setAttribute("ll",ll);
						request.setAttribute("lw",lw);
						
						}
						else{
							request.setAttribute("ll","1");
							request.setAttribute("lw","1");	
							request.setAttribute("m",
									"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
						}
						request.setAttribute("mk","老员工");
						request.setAttribute("q",q);
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
						
					}
					else if(p.selectOnecount()>p.selectTwocount()){
						//显示所有老员工，对表二进行打分
						List<Login>lw=p.empNameAndDeptTwo(name,name,name,section);
						int q=p.selectTwocount();
						if(n.selectOneEmpA()==n.selectOneEmpB()){
							request.setAttribute("p",n.selectOneEmpA());
						}
						else if(n.selectOneEmpA()<n.selectOneEmpB()){
							request.setAttribute("p",n.selectOneEmpA());
						}
						else{
							request.setAttribute("p",n.selectOneEmpB());
						}
						if((p.selectOne(name)+p.selectTwoB(name))<3){
						
						request.setAttribute("lw",lw);
						
						request.setAttribute("ll","1");
						}
						else{
							request.setAttribute("ll","1");
							request.setAttribute("lw","1");
							request.setAttribute("m",
									"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
						}
						request.setAttribute("q",q);
						request.setAttribute("mk","老员工");
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
						
					}
					else{
					
						//显示除自己以外的表二中自己未打分的的所有人全部显示
						List<Login>ll=p.empNameAndDeptF(name,name,name,section);
						int q=p.selectOnecount();
						if(n.selectOneEmpA()==n.selectOneEmpB()){
							request.setAttribute("p",n.selectOneEmpA());
						}
						else if(n.selectOneEmpA()<n.selectOneEmpB()){
							request.setAttribute("p",n.selectOneEmpA());
						}
						else{
							request.setAttribute("p",n.selectOneEmpB());
						}
						if((p.selectOneA(name)+p.selectTwo(name))<3){
						request.setAttribute("ll",ll);
					
						request.setAttribute("lw","1");
						}
						else{
							request.setAttribute("ll","1");
							request.setAttribute("lw","1");
							request.setAttribute("m",
									"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
						}
						request.setAttribute("mk","老员工");
						request.setAttribute("q",q);
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;						
					}
			}
				//新员工评分，写入新员工评分表
				else{
					String section=p.selectSection(name);
					int r=p.empcount(section);
					if((p.selectEmpNewCount()%r)==0){
						List<Login>ll=p.empNameAndDept(name,section);
						int q=p.selectNewcount();
						request.setAttribute("ll",ll);
						//request.setAttribute("r","new");
						session.setAttribute("r","new");
						request.setAttribute("mk","新员工");
						request.setAttribute("q",q);
						request.setAttribute("p",n.selectOneEmpC());
						request.setAttribute("lw","1");
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
					}
					else{
						if(p.selectNew(name)<3){
						List<Login>ll=p.empNewName(name,section);
						int q=p.selectNewcount();
						request.setAttribute("ll",ll);
						//request.setAttribute("r","new");
						session.setAttribute("r","new");
						request.setAttribute("mk","新员工");
						request.setAttribute("q",q);
						request.setAttribute("p",n.selectOneEmpC());
						request.setAttribute("lw","1");
						}else{
							request.setAttribute("ll","1");
							request.setAttribute("lw","1");	
							request.setAttribute("m","<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
						}
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
					}
				}
		}
	}
	
}
