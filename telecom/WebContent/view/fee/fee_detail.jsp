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
    <body>
       
        <!--导航区域开始-->
        <%@include file="../header.jsp"%>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <form action="" method="post" class="main_form">
                <div class="text_info clearfix"><span>资费ID：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly="readonly" value="${expenses.getEps_id() }" /></div>
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly="readonly" value="${expenses.getEps_name() }"/></div>
                <div class="text_info clearfix"><span>资费状态：</span></div>
                <div class="input_info">
                    <select class="readonly" disabled="disabled">
                    	
                        <option <c:if test="${expenses.getEps_status().equals('启用') }">selected="selected"</c:if>>开通</option>
                        <option <c:if test="${expenses.getEps_status().equals('暂停') }">selected="selected"</c:if>>暂停</option>
                        <option <c:if test="${expenses.getEps_status().equals('删除') }">selected="selected"</c:if>>删除</option>
                    </select>                        
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info fee_type">
                    <input type="radio" name="radFeeType" 
                    <c:if test="${expenses.getEps_type() == 0 }">checked="checked"</c:if>
                    id="monthly" disabled="disabled" />
                    <label for="monthly">包月</label>
                    <input type="radio" name="radFeeType" 
                    <c:if test="${expenses.getEps_type() == 1 }">checked="checked"</c:if>
                    id="package" disabled="disabled" />
                    <label for="package">套餐</label>
                    <input type="radio" name="radFeeType" 
                    <c:if test="${expenses.getEps_type() == 2 }">checked="checked"</c:if>
                    id="timeBased" disabled="disabled" />
                    <label for="timeBased">计时</label>
                </div>
                <div class="text_info clearfix"><span>基本时长：</span></div>
                <div class="input_info">
                    <input type="text" class="readonly" value="${expenses.getEps_duration() }" readonly="readonly" value="20"  />
                    <span>小时</span>
                </div>
                <div class="text_info clearfix"><span>基本费用：</span></div>
                <div class="input_info">
                    <input type="text"  class="readonly" value="${expenses.getEps_cost() }" readonly="readonly" value="24.5" />
                    <span>元</span>
                </div>
                <div class="text_info clearfix"><span>单位费用：</span></div>
                <div class="input_info">
                    <input type="text"  class="readonly" value="${expenses.getEps_unitc() }" readonly="readonly" value="3.00" />
                    <span>元/小时</span>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info"><input type="text"  class="readonly" readonly="readonly" value="${expenses.getEps_createtime() }" /></div>      
                <div class="text_info clearfix"><span>启动时间：</span></div>
                <div class="input_info"><input type="text"  class="readonly" readonly="readonly" value="${expenses.getEps_starttime() }" /></div>      
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70 readonly" readonly="readonly">${expenses.getEps_desc() }</textarea>
                </div>                    
                <div class="button_info clearfix">
                    <input type="button" value="返回" class="btn_save" onclick="location.href='${pageContext.request.contextPath }/fee/feeListServlet';" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
