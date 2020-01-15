<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>确认订单</title>
	<style>
		body{
			width: 500px;
			margin-top: 200px;
			margin-left: 650px;
		}
		div{
			margin: 0 auto;
			width: 300px;
			height: 200px;
			border: 1px solid #000;
			background: #EEE;
		}
		p{
			text-align: center;
			font-size: 20px;
		}

		a{	
			float: left;
			display: block;
			font-size: 20px;
			width: 50px;
			height: 30px;
			text-align: center;
			text-decoration: none;
			border: 1px solid #000;
			background: #fff;
			color: #000;
			margin-left: 60px;
			margin-top: 20px;
		}
	</style>
</head>
<body>
	<div>
		<%  double sum = (double)request.getAttribute("sum"); %>
		<p>订单确认界面</p>
		<p>您需要支付<%=sum %>元</p>
		<a href="PayServlet?select=yes">确认</a>
		<a href="PayServlet?select=no">取消</a>
	</div>
</body>
</html>