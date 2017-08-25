<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <%@include file="../include.jsp" %>
        <script language="javascript" type="text/javascript">
			$(function(){
				$("#monthly").click(function(){
					$("#text_eps_duration").hide();
					$("#input_info1").hide();

					$("#text_eps_cost").show();
					$("#input_info2").show();
					
					$("#text_eps_unitc").hide();
					$("#input_info3").hide();

					
					
				});
				 
				$("#package").click(function(){
					$("#text_eps_duration").show();
					$("#input_info1").show();

					$("#text_eps_cost").show();
					$("#input_info2").show();

					$("#text_eps_unitc").show();
					$("#input_info3").show();

				});

				$("#timeBased").click(function(){
					$("#text_eps_duration").hide();
					$("#input_info1").hide();

					$("#text_eps_cost").hide();
					$("#input_info2").hide();

					$("#text_eps_unitc").show();
					$("#input_info3").show();
					
				});

				
				


			});





        
            //保存结果的提示
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
            	var divResult = $("#save_result_info");
                if (flag){
                	divResult.show();
                }
                else{
                	divResult.hide();
                }
            }

            //切换资费类型
            function feeTypeChange(type) {
                var inputArray = document.getElementById("main").getElementsByTagName("input");
                if (type == 1) {
                    inputArray[4].readonly = true;
                    inputArray[4].value = "";
                    inputArray[4].className += " readonly";
                    inputArray[5].readonly = false;
                    inputArray[5].className = "width100";
                    inputArray[6].readonly = true;
                    inputArray[6].className += " readonly";
                    inputArray[6].value = "";
                }
                else if (type == 2) {
                    inputArray[4].readonly = false;
                    inputArray[4].className = "width100";
                    inputArray[5].readonly = false;
                    inputArray[5].className = "width100";
                    inputArray[6].readonly = false;
                    inputArray[6].className = "width100";
                }
                else if (type == 3) {
                    inputArray[4].readonly = true;
                    inputArray[4].value = "";
                    inputArray[4].className += " readonly";
                    inputArray[5].readonly = true;
                    inputArray[5].value = "";
                    inputArray[5].className += " readonly";
                    inputArray[6].readonly = false;
                    inputArray[6].className = "width100";
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
            <div id="save_result_info" class="save_fail">保存失败，资费名称重复！</div>
            <form action="${pageContext.request.contextPath }/fee/addExpServlet" method="post" class="main_form">
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info">
                    <input type="text" class="width300" name="eps_name" value=""/>
                    <span class="required">*</span>
                    <div class="validate_msg_short">50长度的字母、数字、汉字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                
                <!-- onclick="feeTypeChange(1);"    onclick="feeTypeChange(2);"    onclick="feeTypeChange(3);" -->
                <div class="input_info fee_type">
                    <input type="radio" name="eps_type" value="0" id="monthly"/>
                    <label for="monthly">包月</label>
                    <input type="radio" name="eps_type" value="1" checked="checked" id="package"/>
                    <label for="package">套餐</label>
                    <input type="radio" name="eps_type" value="2" id="timeBased"/>
                    <label for="timeBased">计时</label>
                </div>
                <div class="text_info clearfix" id="text_eps_duration"><span>基本时长：</span></div>
                <div class="input_info" id="input_info1">
                    <input type="text" name="eps_duration" value="" class="width100" />
                    <span class="info">小时</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long">1-600之间的整数</div>
                </div>
                <div class="text_info clearfix" id="text_eps_cost"><span>基本费用：</span></div>
                <div class="input_info" id="input_info2">
                    <input type="text" name="eps_cost" value="" class="width100" />
                    <span class="info">元</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long error_msg">0-99999.99之间的数值</div>
                </div>
                <div class="text_info clearfix" id="text_eps_unitc"><span>单位费用：</span></div>
                <div class="input_info" id="input_info3">
                    <input type="text" name="eps_unitc" value="" class="width100" />
                    <span class="info">元/小时</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long error_msg">0-99999.99之间的数值</div>
                </div>
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70" name="eps_desc"></textarea>
                    <div class="validate_msg_short error_msg">100长度的字母、数字、汉字和下划线的组合</div>
                </div>                    
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save" />
                    <input type="button" value="取消" class="btn_save" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>
