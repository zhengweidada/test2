<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include.jsp" %>

        <script language="javascript" type="text/javascript">
        $(document).ready(function(){
			$("#user_idcard").blur(function(){
				var idcard = $("#user_idcard").val();
				
				if(idcard != ""){
					var birth = idcard.substring(6, 10)+"-"+idcard.substring(10, 12)+"-"+idcard.substring(12, 14);
					
					$("#birth").val(birth);
				}
			});
		}); 



        
            //保存成功的提示信息
            function showResult() {
                showResultDiv(true);
                window.setTimeout(showResultDiv(false), 3000);
            }
            function showResultDiv(flag) {
                var divResult = $("#save_result_info");
                if (flag)
                    divResult.show();
                else
                    divResult.hide();
            }

            //显示修改密码的信息项
            function showPwd(chkObj) {
                if (chkObj.checked)
                    $("#divPwds").show();
                else
                    $("#divPwds").hide();
            }
        </script>
    </head>
    <body>
       
        <!--导航区域开始-->
        <%@include file="../header.jsp"%>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">  
            <!--保存成功或者失败的提示消息-->          
            <div id="save_result_info" class="save_fail">保存失败，旧密码错误！</div>
            <form action="${pageContext.request.contextPath }/account/updateAccountServlet?op=modi" method="post" class="main_form">
                    <!--必填项-->
                    <div class="text_info clearfix"><span>账务账号ID：</span></div>
                    <div class="input_info">
                        <input type="text" name="account_id" value="${account.getAccount_id() }" readonly class="readonly" />
                    </div>
                    <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <input type="text" name="user_name" value="${account.getUser_name() }" />
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">20长度以内的汉字、字母和数字的组合</div>
                    </div>
                    <div class="text_info clearfix"><span>身份证：</span></div>
                    <div class="input_info">
                        <input type="text" name="user_idcard" id="user_idcard" value="${account.getUser_idcard() }" readonly class="readonly" />
                    </div>
                    <div class="text_info clearfix"><span>登录账号：</span></div>
                    <div class="input_info">
                        <input type="text" name="user_login_name" value="${account.getUser_login_name() }" readonly class="readonly"  />                        
                        <div class="change_pwd">
                            <input id="chkModiPwd" type="checkbox" name="ckPsw" value="pswChecked" onclick="showPwd(this);" />
                            <label for="chkModiPwd">修改密码</label>
                        </div>
                    </div>
                    <!--修改密码部分-->
                    <div id="divPwds">
                        <div class="text_info clearfix"><span>旧密码：</span></div>
                        <div class="input_info">
                            <input type="password" name="user_psw" />
                            <span class="required">*</span>
                            <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
                        </div>
                        <div class="text_info clearfix"><span>新密码：</span></div>
                        <div class="input_info">
                            <input type="password" name="user_new_psw" />
                            <span class="required">*</span>
                            <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
                        </div>
                        <div class="text_info clearfix"><span>重复新密码：</span></div>
                        <div class="input_info">
                            <input type="password" name="user_new_rpsw" />
                            <span class="required">*</span>
                            <div class="validate_msg_long">两次密码必须相同</div>
                        </div>  
                    </div>                   
                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <input type="text" name="user_phone" value="${account.getUser_phone() }" class="width200"/>
                        <span class="required">*</span>
                        <div class="validate_msg_medium error_msg">正确的电话号码格式：手机或固话</div>
                    </div>
                    <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
                    <div class="input_info">
                        <input type="text" name="referee_idcard" value="${account.getReferee_idcard() }"/>
                        <div class="validate_msg_long error_msgs">正确的身份证号码格式</div>
                    </div>
                    <div class="text_info clearfix"><span>生日：</span></div>
                    <div class="input_info">
                        <input type="text" name="birth" id="birth" value="${account.getBirth() }" readonly class="readonly" />
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" name="email" value="${account.getEmail() }" class="width200"/>
                        <div class="validate_msg_medium">50长度以内，合法的 Email 格式</div>
                    </div> 
                    <div class="text_info clearfix"><span>职业：</span></div>
                    <div class="input_info">
                        <select name="job">
                            <option value="干部" <c:if test="${account.getJob() == '干部' }">selected="selected"</c:if>>干部</option>
                            <option value="学生" <c:if test="${account.getJob() == '学生' }">selected="selected"</c:if>>学生</option>
                            <option value="技术人员" <c:if test="${account.getJob() == '技术人员' }">selected="selected"</c:if>>技术人员</option>
                            <option value="其他" <c:if test="${account.getJob() == '其他' }">selected="selected"</c:if>>其他</option>
                        </select>                        
                    </div>
                    <div class="text_info clearfix"><span>性别：</span></div>
                    <div class="input_info fee_type">
                    	
                        <input type="radio" name="sex" value="0" <c:if test="${account.getSex() == 0 }">checked="checked"</c:if> id="female" onclick="feeTypeChange(1);" />
                        <label for="female">女</label>
                        <input type="radio" name="sex" value="1" id="male" <c:if test="${account.getSex() == 1 }">checked="checked"</c:if> />
                        <label for="male">男</label>
                    </div> 
                    <div class="text_info clearfix"><span>通信地址：</span></div>
                    <div class="input_info">
                        <input type="text" name="address" value="${account.getAddress() }" class="width350"/>
                        <div class="validate_msg_tiny">50长度以内</div>
                    </div> 
                    <div class="text_info clearfix"><span>邮编：</span></div>
                    <div class="input_info">
                        <input type="text" name="user_code" value="${account.getUser_code() }"/>
                        <div class="validate_msg_long">6位数字</div>
                    </div> 
                    <div class="text_info clearfix"><span>QQ：</span></div>
                    <div class="input_info">
                        <input type="text" name="qq" value="${account.getQq() }"/>
                        <div class="validate_msg_long">5到13位数字</div>
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