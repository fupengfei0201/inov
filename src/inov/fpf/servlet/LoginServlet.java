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
				//�жϾ���Ĵ�������������������ܵ�Ա�������ǳɱ����ģ���˵��δ����ݻ����ɱ����ķ֣�����ʾ���е�Ա��
				if(p.selectEmpMnCount()%r==0){
					List<Login>ll=p.empNameAndDept(name);
					//request.setAttribute("msg",name);
					request.setAttribute("ll",ll);
					request.setAttribute("mk","����");
					request.setAttribute("q",q);
					request.getRequestDispatcher("empsel.jsp").forward(request, response);	
				}
				else{
					List<Login>ll=p.empMnName();
					request.setAttribute("ll",ll);
					//request.setAttribute("msg",name);
					request.setAttribute("mk","����");
					request.setAttribute("q",q);
					request.getRequestDispatcher("empsel.jsp").forward(request, response);
				}
		}
		if(levle.equals("tea")){
			JDBCTeacher teacher=new JDBCTeacher();
			int q=p.selectcount();
				//�ж�ʦ���Ĵ�������������������ܵ�Ա�������ǳɱ����ģ���˵��δ����ݻ����ɱ����ķ֣�����ʾ���е�Ա��
				if(p.selectEmpTeaCount()%r==0){
					List<Login>ll=p.empNameAndDept(name);
					request.setAttribute("ll",ll);
					//request.setAttribute("msg",levle);
					request.setAttribute("mk","ʦ��");
					request.setAttribute("q",q);
					request.getRequestDispatcher("empsel.jsp").forward(request, response);
				}
				else{
					List<Login>ll=p.empTeaName();
					request.setAttribute("ll",ll);
					//request.setAttribute("msg",levle);
					request.setAttribute("mk","ʦ��");
					request.setAttribute("q",q);
					request.getRequestDispatcher("empsel.jsp").forward(request, response);
				}
		}
		if(levle.equals("emp")){	
				//��Ա������
				if(p.empentry(name)){
					session.setAttribute("r","oldone");
					if(p.selectOnecount()==p.selectTwocount()){
						//��ʾ���Լ�����ı�����Լ�δ��ֵĵ�������ȫ����ʾ
						List<Login>ll=p.empNameAndDeptOne(name, name,name);
						//��ʾ������Ա�����Ա�����д��
						List<Login>lw=p.empNameAndDeptThree(name,name,name);
						int q=p.selectOnecount();
						request.setAttribute("ll",ll);
						request.setAttribute("lw",lw);
						request.setAttribute("mk","��Ա��");
						request.setAttribute("q",q);
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
						
					}
					else if(p.selectOnecount()>p.selectTwocount()){
						//��ʾ������Ա�����Ա�����д��
						List<Login>lw=p.empNameAndDeptTwo(name,name,name);
					
						int q=p.selectTwocount();
						request.setAttribute("q",q);
						request.setAttribute("lw",lw);
						request.setAttribute("mk","��Ա��");
						request.setAttribute("ll","1");
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
						
					}
					else{
						//��ʾ���Լ�����ı�����Լ�δ��ֵĵ�������ȫ����ʾ
						List<Login>ll=p.empNameAndDeptF(name,name,name);
						int q=p.selectOnecount();
						request.setAttribute("ll",ll);
						request.setAttribute("mk","��Ա��");
						request.setAttribute("q",q);
						request.setAttribute("lw","1");
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
						
					}
					/*//�����Ա������һ���д����������Ա���ı�����˵�����������1.��δ����ݣ�2��������Ա������ɱ��ķ�
					if(p.selectEmpOnecount()%r==0){
						//�ٲ�ѯ��Ա����ֱ���������Ա�����ֱ������Ա���ı�����˵�����������1.��δ����ݣ�2��������Ա������ɱ��ķ�
						if(p.selectEmpTwocount()%r==0&&p.selectEmpOnecount()==p.selectEmpTwocount()){
							//����ʾ��Ա����һ������Ա����һ���д��
						List<Login>ll=p.empNameAndDept(name);
						int q=p.selectOnecount();
						request.setAttribute("ll",ll);
						//request.setAttribute("r","oldone");
						session.setAttribute("r","oldone");
						request.setAttribute("mk","��Ա��һ");
						request.setAttribute("q",q);
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						}
						else if(p.selectEmpTwocount()%r==0&&p.selectEmpOnecount()!=p.selectEmpTwocount()){
							
							//��ʾ������Ա�����Ա�����д��
							List<Login>ll=p.empNameAndDeptTwo(name,name);
							int q=p.selectTwocount();
							request.setAttribute("ll",ll);
							//request.setAttribute("r","oldtwo");
							session.setAttribute("r","oldtwo");
							request.setAttribute("mk","��Ա����");
							request.setAttribute("q",q);
							request.getRequestDispatcher("empsel.jsp").forward(request, response);
						}
				
						//�����ʣ��δ��ֵ���Ա��������д��
						else{
							List<Login>ll=p.empNameTwo(name,name);
							int q=p.selectTwocount();
							request.setAttribute("ll",ll);
							//request.setAttribute("r","oldtwo");
							session.setAttribute("r","oldtwo");
							request.setAttribute("mk","��Ա����");
							request.setAttribute("q",q);
							request.getRequestDispatcher("empsel.jsp").forward(request, response);
						}
					}
	
					//�������Ա����һδ�����Ա���д��
				else{
						List<Login>ll=p.empName(name);
						int q=p.selectOnecount();
						request.setAttribute("ll",ll);
						//request.setAttribute("r","oldtwo");
						session.setAttribute("r","oldone");
						request.setAttribute("mk","��Ա��һ");
						request.setAttribute("q",q);
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
					}*/
				
			}
				//��Ա�����֣�д����Ա�����ֱ�
				else{
					if((p.selectEmpNewCount()%r)==0){
						List<Login>ll=p.empNameAndDept(name);
						int q=p.selectNewcount();
						request.setAttribute("ll",ll);
						//request.setAttribute("r","new");
						session.setAttribute("r","new");
						request.setAttribute("mk","��Ա��");
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
						request.setAttribute("mk","��Ա��");
						request.setAttribute("q",q);
						request.setAttribute("lw","1");
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
					}
				}
		}
	}
	
}
