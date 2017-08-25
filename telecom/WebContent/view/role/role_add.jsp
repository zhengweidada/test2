<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<%@ include file="../include.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/additional-methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/messages_zh.js"></script>
<script language="javascript" type="text/javascript">
	$(function(){
		$("#add_role_form").validate({
			 rules:{
				 role_name:{
					required:true,
					rangelength:[2,30]
				 }
			 },
			 messages:{
				 role_name:{
					required:"请输入角色名",
					rangelength: $.validator.format("长度在 {0} 到 {1} 之间")
				 }
		     },
	          errorPlacement:function(error, element){
	                error.appendTo(element.next("em"));
	         } 
		});

		var timer;
	    function startTimes() {
	        timer = window.setTimeout(showSecondes, 2000);
	    }
	    function showSecondes() {
	    	 $("#operate_result_info").hide();
	    	 window.clearTimeout(timer);
	    }

		$("#btn_save").click(function(){
			var role_name = $("#role_name").val();
			var permit = new Array();
			var permissions = $("input[name=permissions]");
			for(var i=0; i<permissions.length; i++){
				if(permissions[i].checked)
					permit.push(permissions[i].value);
			}
			if(role_name != ""){
				$.post("${pageContext.request.contextPath }/role/addRoleServlet", {"role_name":role_name, "permit":permit.toString()}, 
						function(data){
							alert("data:"+data);
							if(data == 1){
								$("#save_result_info").text("保存成功！").show();
								startTimes();
							}else{
								$("#save_result_info").text("保存失败！").show();
								startTimes();
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
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，角色名称重复！-->
            <form action="" method="post" class="main_form" id="add_role_form">
                <div class="text_info clearfix"><span>角色名称：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" name="role_name" id="role_name"/><em style="color:red"></em>
                </div>                    
                <div class="text_info clearfix"><span>设置权限：</span></div>
                <div class="input_info_high">
                    <div class="input_info_scroll">
                        <ul>
                            <li><input type="checkbox" name="permissions" value="1"/>管理员管理</li>
                            <li><input type="checkbox" name="permissions" value="2"/>角色管理</li>
                            <li><input type="checkbox" name="permissions" value="3"/>资费管理</li>
                            <li><input type="checkbox" name="permissions" value="4"/>账务账号</li>
                            <li><input type="checkbox" name="permissions" value="5"/>业务账号</li>
                            <li><input type="checkbox" name="permissions" value="6"/>账单</li>
                            <li><input type="checkbox" name="permissions" value="7"/>报表</li>
                        </ul>
                    </div>
                    <em style="color:red"></em>
                </div>
                <div class="button_info clearfix">
                    <input type="submit" value="保存" id="btn_save" class="btn_save"/>
                    <input type="reset" value="取消" class="btn_save" />
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>
