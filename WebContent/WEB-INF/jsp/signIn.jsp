<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
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
							<p>・ニックネームqqq:<span style="font-size:12px;">(半角英数字4~8字,記号不可)</span></p>
							<input type="text" name="nickName" placeholder=" 例）user1234" id="formText"><br>
							<p class="error_msg"></p>
							<p>・メールアドレス:</p>
							<input type="email" name="email" placeholder=" 例）test1@ex.com" id="formEmail"><br>
							<p class="error_msg"></p>
							<p>・パスワード:<span	 style="font-size:12px;">(<strong style="color:pink;">記号</strong>,半角英数字を含む4~8字)</span></p>
							<input type="password" name="password"  placeholder=" 例）pass+!-1" id="formPass"><br>
							<p class="error_msg"></p>
							<button type="submit">Sign In</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>