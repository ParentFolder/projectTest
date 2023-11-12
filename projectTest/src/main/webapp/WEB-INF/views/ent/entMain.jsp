<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>entMain</h1>
	<c:if test="${empty sessionScope.own_id }">
		<input type="button" value="로그인" onclick="location.href='/ent/entLogin';">		
		<input type="button" value="회원가입" onclick="location.href='/ent/entJoin';">
	</c:if>

	<c:if test="${!empty sessionScope.own_id }">
		<h2>${sessionScope.own_id }님 환영합니다.</h2>
		
		<hr>
		<input type="button" value="로그아웃" onclick="location.href='/ent/entLogout';">
		
		<hr>
		<h3><a href="/ent/info">회원정보 조회</a></h3>
		
		<hr>
		<h3><a href="/ent/update">회원정보 수정</a></h3>
		
		<hr>
		<h3><a href="/ent/delete">회원정보 삭제</a></h3>
	</c:if>

</body>
</html>