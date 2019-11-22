<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.User" %>
<% User findedUser = (User) request.getAttribute("findedUser"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mainPage.css">
		<title>どこつぶ改！！！</title>
	</head>
	<body>

		<div class="mainTop">
			<div class="mainTop__left"><h3 class="mainTop__left__title">PFCバランサー</h3></div>
			<div class="mainTop__right">
				<div class="mainTop__right__text">
					<p class="mainTop__right__textUp">ようこそ</p>
					<p class="mainTop__right__textLow">
						<strong class="mainTop__right__textLow__strong"><%= findedUser.getNickName() %></strong>さん
					</p>
				</div>
			</div>
		</div>

		<div class="mainTopImg">
			<img src="${pageContext.request.contextPath}/image/mainPage_top.jpg" alt="mainTopImg" class="mainTopImg__item">
		</div>

	</body>
</html>