<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/reset.css" media="all" />
<style>
#wrap {position:relative;width:500px;left:300px;top:0px;}
div>title {width:200px;background:#f00}
</style>
<title>회원 가입 페이지</title>
</head>
<body>
	<div id = "wrap">
	<b><font size = "7" color = "gray">회원가입</font></b>
	<form action = "Regist.do" method = "post">

		아이디 : <input type = "text" name = "id"><br>
		비밀번호 : <input type = "password" name = "password"><br>
		비밀번호 힌트 : <input type = "text" name = "hint"><br>
		닉네임(별명) : <input type = "text" name = "nickname"><br>
		이름 : <input type = "text" name = "name"><br>
		성별 : 남자 <input type = "radio" name = "gender" value = "M">
			  여자 <input type = "radio" name = "gender" value = "F"><br>
		취미 : 등산 <input type = "checkbox" name = "hobby" value = "mount">
			  영화감상 <input type = "checkbox" name = "hobby" value = "movie">
			  여행 <input type = "checkbox" name = "hobby" value = "travel">
			  독서 <input type = "checkbox" name = "hobby" value = "read"><br>
		생일 : <input type = "date" name = "birth"><br>
		전화번호 : <select name = "phone1">
					<option value = "010">010</option>
					<option value = "011">011</option>
					<option value = "017">017</option>
				</select> - <input type = "text" name = "phone2" size = 10>
				- <input type = "text" name = "phone3" size = 10><br>
				<textarea name = "intro" rows = "10" cols = "60">자기소개</textarea><br><br>
			<br/>	
				<input type = "submit" value = "확인"/><input type = "reset" value = "다시입력"/>
		
	</form>
	</div>
</body>
</html>