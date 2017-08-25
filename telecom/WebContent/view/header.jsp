<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--Logo区域开始-->
<div id="header">
    <img src="${pageContext.request.contextPath }/images/logo.png" alt="logo" class="left"/>
    <a href="${pageContext.request.contextPath }/user/exitServlet">[退出]</a>            
</div>
<!--Logo区域结束-->

 <!--导航区域开始-->
<div id="navi">                        
    <ul id="menu">
    <li><a href="${pageContext.request.contextPath}/view/index.jsp" class="index_on"></a></li>
    <c:forEach items="${sessionScope.currLoginAdmins.getRoles().getList() }" var="admin_permission">
    	<li><a href="${pageContext.request.contextPath}${admin_permission.getPurl()}" class="${admin_permission.getPclass() }"></a></li>
    
    </c:forEach>
  
  <li><a href="${pageContext.request.contextPath}/view/user/user_info.jsp" class="information_off"></a></li>
  <li><a href="${pageContext.request.contextPath}/view/user/user_modi_pwd.jsp" class="password_off"></a></li>
    </ul>            
</div>
<!--导航区域结束-->