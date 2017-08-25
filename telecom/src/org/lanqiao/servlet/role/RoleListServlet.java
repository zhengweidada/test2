package org.lanqiao.servlet.role;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.entity.Roles;
import org.lanqiao.service.RoleService;
import org.lanqiao.service.impl.RoleServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Servlet implementation class RoleListServlet
 */
@WebServlet("/role/roleListServlet")
public class RoleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleListServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleService roleService = new RoleServiceImpl();
		List<Roles> rlist = roleService.getAllRoles2();
		HttpSession session = request.getSession();
		session.setAttribute("roles", rlist);
		
		String json = ""; 
		try{  
            ObjectMapper mapper = new ObjectMapper(); 
            json = mapper.writeValueAsString(rlist);  
            //System.out.println(json);  
        }catch(Exception e){  
            e.printStackTrace();  
        }
		session.setAttribute("rList_json", json);
		
		//session.setAttribute("permit", map);
		//session.setAttribute("permitJSON", json);
		response.sendRedirect(request.getContextPath()+"/view/role/role_list.jsp");
				
		
		
		
		
		//将角色抽取出来，方便之后角色id与其所拥有的权限相对应
		/*List<Roles> rolesList = new ArrayList<Roles>();
		for(int i=0; i<list.size()-1; i++){
			if(list.get(i).getRoles().getRole_id() != list.get(i+1).getRoles().getRole_id()){
				rolesList.add(list.get(i).getRoles());
				System.out.println(list.get(i).getRoles().getRole_id()+"  "+list.get(i).getRoles().getRole_name());
			}
			if(i == list.size()-2)
				rolesList.add(list.get(i+1).getRoles());
		}*/
		
		//将权限抽取出来，使得一个role_id对应一个权限集合
		/*Map<Integer, List<Permissions>> map = new HashMap<Integer, List<Permissions>>();
		List<Permissions> permit = new ArrayList<Permissions>();
		for(int i=0; i<list.size()-1; i++){
			if(list.get(i).getRoles().getRole_id() == list.get(i+1).getRoles().getRole_id()){
				permit.add(list.get(i).getPermissions());
			}else{
				permit.add(list.get(i).getPermissions());
				map.put(list.get(i).getRoles().getRole_id(), permit);
				permit = new ArrayList<Permissions>();
			}
			//保证最后一条数据与倒数第二条数据一样的加到集合中区，前面的数据没有被装进去
			if(i==list.size()-2 && list.get(i).getRoles().getRole_id() == list.get(list.size()-1).getRoles().getRole_id()){
				permit.add(list.get(list.size()-1).getPermissions());
				map.put(list.get(list.size()-1).getRoles().getRole_id(), permit);
			}else{
				//将最后一条数据与倒数第二条数据不一样的加到集合中区，前面的数据已经被装进去了
				map.put(list.get(list.size()-1).getRoles().getRole_id(), permit);
			}
			
		}	*/
	/*	//遍历map
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Entry) it.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println("key:"+key+"--value:"+value);
			
		}
		System.out.println("将map转化为json");*/
		/*String json = ""; 
		try{  
            ObjectMapper mapper = new ObjectMapper(); 
            json = mapper.writeValueAsString(map);  
            //System.out.println(json);  
        }catch(Exception e){  
            e.printStackTrace();  
        } */
		
		//HttpSession session = request.getSession();
		//session.setAttribute("roles", rolesList);
		//session.setAttribute("permit", map);
		//session.setAttribute("permitJSON", json);
		//response.sendRedirect("../view/role/role_list.jsp");
		
		
		/*for(Roles_Permissions r_p:list){
			System.out.println(r_p.getRoles().getRole_id()+"-"+r_p.getRoles().getRole_name()+"-"+
					r_p.getPermissions().getPer_id()+"-"+r_p.getPermissions().getPer_name()
					);
			
			
		}*/
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
