<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<%@ include file="../include.jsp" %>
<script language="javascript" type="text/javascript">
	$(function(){
		$(".btn_modify").click(function(){
			var id = $(this).parents("td").parents("tr").children("td:first").text();
			window.location.href="${pageContext.request.contextPath}/view/role/role_modi.jsp?id="+id;

		});

		$(".btn_delete").click(function(){
			var trEle = $(this).parents("td").parents("tr");
			var id = trEle.children("td:first").text();
			$.post("${pageContext.request.contextPath }/role/deleteRoleServlet", {"id":id},
				function(data){
					if(data == 1){
						$("#operate_result_info").text("删除成功！").show();
						startTimes();
						trEle.remove();
					}else{
						$("#operate_result_info").text("删除失败！").show();
					}

				});

		});

		$("#operate_result_info").click(function(){
			$("#operate_result_info").text("删除成功！").hide();

		});


	 	var timer;
	    function startTimes() {
	        timer = window.setTimeout(showSecondes, 2000);
	    }
	    function showSecondes() {
	    	 $("#operate_result_info").hide();
	    	 window.clearTimeout(timer);
	    }
	

	});





/* function deleteRole(role_id) {
     var r = window.confirm("确定要删除此角色吗？");
	 if(r){
		$.ajax({
			type:"post",
  		  	url:"../../role/deleteRoleServlet",
  		  	data:{"role_id":role_id},
  		  	dataType:"text",
			success:function(data){
				alert("成功获取返回值");
				if("1" == data){
					document.getElementById("operate_result_info").style.display = "block";
				}else{
					document.getElementById("operate_result_info").innerHTML = "删除失败！";
					document.getElementById("operate_result_info").style.display = "block";
				}
			},error : function(){
  				alert("失败");
  	        }

		});

	}
    
} */
</script>
</head>
<body>
   
   <!--导航区域开始-->
    <%@include file="../header.jsp"%>
   <!--导航区域结束-->
   <!--主要区域开始-->
   <div id="main">
       <form action="" method="post">
           <!--查询-->
           <div class="search_add">
               <input type="button" value="增加" class="btn_add" onclick="location.href='role_add.jsp';" />
           </div>  
           <!--删除的操作提示-->
           <div id="operate_result_info" class="operate_success">
               <%-- <img src="${pageContext.request.contextPath }/images/close.png" /> --%>
               删除成功！
           </div> <!--删除错误！该角色被使用，不能删除。-->
           <!--数据区域：用表格展示数据--> 
           
           <div id="data">                      
               <table id="datalist">
                   <tr>                            
                       <th>角色 ID</th>
                       <th>角色名称</th>
                       <th class="width600">拥有的权限</th>
                       <th class="td_modi"></th>
                   </tr> 
                   <c:forEach items="${sessionScope.roles }" var="role">
           			<tr>
           				<td>${role.getRole_id()}</td>
           				<td>${role.getRole_name()}</td>
           				<td>
           					<c:forEach items="${role.getList() }" var="per">
           						<c:out value="${per.getPer_name()}"></c:out>
           						
           					</c:forEach>
           				</td>
           				<td>
           					<input type="button" value="修改" class="btn_modify"/>
                           <input type="button" value="删除" class="btn_delete" />
           				</td>
           			</tr>
           			</c:forEach>  
               </table>
           </div> 
           <!--分页-->
           <div id="pages">
   	        <a href="#">上一页</a>
               <a href="#" class="current_page">1</a>
               <a href="#">2</a>
               <a href="#">3</a>
               <a href="#">4</a>
               <a href="#">5</a>
               <a href="#">下一页</a>
           </div>
       </form>
   </div>
   <!--主要区域结束-->
    <div id="footer">
       
    </div>
</body>
</html>
