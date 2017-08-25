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
        //排序按钮的点击事件
        function sort(btnObj) {
            //因为生成了新的请求，所以每次排序完又回到了原先的状态，所以每项只可能进行一次查询排序
            if (btnObj.className == "sort_desc"){
            	 btnObj.className = "sort_asc";
				if(btnObj.value == "月租"){
					window.location.href="${pageContext.request.contextPath }/fee/sortExpServlet?sort=desc&field=du";
				}else if(btnObj.value == "基费"){
					window.location.href="${pageContext.request.contextPath }/fee/sortExpServlet?sort=desc&field=cost";
				}else if(btnObj.value == "时长"){
					window.location.href="${pageContext.request.contextPath }/fee/sortExpServlet?sort=desc&field=dura";
				}
            }else{
                btnObj.className = "sort_desc";
                if(btnObj.value == "月租"){
                	window.location.href="${pageContext.request.contextPath }/fee/sortExpServlet?sort=asc&field=du";
				}else if(btnObj.value == "基费"){
					window.location.href="${pageContext.request.contextPath }/fee/sortExpServlet?sort=asc&field=cost";
				}else if(btnObj.value == "时长"){
					window.location.href="${pageContext.request.contextPath }/fee/sortExpServlet?sort=asc&field=dura";
				}
            }
        }

        //启用资费
        function startFee(id) {
            var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
			if(r){
				alert(id);
				window.location.href="${pageContext.request.contextPath }/fee/updateFeeServlet?op=1&id="+id;
				//$.post("${pageContext.request.contextPath }/fee/updateFeeServlet?op=1&id="+id, function(data){});
			
			}
            //document.getElementById("operate_result_info").style.display = "block";
            
        }
        //删除
        function deleteFee(id) {
            var r = window.confirm("确定要删除此资费吗？");
            if(r){
           		 window.location.href="${pageContext.request.contextPath }/fee/updateFeeServlet?op=del&id="+id;
            }
            //document.getElementById("operate_result_info").style.display = "block";
        }
    </script>        
</head>
    <body>
        
        <!--导航区域开始-->
        <%@include file="../header.jsp"%>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--排序-->
                <div class="search_add">
                    <div>
                        <input type="button" value="月租" class="sort_asc" onclick="sort(this);" />
                        <input type="button" value="基费" class="sort_asc" onclick="sort(this);" />
                        <input type="button" value="时长" class="sort_asc" onclick="sort(this);" />
                    </div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath }/view/fee/fee_add.jsp';" />
                </div> 
                <!--启用操作的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div>    
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th>资费ID</th>
                            <th class="width100">资费名称</th>
                            <th>基本时长</th>
                            <th>基本费用</th>
                            <th>单位费用</th>
                            <th>创建时间</th>
                            <th>开通时间</th>
                            <th class="width50">状态</th>
                            <th class="width200"></th>
                        </tr>  
                        <c:forEach items="${eList }" var="exp">
                        	 <tr>
                            <td>${exp.getEps_id() }</td>
                            <td><a href="${pageContext.request.contextPath }/fee/updateFeeServlet?op=detail&id=${exp.getEps_id()}">${exp.getEps_name() }</a></td>
                            <td>${exp.getEps_duration() }</td>
                            <td>${exp.getEps_cost() }</td>
                            <td>${exp.getEps_unitc() }</td>
                            <td>${exp.getEps_createtime() }</td>
                            <td>${exp.getEps_starttime() }</td>
                            <td>
                            	<c:if test="${exp.getEps_status() == 0}">暂停</c:if>
                            	<c:if test="${exp.getEps_status() == 1}">启用</c:if>
                            	<c:if test="${exp.getEps_status() == 2}">删除</c:if>
                            
                            </td>
                            <td>      
                            	<c:if test="${exp.getEps_status() != 2}">
                            		<c:if test="${exp.getEps_status() == 0}">
                            			<input type="button" value="启用" class="btn_start" onclick="startFee('${exp.getEps_id()}');" />
                            		</c:if>
                            		<c:if test="${exp.getEps_status() == 1}">
                            			<input type="button" value="暂停" class="btn_pause" onclick="startFee('${exp.getEps_id()}');" />
                            		</c:if>
                            		 <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath }/fee/updateFeeServlet?op=show&id=${exp.getEps_id()}';" />
                                <input type="button" value="删除" class="btn_delete" onclick="deleteFee('${exp.getEps_id()}');" />
                            	</c:if>
                            </td>
                        </tr>
                        
                        </c:forEach>
                    </table>
                    <p>业务说明：<br />
                    1、创建资费时，状态为暂停，记载创建时间；<br />
                    2、暂停状态下，可修改，可删除；<br />
                    3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                    4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
                    </p>
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
