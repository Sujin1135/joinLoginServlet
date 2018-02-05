<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 - Mango</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="join" method="POST">
		<div>
			<label for="email">이메일: </label>
			<input type="email" id="email" name="email" />
		</div>
		<div>
			<label for="name">이름: </label>
			<input type="text" id="name" name="name" />
		</div>
		<div>
			<label for="pwd">비밀번호: </label>
			<input type="password" id="pwd" name="password" />
		</div>
		<div>
			<label for="pwdc">비밀번호 확인: </label>
			<input type="password" id="pwdc" name="passwordCheck" />
		</div>
		<div>
			<button type="submit">가입</button>
			<button type="reset">취소</button>
		</div>
	</form>
</body>
</html>