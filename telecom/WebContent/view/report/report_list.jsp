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
			$(function(){
				$("#order1").click(function(){
					window.location.href = "${pageContext.request.contextPath }/report/orderReportServlet?op=o1";

				});
				$("#order2").click(function(){
					window.location.href = "${pageContext.request.contextPath }/report/orderReportServlet?op=o2";

				});

				var op = "${param.op}";
				if(op == "o1"){
					$("#datalist").show();
					$("#datalist1").hide();
					$("#datalist2").hide();
				}else if(op == "o2"){
					$("#datalist").hide();
					$("#datalist1").show();
					$("#datalist2").hide();
					
				}


			});

        
        
            function changeTab(e,ulObj) {                
                var obj = e.srcElement || e.target;
                if (obj.nodeName == "A") {
                    var links = ulObj.getElementsByTagName("a");
                    for (var i = 0; i < links.length; i++) {
                        if (links[i].innerHTML == obj.innerHTML) {
                            links[i].className = "tab_on";
                        }
                        else {
                            links[i].className = "tab_out";
                        }
                    }
                }
            }
        </script>
    </head>
    <body>
        
        <!--导航区域开始-->
         <%@include file="../header.jsp"%>
        <!--导航区域结束-->
        <!--主要区域开始-->        
        <div id="report_main">
        	<div class="tabs">
    	        <ul>
        	        <li><a href="#####" class="tab_on" id="order1" title="每位客户每月的累计时长">客户使用时长</a></li>
                    <li><a href="#####" class="tab_out" id="order2" title="每台服务器上累计时长最高的前三名客户">时长排行榜</a></li>
                    <li><a href="#####" class="tab_out" id="order3" title="每台服务器每种资费标准的使用次数">资费使用率</a></li>
                </ul>
            </div>            
            <div class="report_box">
                <!--数据区域：用表格展示数据-->
                <div id="report_data">
                    <table id="datalist">
                        <tr>                            
                            <th>账号 ID</th>
                            <th>账务帐号</th>
                            <th>客户名称</th>
                            <th class="width200">身份证号码</th>
                            <th>电话</th>
                            <th class="width150">月份</th>
                            <th class="width150">累积时长</th>
                        </tr>  
                       <c:forEach items="${requestScope.rList }" var="report">
                       	<tr>
                            <td>${report.account.account_id }</td>
                            <td>${report.account.user_login_name }</td>
                            <td>${report.account.user_name }</td>
                            <td>${report.account.user_idcard }</td>
                            <td>${report.account.user_phone }</td>
                            <td>${report.billItem.bill.bill_createtime }</td>
                            <td>${report.billItem.item_duration }</td>
                        </tr>
                       </c:forEach>
                    </table>
                    <table id="datalist1" style="display:none;">
                        <tr>                            
                            <th class="width300">Unix 服务器IP</th>
                            <th>账务帐号</th>
                            <th>客户名称</th>
                            <th class="width200">身份证号码</th>
                            <th class="width150">累积时长</th>
                        </tr>                      
                         <c:forEach items="${requestScope.rList }" var="report">
                       	<tr>
                           	<td>${report.billItem.bussess.server_ip }</td>
                            <td>${report.account.user_login_name }</td>
                            <td>${report.account.user_name }</td>
                            <td>${report.account.user_idcard }</td>
                            <td>${report.billItem.item_duration }</td>
                        </tr>
                       </c:forEach>
                       <tr>
                            <td>192.168.0.20</td>
                            <td>jecy</td>
                            <td>米妮</td>
                            <td>220222020202020202</td>
                            <td>16小时32分</td>
                        </tr>
                        <tr>
                            <td>192.168.0.23</td>
                            <td>mary</td>
                            <td>贾强</td>
                            <td>220222020202020202</td>
                            <td>16小时32分</td>
                        </tr>
                    </table>
                    <table id="datalist2" style="display:none;">
                        <tr>                            
                            <th class="width300">Unix 服务器IP</th>
                            <th>包月</th>
                            <th>套餐</th>
                            <th>计时</th>
                        </tr>                      
                        <tr>
                            <td>192.168.0.20</td>
                            <td>345</td>
                            <td>21</td>
                            <td>34</td>
                        </tr>
                        <tr>
                            <td>192.168.0.23</td>
                            <td>32</td>
                            <td>221</td>
                            <td>314</td>
                        </tr>                        
                    </table>
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

            </div>
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
          
        </div>
    </body>
</html>
