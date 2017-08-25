<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include.jsp" %>
</head>
 <body>
       
        <!--导航区域开始-->
        <%@include file="../header.jsp"%>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <form action="" method="" class="main_form">
                <!--必填项-->
                <div class="text_info clearfix"><span>账务账号ID：</span></div>
                <div class="input_info"><input type="text" value="${account.getAccount_id() }" readonly class="readonly" /></div>
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info"><input type="text" value="${account.getUser_name() }" readonly class="readonly" /></div>
                <div class="text_info clearfix"><span>身份证：</span></div>
                <div class="input_info">
                    <input type="text" value="${account.getUser_idcard() }" readonly class="readonly" />
                </div>
                <div class="text_info clearfix"><span>登录账号：</span></div>
                <div class="input_info">
                    <input type="text" value="${account.getUser_login_name() }" readonly class="readonly" />
                </div>                   
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" class="width200 readonly" readonly value="${account.getUser_phone() }" />
                </div>
                <div class="text_info clearfix"><span>推荐人账务账号ID：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${account.getReferee_id() }" /></div>
                <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${account.getReferee_idcard() }" /></div>
                <div class="text_info clearfix"><span>状态：</span></div>
                <div class="input_info">
                    <select disabled>
                    	
                        <option <c:if test="${account.getUser_status() == '启用' }">selected="selected"</c:if>>开通</option>
                        <option <c:if test="${account.getUser_status() == '暂停' }">selected="selected"</c:if>>暂停</option>
                        <option <c:if test="${account.getUser_status() == '删除' }">selected="selected"</c:if>>删除</option>
                    </select>                        
                </div>                    
                <div class="text_info clearfix"><span>开通/暂停/删除时间：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${account.getService_time() }" /></div>

                <div class="text_info clearfix"><span>上次登录时间：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${account.getLast_login_time() }" /></div>
                <div class="text_info clearfix"><span>上次登录IP：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${account.getLast_login_ip() }" /></div>
                <!--可选项数据-->
                <div class="text_info clearfix"><span>生日：</span></div>
                <div class="input_info">
                    <input type="text" readonly class="readonly" value="${account.getBirth() }" />
                </div>
                <div class="text_info clearfix"><span>Email：</span></div>
                <div class="input_info">
                    <input type="text" class="width350 readonly" readonly value="${account.getEmail() }" />
                </div> 
                <div class="text_info clearfix"><span>职业：</span></div>
                <div class="input_info">
                    <select disabled>
                        <option <c:if test="${account.getJob() == '干部'}">selected="selected"</c:if>>干部</option>
                        <option <c:if test="${account.getJob() == '学生'}">selected="selected"</c:if>>学生</option>
                        <option <c:if test="${account.getJob() == '技术人员'}">selected="selected"</c:if>>技术人员</option>
                        <option <c:if test="${account.getJob() == '其他'}">selected="selected"</c:if>>其他</option>
                    </select>                        
                </div>
                <div class="text_info clearfix"><span>性别：</span></div>
                <div class="input_info fee_type">
                    <input type="radio" name="radSex" <c:if test="${account.getSex() == 0}">checked="checked"</c:if> id="female" disabled />
                    <label for="female">女</label>
                    <input type="radio" name="radSex" <c:if test="${account.getSex() == 0}">checked="checked"</c:if> id="male" disabled />
                    <label for="male">男</label>
                </div> 
                <div class="text_info clearfix"><span>通信地址：</span></div>
                <div class="input_info"><input type="text" class="width350 readonly" readonly value="${account.getAddress() }" /></div> 
                <div class="text_info clearfix"><span>邮编：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="${account.getUser_code() }" /></div> 
                <div class="text_info clearfix"><span>QQ：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="${account.getQq() }" /></div>                
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="button" value="返回" class="btn_save" onclick="location.href='${pageContext.request.contextPath }/account/accountListServlet';" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>