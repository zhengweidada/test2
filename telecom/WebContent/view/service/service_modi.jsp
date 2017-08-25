﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<%@ include file="../include.jsp" %>
<script language="javascript" type="text/javascript">
	$(function(){
		//alert("文档加载完毕")
		$.ajax({
			url:"${pageContext.request.contextPath}/service/updateServiceServlet",
			type:"post",
			data:{"op":"esearch"},
			datatype:"json",
			success:function(data){
				var json = eval(data);
				for(var i=0; i<json.length; i++){
					//alert(json[i].eps_name);
					var option = "<option value="+json[i].eps_id+">"+json[i].eps_name+"</option>";
					$("select[name=eps_id]").append(option);
				}
			},
			error:function(data){
				alert("error");
			}
		});
		
		$("#btn_save").click(function(){
			var id = $(":text:first").val();
			//alert("bus_id:"+id);
			var eps_id = $("select[name=eps_id]").val();
			//alert("eps_id"+eps_id);
			
			$.ajax({
				url:"${pageContext.request.contextPath}/service/updateServiceServlet",
				type:"post",
				datatype:"text",
				data:{"op":"modi", "id":id, "eps_id":eps_id},
				success:function(data){
					if(data == 1){
						window.location.href="${pageContext.request.contextPath}/service/serviceListServlet";
					}else{
						showResult();
					}
				},
				error:function(data){
					alert(data);
				}


			});


		});


		
	});


  //保存成功的提示信息
  function showResult() {
      showResultDiv(true);
      window.setTimeout("showResultDiv(false);", 3000);
  }
  function showResultDiv(flag) {
	  var divResult = $("#save_result_info");
      if (flag){
    	  divResult.show();
      } else{
    	  divResult.hide();
      }
        
  }
</script>
</head>
    <body>
        
        <!--导航区域开始-->
         <%@include file="../header.jsp"%>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <!--保存操作的提示信息-->
            <div id="save_result_info" class="save_fail">资费修改失败！</div>
            <form action="" method="post" class="main_form">
                <!--必填项-->
                <div class="text_info clearfix"><span>业务账号ID：</span></div>
                <div class="input_info">
                    <input type="text" value="${bussess.getBuss_id() }" readonly="readonly" class="readonly" />
                </div>
                <div class="text_info clearfix"><span>OS 账号：</span></div>
                <div class="input_info">
                    <input type="text" value="${bussess.getOs_account() }" readonly="readonly" class="readonly" />
                </div>
                <div class="text_info clearfix"><span>服务器 IP：</span></div>
                <div class="input_info">
                    <input type="text" value="${bussess.getServer_ip() }" readonly="readonly" class="readonly" />
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info">
                    <select class="width150" name="eps_id">
                       
                    </select>
                    <div class="validate_msg_long">请修改资费类型，或者取消修改操作。</div>                      
                </div>
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" id="btn_save"/>
                    <input type="button" value="取消" class="btn_save" />
                </div>

                
                <p>业务说明：<br />
                1、修改资费后，点击保存，并未真正修改数据库中的数据；<br />
                2、提交操作到消息队列；<br />
                3、每月月底由程序自动完成业务所关联的资费；</p>
                
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
