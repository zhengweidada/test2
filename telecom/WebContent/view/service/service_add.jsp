<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
       <%@ include file="../include.jsp" %>
       <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.1.js"></script>
        <script language="javascript" type="text/javascript">
			$(document).ready(function(){
				$("#searrchBtn").click(function(){
					var user_idcard = $("#user_idcard").val();
					//window.location.href="${pageContext.request.contextPath }/service/addServiceServlet?op=search&idcard="+user_idcard;

					$.post("${pageContext.request.contextPath }/service/addServiceServlet?op=search", {"idcard":user_idcard},
							function(data){
								if(data != ""){
									 var json_data = $.parseJSON(data);
									 $("#user_login_name").val(json_data.user_login_name);
									 $("#account_id").val(json_data.account_id);
								 
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
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
            }

            //自动查询账务账号
            function searchAccounts(txtObj) {
                //document.getElementById("a1").innerHTML = txtObj.value;
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
            <div id="save_result_info" class="save_fail">保存失败！192.168.0.23服务器上已经开通过 OS 账号 “mary”。</div>
            <form action="${pageContext.request.contextPath }/service/addServiceServlet?op=add" method="post" class="main_form">
                <!--内容项-->
                <div class="text_info clearfix"><span>身份证：</span></div>
                <div class="input_info">
                	<input type="hidden" name="account_id" id="account_id" value=""/>
                    <input type="text" name="user_idcard" id="user_idcard" value="" class="width180" />
                    <input type="button" id="searrchBtn" value="查询账务账号" class="btn_search_large"/>
                    <span class="required">*</span>
                    <div class="validate_msg_short">没有此身份证号，请重新录入。</div>
                </div>
                <div class="text_info clearfix"><span>账务账号：</span></div>
                <div class="input_info">
                    <input type="text" name="user_login_name" id="user_login_name" value="" onkeyup="searchAccounts(this);" />
                    <span class="required">*</span>
                    <div class="validate_msg_long">没有此账务账号，请重新录入。</div>
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info">
                    <select name="eps_id">
                    	<c:forEach items="${eList }" var="exp">
                    		<option value="${exp.getEps_id() }">${exp.getEps_name() }</option>
                    	
                    	</c:forEach>
                    </select>                        
                </div> 
                <div class="text_info clearfix"><span>服务器 IP：</span></div>
                <div class="input_info">
                    <input type="text" name="server_ip" value="192.168.0.23"  />
                    <span class="required">*</span>
                    <div class="validate_msg_long">15 长度，符合IP的地址规范</div>
                </div>                   
                <div class="text_info clearfix"><span>登录 OS 账号：</span></div>
                <div class="input_info">
                    <input type="text" name="os_account" value=""  />
                    <span class="required">*</span>
                    <div class="validate_msg_long">8长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>密码：</span></div>
                <div class="input_info">
                    <input type="password" name="os_psw" />
                    <span class="required">*</span>
                    <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>重复密码：</span></div>
                <div class="input_info">
                    <input type="password" name="os_rpsw" />
                    <span class="required">*</span>
                    <div class="validate_msg_long">两次密码必须相同</div>
                </div>     
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save"/>
                    <input type="button" value="取消" class="btn_save" />
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>
