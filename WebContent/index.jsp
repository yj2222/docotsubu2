<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
	<title>PFC Chart</title>
</head>
<body>
	<div class="indexTop" style="background-image: url(image/indexTop.jpg);">
		<div class="innerBlack">
			<div class="indexTop__text">
				<h1 class="indexTop__text__title">PFC Chart</h1>
				<p class="indexTop__text__discription">
					PFCのバランスを可視化できるようにしたチャートです。<br>
					本機能利用にはログインをお願いします。
				</p>
				<!-- サーブレットへのリンクは相対パスでないとダメ -->
				<a href="./LoginServlet" class="indexTop__text__LoginBtn">Login</a>
				<a href="./SignInServlet" class="indexTop__text__SigninBtn">Signin</a>
			</div>
		</div>
	</div>
</body>
</html>