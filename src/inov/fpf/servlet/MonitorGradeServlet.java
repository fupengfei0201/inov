package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCContent;
import inov.fpf.model.dao.JDBCEmp;
import inov.fpf.model.dao.JDBCMonitor;
import inov.fpf.model.dao.JDBCNum;
import inov.fpf.model.vo.Empcontent;
import inov.fpf.model.vo.Empgrade;
import inov.fpf.model.vo.Login;
import inov.fpf.model.vo.Monitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MonitorGradeServlet
 */
public class MonitorGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private List<Integer> lx;
	private List<Integer> sf;
	private List<Integer> td;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonitorGradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		lx = new ArrayList<Integer>();
		sf = new ArrayList<Integer>();
		td = new ArrayList<Integer>();
		System.out.println("init()运行");
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
		// List<Empcontent>list=(ArrayList<Empcontent>)request.getAttribute("list");
		JDBCContent j = new JDBCContent();
		System.out.println("============================================");
		List<Empcontent> list1 = j.empcontents();
		List<Integer> l = new ArrayList<Integer>();
		HttpSession session = request.getSession();
		String ename = (String) session.getAttribute("name");
		// System.out.println(ename);
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		System.out.println(list1.size());
		int sum = 0;
		for (int x = 0; x < list1.size(); x++) {
			int i;
			String grade = request.getParameter("grade" + x);
			System.out.println(grade);
			i = Integer.parseInt(grade);
			l.add(i);
			sum = sum + i;
		}

		if (sum > 100 || sum < 0) {
			List<Empcontent> list = j.empcontents();
			request.setAttribute("list", list);
			request.setAttribute("pname", name);
			request.setAttribute("dept", dept);
			request.setAttribute("msg",
					"<script>alert(\"分数提交有误，不予提交！\");</script>");
			System.out.println("分数提交");
			request.getRequestDispatcher("grade/grade/d.jsp").forward(request,
					response);
			return;
		}
		JDBCMonitor mon=new JDBCMonitor();
		JDBCNum n = new JDBCNum();
		JDBCEmp p=new JDBCEmp();
		
		boolean f=mon.selectEmpMonName(name);
		if(f==true){
			request.setAttribute("m",
					"<script>alert(\"本次此员工已经提交过分数，请为其他员工打分！\");</script>");
			System.out.println("重复提交分数");
			String section=mon.selMonSection(ename);
			int q=mon.selecMoncount();
			int r=mon.selectMonCount(section);
			if((mon.selectMonCount()%p.empcount())==0){
				List<Login>ll=mon.monNameAndDept(section);
			
				request.setAttribute("ll",ll);
				//request.setAttribute("r","new");
				request.setAttribute("mk", "班组长");
				request.setAttribute("q", q);
				request.setAttribute("p", n.selectOneEmpC());
				request.getRequestDispatcher("empsel.jsp").forward(request,
						response);
				return;
				
			}
			else{
				if(mon.selectMon(ename)<((p.empcount()/r)+1)){
					
				
				List<Login>ll=mon.empMonName(section);
			
				request.setAttribute("ll",ll);
				//request.setAttribute("r","new");
				request.setAttribute("mk", "班组长");
				request.setAttribute("q", q);
				request.setAttribute("p", n.selectOneEmpC());
				request.getRequestDispatcher("empsel.jsp").forward(request,
						response);
				return;
			
				
			
				}else{
					request.setAttribute("ll","1");
					request.setAttribute("m",
							"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
					request.setAttribute("mk", "班组长");
					request.setAttribute("q", q);
					request.setAttribute("p", n.selectOneEmpC());
					request.getRequestDispatcher("empsel.jsp").forward(request,
							response);
					return;
				}
			
					
			}
			}
			if (sum >= 90) {
				sf.add(sum);
				System.out.println("sf的数量为" + sf.size());
				if (sf.size() > p.empcount() * 0.3) {
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					request.setAttribute("pname", name);
					request.setAttribute("dept", dept);
					request.setAttribute("msg",
							"<script>alert(\"优秀人数超出，不予提交！\");</script>");
					System.out.println("优秀人数过多");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				} else {
					Monitor monitor = new Monitor(mon.selecMoncount(), name, dept, ename,
							l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
							l.get(5), l.get(6), l.get(7), l.get(8), sum);
					lx.add(sum);
					//JDBCEmp emp = new JDBCEmp();
					int s = mon.empMonInsert(monitor);
					if (s == 1) {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						System.out.println("----------------------");
						request.setAttribute("msg",
								"<script>alert(\"提交成功 \");</script>");
						if (lx.size() == p.empcount()) {
							request.setAttribute("l",
									"<script>alert(\"本次您已评分完毕\")<script>");
							lx.removeAll(lx);
							sf.removeAll(sf);
							td.removeAll(td);
							mon.insertMoncount(1);
							n.oneMon(1);
						}

						String section=mon.selMonSection(ename);
						int q=mon.selecMoncount();
						int r=mon.selectMonCount(section);
						if((mon.selectMonCount()%p.empcount())==0){
							List<Login>ll=mon.monNameAndDept(section);
						
							request.setAttribute("ll",ll);
							//request.setAttribute("r","new");
							request.setAttribute("mk", "班组长");
							request.setAttribute("q", q);
							request.setAttribute("p", n.selectOneEmpC());
							request.getRequestDispatcher("empsel.jsp").forward(request,
									response);
							return;
							
							
						}
						else{
							if(mon.selectMon(ename)<((p.empcount()/r)+1)){
								
							
							List<Login>ll=mon.empMonName(section);
						
							request.setAttribute("ll",ll);
							//request.setAttribute("r","new");
							request.setAttribute("mk", "班组长");
							request.setAttribute("q", q);
							request.setAttribute("p", n.selectOneEmpC());
							request.getRequestDispatcher("empsel.jsp").forward(request,
									response);
							return;
						
							
						
							}else{
								request.setAttribute("ll","1");
								request.setAttribute("m",
										"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
								request.setAttribute("mk", "班组长");
								request.setAttribute("q", q);
								request.setAttribute("p", n.selectOneEmpC());
								request.getRequestDispatcher("empsel.jsp").forward(request,
										response);
								return;
							}
						
						}

					} else {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						request.setAttribute("pname", name);
						request.setAttribute("dept", dept);
						request.setAttribute("msg",
								"<script>alert(\"提交失败 \");</script>");
						request.getRequestDispatcher("grade/d.jsp").forward(request,
								response);
						return;
					}
				}

			} else if (sum >= 80 && sum < 90) {
				td.add(sum);
				if (td.size() > p.empcount()* 0.3) {
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					request.setAttribute("pname", name);
					request.setAttribute("dept", dept);
					request.setAttribute("msg",
							"<script>alert(\"良好人数超出，不予提交！\");</script>");
					System.out.println("良好人数过多");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				} else {

					Monitor monitor = new Monitor(mon.selecMoncount(), name, dept, ename,
							l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
							l.get(5), l.get(6), l.get(7), l.get(8), sum);
					lx.add(sum);
					//JDBCEmp emp = new JDBCEmp();
					int s = mon.empMonInsert(monitor);
					if (s == 1) {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						System.out.println("----------------------");
						request.setAttribute("msg",
								"<script>alert(\"提交成功 \");</script>");
						if (lx.size() >= p.empcount()) {
							request.setAttribute("l",
									"<script>alert(\"本次您已评分完毕\")<script>");
							lx.removeAll(lx);
							sf.removeAll(sf);
							td.removeAll(td);
							mon.insertMoncount(1);
							n.oneMon(1);
						}

						String section=mon.selMonSection(ename);
						int q=mon.selecMoncount();
						int r=mon.selectMonCount(section);
						if((mon.selectMonCount()%p.empcount())==0){
							List<Login>ll=mon.monNameAndDept(section);
						
							request.setAttribute("ll",ll);
							//request.setAttribute("r","new");
							request.setAttribute("mk", "班组长");
							request.setAttribute("q", q);
							request.setAttribute("p", n.selectOneEmpC());
							request.getRequestDispatcher("empsel.jsp").forward(request,
									response);
							return;
							
						}
						else{
							if(mon.selectMon(ename)<((p.empcount()/r)+1)){
								
							
							List<Login>ll=mon.empMonName(section);
						
							request.setAttribute("ll",ll);
							//request.setAttribute("r","new");
							request.setAttribute("mk", "班组长");
							request.setAttribute("q", q);
							request.setAttribute("p", n.selectOneEmpC());
							request.getRequestDispatcher("empsel.jsp").forward(request,
									response);
							return;
						
							
						
							}else{
								request.setAttribute("ll","1");
								request.setAttribute("m",
										"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
								request.setAttribute("mk", "班组长");
								request.setAttribute("q", q);
								request.setAttribute("p", n.selectOneEmpC());
								request.getRequestDispatcher("empsel.jsp").forward(request,
										response);
								return;
							}
						
						}

					} else {
						List<Empcontent> list = j.empcontents();
						request.setAttribute("list", list);
						request.setAttribute("pname", name);
						request.setAttribute("dept", dept);
						request.setAttribute("msg",
								"<script>alert(\"提交失败 \");</script>");
						request.getRequestDispatcher("grade/d.jsp").forward(request,
								response);
						return;
					}

				}

			} else {
				Monitor monitor = new Monitor(mon.selecMoncount(), name, dept, ename,
						l.get(0), l.get(1), l.get(2), l.get(3), l.get(4),
						l.get(5), l.get(6), l.get(7), l.get(8), sum);
				//JDBCEmp emp = new JDBCEmp();
				int s = mon.empMonInsert(monitor);

				if (s == 1) {
					lx.add(sum);
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					System.out.println("----------------------");
					request.setAttribute("msg",
							"<script>alert(\"提交成功 \");</script>");
					if (lx.size() == p.empcount()) {
						request.setAttribute("l",
								"<script>alert(\"本次您已评分完毕\")<script>");
						lx.removeAll(lx);
						sf.removeAll(sf);
						td.removeAll(td);
						mon.insertMoncount(1);
						n.oneMon(1);
					}

					String section=mon.selMonSection(ename);
					int q=mon.selecMoncount();
					int r=mon.selectMonCount(section);
					if((mon.selectMonCount()%p.empcount())==0){
						List<Login>ll=mon.monNameAndDept(section);
					
						request.setAttribute("ll",ll);
						//request.setAttribute("r","new");
						request.setAttribute("mk", "班组长");
						request.setAttribute("q", q);
						request.setAttribute("p", n.selectOneEmpC());
						request.getRequestDispatcher("empsel.jsp").forward(request,
								response);
						return;
						
					}
					else{
						if(mon.selectMon(ename)<((p.empcount()/r)+1)){
							
						
						List<Login>ll=mon.empMonName(section);
					
						request.setAttribute("ll",ll);
						//request.setAttribute("r","new");
					
						request.setAttribute("mk", "班组长");
						request.setAttribute("q", q);
						request.setAttribute("p", n.selectOneEmpC());
						request.getRequestDispatcher("empsel.jsp").forward(request,
								response);
						return;
						
					
						}else{
							request.setAttribute("ll","1");
							request.setAttribute("m",
									"<script>alert(\"您本月已打分完毕，请下次再打\");</script>");
							request.setAttribute("mk", "班组长");
							request.setAttribute("q", q);
							request.setAttribute("p", n.selectOneEmpC());
							request.getRequestDispatcher("empsel.jsp").forward(request,
									response);
							return;
						}
					}
				} else {
					List<Empcontent> list = j.empcontents();
					request.setAttribute("list", list);
					request.setAttribute("msg",
							"<script>alert(\"提交失败 \");</script>");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				}
			}
		}
	
}
