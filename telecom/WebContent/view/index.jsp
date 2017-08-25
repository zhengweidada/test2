<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="include.jsp" %>
</head>
<body class="index">
   
   <div id="index_navi">                        
    <ul id="menu">
    <li><a href="${pageContext.request.contextPath}/view/index.jsp" class="index_on"></a></li>
    <c:forEach items="${sessionScope.currLoginAdmins.getRoles().getList() }" var="admin_permission">
    	<li><a href="${pageContext.request.contextPath}${admin_permission.getPurl()}" class="${admin_permission.getPclass() }"></a></li>
    
    </c:forEach>
  
	  <li><a href="${pageContext.request.contextPath}/view/user/user_info.jsp" class="information_off"></a></li>
	  <li><a href="${pageContext.request.contextPath}/view/user/user_modi_pwd.jsp" class="password_off"></a></li>
    </ul>            
	</div>
   
  
    <!-- <div id="index_navi">
      <ul id="menu">
          <li><a href="index.jsp" class="index_on"></a></li>
          <li><a href="../role/roleListServlet" class="role_off"></a></li>
          <li><a href="../admin/adminListServlet" class="admin_off"></a></li>
          <li><a href="fee/fee_list.jsp" class="fee_off"></a></li>
          <li><a href="account/account_list.jsp" class="account_off"></a></li>
          <li><a href="service/service_list.jsp" class="service_off"></a></li>
          <li><a href="bill/bill_list.jsp" class="bill_off"></a></li>
          <li><a href="report/report_list.jsp" class="report_off"></a></li>
          <li><a href="user/user_info.jsp" class="information_off"></a></li>
          <li><a href="user/user_modi_pwd.jsp" class="password_off"></a></li>
     </ul>
  </div>  -->
</body>
</html>