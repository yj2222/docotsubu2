<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<%-- JSPからは、${pageContext.request.contextPath}を指定することでWebContent配下を読込める。--%>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/signIn.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/signIn.js"></script>
		<title>どこつぶ改！！！</title>
	</head>
	<body>
		<div class="background-image"
		 style="background-image: url(${pageContext.request.contextPath}/image/signIn.jpg);
		  background-size: cover">
			<div class="background-image_inner">
				<div class="container">
					<div class="inner">
						<h3 class="title">Sign In</h3>
						<form action="/docoTsubu2/SignInServlet" method="post" id="form">
							<p>・ニックネーム:<span style="font-size:12px;">(半角英数字4~8字,記号不可)</span></p>
							<input type="text" name="nickName" placeholder=" 例）user1234" id="formNickName">
							<p class="errorMsg"></p>
							<p>・メールアドレス:</p>
							<input type="email" name="email" placeholder=" 例）test1@ex.com" id="formEmail">
							<p class="errorMsg"></p>
							<p>・パスワード:<span	 style="font-size:12px;">(<strong style="color:pink;">記号</strong>,半角英数字を含む4~8字)</span></p>
							<input type="password" name="password"  placeholder=" 例）pass+!-1" id="formPass">
							<p class="errorMsg"></p>
							<button type="submit" id="signInBtn">Sign In</button>
							<div class="linkToOtherPage">
								<p class="linkText">アカウントお持ちの方は↓↓↓</p>
								<a href="./LoginServlet" class="linkTag">ログインページ＞＞</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>