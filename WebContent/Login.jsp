<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<!-- 로그인 폼 -->
	<form action = "Login.do" method = "post">

			<label for = "id">아이디</label><input type = "text" name = "id"><br>
			<label for = "pw">비밀번호</label><input type = "text" name = "password"><br>
			
			<input type = "submit" value = "로그인">
		
		<!-- 회원가입 페이지 이동 -->
		<input type = "button" value = "회원가입" onclick = "location.href = 'MemberRegist.jsp'"/>

	</form>
</body>
</html>