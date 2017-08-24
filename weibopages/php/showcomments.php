<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Language" content="en" />
	<meta name="GENERATOR" content="PHPEclipse 1.2.0" />
	
	<title>show Comments</title>
</head>
<body>
<?php
//header("Content-type:text/html;charset=utf-8");

//连接数据库
$link = @mysql_connect("localhost","root","3369257") or
die("Could not connect:".mysql_error());
//print("connected successfully<br/>");
//选择数据库
@mysql_select_db("weibo") or die("Could not use test:".mysql_error());
mysql_query('set names utf8');
$showid = $_GET['id'];
$sql = "select * from issue where id=$showid";
$result = mysql_query($sql,$link);
$row = mysql_fetch_array($result);




?>
<div id="content" style="width:400px;height:300px;border:1px solid red;position:relative;top:50px;left:230px;">
	<div style="height:35px;background-color:gray;color:blue;font-size:24px;line-height:35px"><?php echo $row['title'];?>
	<span><a href="/weibopages/php/showcomments.php?commentsid=<?php echo $showid; ?>" style="float:right;font-size:18px;color:purple;">评论</a></span>
	</div>
	<div><?php echo $row['content'];?></div>
	<div><?php
		//$commid = $row['id'];
		$c = "select * from comments where id=$showid";
		$r = mysql_query($c,$link);
		if($r){
			echo "ok";
		}else{
			echo "fail";
		}
		while($comm = mysql_fetch_array($r)){
		?>	
		<div><?php echo $comm['comment'];?></div>	
			
	<?php } ?>
	
	
	</div>
	<?php 
		if(isset($_GET['commentsid'])){
			$commentsid = $_GET['commentsid'];
		?>
			<div>回复：<input type="text" name="reply"/>
				<input type="submit" name="submit" value="回复"/>
			</div>
			
			
	<?php if(!empty($_POST['submit'])){
		$reply = $_POST['reply'];
		$comments = "insert into comments(id,comment) values($commentsid,'$reply')";
		$commentsresult = mysql_query($comments,$link);
		if($commentsresult){
			echo "Insert ok";
		}else{
			echo "Insert fail";
		}
		
	}
	
	
	
	
	}
		
	
	
	
	?>
</div>
</body>
</html>