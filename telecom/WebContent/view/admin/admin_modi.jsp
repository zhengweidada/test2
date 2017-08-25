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
          //保存成功的提示消息
          function showResult() {
              showResultDiv(true);
              window.setTimeout("showResultDiv(false);", 3000);
          }
          function showResultDiv(flag) {
              var divResult = document.getElementById("save_result_info");
              if (flag)
                  divResult.style.display = "block";
              else
                  divResult.style.display = "none";
          }
      </script>
</head>
    <body>
    	<c:set var="admin_modi_id" scope="page">${pageScope.admin_modi_id}</c:set>
    	<c:forEach items="${sessionScope.aList }" var="admins">
    		<c:if test="${admins.getAdmin_id() == param.id }">
    			<c:set var="curr_page_admin" value="${admins}" scope="page"></c:set>
    		</c:if>
    	</c:forEach>
    	
        
        <!--导航区域开始-->
         <%@include file="../header.jsp"%>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_success">保存成功！</div>
            <form action="${pageContext.request.contextPath }/admin/updateAdminServlet" method="post" class="main_form">
                    <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <input type="text" name="admin_name" value="${curr_page_admin.getAdmin_name() }" />
                        <span class="required">*</span>
                        <input type="hidden" name="admin_id" value="${curr_page_admin.getAdmin_id() }" />
                        <div class="validate_msg_long error_msg">20长度以内的汉字、字母、数字的组合</div>
                    </div>
                    <div class="text_info clearfix"><span>管理员账号：</span></div>
                    <div class="input_info"><input type="text" readonly="readonly" name="admin_loginname" class="readonly" value="${curr_page_admin.getAdmin_loginname() }"  /></div>
                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <input type="text" name="admin_phone" value="${curr_page_admin.getAdmin_phone() }"  />
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">正确的电话号码格式：手机或固话</div>
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" name="admin_email" class="width200" value="${curr_page_admin.getAdmin_email() }"/>
                        <span class="required">*</span>
                        <div class="validate_msg_medium error_msg">50长度以内，正确的 email 格式</div>
                    </div>
                    <div class="text_info clearfix"><span>角色：</span></div>
                    <div class="input_info_high">
                        <div class="input_info_scroll">
                            <ul>
                            	<c:forEach items="${sessionScope.rList }" var="roles">
                            		<li><input type="checkbox" name="roles" value="${roles.getRole_id() }"/>${roles.getRole_name()}</li>								
                            	
                            	</c:forEach>
                            </ul>
                        </div>
                        <span class="required">*</span>
                        <div class="validate_msg_tiny error_msg">至少选择一个</div>
                    </div>
                    <div class="button_info clearfix">
                        <input type="submit" value="保存" class="btn_save" />
                        <input type="button" value="取消" class="btn_save" />
                    </div>
                </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
