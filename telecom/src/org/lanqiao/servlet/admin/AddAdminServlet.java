package org.lanqiao.servlet.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.lanqiao.entity.Admins;
import org.lanqiao.entity.Roles;
import org.lanqiao.service.AdminService;
import org.lanqiao.service.RoleService;
import org.lanqiao.service.impl.AdminsServiceImpl;
import org.lanqiao.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class AddAdminServlet
 */
@WebServlet("/admin/addAdminServlet")
public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String admin_name = request.getParameter("admin_name");
		String admin_loginname = request.getParameter("admin_loginname");
		String admin_psw = request.getParameter("admin_psw");
		String admin_rpsw = request.getParameter("admin_rpsw");
		String admin_phone = request.getParameter("admin_phone");
		String admin_email = request.getParameter("admin_email");
		String[] permissions = request.getParameterValues("permissions");*/
		
		String op = request.getParameter("op");
		if("show".equals(op)){
			RoleService roleService = new RoleServiceImpl();
			List<Roles> rlist =  roleService.getAllRoles();
			HttpSession session = request.getSession();
			session.setAttribute("rlist", rlist);
			response.sendRedirect(request.getContextPath()+"/view/admin/admin_add.jsp");
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		 Admins a= (Admins) session.getAttribute("currLoginAdmins");
		 String savePath = "D:/apache-tomcat-8.0.45/uploads";
		 Admins admins = null;
		 
		 
		 File file = new File(savePath);
        if (!file.exists() && !file.isDirectory()) {
           file.mkdir();
        }
		
       try{
          DiskFileItemFactory factory = new DiskFileItemFactory();
          ServletFileUpload upload = new ServletFileUpload(factory); 
          upload.setHeaderEncoding("UTF-8"); 
          //3、判断提交上来的数据是否是上传表单的数据
          if(!ServletFileUpload.isMultipartContent(request)){
               //按照传统方式获取数据
               return;
          }
          //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
          //将一个表单中的数据全部封装到一个集合中去，每次循环取出一条数据项，一一进行判断
          List<FileItem> list = upload.parseRequest(request);
          admins = new Admins();
           for(FileItem item : list){
              //如果fileitem中封装的是普通输入项的数据
              if(item.isFormField()){
           	   	 //获取表单数据项的名字
                 String name = item.getFieldName();
                 //解决普通输入项的数据的中文乱码问题
                 String value = item.getString("UTF-8");
                 if(name.equals("admin_name")){
                	 admins.setAdmin_name(value);
                 }else if(name.equals("admin_loginname")){
                	 admins.setAdmin_loginname(value);
                 }else if(name.equals("admin_psw")){
                	 admins.setAdmin_psw(value);
                 }else if(name.equals("admin_phone")){
                	 admins.setAdmin_phone(value);
                 }else if(name.equals("admin_email")){
                	 admins.setAdmin_email(value);
                 }else if(name.equals("permissions")){
                	 if(value != null){
                		 admins.setRoles(new Roles(Integer.parseInt(value)));
                	 }
                 }else{
                	 admins.setCreate_by(a.getAdmin_id());
                 }
                   
              }else{//如果fileitem中封装的是上传文件
           	   //得到上传的文件名称，
           	   String filename = item.getName();
           	   if(filename == null || "".equals(filename)){
           		 admins.setAdmin_img("未上传");
           	   }else{
           		String img_url = savePath+"/"+filename; 
           		admins.setAdmin_img(img_url);
           	   }
           	  
                  
                  if(filename==null || filename.trim().equals("")){
               	   continue;
                  }
                 //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                  //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                  filename = filename.substring(filename.lastIndexOf("\\")+1);
                 //获取item中的上传文件的输入流，获取文件上传组件的字节流
                 InputStream in = item.getInputStream();
                 //创建一个文件输出流
                 FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
                 //创建一个缓冲区
                 byte buffer[] = new byte[1024];
                 //判断输入流中的数据是否已经读完的标识
                 int len = 0;
                 while((len=in.read(buffer))>0){
                     //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                     out.write(buffer, 0, len);
                }
                 //关闭输入流
                 in.close();
                 //关闭输出流
                 out.close();
                 //删除处理文件上传时生成的临时文件
                 item.delete();
                
              }
           }
      }catch (Exception e) {
          e.printStackTrace();
      }
       
       AdminService adminService = new AdminsServiceImpl();
		if(adminService.addAdmin(admins)){
			response.sendRedirect(request.getContextPath()+"/view/admin/admin_list.jsp");
		
		}else{
			response.sendRedirect(request.getContextPath()+"/view/error.jsp");
		}
       
        

		
		
	}
	
	
		
		
}

