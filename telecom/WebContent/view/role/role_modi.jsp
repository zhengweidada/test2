<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<%@ include file="../include.jsp" %>
<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script language="javascript" type="text/javascript">
	$(function(){
		var r_id = "${param.id}";
		var rList = "${sessionScope.rList_json}";
		var r_json = eval(rList);
		for(var i=0; i<r_json.length; i++){
			if(r_json[i].role_id == r_id){
				var p_list = eval(r_json[i].list);
				for(var j=0; j<p_list.length; j++){
					if(p_list[j].per_id == 1){
						$("#ck1").prop("checked",true);
					}
					if(p_list[j].per_id == 2){
						$("#ck2").prop("checked",true);
					}
					if(p_list[j].per_id == 3){
						$("#ck3").prop("checked",true);
					}
					if(p_list[j].per_id == 4){
						$("#ck4").prop("checked",true);
					}
					if(p_list[j].per_id == 5){
						$("#ck5").prop("checked",true);
					}
					if(p_list[j].per_id == 6){
						$("#ck6").prop("checked",true);
					}
					if(p_list[j].per_id == 7){
						$("#ck7").prop("checked",true);
					}
				}
			}
			
		}

	});
    
</script>
</head>
<body>
   
    <!--导航区域开始-->
     <%@include file="../header.jsp"%>
    <!--导航区域结束-->
    
    <!-- 获取数据向角色名称文本框中写入 -->
    <c:forEach items="${sessionScope.roles }" var="role">
    	<c:if test="${requestScope.id == role.getRole_id() }">
    		<c:set var="role_id" scope="page">${role.getRole_id()}</c:set>
    		<c:set var="role_name" scope="page">${role.getRole_name()}</c:set>
    	</c:if>
    </c:forEach>
    <!--主要区域开始-->
    <div id="main">           
        <!--保存操作后的提示信息：成功或者失败-->
        <div id="save_result_info" class="save_success">保存成功！</div>
        <c:forEach items="${sessionScope.roles }" var="role">
        	<c:if test="${role.getRole_id() == param.id }">
        	
        		<form action="${pageContext.request.contextPath }/role/modifyRoleServlet" method="post" class="main_form">
            <div class="text_info clearfix"><span>角色名称：</span></div>
            <div class="input_info">
            	<input type="hidden" name="role_id" value="${role.getRole_id() }" />
                <input type="text" class="width200" name="role_name" value="${role.getRole_name()}" />
                <span class="required">*</span>
                <div class="validate_msg_medium error_msg">不能为空，且为20长度的字母、数字和汉字的组合</div>
            </div>                    
            <div class="text_info clearfix"><span>设置权限：</span></div>
            <div class="input_info_high">
                <div class="input_info_scroll">
                    <ul>
                    	<li><input type="checkbox" name="permissions" value="1" id="ck1"/>管理员管理</li>								
						<li><input type="checkbox" name="permissions" value="2" id="ck2"/>角色管理</li>	
						<li><input type="checkbox" name="permissions" value="3" id="ck3"/>资费管理</li>								
						<li><input type="checkbox" name="permissions" value="4" id="ck4"/>帐务帐号</li>								
						<li><input type="checkbox" name="permissions" value="5" id="ck5"/>业务帐号</li>								
						<li><input type="checkbox" name="permissions" value="6" id="ck6"/>账单</li>			
						<li><input type="checkbox" name="permissions" value="7" id="ck7"/>报表</li>	
                    </ul>
                </div>
                <span class="required">*</span>
                <div class="validate_msg_tiny">至少选择一个权限</div>
            </div>
            <div class="button_info clearfix">
                <input type="submit" value="保存" class="btn_save" id="btn_modi"/>
                <input type="button" value="取消" class="btn_save" />
            </div>
        </form> 
        	</c:if>
        </c:forEach>
        
        
        
        
        
    </div>
    <!--主要区域结束-->
    <div id="footer">
        
    </div>
</body>
</html>
