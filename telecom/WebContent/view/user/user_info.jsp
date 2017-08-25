<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<%@ include file="../include.jsp" %>
<script language="javascript" type="text/javascript">
	$(function(){
		
		$(":button:first").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath }/user/updateUserServlet",
				type:"post",
				data:$("#submit_form").serialize(),
				dataType:"text",
				success:function(data){
					if(data == 1){
						$("#save_result_info").show();
						startTimes();
					}
				},
				error:function(data){

				}
			});
		});

		var timer;
	    function startTimes() {
	        timer = window.setTimeout(showSecondes, 2000);
	    }
	    function showSecondes() {
	    	 $("#save_result_info").hide();
	    	 window.clearTimeout(timer);
	    }
	
		

	});

</script>
</head>
    <body>
        <!--导航区域开始-->
         <%@include file="../header.jsp"%>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，数据并发错误！-->
            
            <form action="" id="submit_form" method="post" class="main_form">
                <div class="text_info clearfix"><span>管理员账号：</span></div>
                <div class="input_info">
                	<input type="text" name="admin_loginname" readonly="readonly" class="readonly" value="${sessionScope.currLoginAdmins.getAdmin_loginname() }" />
                	<input type="hidden" name="admin_id" value="${sessionScope.currLoginAdmins.getAdmin_id() }"/>
                	</div>
                <div class="text_info clearfix"><span>角色：</span></div>
                <div class="input_info">
                	<input type="hidden" name="admin_role_id" value="${sessionScope.currLoginAdmins.getRoles().getRole_id() }"/>
                    <input type="text" readonly="readonly" class="readonly width400" value="${sessionScope.currLoginAdmins.getRoles().getRole_name() }" />
                </div>
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                    <input type="text" name="admin_name" value="${sessionScope.currLoginAdmins.getAdmin_name() }" />
                    <span class="required">*</span>
                    <div class="validate_msg_long error_msg">20长度以内的汉字、字母的组合</div>
                </div>
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" name="admin_phone" class="width200" value="${sessionScope.currLoginAdmins.getAdmin_phone() }" />
                    <div class="validate_msg_medium">电话号码格式：手机或固话</div>
                </div>
                <div class="text_info clearfix"><span>Email：</span></div>
                <div class="input_info">
                    <input type="text" name="admin_email" class="width200" value="${sessionScope.currLoginAdmins.getAdmin_email() }" />
                    <div class="validate_msg_medium">50长度以内，符合 email 格式</div>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${sessionScope.currLoginAdmins.getGrant_time() }"/></div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save"/>
                    <input type="button" value="取消" class="btn_save" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>
