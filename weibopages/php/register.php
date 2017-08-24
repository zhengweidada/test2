<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="en" />
<meta name="GENERATOR" content="PHPEclipse 1.2.0" />

<?php 
	//require "../js/jquery-1.11.1.js";
	//echo "<link type='text/stylesheet' href='../weibopages/css/register.css'/>";
	//echo "<script src='../weibopages/js/jquery-1.11.1.js'></script>";
	//echo "<script></script>";
?>
<title>注册</title>
<style type="text/css">
	.right{text-align:right;}
</style>


</head>
<body>
<div style="position:absolute;top:100px;left:300px;border:1px solid red;width:400px;height:350px;background-color:pink;">
<form action="validation.php" method="post" enctype="multipart/form-data">
	<table style="font-size:20px">
		<tr>
			<td class="right">常用Email</td>
			<td><input type="text" name="email"/></td>
		</tr>
		<tr>
			<td class="right">帐号昵称</td>
			<td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<td class="right">登录密码</td>
			<td><input type="text" name="pword"/></td>
		</tr>
		<tr>
			<td class="right">确认密码</td>
			<td><input type="text" name="rpword"/></td>
		</tr>
		<tr>
			<td class="right">头像</td>
			<td><input type="file" name="file"/></td>
		</tr>
		<tr>
			<td class="right">年龄</td>
			<td><input type="text" name="age"/></td>
		</tr>
		<tr>
			<td class="right">性别</td>
			<td><input type="radio" name="sex" value="male"/>男&nbsp;<input type="radio" name="sex" value="female"/>女</td>
		</tr>
		<tr>
			<td class="right">地址</td>
			<td>
				<select name="province" size="0">
					<option value="BeiJing">北京市</option>
					<option value="ShangHai">上海市</option>
					<option value="HuBei">湖北省</option>
					<option value="HuNan">湖南省</option>
					<option value="HeNan">河南省</option>
					<option value="HeBei">河北省</option>
					<option value="AnHui">安徽省</option>
					<option value="ShanXi">陕西省</option>
					<option value="Shani">山西省</option>
					<option value="GuiZhou">贵州省</option>
					<option value="GuangDong">广东省</option>
					<option value="JiangSu">江苏省</option>
				</select>
				<select name="city" size="0">
					<option value="HuangGang">黄冈市</option>
					<option value="XianNing">咸宁市</option>
					<option value="JIngZhou">荆州市</option>
					<option value="XianTao">仙桃市</option>
					<option value="XiangYang">襄阳市</option>
				</select>
				<select name="district" size="0">
					<option value="Huangzhou">黄州区</option>
					<option value="Jingzhou">荆州区</option>
					<option value="Jiangxia">江夏区</option>
					<option value="Hanyang">汉阳区</option>
					<option value="Xinzhou">新洲区</option>
				</select>
			</td>
		</tr>
		<tr>
			<td class="right"></td>
			<td><input type="checkbox" name="protocol"/>我已看过并同意《使用协议》</td>
		</tr>
		<tr>
			<td class="right"></td>
			<td><input type="submit" name="submit" value="&nbsp;注册&nbsp;" style="background-color:gray;"/></td>
		</tr>
	</table>


</form>
</div>
</body>
</html>