package inov.fpf.servlet;

import inov.fpf.model.dao.JDBCHR;
import inov.fpf.model.vo.HRGrade;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * Servlet implementation class ExcelServel
 */
public class ExcelServel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelServel() {
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
		String time=request.getParameter("exe");
		JDBCHR jr=new JDBCHR();
		List<HRGrade>list=jr.allemp(time);
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("name");
		String levle=(String)session.getAttribute("title");
		request.setAttribute("pname",name);
		request.setAttribute("detp",levle);
		session.setAttribute("name",name);
		session.setAttribute("title",levle);
		//System.out.println(list.get(1).getName()+"证明list有值");
		try {  
		         
		  
		        response.setContentType("application/vnd.ms-excel"); //保证不乱码  
		  
		        String fileName = time + "excel成绩表格数据.xls";  
		        /* //到第一个值项是attachment，这是真正的关键，设定了这个值，浏览器就会老老实实地显示另存为对话框，如果这个值设成 inline，则无论怎样浏览器都会自动尝试用已知关联的程序打开文件。 
		        response.addHeader("Content-Disposition","attachment; filename=\""+ new String(fileName.getBytes("gb2312"),"iso8859-1") + "\""); */  
		          
		        response.setHeader("Content-Disposition", "attachment;"  
		                + " filename="  
		                + new String(fileName.getBytes(), "ISO-8859-1"));  
		        OutputStream os = response.getOutputStream();  
		        /*out.clear();  
		        out = pageContext.pushBody();*///这2句一定要，不然会报错。  
		        // 新建excel的工作薄文件  
		        WritableWorkbook book = Workbook.createWorkbook(os);  
		        // 生成名为"第一页"的工作表，参数0表示这是第一页  
		        WritableSheet sheet1 = book.createSheet("第一页", 0);  
		        /***********start第一行（各个列的标题）************/  
		        //第一列第一行(0,0)  
		        Label label1 = new Label(0, 0, "序号");  
		        // 将定义好的单元格添加到工作表中  
		        sheet1.addCell(label1);  
		        //第二列第一行  
		        Label label2 = new Label(1, 0, "姓名");  
		        sheet1.addCell(label2);  
		        //第三列第一行  
		        Label label3 = new Label(2, 0, "部门负责人");  
		        sheet1.addCell(label3);  
		        //第四列第一行  
		        Label label4 = new Label(3, 0, "得分");  
		        sheet1.addCell(label4); 
		        //第五列第一行  
		        Label label5 = new Label(4, 0, "指导老师（师傅）");  
		        sheet1.addCell(label5); 
		        //第六列第一行  
		        Label label6 = new Label(5, 0, "得分");  
		        sheet1.addCell(label6); 
		        //第七列第一行  
		        Label label7 = new Label(6, 0, "工段长");  
		        sheet1.addCell(label7); 
		        //第八列第一行  
		        Label label8 = new Label(7, 0, "得分");  
		        sheet1.addCell(label8); 
		        //第九列第一行  
		        Label label9 = new Label(8, 0, "班组长");  
		        sheet1.addCell(label9); 
		        //第十列第一行  
		        Label label10 = new Label(9, 0, "得分");  
		        sheet1.addCell(label10); 
		        //第十一列第一行  
		        Label label11 = new Label(10, 0, "总分");  
		        sheet1.addCell(label11); 
		        //第十二列第一行  
		        Label label12 = new Label(11, 0, "部门负责人评语");  
		        sheet1.addCell(label12); 
		        /***********end第一行（各个列的标题）************/  
		        for(int i=1; i<=list.size(); i++){    //控制行数（从第二行开始）  
		                for(int j=0 ;j<12;j++) { //控制列数  
		                    if(j==0) {  
		                        Label label = new Label(j, i, list.get(i-1).getCod()+"");  
		                        sheet1.addCell(label);  
		                    }  
		                    if(j==1) {  
		                        Label label = new Label(j, i, list.get(i-1).getName());  
		                        sheet1.addCell(label);  
		                    }  
		                    if(j==2) {  
		                        Label label = new Label(j, i, list.get(i-1).getDeptname());  
		                        sheet1.addCell(label);  
		                    } 
		                    if(j==3){
		                    	  Label label = new Label(j, i, list.get(i-1).getDeptgrade()+"");  
			                        sheet1.addCell(label);  
		                    }
		                    if(j==4){
		                    	  Label label = new Label(j, i, list.get(i-1).getTeachername());  
			                        sheet1.addCell(label);  
		                    }
		                    if(j==5){
		                    	  Label label = new Label(j, i, list.get(i-1).getTeachergrade()+"");  
			                        sheet1.addCell(label);  
		                    }
		                    if(j==6){
		                    	  Label label = new Label(j, i, list.get(i-1).getForemenname());  
			                        sheet1.addCell(label);  
		                    }
		                    if(j==7){
		                    	  Label label = new Label(j, i, list.get(i-1).getForemengrade()+"");  
			                        sheet1.addCell(label);  
		                    }
		                    if(j==8){
		                    	  Label label = new Label(j, i, list.get(i-1).getMonname());  
			                        sheet1.addCell(label);  
		                    }
		                    if(j==9){
		                    	  Label label = new Label(j, i, list.get(i-1).getMongrade()+"");  
			                        sheet1.addCell(label);  
		                    }
		                    if(j==10){
		                    	  Label label = new Label(j, i, list.get(i-1).getSum()+"");  
			                        sheet1.addCell(label);  
		                    }
		                    if(j==11){
		                    	  Label label = new Label(j, i, list.get(i-1).getComment());  
			                        sheet1.addCell(label);  
		                    }
		               
		                }         
		        }     
		        // 写入数据并关闭文件  
		        book.write();  
		        book.close();  
		        os.close();  
		  
		    } catch (Exception e) {  
		        System.out.println("生成信息表(Excel格式)时出错：");  
		        e.printStackTrace();  
		    }  
	}
}
