<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Language" content="en" />
	<meta name="GENERATOR" content="PHPEclipse 1.2.0" />
	<title>Login</title>
</head>
<body>
<form action="/weibopages/php/login.php" method="post">
	用户名：<input type="text" name="username"/><br/>
	密码：<input type="password" name="pword"/><br/>
	<input type="submit" name="submit" value="登录"/><br/>
</form>
<?php
//连接数据库
$link = @mysql_connect("localhost","root","3369257") or
die("Could not connect:".mysql_error());
//print("connected successfully<br/>");
//选择数据库
@mysql_select_db("weibo") or die("Could not use test:".mysql_error());
mysql_query('set names utf8');
$username = $_POST['username'];
$pword = $_POST['pword'];
$sql = "select username,pword from register where username='$username'";
$result = mysql_query($sql,$link);
$re = mysql_fetch_array($result);

if(!empty($_POST['submit'])){
	if($username == $re['username'] && $pword == $re['pword']){
	setcookie('username',$username);
	header("Refresh:0;url=/weibopages/php/index.php");
	}else{
	echo "用户名与密码不匹配，请重新输入！";
	header("Refresh:1;url=/weibopages/php/login.php");
	}
	
	
}







?>

</body>
</html>