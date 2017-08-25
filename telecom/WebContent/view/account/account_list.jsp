<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include.jsp" %>
        <script language="javascript" type="text/javascript">
            //删除
            function deleteAccount(id) {
				var r = window.confirm("确定要删除此账务账号吗？\r\n删除后将不能恢复，且会删除其下属的所有业务账号。");
				if(r)
					window.location.href="${pageContext.request.contextPath}/account/updateAccountServlet?op=del&id="+id;
			

                
               // document.getElementById("operate_result_info").style.display = "block";
            }
            //开通或暂停
            function setState(btnObj, id) {
            	if(btnObj.value == "暂停"){
            		var r = window.confirm("确定要暂停此账务账号吗？");
            		if(r)
      					window.location.href="${pageContext.request.contextPath}/account/updateAccountServlet?op=pause&id="+id;

				}else{
					var r = window.confirm("确定要重新开启此账务账号吗？");
					if(r)
						window.location.href="${pageContext.request.contextPath}/account/updateAccountServlet?op=open&id="+id;
				}

                
              
                
                //document.getElementById("operate_result_info").style.display = "block";
            }
        </script>
    </head>
    <body>
       
       <!--导航栏  -->
       <%@include file="../header.jsp"%>
        <!--主要区域开始-->
        <div id="main">
            <form action="${pageContext.request.contextPath }/account/searchAccountServlet" method="post">
                <!--查询-->
                <div class="search_add">                        
                    <div>身份证：<input type="text" name="condi_id_card" value="${condi_account.getUser_idcard() }" class="text_search" /></div>                            
                    <div>姓名：<input type="text" name="condi_name" class="width70 text_search" value="${condi_account.getUser_name() }" /></div>
                    <div>登录名：<input type="text" name="condi_login_name" value="${condi_account.getUser_login_name() }" class="text_search" /></div>
                    <div>
                        状态：
                        <select class="select_search" name="condi_status">
                        
                            <option value="-1" <c:if test="${condi_account.getUser_status() == -1 }">selected="selected"</c:if>>全部</option>
                            <option value="1" <c:if test="${condi_account.getUser_status() == 1 }">selected="selected"</c:if>>开通</option>
                            <option value="0" <c:if test="${condi_account.getUser_status() == 0 }">selected="selected"</c:if>>暂停</option>
                            <option value="2" <c:if test="${condi_account.getUser_status() == 2 }">selected="selected"</c:if>>删除</option>
                        </select>
                    </div>
                    <div>
                    <input type="submit" value="搜索" class="btn_search"/></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath }/view/account/account_add.jsp';" />
                </div>
                </form> 
                <!--删除等的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="${pageContext.request.contextPath }/images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功，且已删除其下属的业务账号！
                </div>   
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th>账号ID</th>
                        <th>姓名</th>
                        <th class="width150">身份证</th>
                        <th>登录名</th>
                        <th>状态</th>
                        <th class="width100">创建日期</th>
                        <th class="width150">上次登录时间</th>                                                        
                        <th class="width200"></th>
                    </tr>
                    <c:forEach items="${aList }" var="account">
                    	<tr>
	                        <td>${account.getAccount_id() }</td>
	                        <td><a href="${pageContext.request.contextPath}/account/updateAccountServlet?op=detail&id=${account.getAccount_id()}">${account.getUser_name() }</a></td>
	                        <td>${account.getUser_idcard() }</td>
	                        <td>${account.getUser_login_name() }</td>
	                        <td>
	                        	<c:if test="${account.getUser_status() == 0}">暂停</c:if>
	                        	<c:if test="${account.getUser_status() == 1}">启用</c:if>
	                        	<c:if test="${account.getUser_status() == 2}">删除</c:if>
	                        
	                        </td>
	                        <td>${account.getUser_createtime() }</td>
	                        <td>${account.getLast_login_time() }</td>                            
	                        <td class="td_modi">
	                        	<c:if test="${account.getUser_status() != 2 }">
	                        		<c:if test="${account.getUser_status() == 1 }">
	                        			<input type="button" value="暂停" class="btn_pause" onclick="setState(this,'${account.getAccount_id() }');" />
	                        		</c:if>
	                        		<c:if test="${account.getUser_status() == 0 }">
	                        			<input type="button" value="启用" class="btn_start" onclick="setState(this,'${account.getAccount_id() }');" />
	                        		</c:if>
	                            	<input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/account/updateAccountServlet?op=show&id=${account.getAccount_id() }';" />
	                            	<input type="button" value="删除" class="btn_delete" onclick="deleteAccount('${account.getAccount_id() }');" />                       	
	                        	
	                        	</c:if>
	                            
	                        </td>
                    	</tr>
                    </c:forEach>
                                  
                </table>
                <p>业务说明：<br />
                1、创建则开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、暂停账务账号，同时暂停下属的所有业务账号；<br />                
                6、暂停后重新开通账务账号，并不同时开启下属的所有业务账号，需要在业务账号管理中单独开启；<br />
                7、删除账务账号，同时删除下属的所有业务账号。</p>
                </div>                   
                <!--分页-->
                <div id="pages">
                    <a href="#">首页</a>
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                    <a href="#">末页</a>
                </div>                    
            
        </div>
        <!--主要区域结束-->
        <div id="footer">
            
        </div>
    </body>
</html>