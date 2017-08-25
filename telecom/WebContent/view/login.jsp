<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="include.jsp" %>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/additional-methods.js"></script>
<script type="text/javascript" src="../js/messages_zh.js"></script>
<script type="text/javascript">
	$(function(){
		$("#login_form").validate({
			rules:{
				uname:{
					required:true,
					rangelength:[3,30] 
				},
				upsw:{
					required:true,
					rangelength:[3,30] 
				}
			},
			 messages:{
				 uname:{
					 required:"请输入用户名",
					 rangelength:$.validator.format("请输入{0}到{1}个字符")
				 },
				 upsw:{
	                    required:"请输入密码",
	                    rangelength:$.validator.format("请输入{0}到{1}个字符")
	             }
	         },
	          errorPlacement:function(error, element){
	                error.appendTo(element.next("em"));
	         } 
		});

		
		$("#upsw").keypress(function(){
			if(event.which == 13){
				$.post("${pageContext.request.contextPath }/admin/adminLoginServlet", 
						{"uname":$("#uname").val(), "upsw":$("#upsw").val()},
						function(data){
							if(data == -1){
								$("#subMsg").text("用户名或密码或错误");
							}else{
								//alert(data);
								window.location.href="${pageContext.request.contextPath }/view/index.jsp";
								//$.post("${pageContext.request.contextPath }/view/index.jsp");
								
							}
								
						});
				
				//$("#login_form").submit();
			} 
			  
		});
		$("#loginSubmit").click(function(){
			alert("单击");
			$("#login_form").submit();
		});
	});


	/* $(document).ready(function(){
		$("#loginSubmit").click(function(){
			var uname = $("#uname").val();
			var upsw = $("#upsw").val();
			var logindata = {"uname":uname, "upsw":upsw};
			alert("获取表单数据"+uname+"--"+upsw);
			$.ajax({
				 type: "post",
	             url: "${pageContext.request.contextPath }/admin/adminLoginServlet",
	             data: logindata,
	             dataType: "json",
	             success: function(data){
		             alert(data);
					alert("ajax请求成功");

		          },
	             error:function(){
		             console.log();
		            alert("出现错误");
		          }
			});

		});

		
	});  */

	
</script>

</head>
<body class="index">
     <div class="login_box">
     <form action="${pageContext.request.contextPath }/admin/adminLoginServlet" id="login_form" method="post">
         <table>
             <tr>
                 <td class="login_info">账号：</td>
                 <td colspan="2"><input name="uname" id="uname" type="text" class="width150" /><em style="color:red"></em></td>
             </tr>
             <tr>
                 <td class="login_info">密码：</td>
                 <td colspan="2"><input name="upsw" id="upsw" type="password" class="width150"/><em style="color:red"></em></td>
             </tr>
             <tr>
                 <td class="login_info">验证码：</td>
                 <td class="width70"><input name="validate" type="text" class="width70" /></td>
                 <td><img src="${pageContext.request.contextPath }/images/valicode.jpg" alt="验证码" title="点击更换" /></td>
             </tr>            
             <tr>
                 <td></td>
                 <td class="login_button" colspan="2">
                     <a href="" id="loginSubmit"><img src="${pageContext.request.contextPath }/images/login_btn.png" /></a>
                     <em id="subMsg" style="color:red"></em>
                 </td> 
             </tr>
         </table>
     </form>
     </div>
</body>
</html>