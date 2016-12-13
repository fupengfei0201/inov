package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCContent;
import inov.fpf.model.dao.JDBCEmp;
import inov.fpf.model.dao.JDBCForemen;
import inov.fpf.model.dao.JDBCGradeNum;
import inov.fpf.model.dao.JDBCNum;
import inov.fpf.model.vo.ForemenGrade;
import inov.fpf.model.vo.Login;
import inov.fpf.model.vo.TCheckPoints;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForemenGradeServlet
 */
public class ForemenGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForemenGradeServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String foremenname = request.getParameter("detp");
		String comm = request.getParameter("comm");
		System.out.println(name);
		System.out.println(foremenname);
		JDBCContent j = new JDBCContent();
		List<TCheckPoints> list1 = j.tCheckPoints();
		List<Integer> l = new ArrayList<Integer>();
		//JDBCTeacher t = new JDBCTeacher();
		JDBCForemen foremen=new JDBCForemen();
		JDBCEmp emp = new JDBCEmp();
		JDBCNum n=new JDBCNum();
		JDBCGradeNum fmnum = new JDBCGradeNum();
		String section=foremen.selForSection(foremenname);
		int sum = 0;
		for (int i = 0; i < list1.size(); i++) {
			
			String grade = request.getParameter("grade" + i);
			System.out.println(grade);
			int x = Integer.parseInt(grade.trim());
			l.add(x);
			sum = sum + x;

		}
		if(sum>100||sum<0){
			List<TCheckPoints> li = j.tCheckPoints();
			request.setAttribute("ls", li);
			request.setAttribute("pname",name);
			request.setAttribute("detp",foremenname);
			request.setAttribute("m",
					"<script>alert(\"分数提交有误，不予提交\");</script>");
			System.out.println("分数提交有误");
			//request.setAttribute("msg", "提交失败");
			request.getRequestDispatcher("grade/d.jsp")
					.forward(request, response);
			return;
		}
		boolean f=foremen.selectName(name);
		double a = emp.empsum();
		int q = emp.selectcount();
		if(f==true){
			request.setAttribute("m",
					"<script>alert(\"已为此员工打过分，请勿再打分 \");</script>");
			System.out.println("已为此员工打过分，请勿再打分");
			//request.setAttribute("msg", "提交失败");
			
			//判断工段长的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
			if(emp.selectEmpForCount(section)%emp.empcount(section)==0){
				List<Login>ll=emp.forNameAndDept(section);
				request.setAttribute("ll",ll);
				//request.setAttribute("msg",levle);
				request.setAttribute("mk","工段长");
				request.setAttribute("q",q);
				request.setAttribute("p",n.selectF());
				request.getRequestDispatcher("empsel.jsp").forward(request, response);
				return;
			}
			else{
				List<Login>ll=emp.empForName(section);
				request.setAttribute("ll",ll);
				//request.setAttribute("msg",levle);
				request.setAttribute("mk","工段长");
				request.setAttribute("q",q);
				request.setAttribute("p",n.selectF());
				request.getRequestDispatcher("empsel.jsp").forward(request, response);
				return;
			}
			
		}
		System.out.println("aa");
		
		System.out.println("a的值为："+a);
	
		if (sum >= 90) {
//			ss.add(sum);
			fmnum.ForemenInsert(1);
//			System.out.println("ss的数量为" + ss.size() + "    a的数量为" + a);

			if (fmnum.selectForemenGrate() > (a * 0.3)){
				System.out.println("判断优秀数量超出");
				List<TCheckPoints> li = j.tCheckPoints();
				request.setAttribute("ls", li);
				request.setAttribute("pname",name);
				request.setAttribute("detp",foremenname);
				request.setAttribute("m",
						"<script>alert(\"优秀人数超出不予提交，请重新打分 \");</script>");
				System.out.println("优秀人数过多");
				//request.setAttribute("msg", "提交失败");
				request.getRequestDispatcher("grade/d.jsp")
						.forward(request, response);
				return;
			} else {
				ForemenGrade fore = new ForemenGrade(q, name, foremenname, l.get(0),
						l.get(1), l.get(2), l.get(3), l.get(4), l.get(5),
						l.get(6), l.get(7), l.get(8), l.get(9), sum, comm);
				
				
				int s = foremen.forinsert(fore);
//				lg.add(sum);
				fmnum.ForemenInsert(3);
				if (s == 1) {
					List<TCheckPoints> li = j.tCheckPoints();
					request.setAttribute("ls", li);
					request.setAttribute("msg",
							"<script>alert(\"提交成功 \");</script>");
					if (fmnum.selectForemenCount() == emp.empsum()) {
//						System.out.println(lg.size() + "=" + a);
//					
//						lg.removeAll(lg);
//						System.out.println(lg.size() + "removeAll()");
//						ss.removeAll(ss);
//						tt.removeAll(tt);
						fmnum.deleteForemenGrade();
						foremen.insertForcount(1);
						n.oneF(1);
						
						request.setAttribute("l",
								"<script>alert(\"本次打分完毕！\");</script>");
						}
				
					//判断工段长的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
					if(emp.selectEmpForCount(section)%emp.empcount(section)==0){
						List<Login>ll=emp.forNameAndDept(section);
						request.setAttribute("ll",ll);
						//request.setAttribute("msg",levle);
						request.setAttribute("mk","工段长");
						request.setAttribute("q",q);
						request.setAttribute("p",n.selectF());
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
					}
					else{
						List<Login>ll=emp.empForName(section);
						request.setAttribute("ll",ll);
						//request.setAttribute("msg",levle);
						request.setAttribute("mk","工段长");
						request.setAttribute("q",q);
						request.setAttribute("p",n.selectF());
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
					}
					} 

				else {
					List<TCheckPoints> li = j.tCheckPoints();
					request.setAttribute("ls", li);
					request.setAttribute("pname",name);
					request.setAttribute("detp",foremenname);
					request.setAttribute("msg",
							"<script>alert(\"提交失败 \");</script>");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
					return;
				}
			}

		} else if (sum < 90 && sum >= 80) {
//			tt.add(sum);
			fmnum.ForemenInsert(2);
//			System.out.println("tt的数量为" + tt.size());
			if (fmnum.selectForemenGood() > (a * 0.3)) {
				System.out.println("判断等级");
				List<TCheckPoints> li = j.tCheckPoints();
				request.setAttribute("ls", li);
				request.setAttribute("pname",name);
				request.setAttribute("detp",foremenname);
				request.setAttribute("l",
						"<script>alert(\"良好人数超出，不予提交，请重新打分！ \");</script>");
				//System.out.println("良好人数过多,不予提交此成绩，请重新打分");
				//request.setAttribute("msg", "提交失败");
				request.getRequestDispatcher("grade/d.jsp")
						.forward(request, response);
			} else {
				ForemenGrade fore = new ForemenGrade(q, name,foremenname, l.get(0),
						l.get(1), l.get(2), l.get(3), l.get(4), l.get(5),
						l.get(6), l.get(7), l.get(8), l.get(9), sum, comm);
				
//				lg.add(sum);
				fmnum.ForemenInsert(3);
				int s = foremen.forinsert(fore);
				if (s == 1) {
					List<TCheckPoints> li = j.tCheckPoints();
					request.setAttribute("ls", li);
					request.setAttribute("msg",
							"<script>alert(\"提交成功 \");</script>");
					if (fmnum.selectForemenCount() == emp.empsum()) {
//						System.out.println(lg.size() + "=" + a);
						request.setAttribute("l",
								"<script>alert(\"本次打分完毕！\");</script>");
//						lg.removeAll(lg);
//						System.out.println(lg.size() + "removeAll()");
//						ss.removeAll(ss);
//						tt.removeAll(tt);
						fmnum.deleteForemenGrade();
						foremen.insertForcount(1);
						n.oneF(1);

					}
					
					
					//判断工段长的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
					if(emp.selectEmpForCount(section)%emp.empcount(section)==0){
						List<Login>ll=emp.forNameAndDept(section);
						request.setAttribute("ll",ll);
						//request.setAttribute("msg",levle);
						request.setAttribute("mk","工段长");
						request.setAttribute("q",q);
						request.setAttribute("p",n.selectF());
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
					}
					else{
						List<Login>ll=emp.empForName(section);
						request.setAttribute("ll",ll);
						//request.setAttribute("msg",levle);
						request.setAttribute("mk","工段长");
						request.setAttribute("q",q);
						request.setAttribute("p",n.selectF());
						request.getRequestDispatcher("empsel.jsp").forward(request, response);
						return;
					}
					
				}

				else {
					List<TCheckPoints> li = j.tCheckPoints();
					request.setAttribute("ls", li);
					request.setAttribute("pname",name);
					request.setAttribute("detp",foremenname);
					request.setAttribute("msg",
							"<script>alert(\"提交失败 \");</script>");
					request.getRequestDispatcher("grade/d.jsp").forward(request,
							response);
				}
			}

		} else {
			ForemenGrade fore = new ForemenGrade(q, name, foremenname, l.get(0),
					l.get(1), l.get(2), l.get(3), l.get(4), l.get(5), l.get(6),
					l.get(7), l.get(8), l.get(9), sum, comm);
			
//			lg.add(sum);
			fmnum.ForemenInsert(3);
			int s = foremen.forinsert(fore);
			request.setAttribute("msg", "<script>alert(\"提交成功 \");</script>");
			if (s == 1) {
				List<TCheckPoints> li = j.tCheckPoints();
				request.setAttribute("ls", li);
				if (fmnum.selectForemenCount() == emp.empsum()) {
//					System.out.println(lg.size() + "=" + a);
					request.setAttribute("l",
							"<script>alert(\"本次打分完毕！\");</script>");
//					lg.removeAll(lg);
//					System.out.println(lg.size() + "removeAll()");
//					ss.removeAll(ss);
//					tt.removeAll(tt);
					fmnum.deleteForemenGrade();
					foremen.insertForcount(1);
					n.oneF(1);
				}

			
				//判断工段长的打分人数如果打分人数与总的员工人数是成比例的，则说明未打过份或打过成倍数的分，需显示所有的员工
				if(emp.selectEmpForCount(section)%emp.empcount(section)==0){
					List<Login>ll=emp.forNameAndDept(section);
					request.setAttribute("ll",ll);
					//request.setAttribute("msg",levle);
					request.setAttribute("mk","工段长");
					request.setAttribute("q",q);
					request.setAttribute("p",n.selectF());
					request.getRequestDispatcher("empsel.jsp").forward(request, response);
					return;
				}
				else{
					List<Login>ll=emp.empForName(section);
					request.setAttribute("ll",ll);
					//request.setAttribute("msg",levle);
					request.setAttribute("mk","工段长");
					request.setAttribute("q",q);
					request.setAttribute("p",n.selectF());
					request.getRequestDispatcher("empsel.jsp").forward(request, response);
					return;
				}
				
			}

			else {
				List<TCheckPoints> li = j.tCheckPoints();
				request.setAttribute("ls", li);
				request.setAttribute("pname",name);
				request.setAttribute("detp",foremenname);
				request.setAttribute("msg",
						"<script>alert(\"提交失败 \");</script>");
				request.getRequestDispatcher("grade/d.jsp")
						.forward(request, response);
				return;
			}
		}	
	}

}
