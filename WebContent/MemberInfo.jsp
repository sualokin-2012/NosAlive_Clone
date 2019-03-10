<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "models.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보</title>
</head>
<body>
	<%
	MemberDTO memberInfo = new MemberDTO();
	memberInfo = (MemberDTO)request.getAttribute("Member");
	
	String password = memberInfo.getPassword();
	%>
	
	<form name = "updateForm" action = "UpdateMemberInfo.do" method = "post">
	<table border = "1">

	<tr>
		<td>아이디</td><td><input name = "id" value = "<%= memberInfo.getId() %>"></td>
	</tr>
	<tr>
		<td>비밀번호</td><td><input type = "password" name = "password" value = "<%= memberInfo.getPassword() %>"></td>
	</tr>
	<tr>
		<td>비밀번호 힌트</td><td><input type = "text" name = "hint" value = "<%= memberInfo.getHint() %>"></td>
	</tr>
	<tr>
		<td>이름</td><td><%= memberInfo.getName() %></td>
	</tr>
	<tr>
		<td>성별</td><td><%= memberInfo.getGender() %></td>
	</tr>
	<tr>
		<td>닉네임</td><td><input type = "text" name = "nickname" value = "<%= memberInfo.getNickname() %>"></td>
	</tr>
	<tr>
	<%
		String phone = memberInfo.getPhone1() + "-" + memberInfo.getPhone2() + "-" + memberInfo.getPhone3();
	%>
		<td>전화번호</td><td><select name = "phone1" value = "<%= memberInfo.getPhone1() %>">
				<option value = "010">010</option>
				<option value = "011">011</option>
				<option value = "017">017</option>
			</select> - <input type = "text" name = "phone2" value = "<%= memberInfo.getPhone2() %>" size = 10>
			- <input type = "text" name = "phone3" value = "<%= memberInfo.getPhone3() %>" size = 10>
			</td>
	</tr>
	<tr>
		<td>취미</td><td><%= memberInfo.getHobby() %></td>
	</tr>
	<tr>
		<td>등급</td><td><%= memberInfo.getGrade() %></td>
	</tr>
	<tr>
		<td>생년월일</td><td><%= memberInfo.getBirth() %></td>
	</tr>
	<tr>
		<td>자기소개</td><td><textarea name = "intro" rows = "10" cols = "60"><%= memberInfo.getIntro() %></textarea></td>
	</tr>

	</table>
	<input type = "submit" value = "회원정보수정">
	<input type = "button" name = "cancel" value = "취소" onclick = "location.href = 'Login_Success.jsp'">
	<input type = "button" value = "회원탈퇴" onclick = "location.href = 'Unregist.do'"/>
	</form>
</body>
</html>