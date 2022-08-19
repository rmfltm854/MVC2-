<%@page import="member.memberdto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function check(){
		if(document.update.email.value == ""){
			alert("이메일을 입력하십시오!");
		}else if(document.update.tel1.value == ""){
			alert("전화번호를 입력하십시오!");
		}else if(document.update.tel2.value == ""){
			alert("전화번호를 입력하십시오!");
		}else if(document.update.tel3.value == ""){
			alert("전화번호를 입력하십시오!");
		}else{
			document.update.submit();
		}
	}
</script>
<%@include file = "/layout/header.jsp" %>
 	<div align="center">
 		<form action="/MyHome/member/update.me" method="post" name = "update">
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
			 		<td id="border"><input type="text" name = "email" value="${login.email }"></td>
			 	</tr>
			 	 	<tr>
			 		<td id="border">전화번호</td>
			 		<td id="border">
						<select name = "tel1">
							<option value="010" selected="selected">010</option>
							<option value="010">011</option>
							<option value="010">018</option>
							<option value="010">017</option>
						</select>
						-<input type="text" size = "5" maxlength="4" value="${login.tel2 }" name = "tel2">
						-<input type="text" size = "5" maxlength="4" value="${login.tel3 }" name = "tel3">
					</td>
			 	</tr>
			 	<tr>
			 		<td colspan="2" align="right" id="border">
			 			<input type="button" value = "수정" onclick="javascript:check()">
			 			<input type="button" value = "돌아가기" onclick="location.href='/MyHome/member/myPage.jsp'">
			 		</td>
			 	</tr>
			 </table>	
 	</form>
 	</div>
<%@include file = "/layout/footer.jsp" %>