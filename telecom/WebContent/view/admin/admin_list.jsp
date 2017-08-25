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
	

	/* $(document).ready(function(){
		var index = 1;
		var totalRecord = "${page.getTotalRecord()}";
		var totalPage = "${page.getTotalPage()}";
		var str = "第"+index+"页  总"+totalPage+"页";

		for(var i=1; i<=totalPage; i++){
			$("#pages").html("<a href='' id='page"+i+"'>"+i+"</a>");

		}
		$("#pages").html("<span>第"+index+"页  总"+totalPage+"页</span>");
		if(index >= 1){
			$("#pages").html("<a href='' id='headPage'>首页</a><a href='' id='prePage'>上一页</a>");
			
		}
		if(index < totalPage){
			$("#pages").html("<a href='' id='nextPage'>下一页</a><a href='' id='footPage'>尾页</a>");
			
		}
			
		
		$("#headPage").click(function(){
			$.get("${pageContext.request.contextPath }/admin/adminPagingServlet", {"index":1},
					function(data){
						alert("首页");
				});
		});

		$("#prePage").click(function(){
			index = index - 1;
			$.get("${pageContext.request.contextPath }/admin/adminPagingServlet", {"index":index},
					 function(data){
						alert("上一页");
					});
		});

		$("#nextPage").click(function(){
			index = index + 1;
			$.get("${pageContext.request.contextPath }/admin/adminPagingServlet", {"index":index},
					function(data){
						alert("下一页");
					});
		});

		$("#footPage").click(function(){
			index = totalPage;
			
			$.get("${pageContext.request.contextPath }/admin/adminPagingServlet", {"index":index},
					function(){
						alert("尾页");
					});
		});


	});
 */
  

	//搜索
	function searchAdmins(){
		$("#update_form").submit();
	}

	$(function(){
		$("#selectAll").click(function(){
			if($(this).val() == "1"){
				$("#datalist input").each(function(){
					$(this).val("0");
					$(this).prop("checked", false);
				});
			}else{
				$("#datalist input").each(function(){
					$(this).val("1");
					$(this).prop("checked", true);
				});
			}

		});

		
		$("#btn_add").click(function(){
			window.location.href="${pageContext.request.contextPath }/admin/addAdminServlet?op=show";
		});

		$("#btn_reset_psw").click(function(){
			 var choose = $("input[name=choose]"); 
			 var arr = new Array();
		   	 for(var i=0;i<choose.length;i++){
		        if(choose[i].checked){
			        arr.push(choose[i].value);
		    	}
		     }

			   $.post("${pageContext.request.contextPath }/admin/resetAllAdminServlet", {id_choose:arr.toString()},  
				        //function方法是接受server端传递过来的方法  
				        function(data){
			       			if(data == "1"){
			       				$("input[name=choose]").each(function(){
									$(this).prop("checked", false);
				       			});
			       				alert("密码重置成功");
				       		}else{
				       			alert("密码重置失败");
					       	}
			         	}
		        ); 
			   
		});

		$(".btn_modify").click(function(){
			var id = $(this).parents("td").parents("tr").children("td:nth-child(2)").text();
			
			window.location.href="${pageContext.request.contextPath }/admin/showAdminServlet?id="+id;
			
		});

		$(".summary").mouseover(function(){
			$(this).parents("td").children("div").show();

		}).mouseout(function(){
			$(this).parents("td").children("div").hide();
			
		});

		$(".btn_delete").click(function(){
			 var id = $(this).parents("td").parents("tr").children("td:nth-child(2)").text();
			   var admin_name = $(this).parents("td").parents("tr").children("td:nth-child(3)").text();
			   alert(admin_name);
		       var r = window.confirm("确定要删除["+admin_name+"]管理员吗？");
		       if(r){
		    		$.post("${pageContext.request.contextPath }/admin/deleteAdminServlet", {"id":id},
		    	    		function(data){
	    	    		alert(1);
								if(data == 1){
									$(this).parents("td").parents("tr").remove();
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
            <form action="${pageContext.request.contextPath }/admin/searchAdminOfRoles" method="post" id="update_form">
                <!--查询-->
                <div class="search_add">
                    <div>模块：
                        <select name="selModules" id="selModules" class="select_search">
                            <option value="-1" selected="selected">全部</option>
                            <option value="2">角色管理</option>
                            <option value="1">管理员管理</option>
                            <option value="3">资费管理</option>
                            <option value="4">账务账号</option>
                            <option value="5">业务账号</option>
                            <option value="6">账单管理</option>
                            <option value="7">报表</option>
                        </select>
                    </div>
                    <div>角色：<input type="text" id="search_role_name" name="search_role_name" value="" class="text_search width200" /></div>
                    <div><input type="button" value="搜索" id="search" onclick="searchAdmins();" class="btn_search"/></div>
                    <input type="button" value="密码重置" id="btn_reset_psw" class="btn_add"/>
                    <input type="button" value="增加" id="btn_add" class="btn_add" />
                </div>
                <!--删除和密码重置的操作提示-->
                <div id="operate_result_info" class="operate_fail">
                    <img src="${pageContext.request.contextPath }/images/close.png" onclick="this.parentNode.style.display='none';" />
                    <span>删除失败！数据并发错误。</span><!--密码重置失败！数据并发错误。-->
                </div> 
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th class="th_select_all">
                                <input type="checkbox" value="0" id="selectAll"/>
                                <span>全选</span>
                            </th>
                            <th>管理员ID</th>
                            <th>姓名</th>
                            <th>登录名</th>
                            <th>电话</th>
                            <th>电子邮件</th>
                            <th>授权日期</th>
                            <th class="width100">拥有角色</th>
                            <th></th>
                        </tr>
                        <c:forEach items="${aList }" var="admins">
                        	<tr>
                            <td><input type="checkbox" name="choose" value="${admins.getAdmin_id()}"/></td>
                            <td>${admins.getAdmin_id()}<input type="hidden" name="id" id="del_id" value="${admins.getAdmin_id()}"/></td>
                            <td>${admins.getAdmin_name()}</td>
                            <td>${admins.getAdmin_loginname()}</td>
                            <td>${admins.getAdmin_phone()}</td>
                            <td>${admins.getAdmin_email()}</td>
                            <td>${admins.getGrant_time() }</td>
                            <td>
                                <a class="summary" onmouseover="showDetail(true, this)" onmouseout="showDetail(false, this)">${admins.getRoles().getRole_name()}</a>
                                <!--浮动的详细信息-->
                                <div class="detail_info">
                                 <c:forEach items="${admins.getRoles().getList() }" var="pList">
                                 	${pList.getPer_name()}
                                 </c:forEach>
                                </div>
                            </td>
                            <td class="td_modi">
                                <input type="button" value="修改" class="btn_modify"/>
                                <input type="button" value="删除" class="btn_delete"/>
                            </td>
                        </tr>
                        </c:forEach>        
                       
                    </table>
                </div>
                <!--分页-->
                <div id="pages">
                	<c:set var="index" value="${1 }" scope="page"></c:set>
                	<c:if test="${index > 1 }">
                		<a href="${pageContext.request.contextPath }/admin/adminPagingServlet?index=${1}" id="headPage">首页</a>
                		<a href="${pageContext.request.contextPath }/admin/adminPagingServlet?index=${index-1}" id="prePage">上一页</a>
                	</c:if>
                	<c:forEach items="${totalPage}" var="currPage">
                		<a href="${pageContext.request.contextPath }/admin/adminPagingServlet?index=${currPage}">${currPage}</a>
                	
                	</c:forEach>
                	<c:if test="${index < page.getTotalPage() }">
                		<a href="${pageContext.request.contextPath }/admin/adminPagingServlet?index=${index+1}" id="nextPage">下一页</a>
                		<a href="${pageContext.request.contextPath }/admin/adminPagingServlet?index=${totalPage.size()}" id="footPage">尾页</a>
                	</c:if>
                
                </div>                    
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>
