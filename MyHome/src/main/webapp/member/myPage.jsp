<%@page import="member.memberdao.MemberDAO"%>
<%@page import="member.memberdto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file = "/layout/header.jsp" %>
<div align="center">
	<table id="table">
		<tr>
			<td id="border">번호</td>
			<td id="border">${login.no }</td>
		</tr>
		<tr>
			<td id="border">아이디</td>
			<td id="border">${login.id }</td>
		</tr>
		<tr>
			<td id="border">이름</td>
			<td id="border">${login.name }</td>
		</tr>
		<tr>
			<td id="border">이메일</td>
			<td id="border">${login.email }</td>
		</tr>
		<tr>
			<td id="border">전화번호</td>
			<td id="border">${login.tel1 }-${login.tel2 }-${login.tel3 }</td>
		</tr>
		<tr>
			<td colspan="2" align="right"  id="border">
				<input type="button" value = "수정" onclick="location.href = '/MyHome/member/updateForm.jsp'">
				<input type="button" value = "회원탈퇴" onclick="location.href = '/MyHome/member/deleteForm.jsp'">
			</td>
		</tr>
	</table>
</div>
<%@include file = "/layout/footer.jsp" %>