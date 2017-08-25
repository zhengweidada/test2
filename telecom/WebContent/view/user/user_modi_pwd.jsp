<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
      <%@ include file="../include.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/additional-methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/messages_zh.js"></script>
     <script type="text/javascript">
		$(function(){
			$("#modi_psw").validate({
				rules:{
					admin_old_psw:{
						required:true
					},
					admin_new_psw:{
						required:true,
						rangelength:[3,30] 
					},
					admin_new_rpsw:{
						required:true,
						rangelength:[3,30],
						//equalTo:'#admin_new_psw' 
					}
				},
				 messages:{
					admin_old_psw:{
						required:"请输入原始密码",
					},
					 admin_new_psw:{
						 required:"请输入新密码",
						 rangelength:$.validator.format("请输入{0}到{1}个字符")
					 },
					 admin_new_rpsw:{
		                    required:"请确认密码",
		                    rangelength:$.validator.format("请输入{0}到{1}个字符")
		             }
		         },
		          errorPlacement:function(error, element){
		                error.appendTo(element.next("em"));
		         } 
			});

			$(":button:first").click(function(){
				//alert($("input[name=admin_old_psw]").val()+"--"+$("input[name=admin_new_psw]").val()+"--"+$("input[name=admin_new_rpsw]").val());
				$.ajax({
					url:"${pageContext.request.contextPath }/user/updatePswServlet",
					type:"post",
					data:{
						"admin_id":$("input[name=admin_id]").val(),
						"admin_new_psw":$("input[name=admin_new_psw]").val(),
						"admin_old_psw":$("input[name=admin_old_psw]").val(),
						"admin_new_rpsw":$("input[name=admin_new_rpsw]").val()
					},
					dataType:"text",
					success:function(data){
						if(data == "1"){
							window.location.href="${pageContext.request.contextPath }/view/login.jsp";
						}else{
							$("#save_result_info").text("请检查您输入的密码是否正确！");
						}
					},
					error:function(data){

					}
				});
			});
			

		});



     </script>
      
      
      
    </head>
    <body>
        
        <!--导航区域开始-->
         <%@include file="../header.jsp"%>
        <!--导航区域结束-->
        <div id="main">      
            <!--保存操作后的提示信息：成功或者失败-->      
            <div id="save_result_info" class="save_success"></div><!--保存失败，旧密码错误！-->
            <form action="" method="post" id="modi_psw"  class="main_form">
                <div class="text_info clearfix"><span>旧密码：</span></div>
                <div class="input_info">
                	
                	<input type="hidden" name="admin_id" value="${sessionScope.currLoginAdmins.getAdmin_id() }"/>
                    <input type="password" name="admin_old_psw" class="width200"  /><em style="color:red"></em>
                   
                </div>
                <div class="text_info clearfix"><span>新密码：</span></div>
                <div class="input_info">
                    <input type="password" name="admin_new_psw" class="width200" /><em style="color:red"></em>
                    
                </div>
                <div class="text_info clearfix"><span>重复新密码：</span></div>
                <div class="input_info">
                    <input type="password" name="admin_new_rpsw" class="width200"  /><em style="color:red"></em>
                   
                </div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" />
                    <input type="button" value="取消" class="btn_save" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
