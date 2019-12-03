<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<%-- JSPからは、${pageContext.request.contextPath}を指定することでWebContent配下を読込める。--%>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/signIn.css">
		<title>どこつぶ改！！！</title>
	</head>
	<body>
		<div class="background-image"
		 style="background-image: url(${pageContext.request.contextPath}/image/signIn.jpg);
		  background-size: cover">
			<div class="background-image_inner">
				<div class="container">
					<div class="inner">
						<h3 class="title">Login</h3>
						<p class="errorMsg"></p>
						<form action="./LoginServlet" method="post">
							<p>・ニックネーム:</p>
							<input type="text" name="nickName" placeholder=" 例）user1234">
							<p class="errorMsg"></p>
							<p>・パスワード:</p>
							<input type="password" name="password"  placeholder=" 例）pass+!-1">
							<p class="errorMsg"></p>
							<button type="submit" style="background-color: #00BFFF;">Login</button>
							<div class="linkToOtherPage">
								<p class="linkText">アカウントお持でない方は↓↓↓</p>
								<a href="./SignInServlet" class="linkTag">サインインページへ＞＞</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>