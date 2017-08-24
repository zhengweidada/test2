<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Language" content="en" />
	<meta name="GENERATOR" content="PHPEclipse 1.2.0" />
	<title>index</title>
<style type="text/css">
	#issue{
		width:400px;
		border:1px solid red;
		margin:auto;
	}
	#head{
		height:30px;
		background-color:purple;
		color:white;
		font-size:20px;
		line-height:30px;
		padding-left:15px;
	}
</style>
</head>
<body>
<div id="issue">
	<div id="head">微博头条<a href="/weibopages/php/register.php" style="color:white;float:right;">注册</a>
	<a href="/weibopages/php/login.php" style="color:white;float:right;margin-left:10px;margin-right:10px;">登录</a>
	<a href="/weibopages/php/index.php?o='zhuxiao'" style="color:white;float:right;">注销</a>
	</div>
	
	<div><?php echo $_COOKIE['username']; ?></div>
	<?php
	
//连接数据库
$link = @mysql_connect("localhost","root","3369257") or
die("Could not connect:".mysql_error());
//print("connected successfully<br/>");
//选择数据库
@mysql_select_db("weibo") or die("Could not use test:".mysql_error());
mysql_query('set names utf8');
$sql = "select * from issue";
$result = mysql_query($sql,$link);
$rowcount = mysql_num_rows($result);
//echo $rowcount;
if(isset($_GET['o']) && $_GET['o'] == "zhuxiao"){
	setcookie('username'," ",time()-3600);
	header("Refresh:0;url=/weibopages/php/index.php");
	}
$page = 1;
if(isset($_GET[page]) && is_numeric($_GET[page])){
	$page = $_GET[page];
}
$pagesize = 2;//每页长度
$offset = ($page-1)*$pagesize;//计算跳过行数
$pagecount = ceil($rowcount/$pagesize);//计算总页数
$s = "select * from issue order by date desc limit $offset,$pagesize";
$fenye = mysql_query($s,$link);

while($row = mysql_fetch_array($fenye)){
?>
	<div>
		<h2><a href="/weibopages/php/showcomments.php?id=<?php echo $row['id']; ?>"><?php echo $row['title']; ?></a></h2>
		<P><?php echo $row['content']; ?></p>
	
	</div>
	
<?php } ?>



<div>
<?php
	if($page == 1){
?>
	首页	
		
<?php }else{ ?>
	<a href="index.php?page=1">首页</a>
	
<?php } ?>

	<?php if($page == 1){
?>
	上一页	
		
<?php }else{ ?>
	<a href="index.php?page=<?php echo $page - 1; ?>">上一页</a>
	
<?php } ?>
	
	<?php if($page == $pagecount){
?>
	下一页	
		
<?php }else{ ?>
	<a href="index.php?page=<?php echo $page + 1; ?>">下一页</a>
	
<?php } ?>
	
<?php if($page == $pagecount){
?>
	尾页	
		
<?php }else{ ?>
	<a href="index.php?page=<?php echo $page; ?>">尾页	</a>
	
<?php } ?>





</div>
</div>



</body>
</html>