<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
       <%@ include file="../include.jsp" %>
        <script language="javascript" type="text/javascript">
            //写入下拉框中的年份和月份
            function initialYearAndMonth() {
                //写入最近3年
                var yearObj = document.getElementById("selYears");
                var year = (new Date()).getFullYear();
                for (var i = 0; i <= 2; i++) {
                    var opObj = new Option(year - i, year - i);
                    yearObj.options[i] = opObj;
                }
                //写入 12 月
                var monthObj = document.getElementById("selMonths");
                var opObj = new Option("全部", "全部");
                monthObj.options[0] = opObj;
                for (var i = 1; i <= 12; i++) {
                    var opObj = new Option(i, i);
                    monthObj.options[i] = opObj;
                }
            }
        </script>
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
                    <div>身份证：<input type="text"  value="230101111111111111" class="text_search" /></div>
                    <div>账务账号：<input type="text" value="admin1" class="width100 text_search" /></div>                            
                    <div>姓名：<input type="text" value="张三" class="width70 text_search" /></div>
                    <div>
                        <select class="select_search" id="selYears">
                        </select>
                        年
                        <select class="select_search" id="selMonths">
                        </select>
                        月
                    </div>
                    <div><input type="button" value="搜索" class="btn_search" /></div>
                </div>  
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th class="width50">账单ID</th>
                        <th class="width70">姓名</th>
                        <th class="width150">身份证</th>
                        <th class="width150">账务账号</th>
                        <th>费用</th>
                        <th class="width100">月份</th>
                        <th class="width100">支付方式</th>
                        <th class="width100">支付状态</th>                                                        
                        <th class="width50"></th>
                    </tr>
                    <c:forEach items="${requestScope.bList }" var="bill">
                    <tr>
                        <td>${bill.bill_id }</td>
                        <td>${bill.account.account_id }</td>
                        <td>${bill.account.user_idcard }</td>
                        <td>${bill.account.user_login_name }</td>
                        <td>${bill.bill_cost }</td>
                        <td>${bill.bill_createtime }</td>
                        <td>
                        	<c:if test="${bill.bill_pay == 1 }">现金</c:if>
                        	<c:if test="${bill.bill_pay == 2 }">支付宝</c:if>
                        	<c:if test="${bill.bill_pay == 3 }">银行卡</c:if>
                        
                        </td>
                        <td>
                        	<c:if test="${bill.bill_pay == 1 }">未支付</c:if>
                        	<c:if test="${bill.bill_pay == 2 }">已支付</c:if>
                        
                        </td>                            
                        <td><a href="${pageContext.request.contextPath }/bill/billDetailServlet?op=item&id=${bill.bill_id}" title="账单明细">明细</a></td>
                    </tr>
                    
                    </c:forEach>
                    
                </table>
                
                <p>业务说明：<br />
                1、设计支付方式和支付状态，为用户自服务中的支付功能预留；<br />
                2、只查询近 3 年的账单，即当前年和前两年，如2013/2012/2011；<br />
                3、年和月的数据由 js 代码自动生成；<br />
                4、由数据库中的ｊｏｂ每月的月底定时计算账单数据。</p>
                </div>                    
                <!--分页-->
                <div id="pages">
                    <a href="#">首页</a>
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                    <a href="#">末页</a>
                </div>                    
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            
           
        </div>
    </body>
</html>
