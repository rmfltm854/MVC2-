<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css">
<!-- <link type="text/css" rel="stylesheet" href="/MyHome/resources/css/style.css"> -->
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div class="header">
			<c:choose>
				<c:when test="${login != null }">
					<a href="/MyHome/member/myPage.jsp">MyPage</a> | 
					<a href="/MyHome/login/logout.do">Logout</a> | 
					<a href="/MyHome/login/main.board">Board</a> 
				</c:when>
				<c:otherwise>
					<a href="/MyHome/login/login.do">Login</a> | 
					<a href="/MyHome/member/joinForm.jsp">Join</a> | 
				</c:otherwise>
			</c:choose>
			  
			<a href="/MyHome/">Home</a>
		</div>
		<div class="main">
		