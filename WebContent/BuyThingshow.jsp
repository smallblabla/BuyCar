<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.pfy.bean.BuyThing" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<style>
		body{
			width: 1200px;
			margin-left: 400px;
		}
		.show{
			width: 1000px;
			height: 10px;
			float: none;
		}
		p{
			margin-left: 380px;
			font-size: 30px;
			color: black;
		}
		.show ul li{
			float: left;
			list-style: none;
			width: 150px;
			height: 30px;
			border: solid 1px red;
			background: yellow;
			color: red;
			text-align: center;
			font-size: 20px;
		}
		.show ul li a{
			text-decoration: none;
			color: black;
		}
		#href{
			width: 820px;
			height: 50px;
		}
		#href a{
			text-align: center;
			font-size: 20px;
			text-decoration: none;
			color: #000;
			margin-top: 10px;
			margin-left: 195px;
			float: left;
			display: block;
			width: 200px;
			height: 30px;
			border: 1px solid #000;
			background: #EEE;
	</style>
<body>
	<%
		List<BuyThing> BuyThingList = new ArrayList(); 
		BuyThingList = (List)request.getAttribute("BuyThingList");
	%>
	<p>购物车商品列表</p>
	<div class="show">
		<ul>
			<li>商品序号</li>
			<li>商品名称</li>
			<li>商品价格</li>
			<li>购买数量</li>
			<li>数量调整</li>
			<li>移除购物车</li>
		</ul>
	</div>
	<c:forEach items="${BuyThingList}" var="tag">
	<div class="show">
		<ul>
			<li>${tag.getId()}</li>
			<li>${tag.getName()}</li>
			<li>${tag.getPrice()}</li>
			<li>${tag.getNum()}</li>
			<li>
				<a href="ChangeBuyThingServlet?name=${tag.getName()}&type=${tag.getTypeAdd()}">增加</a>
				<a href="ChangeBuyThingServlet?name=${tag.getName()}&type=${tag.getTypeSubtract()}">减少</a>
			</li>
			<li><a href="ChangeBuyThingServlet?name=${tag.getName()}&type=${tag.getTypeDelete()}">移除</a></li>
		</ul>
	</div>
	</c:forEach>
	<div id="href">
		<a href="ShowThingServlet">返回商品列表</a>
		<a href="PayServlet">支付</a>
	</div>
</body>
</html>