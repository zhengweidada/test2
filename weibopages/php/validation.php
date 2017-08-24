<?php
if(!empty($_POST['submit'])){
//连接数据库
$link = @mysql_connect("localhost","root","3369257") or
		die("Could not connect:".mysql_error());
print("connected successfully<br/>");
//选择数据库
@mysql_select_db("weibo") or die("Could not use weibo:".mysql_error());
mysql_query('set names utf8');
//获取表单数据
$email = $_POST['email'];
$username = $_POST['username'];
$pword = $_POST['pword'];
$rpword = $_POST['rpword'];
$file = "F:/eclipse/workSpace/upload/".$_FILES["file"]["name"];
$age = $_POST['age'];
$sex = $_POST['sex'];
$province = $_POST['province'];
$city = $_POST['city'];
$district = $_POST['district'];
$protocol = $_POST['protocol'];


if(!((strlen($pword) < 12) && (strlen($rpword) < 12) && ($pword == $rpword))){
	echo '<script type="text/javascript">alert("密码错误，请重新输入！");</script>';
	
}
if(empty($_FILES["file"]["tmp_name"])){
		echo "文件还未上传！";
	}else if(!(($_FILES["file"]["type"] == "image/gif" )
	 		|| ($_FILES["file"]["type"] == "image/jpeg")
	 		|| ($_FILES["file"]["type"] == "image/pjpeg" ))){
	 	echo "文件类型不合法！";
	}else if($_FILES["file"]["size"] > 80000){
		echo "文件大小超过了80K";
	}else{
		if($_FILES["file"]["error"] > 0){
			echo "返回错误代码：".$_FILES["file"]["error"]."<br/>";
		}else{
			echo "文件名称：".$_FILES["file"]["name"]."<br/>";
			echo "文件类型：".$_FILES["file"]["type"]."<br/>";
			echo "文件大小：".$_FILES["file"]["size"]."<br/>";
			echo "临时文件路径：".$_FILES["file"]["tmp_name"]."<br/>";
			
			if(file_exists("F:/eclipse/workSpace/upload/".$_FILES["file"]["name"])){
				echo $_FILES["file"]["name"]."alreadly exists";
			}else{
				move_uploaded_file($_FILES["file"]["tmp_name"],"F:/eclipse/workSpace/upload/".$_FILES["file"]["name"]);
				//echo "保存路径："."upload/".$_FILES["file"]["name"];
			}
			
			
			
		}
	}
	
$insert = "insert into register(email,username,pword,rpword,sex,age,file,t_province,t_city,t_district) " .
		"values('$email','$username','$pword','$rpword','$sex','$age','$file','$province','$city','$district')";

$result = mysql_query($insert,$link);
if($result){
	echo "Insert ok";
}else{
	echo "Insert fail";
}
	
	
	
	
	
}
?>
