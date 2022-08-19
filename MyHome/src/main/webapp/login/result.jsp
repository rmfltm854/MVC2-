<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp" %>
	<div align="center">
		${msg }<br>
		<c:if test="${check }">
			MyPage | 회원탈퇴
		</c:if>
		<c:if test="${!check }">
			ID찾기 | PW찾기 | 
			<a href="/MyHome/login/login.do">Login</a>
		</c:if>
	</div>
<%@ include file="/layout/footer.jsp" %>