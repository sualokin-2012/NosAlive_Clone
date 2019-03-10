<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "true" %>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String nickname = request.getParameter("nickname");
			
	// 세션이 있는 경우 반환, 없을 경우 생성
	HttpSession httpSession = request.getSession();
	//if(httpSession.isNew()){
		// 새로 생성된 세션에게만 값 세팅
		httpSession.setAttribute("MEMBERID", id);
		httpSession.setAttribute("PASSWORD", password);
		httpSession.setAttribute("NICKNANE", nickname);
	//}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 성공</title>
</head>
<body>
	아이디 :"<%= id %>"<br>
	패스워드 : "<%= password %>"<br>
	로그인에 성공하셨습니다.
	
	<input type = "button" value = "마이페이지" onclick = "location.href = 'MyPage.jsp'"/>
	<input type = "button" value = "회원정보" onclick = "location.href = 'GetMemberInfo.do'"/>
	<input type = "button" value = "회원정보 리스트" onclick = "location.href = 'GetMemberList.do'"/>
	<input type = "button" value = "티켓구매" onclick = "location.href = 'BuyTicket.jsp'"/>
	<input type = "button" value = "로그아웃" onclick = "location.href = 'Logout.jsp'" />
	
</body>
</html>