<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆界面</title>
<style>
	div{
		width: 500px;
		height: 400px;
		margin: 100px auto;
		background: #F8F8F8;
		border: 1px solid #000;
	}
	p{
		margin-left: 130px;
	}
	form{
		padding-top: 50px;
		margin-left: 90px;
	}
	.text{
		    border: solid 1px #CCC;
    		width: 251px;
    		height: 38px;
    		font-size: 14px;
    		margin-top: 10px;
	}
	#button-login {
    margin-top: 50px;
    margin-bottom: 20px;
    font-size: 14px;
    width: 310px;
    height: 32px;
    border: 1px solid #000;
    color: #000;
    padding: 0 32px;
    background-color: #FFFFFF;
	}
</style>
</head>
<body>
	<div>
		<form action="UserLoginServlet" method="post">
			<p>登录界面</p>
			账号：<input class="text" type="text" name="username"/><br>
			密码：<input class="text" type="password" name="password"/>
			<input type="submit" id="button-login" value="登录">
		</form>
	</div>
</body>
</html>