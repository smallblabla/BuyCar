<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.pfy.bean.Thing" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品列表</title>
	<style>
		body{
			width: 1200px;
			margin-left: 400px;
		}
		div{
			width: 1000px;
		}
		p{
			margin-left: 430px;
			font-size: 30px;
			color: black;
		}
		/*#show*/ ul li{
			float: left;
			list-style: none;
			width: 180px;
			height: 30px;
			border: solid 1px red;
			background: yellow;
			color: red;
			text-align: center;
			font-size: 20px;
		}
		ul li a{
			text-decoration: none;
			color: black;
		}
		#buy{
			float:left;
			text-align: center;
			font-size: 25px;
			text-decoration: none;
			color: #000;
			margin-top: 10px;
			margin-left: 400px;
			display: block;
			width: 150px;
			height: 40px;
			border: 1px solid #000;
			background: #EEE;
		}
	</style>
</head>
<body>
	<%
		List<Thing> thingList = new ArrayList(); 
		thingList = (List)request.getAttribute("thingList");
	%>
	<p>商品列表</p>
	<div id="show">
		<ul>
			<li>商品序号</li>
			<li>商品名称</li>
			<li>商品价格</li>
			<li>剩余数量</li>
			<li>加入购物车</li>
		</ul>
	</div>
	<c:forEach items="${thingList}" var="tag">
	<div>
		<ul>
			<li>${tag.getId()}</li>
			<li>${tag.getName()}</li>
			<li>${tag.getPrice()}</li>
			<li>${tag.getNum()}</li>
			<li><a href="ShowServlet?name=${tag.getName()}">添加</a></li>
		</ul>
	</div>
	</c:forEach>
	<a href="BuyThingShowSrevlet" id="buy">购物车列表</a>
</body>
</html>