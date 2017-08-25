<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<%@ include file="../include.jsp" %>
<%--  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script> --%>
<script language="javascript" type="text/javascript">
	$(function(){
		$(".summary").mouseover(function(){
			$(this).parents("td").children("div").show();

		}).mouseout(function(){
			$(this).parents("td").children("div").hide();
			
		});

		$(".btn_search").click(function(){
			$.post("${pageContext.request.contextPath}/service/updateServiceServlet",
					{"op":"condi",
						"os_account":$("input[name=os_account]").val(),
						"server_ip":$("input[name=server_ip]").val(),
						"user_idcard":$("input[name=user_idcard]").val(),
						"bus_status":$("select[name=bus_status]").val()});


		});
		


		
		$("body").delegate(":button", "click", function(){    
			var curr_button = $(this).val();
			//alert(curr_button);
			var trEle = $(this).parents("td").parents("tr");//tr元素
			var id = trEle.children("td:first").text();//第一个td的文本id
			
			if(curr_button == "启用"){
				$.post("${pageContext.request.contextPath}/service/updateServiceServlet", {"op":"open", "id":id}, function(data){
					if(data == 1){
						trEle.children("td:nth-child(6)").text("启用");
						trEle.children("td:nth-child(9)").children(":button:first").replaceWith("<input type='button' value='暂停' class='btn_pause'/>");
						
					}else{
						alert("开启失败");
					}

				});
			}else if(curr_button == "暂停"){
				$.post("${pageContext.request.contextPath}/service/updateServiceServlet", {"op":"pause", "id":id}, function(data){
					if(data == 1){
						trEle.children("td:nth-child(6)").text("暂停");
						trEle.children("td:nth-child(9)").children(":button:first").replaceWith("<input type='button' value='开启' class='btn_start'/>");
						
					}else{
						alert("暂停失败");
					}

				});
			}else if(curr_button == "修改"){
				window.location.href="${pageContext.request.contextPath}/service/updateServiceServlet?op=show&id="+id;

			}else if(curr_button == "删除"){
				$.post("${pageContext.request.contextPath}/service/updateServiceServlet", {"op":"del", "id":id}, function(data){
					if(data == 1){
						trEle.children("td:nth-child(6)").text("删除");
						trEle.children("td:nth-child(9)").children(":button").remove();
					}
				});
			}

		
		}); 

	});

        
     
    </script>
</head>
    <body>
       
        <!--导航区域开始-->
        <%@include file="../header.jsp"%>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--查询-->
                <div class="search_add">                        
                    <div>OS 账号：<input type="text" name="os_account" value="" class="width100 text_search" /></div>                            
                    <div>服务器 IP：<input type="text" name="server_ip" value="" class="width100 text_search" /></div>
                    <div>身份证：<input type="text"  name="user_idcard" value="" class="text_search" /></div>
                    <div>状态：
                        <select class="select_search" name="bus_status">
                            <option value="-1" selected="selected">全部</option>
                            <option value="1">开通</option>
                            <option value="0">暂停</option>
                            <option value="2">删除</option>
                        </select>
                    </div>
                    <div><input type="button" value="搜索" class="btn_search" /></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath }/service/addServiceServlet?op=sefe';" />
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="${pageContext.request.contextPath }/images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div>   
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th class="width50">业务ID</th>
                        <th class="width70">账务账号ID</th>
                        <th class="width150">身份证</th>
                        <th class="width70">姓名</th>
                        <th>OS 账号</th>
                        <th class="width50">状态</th>
                        <th class="width100">服务器 IP</th>
                        <th class="width100">资费</th>                                                        
                        <th class="width200"></th>
                    </tr>
                    <c:forEach items="${bList }" var="buss">
                    	<tr>
                        <td><a href="${pageContext.request.contextPath }/view/service/service_detail.jsp" title="查看明细">${buss.getBuss_id() }</a></td>
                        <td>${buss.getAccount().getAccount_id() }</td>
                        <td>${buss.getAccount().getUser_idcard() }</td>
                        <td>${buss.getAccount().getUser_name() }</td>
                        <td>${buss.getOs_account() }</td>
                        <td>
                        	<c:if test="${buss.getBuss_status() == 0 }">暂停</c:if>
                        	<c:if test="${buss.getBuss_status() == 1 }">开启</c:if>
                        	<c:if test="${buss.getBuss_status() == 2 }">删除</c:if>
                        </td>
                        <td>${buss.getServer_ip() }</td>
                        <td>
                            <a class="summary">${buss.getExpenses().getEps_name() }</a>
                            <!--浮动的详细信息-->
                            <div class="detail_info">
                               ${buss.getExpenses().getEps_desc() }
                            </div>
                        </td>                            
                        <td class="td_modi">
                       	<c:if test="${buss.getBuss_status() != 2 }">
                       		<c:if test="${buss.getBuss_status() == 1 }">
                       			<input type="button" value="暂停" class="btn_pause"/>
                       		</c:if>
                       		<c:if test="${buss.getBuss_status()== 0 }">
                       			<input type="button" value="启用" class="btn_start"/>
                       		</c:if>
                           	<input type="button" value="修改" class="btn_modify"/>
                           	<input type="button" value="删除" class="btn_delete"/>                       	
                        	
                        </c:if>
                         
                        </td>
                    </tr>
                    </c:forEach>                                         
                </table>                
                <p>业务说明：<br />
                1、创建即开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、业务账号不设计修改密码功能，由用户自服务功能实现；<br />
                6、暂停和删除状态的账务账号下属的业务账号不能被开通。</p>
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
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
