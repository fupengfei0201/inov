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
		//System.out.println(list.get(1).getName()+"֤��list��ֵ");
		try {  
		         
		  
		        response.setContentType("application/vnd.ms-excel"); //��֤������  
		  
		        String fileName = time + "excel�ɼ��������.xls";  
		        /* //����һ��ֵ����attachment�����������Ĺؼ����趨�����ֵ��������ͻ�����ʵʵ����ʾ���Ϊ�Ի���������ֵ��� inline����������������������Զ���������֪�����ĳ�����ļ��� 
		        response.addHeader("Content-Disposition","attachment; filename=\""+ new String(fileName.getBytes("gb2312"),"iso8859-1") + "\""); */  
		          
		        response.setHeader("Content-Disposition", "attachment;"  
		                + " filename="  
		                + new String(fileName.getBytes(), "ISO-8859-1"));  
		        OutputStream os = response.getOutputStream();  
		        /*out.clear();  
		        out = pageContext.pushBody();*///��2��һ��Ҫ����Ȼ�ᱨ��  
		        // �½�excel�Ĺ������ļ�  
		        WritableWorkbook book = Workbook.createWorkbook(os);  
		        // ������Ϊ"��һҳ"�Ĺ���������0��ʾ���ǵ�һҳ  
		        WritableSheet sheet1 = book.createSheet("��һҳ", 0);  
		        /***********start��һ�У������еı��⣩************/  
		        //��һ�е�һ��(0,0)  
		        Label label1 = new Label(0, 0, "���");  
		        // ������õĵ�Ԫ����ӵ���������  
		        sheet1.addCell(label1);  
		        //�ڶ��е�һ��  
		        Label label2 = new Label(1, 0, "����");  
		        sheet1.addCell(label2);  
		        //�����е�һ��  
		        Label label3 = new Label(2, 0, "���Ÿ�����");  
		        sheet1.addCell(label3);  
		        //�����е�һ��  
		        Label label4 = new Label(3, 0, "�÷�");  
		        sheet1.addCell(label4); 
		        //�����е�һ��  
		        Label label5 = new Label(4, 0, "ָ����ʦ��ʦ����");  
		        sheet1.addCell(label5); 
		        //�����е�һ��  
		        Label label6 = new Label(5, 0, "�÷�");  
		        sheet1.addCell(label6); 
		        //�����е�һ��  
		        Label label7 = new Label(6, 0, "���γ�");  
		        sheet1.addCell(label7); 
		        //�ڰ��е�һ��  
		        Label label8 = new Label(7, 0, "�÷�");  
		        sheet1.addCell(label8); 
		        //�ھ��е�һ��  
		        Label label9 = new Label(8, 0, "���鳤");  
		        sheet1.addCell(label9); 
		        //��ʮ�е�һ��  
		        Label label10 = new Label(9, 0, "�÷�");  
		        sheet1.addCell(label10); 
		        //��ʮһ�е�һ��  
		        Label label11 = new Label(10, 0, "�ܷ�");  
		        sheet1.addCell(label11); 
		        //��ʮ���е�һ��  
		        Label label12 = new Label(11, 0, "���Ÿ���������");  
		        sheet1.addCell(label12); 
		        /***********end��һ�У������еı��⣩************/  
		        for(int i=1; i<=list.size(); i++){    //�����������ӵڶ��п�ʼ��  
		                for(int j=0 ;j<12;j++) { //��������  
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
		        // д�����ݲ��ر��ļ�  
		        book.write();  
		        book.close();  
		        os.close();  
		  
		    } catch (Exception e) {  
		        System.out.println("������Ϣ��(Excel��ʽ)ʱ����");  
		        e.printStackTrace();  
		    }  
	}
}
