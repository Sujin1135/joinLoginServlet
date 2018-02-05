<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 - Mango</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="login" method="POST">
		<div>
			<label for="email">이메일: </label>
			<input type="text" id="email" name="email" />
		</div>
		<div>
			<label for="password">비밀번호: </label>
			<input type="password" id="password" name="password" />
		</div>
		<div>
			<button type="submit">로그인</button>
			<button type="reset">취소</button>
		</div>
	</form>
</body>
</html>