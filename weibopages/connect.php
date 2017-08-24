<?php
//连接数据库
$link = @mysql_connect("localhost","root","3369257")
		or die("Could not connect:".mysql_error());
mysql_select_db("weibo",$link);

?>
