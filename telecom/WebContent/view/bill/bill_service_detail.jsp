<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
       <%@ include file="../include.jsp" %>
    </head>
    <body onload="initialYearAndMonth();">
        
        <!--导航区域开始-->
        <%@include file="../header.jsp"%>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--查询-->
                <div class="search_add">                        
                    <div>账务账号：<span class="readonly width70">admin1</span></div>                            
                    <div>OS 账号：<span class="readonly width100">openlab1</span></div>
                    <div>服务器 IP：<span class="readonly width100">192.168.0.20</span></div>
                    <div>计费时间：<span class="readonly width70">2013年8月</span></div>
                    <div>费用：<span class="readonly width70">34.78</span></div>
                    <input type="button" value="返回" class="btn_add" onclick="location.href='${pageContext.request.contextPath }/view/bill/bill_item.jsp';" />
                </div>  
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th class="width150">客户登录 IP</th>
                            <th class="width150">登入时刻</th>
                            <th class="width150">登出时刻</th>
                            <th class="width100">时长（秒）</th>
                            <th class="width150">费用</th>
                            <th>资费</th>
                        </tr>
                        
                        <c:forEach items="${requestScope.details}" var="detail">
                        <tr>
                            <td>${detail.billItem.bussess.server_ip }</td>
                            <td>${detail.detail_login_time }</td>
                            <td>${detail.detail_logout_time }</td>
                            <td>${detail.detail_duration }</td>
                            <td>${detail.detail_cost }</td>
                            <td>${detail.billItem.expenses.eps_name }</td>
                        </tr>
                        </c:forEach>
                    </table>
                </div>
                <!--分页-->
                <div id="pages">
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                </div>                    
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
